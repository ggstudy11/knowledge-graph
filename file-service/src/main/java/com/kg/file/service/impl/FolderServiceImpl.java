package com.kg.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.common.UserContext;
import com.kg.file.model.Folder;
import com.kg.file.model.dto.CreateFolderDTO;
import com.kg.file.model.dto.UpdateFolderDTO;
import com.kg.file.model.vo.FolderVO;
import com.kg.file.repository.FolderMapper;
import com.kg.file.service.IFolderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 13:56
 * @description
 */
@Service
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> implements IFolderService {
    @Override
    public FolderVO create(CreateFolderDTO createFolderDTO) {

        Folder folder = Folder.builder()
                .name(createFolderDTO.getName())
                .userId(UserContext.getUser())
                .parentId(createFolderDTO.getFolderId())
                .createTime(LocalDateTime.now()).build();

        this.save(folder);

        return FolderVO.builder().id(folder.getId()).name(folder.getName()).createTime(folder.getCreateTime()).build();
    }

    @Override
    public void updateFolder(UpdateFolderDTO updateFolderDTO, Integer id) {
        Folder folder = this.getById(id);

        folder.setParentId(updateFolderDTO.getFolderId());
        folder.setCreateTime(LocalDateTime.now());
        folder.setName(updateFolderDTO.getFolderName());

        this.save(folder);
    }
}
