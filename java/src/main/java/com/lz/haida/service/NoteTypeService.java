package com.lz.haida.service;

import com.lz.haida.domain.Note;
import com.lz.haida.domain.NoteType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoteTypeService {

    /**
     * 新增/修改
     *
     * @param noteType id不存在则新增，存在则修改
     */
    void save(NoteType noteType);

    /**
     * 删除笔记类型
     *
     * @param noteTypeId 笔记类型id
     */
    @Transactional
    void deleteNoteType(Integer noteTypeId);

    /**
     * 查询所有笔记类型
     *
     * @param userId
     * @return
     */
    List<NoteType> findNoteTypeList(Integer userId);

    /**
     * 查询笔记分类list
     *
     * @param noteType 查询条件
     * @return
     */
    List<NoteType> listNoteType(NoteType noteType,Note note);

    void insert(NoteType noteType);

    void delete(Integer id);

    void update(NoteType noteType);

    NoteType get(Integer id);

}
