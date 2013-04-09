package com.svwpu.mailbirthday.sendmail.dao.impl;

import org.springframework.stereotype.Repository;

import com.svwpu.mailbirthday.base.dao.BaseDaoImpl;
import com.svwpu.mailbirthday.sendmail.dao.SendMessageDao;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;

@Repository
public class SendMessageDaoImpl extends BaseDaoImpl<SendMessage, Long> implements SendMessageDao {

}
