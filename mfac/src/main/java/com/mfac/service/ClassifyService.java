package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ClassifyListDTO;
import com.mfac.pojo.entity.Classify;
import com.mfac.pojo.vo.ClassifyListVO;

import java.util.List;

public interface ClassifyService {
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
    Integer countByNameForCreate(String name);


    /**
     * 获取分类列表
     * @param classifyListDTO
     * @return
     */
    PageResult list(ClassifyListDTO classifyListDTO);

    /**
     * 用于更新时判断分类名是否重复
     * @param name
     * @param id
     * @return
     */
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
    Integer delete(Long id);

    /**
     * 获取所有分类
     * @return
     */
    List<Classify> listAll();

    /**
     * 随机获取5个分类
     * @return
     */
    List<Classify> random();

    /**
     * 获取所有分类，并且包括相关的博客数
     * @return
     */
    List<ClassifyListVO> listAllWithTotal();

    /**
     * 用于删除前判断该分类下是否有标签
     * @param id
     * @return
     */
    Integer countBlogByIdForDelete(Long id);
}
