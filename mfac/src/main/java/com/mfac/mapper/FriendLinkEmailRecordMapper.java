package com.mfac.mapper;

import com.github.pagehelper.Page;
import com.mfac.pojo.dto.EmailListDTO;
import com.mfac.pojo.entity.FriendLinkEmailRecord;
import com.mfac.pojo.vo.FriendLinkEmailRecordListVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FriendLinkEmailRecordMapper {
    /**
     * 创建记录
     * @param record
     * @return
     */
    Integer create(FriendLinkEmailRecord record);


    /**
     * 更新记录状态
     * @param record
     * @return
     */
    Integer changeStatus(FriendLinkEmailRecord record);

    /**
     * 获取记录详情
     * @param id
     * @return
     */
    @Select("select * from friend_link_email_record where id = #{id}")
    FriendLinkEmailRecord detail(Long id);

    /**
     * 获取邮件记录列表
     * @param emailListDTO
     * @return
     */
    Page<FriendLinkEmailRecordListVO> list(EmailListDTO emailListDTO);

    /**
     * 修改邮箱
     * @param friendLinkEmailRecord
     * @return
     */
    @Update("update friend_link_email_record set email = #{email} where id = #{id}")
    Integer changeEmail(FriendLinkEmailRecord friendLinkEmailRecord);

    /**
     * 删除记录
     * @param id
     * @return
     */
    @Delete("delete from friend_link_email_record where id = #{id}")
    Integer delete(Long id);
}
