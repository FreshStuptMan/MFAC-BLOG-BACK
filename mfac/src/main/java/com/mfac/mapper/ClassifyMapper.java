package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.ClassifyListDTO;
import com.mfac.pojo.entity.Classify;
import com.mfac.pojo.vo.ClassifyListVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassifyMapper {
    /**
     * 创建分类
     * @param classify
     * @return
     */
    Integer create(Classify classify);

    /**
     * 用于创建时判断分类名是否重复
     * @param name
     * @return
     */
    @Select("select COUNT(id) from classify where name = #{name}")
    Integer countByNameForCreate(String name);


    /**
     * 获取分类列表
     * @param classifyListDTO
     * @return
     */
    Page<ClassifyListVO> list(ClassifyListDTO classifyListDTO);


    /**
     * 用于更新时判断分类名是否重复
     * @param name
     * @param id
     * @return
     */
    @Select("select COUNT(id) from classify where name = #{name} and id != #{id}")
    Integer countByNameForUpdate(String name, Long id);

    /**
     * 更新分类
     * @param classify
     * @return
     */
    Integer update(Classify classify);

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Delete("delete from classify where id = #{id}")
    Integer delete(Long id);
}