package com.lz.haida.dao;


import com.lz.haida.common.MyBatisDao;
import com.lz.haida.domain.Note;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface NoteDao {
    /**
     * 新增
     *
     * @param note 笔记
     */
    void insert(Note note);

    /**
     * 更新
     *
     * @param note 笔记
     */
    void update(Note note);

    /**
     * 删除
     *
     * @param id 笔记id
     */
    void delete(Integer id);

    /**
     * 根据主键获取
     *
     * @param id 笔记id
     */
    Note get(Integer id);

    /**
     * 查询list
     *
     * @param note
     * @return
     */
    List<Note> listNote(Note note);

}
