package com.lz.haida.controller;

import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.Note;
import com.lz.haida.domain.NoteType;
import com.lz.haida.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller("noteTypeController")
@RequestMapping("noteType")
public class NoteTypeController {

    @Autowired
    private NoteTypeService service;


    /**
     * 笔记类型表单提交保存
     *
     * @param noteType 笔记类型信息
     * @return
     */
    @RequestMapping(value = "/saveNoteType")
    @ResponseBody
    public Map<String, Object> saveNoteType(NoteType noteType, HttpServletRequest request) {
        Map<String, Object> resultMap;
        try {
            noteType.setUserId(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
            service.save(noteType);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 根据noteId删除笔记类型
     *
     * @param noteTypeId 笔记类型id
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(Integer noteTypeId) {
        Map<String, Object> resultMap;
        try {
            service.deleteNoteType(noteTypeId);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 查询所有笔记类型
     *
     * @return
     */
    @RequestMapping("findNoteTypeList")
    @ResponseBody
    public Map<String, Object> findNoteTypeList(HttpServletRequest request) {
        try {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            return RenderUtils.renderSuccess(service.findNoteTypeList(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return RenderUtils.renderError(e.getMessage());
        }
    }

    /**
     * 获取笔记分类列表数据
     *
     * @param noteType
     * @return
     */
    @RequestMapping(value = "findList")
    @ResponseBody
    public Map<String, Object> findList(NoteType noteType, Note note, HttpServletRequest request) {
        Map<String, Object> resultMap;
        try {
            noteType.setUserId((Integer)request.getSession().getAttribute("userId"));
            List<NoteType> noteTypeList = service.listNoteType(noteType,note);
            resultMap = RenderUtils.renderSuccess(noteTypeList);
        }catch (Exception e){
            e.printStackTrace();
            resultMap = RenderUtils.renderError("获取笔记分类列表数据失败!");
        }
        return resultMap;
    }
}
