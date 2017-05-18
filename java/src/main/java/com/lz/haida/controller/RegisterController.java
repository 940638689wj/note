package com.lz.haida.controller;

import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.User;
import com.lz.haida.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author
 * @description 会员注册
 * @date
 */
@Controller("registerController")
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    /**
     * 提交注册表单
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "/register_post")
    @ResponseBody
    public Map<String, Object> registerPost(User user) {
        Map<String, Object> resultMap;
        try {
            resultMap = service.registerPost(user);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = RenderUtils.renderError("注册失败!");
        }
        return resultMap;
    }
}
