package com.kg.file.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.common.page.PageDTO;
import com.kg.common.page.PageQuery;
import com.kg.common.utils.OssUtil;
import com.kg.file.model.File;
import com.kg.file.model.dto.CreateFileDTO;
import com.kg.file.model.dto.UpdateFileDTO;
import com.kg.file.model.vo.FileFolderVO;
import com.kg.file.model.vo.FileVO;
import com.kg.file.repository.FileMapper;
import com.kg.file.service.IFileService;
import com.kg.file.service.IFolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:36
 * @description
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    private final FileMapper fileMapper;

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
        f.setRevisions(f.getRevisions() + 1);
        this.updateById(f);

        return f.getUpdateTime();
    }

    @Override
    public String getUrl(Integer id) {
        return this.getById(id).getUrl();
    }

    @Override
    public PageDTO<FileFolderVO> pageQuery(Integer id, PageQuery pageQuery) {
        Page<Map<String, Object>> page = new Page<>(pageQuery.getPageNo(), pageQuery.getPageSize());
        Page<Map<String, Object>> result = fileMapper.selectFileAndFolder(id, page);

        List<FileFolderVO> voList = result.getRecords().stream().map(record -> {
            FileFolderVO vo = new FileFolderVO();
            vo.setId(((Number) record.get("id")).intValue());
            vo.setName((String) record.get("name"));
            vo.setIsFolder(((Number) record.get("is_folder")).intValue());
            vo.setType(((Number) record.get("type")).intValue());
            vo.setLastTime((LocalDateTime) record.get("last_time"));
            return vo;
        }).toList();

        return new PageDTO<>(result.getTotal(), result.getPages(), voList);
    }

    @Override
    public void updateFile(UpdateFileDTO updateFileDTO, Integer id) {
        Integer folderId = updateFileDTO.getFolderId();
        String name = updateFileDTO.getName();
        File file = this.getById(id);

        file.setUpdateTime(LocalDateTime.now());
        file.setRevisions(file.getRevisions() + 1);
        file.setName(name);
        file.setFolderId(folderId);

        this.updateById(file);
    }
}
