package com.lz.haida.service.impl;

import com.lz.haida.domain.NoteType;
import com.lz.haida.domain.User;
import com.lz.haida.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lz.haida.service.RegisterService;
import com.lz.haida.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @description 会员注册
 * @date
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteTypeService noteTypeService;

    /**
     * 用户注册表单信息提交
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public Map<String, Object> registerPost(User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (user == null) {
            resultMap.put("result", false);
            resultMap.put("message", "用户提交信息为空!");
            return resultMap;
        }
        if (userService.getByUserName(user.getUserName()) != null || userService.getByLoginName(user.getUserName()) != null) {
            // 姓名已存在
            resultMap.put("result", false);
            resultMap.put("message", "姓名已存在!");
            return resultMap;
        }
        if (userService.getByLoginName(user.getLoginName()) != null) {
            // 用户名已存在
            resultMap.put("result", false);
            resultMap.put("message", "用户名已存在!");
            return resultMap;
        }
        // 注册成功 新增用户
        user.setCreateTime(new Date());
        userService.save(user);

        // 生成默认笔记类型
        NoteType noteType = new NoteType();
        noteType.setTypeName("默认");
        noteType.setStatusCd(1);
        noteType.setUserId(user.getId());
        noteTypeService.insert(noteType);

        resultMap.put("result", true);
        return resultMap;
    }

}
