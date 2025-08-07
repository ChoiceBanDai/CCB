package com.demo.studentdemo.service;

import com.demo.studentdemo.VO.RegisterRequestVO;
import com.demo.studentdemo.VO.RegisterResponseVO;
import com.demo.studentdemo.entity.UserAuth;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户认证服务接口
 */
public interface IUserAuthService {

    /**
     * 学生注册
     * @param requestVO 注册请求参数
     * @return 注册结果
     */
    RegisterResponseVO register(RegisterRequestVO requestVO);
}
