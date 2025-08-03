package com.demo.studentdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.studentdemo.entity.Student;
import com.demo.studentdemo.VO.StudentGpaVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 学生基本信息 Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2025-07-30
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询学生GPA
     * @param studentId 学生学号
     * @return 学生GPA信息
     */
    StudentGpaVO selectStudentGpa(@Param("studentId") String studentId);
}
