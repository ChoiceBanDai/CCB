package com.demo.studentdemo.service.impl;

import com.demo.studentdemo.entity.Grade;
import com.demo.studentdemo.mapper.GradeMapper;
import com.demo.studentdemo.service.IGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生基本信息 服务实现类
 * </p>
 *
 * @author admin
 * @since 2025-08-02
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService{
}
