package com.demo.studentdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.studentdemo.entity.Grade;
import com.demo.studentdemo.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 课程基本信息 前端控制器
 * </p>
 *
 * @author admin
 * @since 2025-08-02
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    /**
     * 获取课程列表
     */
    @GetMapping("/list")
    public ResponseEntity<List<Grade>> list() {
        List<Grade> grades = gradeService.list();
        return ResponseEntity.ok(grades);
    }

    /**
     * 分页查询课程
     */
    @GetMapping("/page")
    public ResponseEntity<Map<String, Object>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name) {

        Page<Grade> page = new Page<>(current, size);
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();

        if (name != null && !name.isEmpty()) {
            queryWrapper.like("course_name", name);
        }

        Page<Grade> resultPage = gradeService.page(page, queryWrapper);

        Map<String, Object> result = new HashMap<>();
        result.put("records", resultPage.getRecords());
        result.put("total", resultPage.getTotal());
        result.put("current", resultPage.getCurrent());
        result.put("size", resultPage.getSize());

        return ResponseEntity.ok(result);
    }


}

