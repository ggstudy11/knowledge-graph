package com.kg.blog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 10:13 PM
 * @description 博客内容检测
 */
@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "博客监控接口", description = "负责博客内容监控相关操作的控制类")
public class BlogController {

    @PostMapping("/extract")
    @Operation(summary = "提取博客关键字", description = "提取博客关键字生成知识节点")
    public void extractKey() {

    }

    @GetMapping("/set")
    @Operation(summary = "获取用户设置", description = "获取用户设置")
    public void getSet() {

    }

    @PutMapping("/set")
    @Operation(summary = "更新用户设置", description = "更新用户设置")
    public void updateSet() {

    }
}
