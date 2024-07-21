package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.ToolTypeListDTO;
import com.mfac.pojo.entity.ToolType;
import com.mfac.pojo.vo.ToolTypeListVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToolTypeMapper {
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
    Page<ToolTypeListVO> list(ToolTypeListDTO toolTypeListDTO);
}
