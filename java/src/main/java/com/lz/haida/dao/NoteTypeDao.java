package com.lz.haida.dao;


import com.lz.haida.common.MyBatisDao;
import com.lz.haida.domain.NoteType;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface NoteTypeDao {
    /**
     * 新增
     *
     * @param noteType 笔记类型
     */
    void insert(NoteType noteType);

    /**
     * 更新
     *
     * @param noteType 笔记类型
     */
    void update(NoteType noteType);

    /**
     * 删除
     *
     * @param id 笔记类型id
     */
    void delete(Integer id);

    /**
     * 根据主键获取
     *
     * @param id 笔记类型id
     */
    NoteType get(Integer id);

    /**
     * 查询所有笔记类型
     *
     * @param userId
     * @return
     */
    List<NoteType> findNoteTypeList(Integer userId);

    /**
     * 查询list
     *
     * @param noteType
     * @return
     */
    List<NoteType> listNoteType(NoteType noteType);
}
