package com.lz.haida.service.impl;

import com.lz.haida.dao.NoteTypeDao;
import com.lz.haida.domain.Note;
import com.lz.haida.domain.NoteType;
import com.lz.haida.service.NoteService;
import com.lz.haida.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("noteTypeService")
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    private NoteTypeDao dao;
    @Autowired
    private NoteService noteService;

    /**
     * 新增/修改
     *
     * @param noteType id不存在则新增，存在则修改
     */
    @Override
    public void save(NoteType noteType) {
        if (noteType.getTypeId() == null) {
            noteType.setCreateTime(new Date());
            noteType.setStatusCd(1);
            this.insert(noteType);
        } else {
            noteType.setLastUpdateTime(new Date());
            this.update(noteType);
        }
    }

    /**
     * 删除笔记类型
     *
     * @param noteTypeId 笔记类型id
     */
    @Override
    @Transactional
    public void deleteNoteType(Integer noteTypeId) {
        // 删除笔记类型
        NoteType noteType = new NoteType();
        noteType.setTypeId(noteTypeId);
        noteType.setStatusCd(0);//删除状态
        this.update(noteType);

        // 查找该笔记类型的笔记，然后删除
        Note note = new Note();
        note.setNoteTypeId(noteType.getTypeId());
        List<Note> noteList = noteService.listNote(note);
        if (noteList != null && noteList.size() > 0) {
            for (Note delNote : noteList) {
                delNote.setStatusCd(0);//删除状态
                noteService.update(delNote);
            }
        }
    }

    /**
     * 查询所有笔记类型
     *
     * @param userId
     * @return
     */
    @Override
    public List<NoteType> findNoteTypeList(Integer userId) {
        return dao.findNoteTypeList(userId);
    }

    /**
     * 查询笔记分类list
     *
     * @param noteType 查询条件
     * @return
     */
    @Override
    public List<NoteType> listNoteType(NoteType noteType,Note note){
        // 自定义类型的笔记
        List<NoteType> noteTypeList = dao.listNoteType(noteType);
        if(noteTypeList!=null){
            for (NoteType noteTp: noteTypeList){
                note.setNoteTypeId(noteTp.getTypeId());
                List<Note> noteList = noteService.listNote(note);
                noteTp.setNoteList(noteList);
            }
        }
        return noteTypeList;
    }

    @Override
    public void insert(NoteType noteType) {
        dao.insert(noteType);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void update(NoteType noteType) {
        dao.update(noteType);
    }

    @Override
    public NoteType get(Integer id) {
        return dao.get(id);
    }

}
