package com.svwpu.mailbirthday.sendmail.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.svwpu.mailbirthday.base.action.BaseAction;
import com.svwpu.mailbirthday.sendmail.model.Employee;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;
import com.svwpu.mailbirthday.sendmail.service.EmployeeService;
import com.svwpu.mailbirthday.sendmail.service.LoginUserService;
import com.svwpu.mailbirthday.sendmail.service.SendMessageService;

@ParentPackage(value = "struts-default")
@Namespace(value = "/admin")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "input", params = {
	"param1", "val1" }) })
public class AdminAction extends BaseAction {

    private static final long serialVersionUID = 5326158448811097127L;
    
    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LoginUserService loginUserService;

    private List<SendMessage> sendMessages;

    private List<Employee> employees;

    private LoginUser loginUser;

    private Date sendTime;

    private String name;

    private String email;

    private String memo;

    @Action(value = "index", results = { @Result(name = "success", location = "index.jsp") })
    public String index() {
	SecurityContext secCtx = SecurityContextHolder.getContext();
	Authentication auth = secCtx.getAuthentication();
	Object principal = auth.getPrincipal();
	String userName = "";
	if (principal instanceof UserDetails) {
	    userName = ((UserDetails) principal).getUsername();
	} else {
	    userName = principal.toString();
	}
	String ret;
	loginUser = loginUserService.getByUserID(userName);
	sendMessages = sendMessageService.findAllSendMessage();
	employees = new ArrayList<Employee>();
	Iterator<SendMessage> it = sendMessages.iterator();
	DateTime dateTime_now = DateTime.now();
	while (it.hasNext()) {
	    SendMessage sm = it.next();
	    String number = sm.getNumber();
	    Employee e = employeeService.getByNumber(number);
	    DateTime dateTime = new DateTime(sm.getSendTime());
	    int sm_year = dateTime.getYear();// 发送信息-年
	    int sm_mon = dateTime.getMonthOfYear();// 发送信息-月
	    int sm_day = dateTime.getDayOfMonth();// 发送信息-日
	    int y = dateTime_now.getYear();// 当前年
	    int m = dateTime_now.getMonthOfYear();// 当前月
	    int d = dateTime_now.getDayOfMonth();// 当前日
	    if (sm_year == y && sm_mon == m && sm_day == d && e.getCorporationCode() == loginUser.getCorporationCode()) {
		continue;
	    } else {
		it.remove();
	    }
	    employees.add(e);
	}
	ret = SUCCESS;
	return ret;
    }

    public List<SendMessage> getSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(List<SendMessage> sendMessages) {
        this.sendMessages = sendMessages;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
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
