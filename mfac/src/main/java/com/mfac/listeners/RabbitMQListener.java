package com.mfac.listeners;

import com.mfac.constant.EmailConstant;
import com.mfac.constant.RabbitMQConstant;
import com.mfac.pojo.entity.FriendLink;
import com.mfac.pojo.entity.FriendLinkEmailRecord;
import com.mfac.service.FriendLinkEmailRecordService;
import com.mfac.service.FriendLinkService;
import com.mfac.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 消费者
 * 发送邮件
 */
@Slf4j
@Component
public class RabbitMQListener {

    @Resource
    private FriendLinkEmailRecordService friendLinkEmailRecordService;
    @Resource
    private FriendLinkService friendLinkService;
    @Resource
    private EmailUtil emailUtil;

    /**
     * 业务消费者
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMQConstant.FRIEND_LINK_EMAIL_MESSAGE_QUEUE),
            exchange = @Exchange(name = RabbitMQConstant.EXCHANGE, type = ExchangeTypes.DIRECT),
            key = RabbitMQConstant.FRIEND_LINK_EMAIL_MESSAGE_QUEUE_KEY,
            arguments = {
                    @Argument(name = "x-dead-letter-exchange", value = RabbitMQConstant.EXCHANGE),
                    @Argument(name = "x-dead-letter-routing-key", value = RabbitMQConstant.OVER_TIME_QUEUE_KEY),
                    @Argument(name = "x-message-ttl", value = RabbitMQConstant.FRIEND_LINK_EMAIL_MESSAGE_TTL, type = "java.lang.Integer")
            }
    ))
    private void EmailMessageSenderListener(Long id) {
        FriendLinkEmailRecord  record = friendLinkEmailRecordService.detail(id);
        FriendLink friendLink = friendLinkService.detail(record.getFriendLinkId());
        // 发送邮件
        if (EmailConstant.FRIEND_LINK_UP_NOTIFY_EMAIL.equals(record.getEmailType())) {
            emailUtil.FriendLinkUpEmailSender(friendLink);
        } else if (EmailConstant.FRIEND_LINK_DOWN_NOTIFY_EMAIL.equals(record.getEmailType())) {
            emailUtil.FriendLinkDownEmailSender(friendLink);
        } else {
            // 邮件类型错误
            updateEmailRecordStatus(id, EmailConstant.SEND_STATUS_FAULT, "邮件类型错误，发送失败");
            return;
        }
        // 更新邮件记录状态
        updateEmailRecordStatus(id, EmailConstant.SEND_STATUS_SUCCESS, null);
    }

    /**
     * 重试耗尽消费者
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMQConstant.TRY_TIME_EXHAUSTED_QUEUE),
            exchange = @Exchange(name = RabbitMQConstant.EXCHANGE, type = ExchangeTypes.DIRECT),
            key = RabbitMQConstant.TRY_TIME_EXHAUSTED_QUEUE_KEY
    ))
    private void TryTimeExhaustedListener(Long id) {
        updateEmailRecordStatus(id, EmailConstant.SEND_STATUS_FAULT, "消费者消费失败，重试次数耗尽！请检查邮箱消息或消费者消费部分！");
    }


    /**
     * 消息超时消费者
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitMQConstant.OVER_TIME_QUEUE),
            exchange = @Exchange(name = RabbitMQConstant.EXCHANGE, type = ExchangeTypes.DIRECT),
            key = RabbitMQConstant.OVER_TIME_QUEUE_KEY
    ))
    private void OverTimeListener(Long id) {
        updateEmailRecordStatus(id, EmailConstant.SEND_STATUS_FAULT, "消费者消费失败，消息超时！");
    }



    /**
     * 更新记录状态
     * @param id
     * @param status
     * @param reason
     */
    private void updateEmailRecordStatus (Long id, Integer status, String reason) {
        FriendLinkEmailRecord record = new FriendLinkEmailRecord();
        FriendLinkEmailRecord dbRecord = friendLinkEmailRecordService.detail(id);
        if (EmailConstant.SEND_STATUS_SENDING.equals(dbRecord.getStatus())) {
            record.setId(id);
            record.setStatus(status);
            record.setFaultReason(reason);
            friendLinkEmailRecordService.changeStatus(record);
        }
    }
}
