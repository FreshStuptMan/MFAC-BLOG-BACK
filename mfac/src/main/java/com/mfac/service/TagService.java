package com.mfac.service;


import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.TagListDTO;
import com.mfac.pojo.entity.Tag;

public interface TagService {
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
    Integer countByNameForCreate(String name);

    /**
     * 获取标签列表
     * @param tagListDTO
     * @return
     */
    PageResult list(TagListDTO tagListDTO);

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
    Integer countByNameForUpdate(String name, Long id);

    /**
     * 删除标签
     * @param id
     * @return
     */
    Integer delete(Long id);
}
