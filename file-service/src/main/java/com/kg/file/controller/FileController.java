package com.kg.file.controller;

import com.kg.common.page.PageDTO;
import com.kg.common.R;
import com.kg.common.UserContext;
import com.kg.common.page.PageQuery;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.dto.CreateFolderDTO;
import com.kg.file.model.dto.UpdateFileDTO;
import com.kg.file.model.dto.UpdateFolderDTO;
import com.kg.file.model.vo.FileFolderVO;
import com.kg.file.model.vo.FileVO;
import com.kg.file.model.vo.FolderVO;
import com.kg.file.service.IFileService;
import com.kg.file.service.IFolderService;
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
    private final IFolderService folderService;

    @PostMapping("/file")
    @Operation(summary = "新建文件", description = "创建文件元描述符")
    public R<FileVO> createFile(@Valid @RequestBody CreateFileDTO createFileDTO) {
        log.info("创建文件：{}", createFileDTO);
        return R.success(fileService.create(createFileDTO));
    }

    @PostMapping("/file/{id}")
    @Operation(summary = "保存文件", description = "保存文件内容")
    public R<LocalDateTime> saveFile(@RequestParam("file") MultipartFile file, @PathVariable(value = "id") Integer id) {
        log.info("保存文件：{}", file);
        return R.success(fileService.upload(file, id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "文件列表查询", description = "查询指定列表下的文件")
    public R<PageDTO<FileFolderVO>> queryAll(@PathVariable(value = "id") Integer id,
                                             @RequestParam(value = "pageNo") Integer pageNo,
                                             @RequestParam(value = "pageSize") Integer pageSize) {
        log.info("查询文件列表：{}", id);
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        return R.success(fileService.pageQuery(id, pageQuery));
    }

    @GetMapping("/file/{id}")
    @Operation(summary = "获取文件内容", description = "根据id获取文件url")
    public R<String> getFile(@PathVariable(value = "id") Integer id) {
        log.info("获取文件：{}", id);
        return R.success(fileService.getUrl(id));
    }


    @DeleteMapping("/file/{id}")
    @Operation(summary = "删除文件", description = "删除文件")
    public R<Object> deleteFile(@PathVariable Integer id) {
        log.info("删除文件：{}", id);
        fileService.removeById(id);
        return R.success();
    }

    @PutMapping("/file/{id}")
    @Operation(summary = "移动或修改文件名", description = "文件重命名、移动")
    public R<Object> updateFile(@PathVariable(value = "id") Integer id, @RequestBody UpdateFileDTO updateFileDTO) {
        log.info("修改文件：{}", updateFileDTO);
        fileService.updateFile(updateFileDTO, id);
        return R.success();
    }

    @PostMapping("/folder")
    @Operation(summary = "新建文件夹", description = "创建文件夹")
    public R<FolderVO> createFolder(@Valid @RequestBody CreateFolderDTO createFolderDTO) {
        log.info("创建文件夹：{}", createFolderDTO);
        return R.success(folderService.create(createFolderDTO));
    }

    @PutMapping("/folder/{id}")
    @Operation(summary = "移动或修改文件名", description = "文件重命名、移动")
    public R<Object> updateFolder(@PathVariable(value = "id") Integer id, @RequestBody UpdateFolderDTO updateFolderDTO) {
        log.info("修改文件夹：{}", updateFolderDTO);
        folderService.updateFolder(updateFolderDTO, id);
        return R.success();
    }
}
