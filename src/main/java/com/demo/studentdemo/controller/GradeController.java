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
 * 成绩信息 前端控制器
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
     * 获取成绩记录列表
     */
    @GetMapping("/list")
    public ResponseEntity<List<Grade>> list() {
        List<Grade> grades = gradeService.list();
        return ResponseEntity.ok(grades);
    }

    /**
     * 分页查询所有成绩记录
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


    /**
     * 根据ID获取成绩信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<Grade> getById(@PathVariable Long id) {
        Grade grade = gradeService.getById(id);
        if (grade != null) {
            return ResponseEntity.ok(grade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 添加成绩
     */
    @PostMapping
    public ResponseEntity<Grade> add(@RequestBody Grade grade) {
        // 设置创建时间和更新时间
        LocalDateTime now = LocalDateTime.now();
        grade.setCreatedAt(now);
        grade.setUpdatedAt(now);
        grade.setCreatedBy("admin"); // 实际应用中应该从登录用户获取
        grade.setUpdatedBy("admin");

        boolean success = gradeService.save(grade);
        if (success) {
            return ResponseEntity.ok(grade);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * 更新成绩信息
     */
    @PutMapping("/{id}")
    public ResponseEntity<Grade> update(@PathVariable Long id, @RequestBody Grade grade) {
        Grade existinggrade = gradeService.getById(id);
        if (existinggrade == null) {
            return ResponseEntity.notFound().build();
        }

        grade.setId(id);
        grade.setUpdatedAt(LocalDateTime.now());
        grade.setUpdatedBy("admin"); // 实际应用中应该从登录用户获取
        grade.setCreatedAt(existinggrade.getCreatedAt());
        grade.setCreatedBy(existinggrade.getCreatedBy());

        boolean success = gradeService.updateById(grade);
        if (success) {
            return ResponseEntity.ok(grade);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * 删除成绩
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean exists = gradeService.getById(id) != null;
        if (!exists) {
            return ResponseEntity.notFound().build();
        }

        boolean success = gradeService.removeById(id);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

