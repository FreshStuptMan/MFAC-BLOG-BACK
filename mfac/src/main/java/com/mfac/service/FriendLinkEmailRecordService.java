package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.EmailListDTO;
import com.mfac.pojo.entity.FriendLinkEmailRecord;

public interface FriendLinkEmailRecordService {
    /**
     * 创建记录
     * @param record
     * @return
     */
    Integer create(FriendLinkEmailRecord record);

    /**
     * 修改邮件记录状态
     * @param record
     * @return
     */
    Integer changeStatus(FriendLinkEmailRecord record);

    /**
     * 获取记录详情
     * @param id
     * @return
     */
    FriendLinkEmailRecord detail(Long id);

    /**
     * 获取邮件记录列表
     * @param emailListDTO
     * @return
     */
    PageResult list(EmailListDTO emailListDTO);

    /**
     * 修改邮箱
     * @param friendLinkEmailRecord
     * @return
     */
    Integer changeEmail(FriendLinkEmailRecord friendLinkEmailRecord);

    /**
     * 删除记录
     * @param id
     * @return
     */
    Integer delete(Long id);
}
