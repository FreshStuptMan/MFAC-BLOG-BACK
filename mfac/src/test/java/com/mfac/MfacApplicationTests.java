package com.mfac;

import com.mfac.util.RabbitMQUtil;
import com.mfac.util.SnowFlakeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MfacApplicationTests {

    @Resource
    private RabbitMQUtil rabbitMQUtil;
    @Test
    void contextLoads() {
        Long id = SnowFlakeUtil.create();
        System.out.println("id: "+id);
        rabbitMQUtil.EmailMessageSender(id);
    }

}
