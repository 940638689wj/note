package com.lz.haida.dao;


import com.lz.haida.common.MyBatisDao;
import com.lz.haida.domain.User;

/**
 * @description 会员dao
 *
 * @author
 * @date
 */
@MyBatisDao
public interface UserDao {

    /**
     * 新增
     *
     * @param user 用户信息
     */
    void insert(User user);

    /**
     * 更新
     *
     * @param user 用户信息
     */
    void update(User user);

    /**
     * 删除
     *
     * @param id 用户id
     */
    void delete(Integer id);

    /**
     * 根据主键获取
     *
     * @param id 用户id
     */
    User get(Integer id);

    /**
     * 根据手机号码获取
     *
     * @param UserName 用户名
     * @return
     */
    User getByUserName(String UserName);

    /**
     * 根据登录名获取
     *
     * @param loginName 登录名
     * @return
     */
    User getByLoginName(String loginName);

    /**
     * 根据登录名和密码获取用户信息
     *
     * @param user 用户信息
     * @return
     */
    User getLoginUser(User user);

}
