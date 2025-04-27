package com.kg.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.file.model.File;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.vo.FileVO;
import com.kg.file.repository.FileMapper;
import com.kg.file.service.IFileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:36
 * @description
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Override
    public FileVO create(CreateFileDTO createFileDTO, Integer id) {
        String name = createFileDTO.getFileName();
        int folderId = createFileDTO.getFolderId();
        int type = createFileDTO.getFileType();

        File file = File.builder()
                .name(name)
                .folderId(folderId)
                .userId(id)
                .type(type)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        this.save(file);

        return FileVO.builder()
                .fileId(file.getId())
                .fileType(type)
                .fileName(name)
                .createTime(file.getCreateTime())
                .build();
    }
}
