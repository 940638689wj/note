package com.lz.haida.domain;


import java.util.Date;

public class Note{

    private Integer noteId; //笔记id
    private Integer userId; //关联用户id
    private String noteTitle; //标题
    private String noteContent; //内容
    private Integer isCollect; //是否收藏
    private Integer noteTypeId; //关联笔记类型id
    private Date createTime; //创建时间
    private Date lastUpdateTime; //更新时间
    private String weather; //天气
    private String location; //地址
    private Integer statusCd;//状态

    /**
      * 获取 笔记id
      */
    public Integer getNoteId(){
        return this.noteId;
    }
    
    /**
      * 设置 笔记id
      */
    public void setNoteId(Integer noteId){
        this.noteId = noteId;
    }
    
    /**
      * 获取 关联用户id
      */
    public Integer getUserId(){
        return this.userId;
    }
    
    /**
      * 设置 关联用户id
      */
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    
    /**
      * 获取 标题
      */
    public String getNoteTitle(){
        return this.noteTitle;
    }
    
    /**
      * 设置 标题
      */
    public void setNoteTitle(String noteTitle){
        this.noteTitle = noteTitle;
    }
    
    /**
      * 获取 内容
      */
    public String getNoteContent(){
        return this.noteContent;
    }
    
    /**
      * 设置 内容
      */
    public void setNoteContent(String noteContent){
        this.noteContent = noteContent;
    }
    
    /**
      * 获取 是否收藏
      */
    public Integer getIsCollect(){
        return this.isCollect;
    }
    
    /**
      * 设置 是否收藏
      */
    public void setIsCollect(Integer isCollect){
        this.isCollect = isCollect;
    }
    
    /**
      * 获取 关联笔记类型id
      */
    public Integer getNoteTypeId(){
        return this.noteTypeId;
    }
    
    /**
      * 设置 关联笔记类型id
      */
    public void setNoteTypeId(Integer noteTypeId){
        this.noteTypeId = noteTypeId;
    }
    
    /**
      * 获取 创建时间
      */
    public Date getCreateTime(){
        return this.createTime;
    }
    
    /**
      * 设置 创建时间
      */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    
    /**
      * 获取 更新时间
      */
    public Date getLastUpdateTime(){
        return this.lastUpdateTime;
    }
    
    /**
      * 设置 更新时间
      */
    public void setLastUpdateTime(Date lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
    }
    
    /**
      * 获取 天气
      */
    public String getWeather(){
        return this.weather;
    }
    
    /**
      * 设置 天气
      */
    public void setWeather(String weather){
        this.weather = weather;
    }
    
    /**
      * 获取 地址
      */
    public String getLocation(){
        return this.location;
    }
    
    /**
      * 设置 地址
      */
    public void setLocation(String location){
        this.location = location;
    }

    /**
     * 获取 状态
     */
    public Integer getStatusCd(){
        return this.statusCd;
    }

    /**
     * 设置 状态
     */
    public void setStatusCd(Integer statusCd){
        this.statusCd = statusCd;
    }
    
}
