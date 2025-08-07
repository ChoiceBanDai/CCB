// com/demo/studentdemo/VO/RegisterRequestVO.java

package com.demo.studentdemo.VO;

import lombok.Data;

@Data
public class RegisterRequestVO {
    private String studentId;
    private String username;
    private String password;
    private String operator = "system"; // 默认值
}
