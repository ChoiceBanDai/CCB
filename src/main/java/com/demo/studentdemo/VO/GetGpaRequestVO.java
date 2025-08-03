package com.demo.studentdemo.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "获取GPA请求参数")
public class GetGpaRequestVO {
    @Schema(description = "学生学号", required = true)
    private String studentId;
}
