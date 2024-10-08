package com.mfac.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mfac.mapper.FriendLinkEmailRecordMapper;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.EmailListDTO;
import com.mfac.pojo.entity.FriendLinkEmailRecord;
import com.mfac.pojo.vo.FriendLinkEmailRecordListVO;
import com.mfac.service.FriendLinkEmailRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FriendLinkEmailRecordServiceImpl implements FriendLinkEmailRecordService {

    @Resource
    private FriendLinkEmailRecordMapper friendLinkEmailRecordMapper;
    /**
     * 创建记录
     * @param record
     * @return
     */
    @Override
    public Integer create(FriendLinkEmailRecord record) {
        return friendLinkEmailRecordMapper.create(record);
    }

    /**
     * 修改记录状态
     * @param record
     * @return
     */
    @Override
    public Integer changeStatus(FriendLinkEmailRecord record) {
        return friendLinkEmailRecordMapper.changeStatus(record);
    }


    /**
     * 获取记录详情
     * @param id
     * @return
     */
    @Override
    public FriendLinkEmailRecord detail(Long id) {
        return friendLinkEmailRecordMapper.detail(id);
    }

    /**
     * 获取邮件记录列表
     * @param emailListDTO
     * @return
     */
    @Override
    public PageResult list(EmailListDTO emailListDTO) {
        PageHelper.startPage(emailListDTO.getPageNum(), emailListDTO.getPageSize());
        Page<FriendLinkEmailRecordListVO> page = friendLinkEmailRecordMapper.list(emailListDTO);
        PageResult result = new PageResult(page.getTotal(), page.getResult());
        return result;
    }

    /**
     * 修改邮箱
     * @param friendLinkEmailRecord
     * @return
     */
    @Override
    public Integer changeEmail(FriendLinkEmailRecord friendLinkEmailRecord) {
        return friendLinkEmailRecordMapper.changeEmail(friendLinkEmailRecord);
    }


    /**
     * 删除记录
     * @param id
     * @return
     */
    @Override
    public Integer delete(Long id) {
        return friendLinkEmailRecordMapper.delete(id);
    }
}
