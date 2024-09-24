package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.FriendLinkListDTO;
import com.mfac.pojo.entity.FriendLink;
import com.mfac.pojo.vo.FriendLinkListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendLinkMapper {
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
    Page<FriendLink> list(FriendLinkListDTO friendLinkListDTO);

    /**
     * 获取友链详情
     * @param id
     * @return
     */
    @Select("select * from friend_link where id = #{id}")
    FriendLink detail(Long id);

    /**
     * 删除友链
     * @param id
     * @return
     */
    @Delete("delete from friend_link where id = #{id}")
    Integer delete(Long id);

    /**
     * 更新友链
     * @param friendLink
     * @return
     */
    Integer update(FriendLink friendLink);

    /**
     * 获取所有上架友链
     * @return
     */
    List<FriendLinkListVO> listAllUp();
}
