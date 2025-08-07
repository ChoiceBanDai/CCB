package com.demo.studentdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户登录认证信息
 * </p>
 *
 * @author admin
 * @since 2025-08-06
 */
@Getter
@Setter
@ToString
@TableName("t_user_auth")
@Schema(name = "UserAuth", description = "用户登录认证信息")
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @Schema(description = "自增主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联学号
     */
    @Schema(description = "关联学号")
    private String studentId;

    /**
     * 登录账号
     */
    @Schema(description = "登录账号")
    private String username;

    /**
     * BCrypt加密密码
     */
    @Schema(description = "BCrypt加密密码")
    private String passwordHash;

    /**
     * 账号状态（ACTIVE: 正常, LOCKED: 锁定）
     */
    @Schema(description = "账号状态（ACTIVE: 正常, LOCKED: 锁定）")
    private String accountStatus;

    /**
     * 最后登录时间
     */
    @Schema(description = "最后登录时间")
    private LocalDateTime lastLogin;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    /**
     * 最后更新时间
     */
    @Schema(description = "最后更新时间")
    private LocalDateTime updatedAt;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private String createdBy;

    /**
     * 最后更新人
     */
    @Schema(description = "最后更新人")
    private String updatedBy;

}
