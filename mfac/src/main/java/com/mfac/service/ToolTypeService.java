package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ToolTypeListDTO;
import com.mfac.pojo.entity.ToolType;

public interface ToolTypeService {

    /**
     * 创建工具类型
     * @param toolType
     * @return
     */
    Integer create(ToolType toolType);

    /**
     * 获取工具类型列表
     * @param toolTypeListDTO
     * @return
     */
    PageResult list(ToolTypeListDTO toolTypeListDTO);
}
