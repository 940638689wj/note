package com.lz.haida.service.impl;

import com.lz.haida.dao.NoteDao;
import com.lz.haida.domain.Note;
import com.lz.haida.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao dao;

    /**
     * 新增/修改
     *
     * @param note id不存在则新增，存在则修改
     */
    @Override
    public void save(Note note) {
        if (note.getNoteId() == null) {
            note.setIsCollect(0);
            note.setCreateTime(new Date());
            note.setStatusCd(1);
            this.insert(note);
        } else {
            Integer statusCd = note.getStatusCd();
            note = this.get(note.getNoteId());
            if (note.getStatusCd() == 0 && statusCd == 0) {
                this.delete(note.getNoteId());
            } else {
                note.setLastUpdateTime(new Date());
                this.update(note);
            }
        }
    }

    /**
     * 更改笔记状态
     *
     * @param noteId 笔记id
     */
    @Override
    public void deleteNote(Integer noteId, Integer statusCd) {
        Note note = this.get(noteId);
        note.setStatusCd(statusCd);//删除状态
        if (statusCd == 1) {//如果是还原操作，则清空笔记类型
            note.setNoteTypeId(null);
        }
        this.update(note);
    }

    /**
     * 获取noteList
     *
     * @param note
     * @return
     */
    @Override
    public List<Note> listNote(Note note) {
        return dao.listNote(note);
    }

    /**
     * 更改收藏状态
     *
     * @param note
     */
    @Override
    public void changeCollect(Note note) {
        Note changeNote = this.get(note.getNoteId());
        changeNote.setIsCollect(note.getIsCollect());
        this.update(changeNote);
    }

    @Override
    public void insert(Note note) {
        dao.insert(note);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void update(Note note) {
        dao.update(note);
    }

    @Override
    public Note get(Integer id) {
        return dao.get(id);
    }

}
