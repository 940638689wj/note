package com.lz.haida.service.impl;

import com.lz.haida.common.PasswordEncoderUtils;
import com.lz.haida.dao.UserDao;
import com.lz.haida.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lz.haida.service.UserService;

import java.util.Date;

/**
 * @author
 * @description 会员
 * @date
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    /**
     * 新增/修改
     *
     * @param user id不存在则新增，存在则修改
     */
    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setCreateTime(new Date());
            if (user.getLoginName() == null) {
                user.setLoginName(user.getUserName());
            }
            user.setPassword(PasswordEncoderUtils.getMd5(user.getPassword()));
            user.setStatusCd(1);
            this.insert(user);
        } else {
            User updateUser = this.get(user.getId());
            updateUser.setLoginName(user.getLoginName());
            updateUser.setPassword(user.getPassword());
            updateUser.setSexCd(user.getSexCd());
            updateUser.setUserName(user.getUserName());
            this.update(user);
        }
    }

    @Override
    @Transactional
    public void insert(User user) {
        dao.insert(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public User get(Integer id) {
        return dao.get(id);
    }

    /**
     * 根据手机号码获取
     *
     * @param UserName 手机号码
     * @return
     */
    @Override
    public User getByUserName(String UserName) {
        return dao.getByUserName(UserName);
    }

    /**
     * 根据登录名获取
     *
     * @param loginName 登录名
     * @return
     */
    @Override
    public User getByLoginName(String loginName) {
        return dao.getByLoginName(loginName);
    }

    /**
     * 根据登录名和密码获取用户信息
     *
     * @param loginName 登录名
     * @return
     */
    @Override
    public User getLoginUser(String loginName) {
        User user = new User();
        user.setLoginName(loginName);
        return dao.getLoginUser(user);
    }
}
