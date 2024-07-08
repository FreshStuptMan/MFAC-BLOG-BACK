package com.mfac.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mfac.constant.BlogConstant;
import com.mfac.mapper.BlogMapper;
import com.mfac.mapper.TagMapper;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.BlogCreateDTO;
import com.mfac.pojo.dto.BlogListDTO;
import com.mfac.pojo.dto.BlogSearchDTO;
import com.mfac.pojo.dto.BlogUpdateDTO;
import com.mfac.pojo.entity.Blog;
import com.mfac.pojo.vo.BlogDetailVO;
import com.mfac.pojo.vo.BlogListVO;
import com.mfac.service.BlogService;
import com.mfac.util.SnowFlakeUtil;
import com.mfac.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TagMapper tagMapper;

    /**
     * 创建博客
     * @param blogCreateDTO
     * @return
     */
    @Transactional
    @Override
    public Integer create(BlogCreateDTO blogCreateDTO) {
        Long id = SnowFlakeUtil.create();
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogCreateDTO, blog);

        blog.setId(id);
        blog.setAuthorId(ThreadLocalUtil.getCurrentId());
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        if(blog.getStatus().equals(BlogConstant.BLOG_STATUS_UP)) {
            blog.setPublishTime(LocalDateTime.now());
        }
        // 更新博客-标签关系表
        tagMapper.createBlogTagBatch(blogCreateDTO.getTagIds(), id);
        // 创建博客
        blogMapper.create(blog);
        return null;
    }


    /**
     * 获取博客列表
     * @param blogListDTO
     * @return
     */
    @Override
    public PageResult list(BlogListDTO blogListDTO) {
        PageHelper.startPage(blogListDTO.getPageNum(), blogListDTO.getPageSize());
        Page<BlogListVO> page = blogMapper.list(blogListDTO);
        // 设置博客标签
        List<BlogListVO> list = page.getResult();
        list.forEach(vo -> {
            vo.setTags(tagMapper.listFromBlogTagByBlogId(vo.getId()));
        });
        PageResult result = new PageResult(page.getTotal(), list);
        return result;
    }

    /**
     * 修改博客状态
     * @param blog
     * @return
     */
    @Override
    public Integer changeStatus(Blog blog) {
        if(blog.getStatus().equals(BlogConstant.BLOG_STATUS_UP)) {
            blog.setPublishTime(LocalDateTime.now());
        }
        return blogMapper.changeStatus(blog);
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Integer delete(Long id) {
        tagMapper.deleteBlogTagByBlogId(id);
        return blogMapper.delete(id);
    }

    /**
     * 获取博客详情
     * @param id
     * @return
     */
    @Override
    public BlogDetailVO detail(Long id) {
        BlogDetailVO blog = blogMapper.detail(id);
        blog.setTags(tagMapper.listFromBlogTagByBlogId(blog.getId()));
        return blog;
    }

    /**
     * 更新博客内容
     * @param blogUpdateDTO
     * @return
     */
    @Transactional
    @Override
    public Integer update(BlogUpdateDTO blogUpdateDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogUpdateDTO, blog);
        if(blog.getStatus().equals(BlogConstant.BLOG_STATUS_UP)) {
            blog.setPublishTime(LocalDateTime.now());
        }
        blog.setUpdateTime(LocalDateTime.now());
        // 更新博客-标签关系表
        tagMapper.deleteBlogTagByBlogId(blog.getId());
        tagMapper.createBlogTagBatch(blogUpdateDTO.getTagIds(), blog.getId());
        // 更新博客内容
        blogMapper.update(blog);
        return null;
    }

    /**
     * 获取最新的五条博客
     * @return
     */
    @Override
    public List<BlogListVO> newest() {
        return blogMapper.newest();
    }


    /**
     * 搜索博客
     * @param blogSearchDTO
     * @return
     */
    @Override
    public PageResult search(BlogSearchDTO blogSearchDTO) {
        PageHelper.startPage(blogSearchDTO.getPageNum(), blogSearchDTO.getPageSize());
        Page<BlogListVO> page = blogMapper.search(blogSearchDTO);
        PageResult result = new PageResult(page.getTotal(), page.getResult());
        return result;
    }
}
