package com.kg.file.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kg.common.page.PageQuery;
import com.kg.file.model.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:32
 * @description
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {

    @Select("SELECT folder.id as id, folder.name as name, 1 as is_folder, -1 as type, folder.create_time as last_time " +
            "FROM folder " +
            "WHERE folder.parent_id = #{id} and folder.user_id = #{userId} " +
            "UNION ALL " +
            "SELECT file.id as id, file.name as name, 0 as is_folder, file.type as type, file.update_time as last_time " +
            "FROM file " +
            "WHERE file.folder_id = #{id} and file.user_id = #{userId} ")
    IPage<Map<String, Object>> selectFileAndFolder(Page<Map<String, Object>> page, @Param("id") Integer id, @Param("userId") Integer userId);
}
