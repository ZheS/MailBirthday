package com.svwpu.mailbirthday.sendmail.service;

import java.util.List;

import com.svwpu.mailbirthday.base.service.BaseService;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;

/**
 * 后台账户管理模块
 * 
 * @author SZ
 * 
 */
public interface LoginUserService extends BaseService {

    /**
     * 获得所有后台账户列表
     * 
     * @param
     * @return List<LoginUser>
     */
    List<LoginUser> findAllLoginUser();

    /**
     * 添加后台账户
     * 
     * @param loginUser
     * @return
     */
    void createLoginUser(LoginUser loginUser);

    /**
     * 更新后台账户信息
     * 
     * @param loginUser
     * @return
     */
    void updateLoginUser(LoginUser loginUser);

    /**
     * 删除后台账户信息
     * 
     * @param loginUser
     * @return
     */
    void deleteLoginUser(LoginUser loginUser);

    /**
     * 根据id查询后台账户
     * 
     * @param id
     * @return LoginUser
     */
    LoginUser getById(Long id);

    /**
     * 根据工号查询后台账户
     * 
     * @param userID
     * @return LoginUser
     */
    LoginUser getByUserID(String userID);
}
