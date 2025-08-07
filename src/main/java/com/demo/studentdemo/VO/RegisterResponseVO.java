package com.demo.studentdemo.VO;

import lombok.Data;

@Data
public class RegisterResponseVO {
    private String status="SUCCESS";
    private String username;
    private String studentId;
    private String message;

    public static RegisterResponseVO success(String username, String studentId) {
        RegisterResponseVO vo = new RegisterResponseVO();
        vo.setStatus("SUCCESS");
        vo.setUsername(username);
        vo.setStudentId(studentId);
        vo.setMessage("注册成功");
        return vo;
    }

    /**
     * 静态方法，用于创建错误响应对象
     */
    public static RegisterResponseVO error(String message) {
        RegisterResponseVO vo = new RegisterResponseVO();
        vo.setStatus("ERROR");
        vo.setMessage(message);
        return vo;
    }
}
