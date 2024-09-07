package com.mfac.service;

import com.mfac.pojo.PageResult;
import com.mfac.pojo.dto.FriendLinkListDTO;
import com.mfac.pojo.entity.FriendLink;
import io.swagger.models.auth.In;

public interface FriendLinkService {
    /**
     * 创建友链
     * @param friendLink
     * @return
     */
    Integer create(FriendLink friendLink);

    /**
     * 修改友链状态
     * @param friendLink
     * @return
     */
    Integer changeStatus(FriendLink friendLink);

    /**
     * 获取友链列表
     * @param friendLinkListDTO
     * @return
     */
    PageResult list(FriendLinkListDTO friendLinkListDTO);

    /**
     * 获取友链详情
     * @param id
     * @return
     */
    FriendLink detail(Long id);

    /**
     * 删除友链
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 更新友链
     * @param friendLink
     * @return
     */
    Integer update(FriendLink friendLink);
}
