package com.kg.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.file.model.Folder;
import com.kg.file.model.dto.CreateFolderDTO;
import com.kg.file.model.dto.UpdateFolderDTO;
import com.kg.file.model.vo.FolderVO;
import jakarta.validation.Valid;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 13:56
 * @description
 */
public interface IFolderService extends IService<Folder> {
    FolderVO create(@Valid CreateFolderDTO createFolderDTO);

    void updateFolder(UpdateFolderDTO updateFolderDTO, Integer id);
}
