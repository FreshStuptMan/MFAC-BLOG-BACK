package com.mfac.controller;

import com.mfac.pojo.Result;
import com.mfac.pojo.entity.Classify;
import com.mfac.pojo.entity.Tag;
import com.mfac.pojo.vo.ClassifyListVO;
import com.mfac.service.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Resource
    private ClassifyService classifyService;

    /**
     * 获取所有分类
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll() {
        List<Classify> list = classifyService.listAll();
        return Result.success(list);
    }

    /**
     * 随机获取5个分类
     * @return
     */
    @GetMapping("/random")
    public Result random() {
        List<Classify> list = classifyService.random();
        return Result.success(list);
    }

    /**
     * 获取所有分类，并且包括相关的博客数
     * @return
     */
    @GetMapping("/listAllWithTotal")
    public Result listAllWithTotal() {
        List<ClassifyListVO> list = classifyService.listAllWithTotal();
        return Result.success(list);
    }
}
