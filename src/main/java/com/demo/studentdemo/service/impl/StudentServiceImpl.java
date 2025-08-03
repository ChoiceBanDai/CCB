package com.demo.studentdemo.service.impl;

import com.demo.studentdemo.entity.Student;
import com.demo.studentdemo.mapper.StudentMapper;
import com.demo.studentdemo.service.IStudentService;
import com.demo.studentdemo.VO.GetGpaRequestVO;
import com.demo.studentdemo.VO.StudentGpaVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生基本信息 服务实现类
 * </p>
 *
 * @author admin
 * @since 2025-07-30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentGpaVO getStudentGpa(GetGpaRequestVO requestVO) {
        // 调用Mapper方法查询GPA
        return studentMapper.selectStudentGpa(requestVO.getStudentId());
    }
}
