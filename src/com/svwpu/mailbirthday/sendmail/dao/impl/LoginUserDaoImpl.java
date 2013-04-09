package com.svwpu.mailbirthday.sendmail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.svwpu.mailbirthday.base.dao.BaseDaoImpl;
import com.svwpu.mailbirthday.sendmail.dao.LoginUserDao;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;

@Repository("loginUserDao")
public class LoginUserDaoImpl extends BaseDaoImpl<LoginUser, Long> implements LoginUserDao {

    @Override
    @SuppressWarnings("unchecked")
    public LoginUser getByUserID(String userID) {
	String hql = "";
	hql = "from LoginUser lu where lu.userID='" + userID + "'";
	List<LoginUser> ls = find(hql);
	if (ls.size() > 0)
	    return ls.get(0);
	else
	    return null;
    }

}
