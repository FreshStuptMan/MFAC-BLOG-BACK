package com.mfac.controller.admin;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.Result;
import com.mfac.pojo.dto.ToolTypeListDTO;
import com.mfac.pojo.entity.ToolType;
import com.mfac.service.ToolTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/toolType")
@Slf4j
public class AdminToolTypeController {
    @Resource
    private ToolTypeService toolTypeService;


    /**
     * 创建工具类型
     * @param toolType
     * @return
     */
    @PostMapping("/create")
    public Result create(@RequestBody ToolType toolType) {
        toolTypeService.create(toolType);
        return Result.success();
    }


    /**
     * 获取工具类型列表
     * @param toolTypeListDTO
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestBody ToolTypeListDTO toolTypeListDTO) {
        PageResult page = toolTypeService.list(toolTypeListDTO);
        return Result.success(page);
    }
}
