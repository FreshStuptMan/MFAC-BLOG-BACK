package com.mfac.controller;

import com.mfac.service.ToolTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/toolType")
public class ToolTypeController {
    @Resource
    private ToolTypeService toolTypeService;
}
