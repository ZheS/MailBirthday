package com.svwpu.mailbirthday.sendmail.action.admin;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.svwpu.mailbirthday.base.action.BaseAction;

@ParentPackage(value = "struts-default")
@Namespace(value = "/admin")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "input", params = {
	"param1", "val1" }) })
public class AdminAction extends BaseAction {

    private static final long serialVersionUID = 5326158448811097127L;

    @Action(value = "index", results = { @Result(name = "success", location = "index.jsp") })
    public String index() {
	String ret;
	ret = SUCCESS;
	logger.info("登录成功");
	return ret;
    }

}
