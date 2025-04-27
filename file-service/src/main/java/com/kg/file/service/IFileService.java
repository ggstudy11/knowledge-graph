package com.kg.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.file.model.File;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.vo.FileVO;
import jakarta.validation.Valid;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:35
 * @description
 */
public interface IFileService extends IService<File> {
    FileVO create(@Valid CreateFileDTO createFileDTO, Integer id);
}
