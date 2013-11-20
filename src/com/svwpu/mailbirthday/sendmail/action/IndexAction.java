package com.svwpu.mailbirthday.sendmail.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.svwpu.mailbirthday.base.action.BaseAction;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;
import com.svwpu.mailbirthday.sendmail.service.LoginUserService;

@ParentPackage(value = "struts-default")
@Namespace(value = "/")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "input", params = {
	"param1", "val1" }) })
public class IndexAction extends BaseAction {

    private static final long serialVersionUID = -1607036560756065265L;

    public static final String ADMIN = "admin";
    public static final String INFO_CONTACTER = "info_contacter";
    public static final String MANAGER = "manager";
    public static final String PUS_EMPLOYEE = "pus_employee";
    public static final String PUS_MANAGER = "pus_manager";
    public static final String PUS_OPERATOR = "pus_operator";

    private LoginUser loginUser;

    @Autowired
    private LoginUserService loginUserService;

    @Action(value = "index", results = { @Result(name = "admin", location = "admin/index.jsp"),
	    @Result(name = "input", location = "error.jsp"), @Result(name = "error", location = "error.jsp") })
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
	try {
	    loginUser = loginUserService.getByUserID(userName);
	    if (loginUser != null) {
		String position = loginUser.getRoleType();
		logger.debug("position：{}", position);
		if ("admin".equals(position)) {
		    ret = ADMIN;
		    logger.info("{}：{}，登录成功。", position, userName);
		} else {
		    ret = INPUT;
		    logger.warn("position出错");
		}
	    } else {
		ret = INPUT;
		logger.warn("loginUser出错");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    ret = ERROR;
	    logger.error("index.action出错");
	}

	return ret;
    }

    public LoginUser getLoginUser() {
	return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
	this.loginUser = loginUser;
    }

}
