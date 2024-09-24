package com.mfac.controller;

import com.mfac.pojo.Result;
import com.mfac.service.FriendLinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/friendLink")
public class FriendLinkController {
    @Resource
    private FriendLinkService friendLinkService;

    /**
     * 获取所有上架友链
     * @return
     */
    @GetMapping("/listAllUp")
    public Result listAllUp() {
        return Result.success(friendLinkService.listAllUp());
    }
}
