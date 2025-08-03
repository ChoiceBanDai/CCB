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
import java.math.BigDecimal;

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
@TableName("t_grade")
@Schema(name = "Grade", description = "成绩信息") // 替换 @ApiModel
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键ID
     */
    @Schema(description = "自增主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学号
     */
    @Schema(description = "学号")
    private String studentId;

    /**
     * 课程表主键
     */
    @Schema(description = "课程表主键")
    private Long courseId;

    /**
     * 学期(如2023S)
     */
    @Schema(description = "学期(如2023S)")
    private String semester;

    /**
     * 百分制成绩
     */
    @Schema(description = "百分制成绩")
    private BigDecimal score;

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

