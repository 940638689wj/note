package com.lz.haida.controller;

import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.User;
import com.lz.haida.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author
 * @description 会员Controller
 * @date
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;


    /**
     * 用户表单提交保存
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "/saveUser")
    @ResponseBody
    public Map<String, Object> saveUser(User user) {
        Map<String, Object> resultMap;
        try {
            service.save(user);
            resultMap = RenderUtils.renderSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 获取当前登录用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public Map<String, Object> getUser(HttpServletRequest request) {
        Map<String, Object> resultMap;
        try {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            if(userId==null){
                resultMap = RenderUtils.renderError("您还未登录!");
            }else{
                User user = service.get(userId);
                resultMap = RenderUtils.renderSuccess(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap = RenderUtils.renderError("获取用户信息失败！");
        }
        return resultMap;
    }
}

