package com.svwpu.mailbirthday.sendmail.service;

import java.util.List;

import com.svwpu.mailbirthday.base.service.BaseService;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;


/**
 * 发送信息管理模块
 * 
 * @author SZ
 * 
 */
public interface EmployeeService extends BaseService {

    /**
     * 获得所有发送信息列表
     * 
     * @param
     * @return List<SendMessage>
     */
    List<SendMessage> findAllSendMessage();

    /**
     * 根据id查询发送信息
     * 
     * @param id
     * @return SendMessage
     */
    SendMessage getById(Long id);

}
