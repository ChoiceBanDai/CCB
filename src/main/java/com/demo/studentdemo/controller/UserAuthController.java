package com.demo.studentdemo.controller;

import com.demo.studentdemo.VO.RegisterRequestVO;
import com.demo.studentdemo.VO.RegisterResponseVO;
import com.demo.studentdemo.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户认证控制器
 */
@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    @Autowired
    private IUserAuthService userAuthService;

    /**
     * 用户注册
     * POST /api/auth/register
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseVO> register(@RequestBody RegisterRequestVO requestVO) {
        try {
            RegisterResponseVO response = userAuthService.register(requestVO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 可以根据异常类型返回不同的状态码
            return ResponseEntity.badRequest().body(RegisterResponseVO.error("注册失败：" + e.getMessage()));
        }
    }
}
