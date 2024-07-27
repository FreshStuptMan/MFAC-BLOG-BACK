package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ToolListDTO;
import com.mfac.pojo.entity.Tool;

public interface ToolService {

    /**
     * 创建工具
     * @param tool
     * @return
     */
    Integer create(Tool tool);

    /**
     * 获取工具列表
     * @param toolListDTO
     * @return
     */
    PageResult list(ToolListDTO toolListDTO);

    /**
     * 删除工具
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 更新工具信息
     * @param tool
     * @return
     */
    Integer update(Tool tool);
}
