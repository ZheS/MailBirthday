package com.svwpu.mailbirthday.sendmail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.svwpu.mailbirthday.base.service.BaseServiceImpl;
import com.svwpu.mailbirthday.sendmail.dao.SendMessageDao;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;
import com.svwpu.mailbirthday.sendmail.service.SendMessageService;

@Service("sendMessageService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SendMessageServiceImpl extends BaseServiceImpl implements SendMessageService {

    @Resource
    private SendMessageDao sendMessageDao;

    @Override
    public List<SendMessage> findAllSendMessage() {
	return sendMessageDao.loadAll();
    }

    @Override
    public SendMessage getById(Long id) {
	return sendMessageDao.get(id);
    }

}
