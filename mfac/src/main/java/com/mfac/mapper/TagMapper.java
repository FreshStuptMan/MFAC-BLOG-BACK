package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.TagListDTO;
import com.mfac.pojo.entity.Tag;
import com.mfac.pojo.vo.TagListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TagMapper {
    /**
     * 创建标签
     * @param tag
     * @return
     */
    Integer create(Tag tag);


    /**
     * 用于创建时判断标签名是否重复
     * @param name
     * @return
     */
    @Select("select COUNT(id) from tag where name = #{name}")
    Integer countByNameForCreate(String name);

    /**
     * 获取标签列表
     * @param tagListDTO
     * @return
     */
    Page<TagListVO> list(TagListDTO tagListDTO);

    /**
     * 更新标签
     * @param tag
     * @return
     */
    Integer update(Tag tag);

    /**
     * 用于更新时判断标签名是否重复
     * @param name
     * @return
     */
    @Select("select COUNT(id) from tag where name = #{id} and id != #{id}")
    Integer countByNameForUpdate(String name, Long id);


    /**
     * 删除标签
     * @param id
     * @return
     */
    @Delete("delete from tag where id = #{id}")
    Integer delete(Long id);
}
