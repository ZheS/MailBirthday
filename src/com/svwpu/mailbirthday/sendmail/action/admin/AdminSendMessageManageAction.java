package com.svwpu.mailbirthday.sendmail.action.admin;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.svwpu.mailbirthday.base.action.BaseAction;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;
import com.svwpu.mailbirthday.sendmail.service.SendMessageService;

@ParentPackage(value = "struts-default")
@Namespace(value = "/admin")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "input", params = {
	"param1", "val1" }) })
public class AdminSendMessageManageAction extends BaseAction {

    private static final long serialVersionUID = -6832104674137007910L;

    @Autowired
    private SendMessageService sendMessageService;

    private List<SendMessage> sendMessages;

    private Date sendTime;

    private String name;

    private String email;

    private String memo;

    @Action(value = "sendMessage", results = {
	    @Result(name = "success", location = "sendMessageManage/sendMessage.jsp"),
	    @Result(name = "input", location = "/error.jsp") })
    public String sendMessage() {
	String ret;
	sendMessages = sendMessageService.findAllSendMessage();
	// employees =
	// // 计算总页数
	// if (page == 0)
	// page = 1;
	// count = corporations.size();
	// totalPage = (count - 1) / 10 + 1;
	// // 每页显示10条
	// int listStart = (page - 1) * 10;
	// int listEnd = page * 10;// which is exclusive
	// if (listEnd >= corporations.size())
	// listEnd = corporations.size();
	// corporations = corporations.subList(listStart, listEnd);
	ret = SUCCESS;
	return ret;
    }

    public List<SendMessage> getSendMessages() {
	return sendMessages;
    }

    public void setSendMessages(List<SendMessage> sendMessages) {
	this.sendMessages = sendMessages;
    }

    public Date getSendTime() {
	return sendTime;
    }

    public void setSendTime(Date sendTime) {
	this.sendTime = sendTime;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getMemo() {
	return memo;
    }

    public void setMemo(String memo) {
	this.memo = memo;
    }

}
