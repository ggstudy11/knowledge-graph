package com.kg.file.controller;

import com.kg.common.PageDTO;
import com.kg.common.R;
import com.kg.common.UserContext;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.vo.FileFolderVO;
import com.kg.file.model.vo.FileVO;
import com.kg.file.service.IFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 11:01 PM
 * @description 文件存储控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
@Slf4j
@Tag(name = "文件管理接口", description = "文件管理相关操作接口")
public class FileController {

    private final IFileService fileService;

    @PostMapping("/file")
    @Operation(summary = "新建文件", description = "创建文件元描述符")
    public R<FileVO> create(@Valid @RequestBody CreateFileDTO createFileDTO) {
        return R.success(fileService.create(createFileDTO, UserContext.getUser()));
    }

    @PostMapping("/file/{id}")
    public R<LocalDateTime> save(MultipartFile file, @PathVariable Integer id) {
        return R.success(fileService.upload(file, id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "文件列表查询", description = "查询指定列表下的文件")
    public R<PageDTO<FileFolderVO>> query(@PathVariable Integer id) {
        return R.success(fileService.pageQuery(id));
    }

    @GetMapping("/file/{id}")
    @Operation(summary = "获取文件内容", description = "根据id获取文件url")
    public R<String> get(@PathVariable Integer id) {
        return R.success(fileService.getUrl(id));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "删除文件", description = "删除文件")
    public void delete() {

    }

    @PutMapping("/{id}")
    @Operation(summary = "文件操作元", description = "文件重命名、移动、保存")
    public void updateName() {

    }

}
