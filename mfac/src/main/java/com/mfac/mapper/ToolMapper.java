package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.ToolListDTO;
import com.mfac.pojo.entity.Tool;
import com.mfac.pojo.vo.ToolListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToolMapper {

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
    Page<ToolListVO> list(ToolListDTO toolListDTO);


    /**
     * 删除工具
     * @param id
     * @return
     */
    @Delete("delete from tool where id = #{id}")
    Integer delete(Long id);

    /**
     * 更新工具信息
     * @param tool
     * @return
     */
    Integer update(Tool tool);
}
