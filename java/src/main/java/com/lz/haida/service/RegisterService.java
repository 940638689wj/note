package com.lz.haida.service;

import com.lz.haida.domain.User;

import java.util.Map;

/**
 * @description  会员注册
 *
 * @author
 * @date
 */
public interface RegisterService {

    /**
     * 用户注册表单信息提交
     *
     * @param user 用户信息
     * @return
     */
    Map<String, Object> registerPost(User user);
}
