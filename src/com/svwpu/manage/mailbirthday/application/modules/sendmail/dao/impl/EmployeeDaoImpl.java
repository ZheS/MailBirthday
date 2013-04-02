package com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.EmployeeDao;
import com.svwpu.manage.mailbirthday.application.modules.sendmail.model.Employee;
import com.svwpu.manage.mailbirthday.core.base.dao.BaseDaoImpl;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee, Long> implements EmployeeDao {

    @SuppressWarnings("unchecked")
    @Override
    public Employee findByNumber(String number) {
	String hql = "";
	hql = "from Employee e where e.number='" + number + "'";
	List<Employee> ls = find(hql);
	if (ls.size() > 0)
	    return ls.get(0);
	else
	    return null;
    }
}
