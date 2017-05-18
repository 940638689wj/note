package com.lz.haida.domain;

import java.util.Date;

/**
 * @description 会员domain
 *
 * @author
 * @date
 */
public class User{

    private Integer id; //用户id
    private String loginName; //登录名
    private String password; //登录密码
    private String userName; //用户名
    private Integer sexCd; //性别
    private Integer statusCd; //用户状态
    private Date createTime; //注册时间

    /**
      * 获取 用户id
      */
    public Integer getId(){
        return this.id;
    }
    
    /**
      * 设置 用户id
      */
    public void setId(Integer id){
        this.id = id;
    }
    
    /**
      * 获取 登录名
      */
    public String getLoginName(){
        return this.loginName;
    }
    
    /**
      * 设置 登录名
      */
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }
    
    /**
      * 获取 登录密码
      */
    public String getPassword(){
        return this.password;
    }
    
    /**
      * 设置 登录密码
      */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 获取 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
      * 获取 性别
      */
    public Integer getSexCd(){
        return this.sexCd;
    }
    
    /**
      * 设置 性别
      */
    public void setSexCd(Integer sexCd){
        this.sexCd = sexCd;
    }
    
    /**
      * 获取 用户状态
      */
    public Integer getStatusCd(){
        return this.statusCd;
    }
    
    /**
      * 设置 用户状态
      */
    public void setStatusCd(Integer statusCd){
        this.statusCd = statusCd;
    }
    
    /**
      * 获取 注册时间
      */
    public Date getCreateTime(){
        return this.createTime;
    }
    
    /**
      * 设置 注册时间
      */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    
}
