package com.lz.haida.controller;

import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.User;
import com.lz.haida.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author
 * @description 会员登录
 * @date
 */
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * 提交登录表单
     *
     * @param user    登录表单
     * @param request
     */
    @RequestMapping(value = "/loginPost")
    @ResponseBody
    public Map<String, Object> loginPost(User user, HttpServletRequest request) {
        Map<String, Object> resultMap;
        try {
            resultMap = service.loginPost(user, request);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("登录失败,请稍后再试!");
        }
        return resultMap;
    }

    /**
     * 判断是否登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/isLogin")
    @ResponseBody
    public Map<String, Object> isLogin(HttpServletRequest request) {
        Map<String, Object> resultMap;
        if (request.getSession().getAttribute("userId") != null) {
            resultMap = RenderUtils.renderSuccess("");
        }else{
            resultMap = RenderUtils.renderError("您还未登录!");
        }
        return resultMap;
    }

    /**
     * 登出
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map logout(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        return RenderUtils.renderSuccess("");
    }

}
