package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.BlogListDTO;
import com.mfac.pojo.entity.Blog;
import com.mfac.pojo.vo.BlogDetailVO;
import com.mfac.pojo.vo.BlogListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {

    /**
     * 创建博客
     * @param blog
     * @return
     */
    Integer create(Blog blog);

    /**
     * 获取博客列表
     * @param blogListDTO
     * @return
     */
    Page<BlogListVO> list(BlogListDTO blogListDTO);

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
    @Delete("delete from blog where id = #{id}")
    Integer delete(Long id);


    /**
     * 获取博客详情
     * @param id
     * @return
     */
    BlogDetailVO detail(Long id);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    Integer update(Blog blog);
}
