package com.lz.haida.domain;


import java.util.Date;
import java.util.List;

public class NoteType {

    private Integer typeId; //类型ID
    private Integer userId; // 用户id
    private String typeName; //描述
    private Integer displayId; //排序
    private Date createTime; //创建时间
    private Integer statusCd; //状态
    private String typeDesc; //分类类型描述
    private Date lastUpdateTime;//更新时间

    private List<Note> noteList;//笔记list

    /**
     * 获取 类型ID
     */
    public Integer getTypeId() {
        return this.typeId;
    }

    /**
     * 设置 类型ID
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 描述
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * 设置 描述
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取 排序
     */
    public Integer getDisplayId() {
        return this.displayId;
    }

    /**
     * 设置 排序
     */
    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    /**
     * 获取 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 状态
     */
    public Integer getStatusCd() {
        return this.statusCd;
    }

    /**
     * 设置 状态
     */
    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * 获取 分类类型描述
     */
    public String getTypeDesc() {
        return this.typeDesc;
    }

    /**
     * 设置 分类类型描述
     */
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    /**
     * 获取 更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置 更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
