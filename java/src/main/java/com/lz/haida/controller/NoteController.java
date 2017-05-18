package com.lz.haida.controller;

import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.Note;
import com.lz.haida.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller("noteController")
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService service;


    /**
     * 笔记表单提交保存
     *
     * @param note 笔记信息
     * @return
     */
    @RequestMapping(value = "/saveNote")
    @ResponseBody
    public Map<String, Object> saveNote(Note note, HttpServletRequest request) {
        Map<String, Object> resultMap;
        try {
            note.setUserId(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
            service.save(note);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 根据noteId删除笔记
     *
     * @param noteId 笔记id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(Integer noteId) {
        Map<String, Object> resultMap;
        try {
            service.deleteNote(noteId, 0);//假删，状态更改为0
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 查询笔记列表数据
     *
     * @param note 查询条件
     * @return
     */
    @RequestMapping(value = "/findList")
    @ResponseBody
    public Map<String, Object> findList(Note note) {
        Map<String, Object> resultMap;
        try {
            List<Note> noteList = service.listNote(note);
            resultMap = RenderUtils.renderSuccess(noteList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("查询笔记列表数据失败!");
        }
        return resultMap;
    }

    /**
     * 根据id获取当前笔记数据
     *
     * @param noteId 笔记id
     * @return
     */
    @RequestMapping(value = "getNote")
    @ResponseBody
    public Map<String, Object> getNote(Integer noteId) {
        Map<String, Object> resultMap;
        try {
            Note note = service.get(noteId);
            resultMap = RenderUtils.renderSuccess(note);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("获取当前笔记数据失败!");
        }
        return resultMap;
    }

    /**
     * 更改收藏状态
     *
     * @param note 收藏笔记的id以及收藏状态
     * @return
     */
    @RequestMapping(value = "changeCollect")
    @ResponseBody
    public Map<String, Object> changeCollect(Note note) {
        Map<String, Object> resultMap;
        try {
            service.changeCollect(note);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("收藏失败!");
        }
        return resultMap;
    }

    /**
     * 从回收站还原
     *
     * @param noteId 笔记id
     * @return
     */
    @RequestMapping(value = "restore")
    @ResponseBody
    public Map<String, Object> restore(Integer noteId) {
        Map<String, Object> resultMap;
        try {
            service.deleteNote(noteId, 1);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("还原失败");
        }
        return resultMap;
    }

    /**
     * 真删
     *
     * @param noteId 笔记id
     * @return
     */
    @RequestMapping(value = "trueDelete")
    @ResponseBody
    public Map<String, Object> trueDelete(Integer noteId) {
        Map<String, Object> resultMap;
        try {
            service.delete(noteId);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("删除失败");
        }
        return resultMap;
    }

}