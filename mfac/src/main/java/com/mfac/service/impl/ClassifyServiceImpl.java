package com.mfac.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mfac.mapper.ClassifyMapper;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.ClassifyListDTO;
import com.mfac.pojo.entity.Classify;
import com.mfac.pojo.vo.ClassifyListVO;
import com.mfac.service.ClassifyService;
import com.mfac.util.SnowFlakeUtil;
import com.mfac.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;

    /**
     * 创建分类
     * @param classify
     * @return
     */
    @Override
    public Integer create(Classify classify) {
        Long id = SnowFlakeUtil.create();
        classify.setId(id);
        classify.setCreatorId(ThreadLocalUtil.getCurrentId());
        classify.setCreateTime(LocalDateTime.now());
        classify.setUpdateTime(LocalDateTime.now());
        return classifyMapper.create(classify);
    }

    /**
     * 用于创建时判断分类名是否重复
     * @param name
     * @return
     */
    @Override
    public Integer countByNameForCreate(String name) {
        return classifyMapper.countByNameForCreate(name);
    }

    /**
     * 获取分类列表
     * @param classifyListDTO
     * @return
     */
    @Override
    public PageResult list(ClassifyListDTO classifyListDTO) {
        PageHelper.startPage(classifyListDTO.getPageNum(), classifyListDTO.getPageSize());
        Page<ClassifyListVO> page = classifyMapper.list(classifyListDTO);
        PageResult result = new PageResult(page.getTotal(), page.getResult());
        return result;
    }


    /**
     * 用于更新时判断分类是否重复
     * @param name
     * @param id
     * @return
     */
    @Override
    public Integer countByNameForUpdate(String name, Long id) {
        return classifyMapper.countByNameForUpdate(name, id);
    }

    /**
     * 更新分类
     * @param classify
     * @return
     */
    @Override
    public Integer update(Classify classify) {
        classify.setUpdateTime(LocalDateTime.now());
        return classifyMapper.update(classify);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Override
    public Integer delete(Long id) {
        return classifyMapper.delete(id);
    }


    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Classify> listAll() {
        return classifyMapper.listAll();
    }


    /**
     * 随机获取5个分类
     * @return
     */
    @Override
    public List<Classify> random() {
        return classifyMapper.random();
    }


    @Override
    public List<ClassifyListVO> listAllWithTotal() {
        return classifyMapper.listAllWithTotal();
    }
}
