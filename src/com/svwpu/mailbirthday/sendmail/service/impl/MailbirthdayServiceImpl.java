package com.svwpu.mailbirthday.sendmail.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.svwpu.mailbirthday.base.service.BaseServiceImpl;
import com.svwpu.mailbirthday.base.util.Mail;
import com.svwpu.mailbirthday.sendmail.dao.CorporationDao;
import com.svwpu.mailbirthday.sendmail.dao.EmployeeDao;
import com.svwpu.mailbirthday.sendmail.dao.SendMessageDao;
import com.svwpu.mailbirthday.sendmail.model.Corporation;
import com.svwpu.mailbirthday.sendmail.model.Employee;
import com.svwpu.mailbirthday.sendmail.model.SendMessage;
import com.svwpu.mailbirthday.sendmail.service.MailBirthdayService;

@Service("MailBirthdayService")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class MailbirthdayServiceImpl extends BaseServiceImpl implements MailBirthdayService, Runnable {

    private int mailType;
    private String host;
    private String username;
    private String password;
    private String title;
    private String html;
    private MimeBodyPart[] mailAnnex;
    private MimeBodyPart[] images;
    private InternetAddress from;
    private InternetAddress[] receive;
    private boolean create;
    private String emailPath;

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private CorporationDao corporationDao;

    @Resource
    private SendMessageDao sendMessageDao;

    private SendMessage sendMessage;

    private String setHtml(Employee employee, Corporation corporation) {
	DateTime dateTime_now = DateTime.now();
	int y = dateTime_now.getYear();// 当前年
	int m = dateTime_now.getMonthOfYear();// 当前月
	int d = dateTime_now.getDayOfMonth();// 当前日
	// 摩羯座
	if (m == 12 && d >= 22 || m == 1 && d <= 19) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#8FBBFA" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#8FBBFA"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#8FBBFA"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#8FBBFA"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/capricorn.png"
		    + "\"></td></tr></table></td></tr></table>";
	}
	// 水瓶座
	else if (m == 1 && d >= 20 || m == 2 && d <= 18) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(223, 223, 223);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#FF9700" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#FF9700"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FF9700"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FF9700"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/aquarius.png"
		    + "\"></td></tr></table></td></tr></table>";
	}
	// 双鱼座
	else if (m == 2 && d >= 19 || m == 3 && d <= 20) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#FF00EB" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#FF00EB"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FF00EB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FF00EB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/pisces.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 白羊座
	else if (m == 3 && d >= 21 || m == 4 && d <= 19) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(36, 227, 45);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#C6F5FB" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#C6F5FB"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#C6F5FB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#C6F5FB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/aries.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 金牛座
	else if (m == 4 && d >= 20 || m == 5 && d <= 20) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(23, 24, 23);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#FAA8E4" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#FAA8E4"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FAA8E4"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FAA8E4"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/taurus.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 双子座
	else if (m == 5 && d >= 21 || m == 6 && d <= 21) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#BC33E9" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#BC33E9"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#BC33E9"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#BC33E9"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/gemini.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 巨蟹座
	else if (m == 6 && d >= 22 || m == 7 && d <= 22) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#FD1B1C" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#FD1B1C"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FD1B1C"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FD1B1C"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/cancer.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 狮子座
	else if (m == 7 && d >= 23 || m == 8 && d <= 22) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#F0C339" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#F0C339"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F0C339"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F0C339"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/leo.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 处女座
	else if (m == 8 && d >= 23 || m == 9 && d <= 22) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#F9FA95" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#F9FA95"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F9FA95"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，联合公司总部全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F9FA95"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>联合公司总部</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/virgo.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 天秤座
	else if (m == 9 && d >= 23 || m == 10 && d <= 23) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#F709AB" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#F709AB"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F709AB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F709AB"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/libra.png" + "\"></td></tr></table></td></tr></table>";
	}
	// 天蝎座
	else if (m == 10 && d >= 24 || m == 11 && d <= 22) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#F7E909" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#F7E909"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F7E909"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#F7E909"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/scorpio.png"
		    + "\"></td></tr></table></td></tr></table>";
	}
	// 射手座
	else if (m == 11 && d >= 23 || m == 12 && d <= 21) {
	    html = "<table align=center height=100%><tr><td valign=middle><table style="
		    + "\"background-color: rgb(2, 0, 3);" + "\"><tr><td valign=" + "\"top" + "\" style="
		    + "\"width: 400px;" + "\"><p><font size=" + "\"3" + "\" color=" + "\"#FA41D1" + "\" style="
		    + "\"font-family: 幼圆" + "\"><b>亲爱的</font><font size=" + "\"5" + "\" color=" + "\"#FA41D1"
		    + "\" style=" + "\"font-family: 幼圆" + "\"><b>"
		    + employee.getName()
		    + "：</font></b></p><p><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FA41D1"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\">&nbsp;&nbsp;今天是"
		    + y
		    + "年"
		    + m
		    + "月"
		    + d
		    + "日，是您的生日。值此佳期，"
		    + corporation.getShortName()
		    + "全体员工向您送来最真诚的祝福！<br />&nbsp;&nbsp;祝您生日快乐，身体健康，事事顺心，事业有成！</font></p><p align="
		    + "\"right"
		    + "\"><font size="
		    + "\"3"
		    + "\" color="
		    + "\"#FA41D1"
		    + "\" style="
		    + "\"font-family: 幼圆"
		    + "\"><b>"
		    + corporation.getShortName()
		    + "</b></font></p></td></tr><tr><td><img src="
		    + "\"http://www.shanghailh.com/MailBirthday/sagittarius.png‎"
		    + "\"></td></tr></table></td></tr></table>";
	}
	return html;
    }

    private List<Employee> findEmployeeBirthdayToday() {
	List<Employee> employees = employeeDao.loadAll();
	if (employees == null || employees.size() == 0) {
	    logger.warn("Employee表没有数据！");
	    return null;
	}
	DateTime dateTime_now = DateTime.now();
	Iterator<Employee> it = employees.iterator();
	while (it.hasNext()) {
	    Employee e = it.next();
	    DateTime dateTime = new DateTime(e.getBirthday());
	    int e_mon = dateTime.getMonthOfYear();// 职工生日-月
	    int e_day = dateTime.getDayOfMonth();// 职工生日-日
	    int m = dateTime_now.getMonthOfYear();// 当前月
	    int d = dateTime_now.getDayOfMonth();// 当前日
	    if (e_mon == m && e_day == d) {
		logger.debug("工号：{}，职工：{}，今天生日", e.getNumber(), e.getName());
		continue;
	    } else {
		logger.debug("工号：{}，职工：{}，生日是{}",
			new Object[] { e.getNumber(), e.getName(), new DateTime(e.getBirthday()).toString("MM-dd") });
		it.remove();
	    }
	}
	return employees;
    }

    private void sendBirthdayMail(Employee employee, Corporation corporation) {
	try {
	    mailType = 2;
	    host = corporation.getHost();
	    username = corporation.getUsername();
	    password = corporation.getPassword();
	    title = "生日祝福";
	    html = setHtml(employee, corporation);
	    mailAnnex = null;
	    images = null;
	    from = new InternetAddress(corporation.getMailAddress());
	    receive = InternetAddress.parse(employee.getEmail());
	    create = false;
	    emailPath = null;
	    Mail.sendMail(mailType, host, username, password, title, html, mailAnnex, images, from, receive, create,
		    emailPath);
	    String memo = "生日邮件发送成功";
	    logger.info("生日员工：{}，{}", employee.getName(), memo);
	    saveInSendMessage(employee, corporation, memo);
	    sendBirthdayMailToAdmin(employee, corporation);
	} catch (Exception e) {
	    String memo = "生日邮件发送失败";
	    logger.info("生日员工：{}，{}", employee.getName(), memo);
	    saveInSendMessage(employee, corporation, memo);
	}
    }

    private void sendBirthdayMailToAdmin(Employee employee, Corporation corporation) {
	try {
	    mailType = 2;
	    host = corporation.getHost();
	    username = corporation.getUsername();
	    password = corporation.getPassword();
	    title = employee.getName() + "生日祝福邮件内容";
	    html = setHtml(employee, corporation);
	    mailAnnex = null;
	    images = null;
	    from = new InternetAddress(corporation.getMailAddress());
	    receive = InternetAddress.parse(corporation.getMailAddress());
	    create = false;
	    emailPath = null;
	    Mail.sendMail(mailType, host, username, password, title, html, mailAnnex, images, from, receive, create,
		    emailPath);
	    String memo = "生日邮件发送给管理员成功";
	    logger.info("生日员工：{}，{}", employee.getName(), memo);
	} catch (Exception e) {
	    String memo = "生日邮件发送给管理员失败";
	    logger.info("生日员工：{}，{}", employee.getName(), memo);
	}
    }

    private void saveInSendMessage(Employee employee, Corporation corporation, String Memo) {
	try {
	    sendMessage = new SendMessage();
	    sendMessage.setSendTime(new Date());
	    sendMessage.setNumber(employee.getNumber());
	    sendMessage.setMemo(Memo);
	    if (sendMessage != null) {
		sendMessageDao.save(sendMessage);
		logger.info("添加发送信息成功");
	    }
	} catch (Exception e) {
	    logger.error("添加发送信息失败");
	}
    }

    private void sendMailToAdmin() {
	List<Corporation> corporations = corporationDao.loadAll();
	if (corporations == null || corporations.size() == 0) {
	    logger.warn("Corporation表没有数据！");
	}
	Iterator<Corporation> it = corporations.iterator();
	while (it.hasNext()) {
	    Corporation c = it.next();
	    try {
		mailType = 2;
		host = c.getHost();
		username = c.getUsername();
		password = c.getPassword();
		title = "生日祝福邮件发送信息";
		html = setAdminHtml(c);
		mailAnnex = null;
		images = null;
		from = new InternetAddress(c.getMailAddress());
		receive = InternetAddress.parse(c.getMailAddress());
		create = false;
		emailPath = null;
		Mail.sendMail(mailType, host, username, password, title, html, mailAnnex, images, from, receive,
			create, emailPath);
		String memo = "反馈信息发送给管理员成功";
		logger.info("企业：{}，{}", c.getName(), memo);
	    } catch (Exception e) {
		String memo = "反馈信息发送给管理员失败";
		logger.info("企业：{}，{}", c.getName(), memo);
	    }
	}
    }

    private String setAdminHtml(Corporation corporation) {
	StringBuffer mailbody = new StringBuffer();
	List<Employee> employees = findEmployeeBirthdayToday();
	Iterator<Employee> it_ = employees.iterator();
	while (it_.hasNext()) {
	    Employee e = it_.next();
	    if (e.getCorporationCode() == corporation.getCode()) {
		continue;
	    } else {
		it_.remove();
	    }
	}
	List<SendMessage> sendMessages = findSendMessageToday();
	if (employees == null || employees.size() == 0) {
	    logger.info("企业：{}，今天没人生日", corporation.getName());
	    mailbody.append("今天没人生日");
	} else {
	    mailbody.append("<table style=" + "\"WIDTH: 95%" + "\" bordercolor=" + "\"#cccccc" + "\" cellspacing="
		    + "\"2" + "\" cellpadding=" + "\"3" + "\" width=" + "\"95%" + "\" align=" + "\"center"
		    + "\" border=" + "\"1" + "\"><tbody><tr><td><strong><font color=" + "\"#313131"
		    + "\">发送日期</font></strong></td><td><strong><font color=" + "\"#313131"
		    + "\">姓名</font></strong></td><td><font color=" + "\"#313131"
		    + "\"><strong>部门</strong></font></td><td><strong><font color=" + "\"#313131"
		    + "\">备注</font></strong></td></tr>");
	    Iterator<SendMessage> it = sendMessages.iterator();
	    while (it.hasNext()) {
		SendMessage sendMessage = it.next();
		Employee employee = employeeDao.getByNumber(sendMessage.getNumber());
		if (employee == null) {
		    logger.warn("SendMessage表中数据错误");
		    continue;
		}
		Corporation corporation_ = corporationDao.getCorporationByCode(employee.getCorporationCode());
		if (corporation_.getCode() == corporation.getCode()) {
		    mailbody.append("<tr><td><font color=" + "\"#0000ff" + "\">"
			    + new DateTime(sendMessage.getSendTime()).toString("yyyy-MM-dd HH:mm:ss")
			    + "</font></td><td><font color=" + "\"#0000ff" + "\">" + employee.getName()
			    + "</font></td><td><font color=" + "\"#0000ff" + "\">" + employee.getDepartment()
			    + "</font></td>");
		    if ("生日邮件发送成功".equals(sendMessage.getMemo()))
			mailbody.append("<td><font color=" + "\"#009D10" + "\"><strong>" + sendMessage.getMemo()
				+ "</strong></font></td></tr>");
		    else
			mailbody.append("<td><font color=" + "\"#ff0000" + "\"><strong>" + sendMessage.getMemo()
				+ "</strong></font></td></tr>");
		}
	    }
	    mailbody.append("</tbody></table>");
	}
	return mailbody.toString();
    }

    private List<SendMessage> findSendMessageToday() {
	List<SendMessage> sendMessages = sendMessageDao.loadAll();
	if (sendMessages == null || sendMessages.size() == 0) {
	    logger.warn("SendMessage表没有数据！");
	    return null;
	}
	DateTime dateTime_now = DateTime.now();
	Iterator<SendMessage> it = sendMessages.iterator();
	while (it.hasNext()) {
	    SendMessage sm = it.next();
	    DateTime dateTime = new DateTime(sm.getSendTime());
	    int sm_year = dateTime.getYear();// 发送信息-月
	    int sm_mon = dateTime.getMonthOfYear();// 发送信息-月
	    int sm_day = dateTime.getDayOfMonth();// 发送信息-日
	    int y = dateTime_now.getYear();// 当前月
	    int m = dateTime_now.getMonthOfYear();// 当前月
	    int d = dateTime_now.getDayOfMonth();// 当前日
	    if (sm_year == y && sm_mon == m && sm_day == d) {
		continue;
	    } else {
		it.remove();
	    }
	}
	return sendMessages;
    }

    @Scheduled(cron = "0 0 7 * * ?")
    //@Scheduled(fixedRate = 4000000)
    public void run() {
	List<Employee> employees = findEmployeeBirthdayToday();
	if (employees == null || employees.size() == 0) {
	    logger.info("今天没人生日");
	} else {
	    Iterator<Employee> it = employees.iterator();
	    while (it.hasNext()) {
		Employee employee = it.next();
		logger.info("工号：{}，职工：{}，今天生日", employee.getNumber(), employee.getName());
		Corporation corporation = corporationDao.getCorporationByCode(employee.getCorporationCode());
		logger.info("所属公司：{}", corporation.getName());
		sendBirthdayMail(employee, corporation);
	    }
	}
	sendMailToAdmin();
    }
}
