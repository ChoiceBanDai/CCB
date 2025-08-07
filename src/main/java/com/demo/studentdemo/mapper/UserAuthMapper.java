package com.demo.studentdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.studentdemo.entity.UserAuth;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户登录认证信息 Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2025-08-06
 */
public interface UserAuthMapper extends BaseMapper<UserAuth> {

    /**
     * 根据用户名查询用户信息（仅返回状态为 ACTIVE 的用户）
     * @param username 登录账号
     * @return 用户认证信息，若不存在则返回 null
     */
    UserAuth findByUsername(@Param("username") String username);

    /**
     * 更新用户的密码哈希值
     * @param username 登录账号
     * @param passwordHash 新的 BCrypt 加密密码
     * @param updatedBy 操作人（通常为 system 或当前用户）
     */
    void updatePassword(@Param("username") String username,
                        @Param("passwordHash") String passwordHash,
                        @Param("updatedBy") String updatedBy);

    /**
     * 更新用户的最后登录时间和更新人
     * @param username 登录账号
     * @param updatedBy 操作人（通常为 system 或当前用户）
     */
    void updateLastLogin(@Param("username") String username,
                         @Param("updatedBy") String updatedBy);

    /**
     * 根据学号查询用户（用于注册时判断是否已存在）
     */
    UserAuth findByStudentId(@Param("studentId") String studentId);

    /**
     * 插入新用户（注册）
     */
    int insertUserAuth(UserAuth userAuth);
}