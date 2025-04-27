package com.kg.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.common.PageDTO;
import com.kg.file.model.File;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.vo.FileFolderVO;
import com.kg.file.model.vo.FileVO;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:35
 * @description
 */
public interface IFileService extends IService<File> {
    FileVO create(@Valid CreateFileDTO createFileDTO, Integer id);

    LocalDateTime upload(MultipartFile file, Integer id);

    String getUrl(Integer id);

    PageDTO<FileFolderVO> pageQuery(Integer id);
}
