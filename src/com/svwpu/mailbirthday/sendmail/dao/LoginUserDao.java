package com.svwpu.mailbirthday.sendmail.dao;

import com.svwpu.mailbirthday.base.dao.BaseDao;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;

public interface LoginUserDao extends BaseDao<LoginUser, Long> {

    LoginUser getByUserID(String userID);

}
