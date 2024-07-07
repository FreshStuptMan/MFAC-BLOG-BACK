package com.mfac.controller.admin;

import com.mfac.pojo.Result;
import com.mfac.pojo.entity.User;
import com.mfac.pojo.vo.UserDetailVO;
import com.mfac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Resource
    private UserService userService;

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/detail")
    public Result detail() {
        UserDetailVO user = userService.detail();
        return Result.success(user);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody User user) {
        userService.changePassword(user);
        return Result.success();
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

}
