package com.lz.haida.service;


import com.lz.haida.domain.User;

/**
 * @description 会员
 *
 * @author
 * @date
 */
public interface UserService {

    /**
     * 新增/修改
     *
     * @param user id不存在则新增，存在则修改
     */
    void save(User user);

    void insert(User user);

    void delete(Integer id);

    void update(User user);

    User get(Integer id);

    /**
     * 根据手机号码获取
     *
     * @param UserName
     * @return
     */
    User getByUserName(String UserName);

    /**
     * 根据登录名获取
     *
     * @param loginName
     * @return
     */
    User getByLoginName(String loginName);

    /**
     * 根据登录名和密码获取用户信息
     *
     * @param loginName 登录名
     * @return
     */
    User getLoginUser(String loginName);
}
