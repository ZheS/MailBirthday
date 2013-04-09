package com.svwpu.mailbirthday.sendmail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.svwpu.mailbirthday.base.service.BaseServiceImpl;
import com.svwpu.mailbirthday.sendmail.dao.LoginUserDao;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;
import com.svwpu.mailbirthday.sendmail.service.LoginUserService;

@Service("loginUserService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class LoginUserServiceImpl extends BaseServiceImpl implements LoginUserService {

    @Resource
    LoginUserDao loginUserDao;

    @Override
    public List<LoginUser> getAllLoginUser() {
	return loginUserDao.loadAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void createLoginUser(LoginUser loginUser) {
	loginUserDao.save(loginUser);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateLoginUser(LoginUser loginUser) {
	loginUserDao.update(loginUser);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteLoginUser(LoginUser loginUser) {
	loginUserDao.delete(loginUser);
    }

    @Override
    public LoginUser findById(Long id) {
	return loginUserDao.get(id);
    }

    @Override
    public LoginUser findByUserID(String userID) {
	return loginUserDao.getByUserID(userID);
    }

}
