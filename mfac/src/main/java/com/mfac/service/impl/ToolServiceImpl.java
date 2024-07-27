package com.mfac.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mfac.mapper.ToolMapper;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ToolListDTO;
import com.mfac.pojo.entity.Tool;
import com.mfac.pojo.vo.ToolListVO;
import com.mfac.service.ToolService;
import com.mfac.util.SnowFlakeUtil;
import com.mfac.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class ToolServiceImpl implements ToolService {
    @Resource
    private ToolMapper toolMapper;

    /**
     * 创建工具
     * @param tool
     * @return
     */
    @Override
    public Integer create(Tool tool) {
        tool.setId(SnowFlakeUtil.create());
        tool.setCreatorId(ThreadLocalUtil.getCurrentId());
        tool.setCreateTime(LocalDateTime.now());
        return toolMapper.create(tool);
    }

    /**
     * 获取工具列表
     * @param toolListDTO
     * @return
     */
    @Override
    public PageResult list(ToolListDTO toolListDTO) {
        PageHelper.startPage(toolListDTO.getPageNum(), toolListDTO.getPageSize());
        Page<ToolListVO> page = toolMapper.list(toolListDTO);
        PageResult result = new PageResult(page.getTotal(), page.getResult());
        return result;
    }


    /**
     * 删除工具
     * @param id
     * @return
     */
    @Override
    public Integer delete(Long id) {
        return toolMapper.delete(id);
    }

    /**
     * 更新工具信息
     * @param tool
     * @return
     */
    @Override
    public Integer update(Tool tool) {
        return toolMapper.update(tool);
    }
}
