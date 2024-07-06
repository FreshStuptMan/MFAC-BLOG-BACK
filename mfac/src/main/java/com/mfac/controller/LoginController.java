package com.mfac.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.mfac.pojo.Result;
import com.mfac.pojo.dto.LoginDTO;
import com.mfac.pojo.entity.User;
import com.mfac.pojo.vo.LoginVO;
import com.mfac.properties.JWTProperties;
import com.mfac.service.UserService;
import com.mfac.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private JWTProperties jwtProperties;

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        User user = userService.selectByAccount(loginDTO.getAccount());
        if(user == null) {
            return Result.error("登录失败，该账户不存在");
        }
        if(!BCrypt.checkpw(loginDTO.getPassword(), user.getPassword())) {
            return Result.error("登录失败，密码错误");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put(jwtProperties.getUserId(),user.getId());
        String token = JWTUtil.createJWT(jwtProperties.getSecretKey(), jwtProperties.getTtl(), claims);
        LoginVO loginVO = new LoginVO(token);
        return Result.success(loginVO);
    }

}
