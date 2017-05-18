package com.lz.haida.service;

import com.lz.haida.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description 会员登录
 *
 * @author
 * @date
 */
public interface LoginService {

    /**
     * 验证登录表单
     *
     * @param user 登录表单信息
     * @param request
     * @return
     */
    Map<String, Object> loginPost(User user, HttpServletRequest request);
}
