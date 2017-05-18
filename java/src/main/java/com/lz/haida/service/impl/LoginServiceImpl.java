package com.lz.haida.service.impl;

import com.lz.haida.common.PasswordEncoderUtils;
import com.lz.haida.common.RenderUtils;
import com.lz.haida.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lz.haida.service.LoginService;
import com.lz.haida.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @description 会员登录
 * @date
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    /**
     * 验证登录表单
     *
     * @param user    登录表单信息
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> loginPost(User user, HttpServletRequest request) {
        //登录验证
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String encoderPaw = PasswordEncoderUtils.getMd5(user.getPassword());//加密密码
        // 会员账号和手机号皆可作为账号
        User userResult = userService.getLoginUser(user.getLoginName());
        if (userResult == null) {
            //账号不存在
            resultMap = RenderUtils.renderError("账号不存在!");
        } else if (encoderPaw != null && !encoderPaw.equals(userResult.getPassword())) {
            //密码错误
            resultMap = RenderUtils.renderError("密码错误!");
        } else {
            //登录成功
            resultMap.put("result", true);
            // session登录
            request.getSession().setAttribute("userId", userResult.getId());
        }
        return resultMap;
    }

}

