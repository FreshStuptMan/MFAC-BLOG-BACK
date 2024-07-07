package com.mfac.controller.admin;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.Result;
import com.mfac.pojo.dto.ClassifyListDTO;
import com.mfac.pojo.entity.Classify;
import com.mfac.service.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/admin/classify")
public class AdminClassifyController {
    @Resource
    private ClassifyService classifyService;

    /**
     * 创建分类
     * @param classify
     * @return
     */
    @PostMapping("/create")
    public Result create(@RequestBody Classify classify) {
        if(classifyService.countByNameForCreate(classify.getName()) > 0) {
            return Result.error("创建失败，该分类已存在");
        }
        classifyService.create(classify);
        return Result.success();
    }

    /**
     * 获取分类列表
     * @param classifyListDTO
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestBody ClassifyListDTO classifyListDTO) {
        PageResult page = classifyService.list(classifyListDTO);
        return Result.success(page);
    }

    /**
     * 更新分类
     * @param classify
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Classify classify) {
        if(classifyService.countByNameForUpdate(classify.getName(), classify.getId()) > 0) {
            return Result.error("更新失败，该分类名已被使用");
        }
        classifyService.update(classify);
        return Result.success();
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        classifyService.delete(id);
        return Result.success();
    }
}
