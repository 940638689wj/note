package com.lz.haida.service;

import com.lz.haida.domain.Note;

import java.util.List;
import java.util.Map;

public interface NoteService {

    /**
     * 新增/修改
     *
     * @param note id不存在则新增，存在则修改
     */
    void save(Note note);

    /**
     * 更改笔记状态
     *
     * @param noteId
     */
    void deleteNote(Integer noteId, Integer statusCd);

    /**
     * 获取noteList
     *
     * @param note
     * @return
     */
    List<Note> listNote(Note note);

    /**
     * 更改收藏状态
     *
     * @param note
     */
    void changeCollect(Note note);

    void insert(Note note);

    void delete(Integer id);

    void update(Note note);

    Note get(Integer id);

}
