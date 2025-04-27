package com.kg.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.common.PageDTO;
import com.kg.common.utils.OssUtil;
import com.kg.file.model.File;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.vo.FileFolderVO;
import com.kg.file.model.vo.FileVO;
import com.kg.file.repository.FileMapper;
import com.kg.file.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

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

    @Override
    public LocalDateTime upload(MultipartFile file, Integer id) {

        String url = OssUtil.upload(file);

        File f = this.getById(id);
        f.setUrl(url);
        f.setUpdateTime(LocalDateTime.now());
        this.updateById(f);

        return f.getUpdateTime();
    }

    @Override
    public String getUrl(Integer id) {
        return this.getById(id).getUrl();
    }

    @Override
    public PageDTO<FileFolderVO> pageQuery(Integer id) {
        return null;
    }
}
