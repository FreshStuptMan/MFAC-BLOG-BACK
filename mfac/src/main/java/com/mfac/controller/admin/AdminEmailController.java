package com.mfac.controller.admin;

import com.mfac.constant.EmailConstant;
import com.mfac.pojo.PageResult;
import com.mfac.pojo.Result;
import com.mfac.pojo.dto.EmailListDTO;
import com.mfac.pojo.entity.FriendLink;
import com.mfac.pojo.entity.FriendLinkEmailRecord;
import com.mfac.service.FriendLinkEmailRecordService;
import com.mfac.service.FriendLinkService;
import com.mfac.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/admin/email")
public class AdminEmailController {
    @Resource
    private FriendLinkEmailRecordService friendLinkEmailRecordService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private EmailUtil emailUtil;
    /**
     * 获取邮件记录列表
     * @param emailListDTO
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestBody EmailListDTO emailListDTO) {
        PageResult result = friendLinkEmailRecordService.list(emailListDTO);
        return Result.success(result);
    }

    /**
     * 修改邮箱
     * @return
     */
    @PostMapping("/changeEmail")
    public Result changeEmail(@RequestBody  FriendLinkEmailRecord friendLinkEmailRecord) {
        friendLinkEmailRecordService.changeEmail(friendLinkEmailRecord);
        return Result.success();
    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        friendLinkEmailRecordService.delete(id);
        return Result.success();
    }

    /**
     * 手动重发
     * @param friendLinkEmailRecord
     * @return
     */
    @PostMapping("/resent")
    public Result resent(@RequestBody FriendLinkEmailRecord friendLinkEmailRecord) {
        try {
            FriendLink friendLink = friendLinkService.detail(friendLinkEmailRecord.getFriendLinkId());
            if (EmailConstant.FRIEND_LINK_UP_NOTIFY_EMAIL.equals(friendLinkEmailRecord.getEmailType())) {
                emailUtil.FriendLinkUpEmailHandSender(friendLink, friendLinkEmailRecord.getEmail());
                updateEmailRecordStatus(friendLinkEmailRecord.getId(), EmailConstant.SEND_STATUS_SUCCESS, "");
            } else if (EmailConstant.FRIEND_LINK_DOWN_NOTIFY_EMAIL.equals(friendLinkEmailRecord.getEmailType())) {
                emailUtil.FriendLinkDownHandEmailSender(friendLink, friendLinkEmailRecord.getEmail());
                updateEmailRecordStatus(friendLinkEmailRecord.getId(), EmailConstant.SEND_STATUS_SUCCESS, "");
            } else {
                updateEmailRecordStatus(friendLinkEmailRecord.getId(), EmailConstant.SEND_STATUS_FAULT, "邮件类型错误");
                return Result.error("邮件类型错误");
            }
        } catch (Exception e) {
            updateEmailRecordStatus(friendLinkEmailRecord.getId(), EmailConstant.SEND_STATUS_FAULT, e.getMessage());
            return Result.error("手动重发出错，请查看日志");
        }
        return Result.success();
    }

    /**
     * 更新记录状态
     * @param id
     * @param status
     * @param reason
     */
    private void updateEmailRecordStatus (Long id, Integer status, String reason) {
        FriendLinkEmailRecord record = new FriendLinkEmailRecord();
        record.setId(id);
        record.setStatus(status);
        record.setFaultReason(reason);
        friendLinkEmailRecordService.changeStatus(record);
    }
}
