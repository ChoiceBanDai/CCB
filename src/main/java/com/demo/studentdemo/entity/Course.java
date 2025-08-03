package com.demo.studentdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema; // 新的注解导入

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程基本信息
 * </p>
 *
 * @author admin
 * @since 2025-08-02
 */
@Getter
@Setter
@ToString
@TableName("t_course")
@Schema(name = "Course", description = "课程基本信息") // 替换 @ApiModel
public class Course implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 课程表自增主键ID
     */
    @Schema(description = "课程表自增主键ID") // 替换 @ApiModelProperty
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程代码
     */
    @Schema(description = "课程代码") // 替换 @ApiModelProperty
    private String courseCode;

    /**
     * 课程名称
     */
    @Schema(description = "课程名称")
    private String courseName;

    /**
     * 学分（1-6）
     */
    @Schema(description = "学分")
    private Integer credit;

    /**
     * 课程类型
     */
    @Schema(description = "课程类型")
    private String courseType;

    /**
     * 开课院系名称
     */
    @Schema(description = "部门名称")
    private String deptName;

    /**
     * 课程描述
     */
    @Schema(description = "课程描述")
    private String courseDesc;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    /**
     * 最后更新时间
     */
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;

    /**
     * 创建人
     */
    @Schema(description = "创建者")
    private String createdBy;

    /**
     * 最后更新人
     */
    @Schema(description = "最后更新人")
    private String updatedBy;


}
