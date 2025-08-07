package com.demo.studentdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.studentdemo.VO.RegisterRequestVO;
import com.demo.studentdemo.VO.RegisterResponseVO;
import com.demo.studentdemo.entity.UserAuth;
import com.demo.studentdemo.mapper.StudentMapper;
import com.demo.studentdemo.mapper.UserAuthMapper;
import com.demo.studentdemo.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class UserAuthServiceImpl
        extends ServiceImpl<UserAuthMapper, UserAuth>
        implements IUserAuthService, UserDetailsService { // 👈 实现两个接口

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ 已注入

    @Override
    @Transactional
    public RegisterResponseVO register(RegisterRequestVO requestVO) {
        String studentId = requestVO.getStudentId();
        String username = requestVO.getUsername();
        String password = requestVO.getPassword();
        String operator = requestVO.getOperator();

        // 1. 检查学号是否存在
        if (studentMapper.selectById(studentId) == null) {
            throw new RuntimeException("学号不存在：" + studentId);
        }

        // 2. 检查该学号是否已注册
        if (userAuthMapper.findByStudentId(studentId) != null) {
            throw new RuntimeException("该学号已注册：" + studentId);
        }

        // 3. 检查用户名是否被占用
        if (userAuthMapper.findByUsername(username) != null) {
            throw new RuntimeException("用户名已存在：" + username);
        }

        // 4. 加密密码
        String encodedPassword = passwordEncoder.encode(password);

        // 5. 构建用户对象
        UserAuth user = new UserAuth();
        user.setStudentId(studentId);
        user.setUsername(username);
        user.setPasswordHash(encodedPassword);
        user.setAccountStatus("ACTIVE");
        user.setCreatedBy(operator);
        user.setUpdatedBy(operator);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // 6. 插入数据库
        boolean success = this.save(user);
        if (!success) {
            throw new RuntimeException("注册失败，请重试");
        }

        // 7. 返回结果
        return RegisterResponseVO.success(username, studentId);
    }

    // ================================
    // 新增：实现 UserDetailsService
    // ================================

    /**
     * Spring Security 登录时会调用这个方法
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库查用户（你可以根据 username 查）
        UserAuth user = userAuthMapper.selectOne(
                new QueryWrapper<UserAuth>().eq("username", username)
        );

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在: " + username);
        }

        // 返回 Spring Security 的 UserDetails 对象
        return User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash()) // ✅ 使用 BCrypt 哈希
                .accountLocked(false)
                .disabled(false)
                .authorities(Collections.emptyList()) // 暂时无权限
                .build();
    }
}
