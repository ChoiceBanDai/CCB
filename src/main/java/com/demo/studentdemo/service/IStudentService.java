package com.demo.studentdemo.service;

import com.demo.studentdemo.VO.GetGpaRequestVO;
import com.demo.studentdemo.VO.StudentGpaVO;
import com.demo.studentdemo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学生基本信息 服务类
 * </p>
 *
 * @author admin
 * @since 2025-07-30
 */
public interface IStudentService extends IService<Student> {
    StudentGpaVO getStudentGpa(GetGpaRequestVO requestVO);
}
