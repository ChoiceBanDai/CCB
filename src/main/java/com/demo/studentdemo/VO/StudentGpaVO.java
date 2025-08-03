package com.demo.studentdemo.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "学生GPA信息")
public class StudentGpaVO {
    @Schema(description = "学生学号")
    private String studentId;

    @Schema(description = "学生姓名")
    private String studentName;

    @Schema(description = "GPA", example = "3.25")
    private BigDecimal gpa;
}
