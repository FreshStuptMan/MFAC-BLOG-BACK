package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.BlogCreateDTO;
import com.mfac.pojo.dto.BlogListDTO;
import com.mfac.pojo.dto.BlogSearchDTO;
import com.mfac.pojo.dto.BlogUpdateDTO;
import com.mfac.pojo.entity.Blog;
import com.mfac.pojo.vo.BlogDetailVO;
import com.mfac.pojo.vo.BlogListVO;

import java.util.List;

public interface BlogService {
    /**
     * 创建博客
     * @param blogCreateDTO
     * @return
     */
    Integer create(BlogCreateDTO blogCreateDTO);

    /**
     * 获取博客列表
     * @param blogListDTO
     * @return
     */
    PageResult list(BlogListDTO blogListDTO);


    /**
     * 修改博客状态
     * @param blog
     * @return
     */
    Integer changeStatus(Blog blog);

    /**
     * 删除博客
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 获取博客详情
     * @param id
     * @return
     */
    BlogDetailVO detail(Long id);

    /**
     * 更新博客
     * @param blogUpdateDTO
     * @return
     */
    Integer update(BlogUpdateDTO blogUpdateDTO);

    /**
     * 获取最新的5条博客
     * @return
     */
    List<BlogListVO> newest();

    /**
     * 搜索博客
     * @param blogSearchDTO
     * @return
     */
    PageResult search(BlogSearchDTO blogSearchDTO);

}
