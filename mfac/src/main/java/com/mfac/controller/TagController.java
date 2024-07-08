package com.mfac.controller;

import com.mfac.pojo.Result;
import com.mfac.pojo.entity.Tag;
import com.mfac.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;

    /**
     * 获取所以标签
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll() {
        List<Tag> list = tagService.listAll();
        return Result.success(list);
    }

    /**
     * 随机获取5个标签
     * @return
     */
    @GetMapping("/random")
    public Result random() {
        List<Tag> list = tagService.random();
        return Result.success(list);
    }
}
