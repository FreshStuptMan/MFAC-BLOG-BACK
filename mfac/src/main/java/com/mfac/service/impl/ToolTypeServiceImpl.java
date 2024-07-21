package com.mfac.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mfac.mapper.ToolTypeMapper;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ToolTypeListDTO;
import com.mfac.pojo.entity.ToolType;
import com.mfac.pojo.vo.ToolTypeListVO;
import com.mfac.service.ToolTypeService;
import com.mfac.util.SnowFlakeUtil;
import com.mfac.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class ToolTypeServiceImpl implements ToolTypeService {
    @Resource
    private ToolTypeMapper toolTypeMapper;


    /**
     * 创建工具分类
     * @param toolType
     * @return
     */
    @Override
    public Integer create(ToolType toolType) {
        toolType.setId(SnowFlakeUtil.create());
        toolType.setCreateTime(LocalDateTime.now());
        toolType.setCreatorId(ThreadLocalUtil.getCurrentId());
        return toolTypeMapper.create(toolType);
    }


    /**
     * 获取工具类型列表
     * @param toolTypeListDTO
     * @return
     */
    @Override
    public PageResult list(ToolTypeListDTO toolTypeListDTO) {
        PageHelper.startPage(toolTypeListDTO.getPageNum(), toolTypeListDTO.getPageSize());
        Page<ToolTypeListVO> page = toolTypeMapper.list(toolTypeListDTO);
        PageResult result = new PageResult(page.getTotal(), page.getResult());
        return result;
    }
}
