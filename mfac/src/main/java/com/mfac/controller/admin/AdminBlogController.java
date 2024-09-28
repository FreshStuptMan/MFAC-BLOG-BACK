package com.mfac.controller.admin;

import com.mfac.aop.annotation.BlogViewAdder;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.Result;
import com.mfac.pojo.dto.BlogCreateDTO;
import com.mfac.pojo.dto.BlogListDTO;
import com.mfac.pojo.dto.BlogUpdateDTO;
import com.mfac.pojo.entity.Blog;
import com.mfac.pojo.vo.BlogDetailVO;
import com.mfac.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/admin/blog")
public class AdminBlogController {
    @Resource
    private BlogService blogService;

    /**
     * 创建博客
     * @param blogCreateDTO
     * @return
     */
    @PostMapping("/create")
    public Result create(@RequestBody BlogCreateDTO blogCreateDTO) {
        blogService.create(blogCreateDTO);
        return Result.success();
    }

    /**
     * 获取博客列表
     * @param blogListDTO
     * @return
     */
    @PostMapping("/list")
    @BlogViewAdder
    public Result list(@RequestBody BlogListDTO blogListDTO) {
        PageResult page = blogService.list(blogListDTO);
        return Result.success(page);
    }

    /**
     * 修改博客状态
     * @param blog
     * @return
     */
    @PostMapping("/changeStatus")
    public Result changeStatus(@RequestBody Blog blog) {
        blogService.changeStatus(blog);
        return Result.success();
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        blogService.delete(id);
        return Result.success();
    }

    /**
     * 获取博客详情
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Long id) {
        BlogDetailVO blog = blogService.detail(id);
        return Result.success(blog);
    }

    /**
     * 更新博客内容
     * @param blogUpdateDTO
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody BlogUpdateDTO blogUpdateDTO) {
        blogService.update(blogUpdateDTO);
        return Result.success();
    }
}
