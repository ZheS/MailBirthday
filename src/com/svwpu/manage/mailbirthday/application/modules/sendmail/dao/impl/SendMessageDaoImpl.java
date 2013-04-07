package com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.impl;

import org.springframework.stereotype.Repository;

import com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.SendMessageDao;
import com.svwpu.manage.mailbirthday.application.modules.sendmail.model.SendMessage;
import com.svwpu.manage.mailbirthday.core.base.dao.BaseDaoImpl;

@Repository
public class SendMessageDaoImpl extends BaseDaoImpl<SendMessage, Long> implements SendMessageDao {

}
