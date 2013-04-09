package com.svwpu.mailbirthday.sendmail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.svwpu.mailbirthday.base.dao.BaseDaoImpl;
import com.svwpu.mailbirthday.sendmail.dao.EmployeeDao;
import com.svwpu.mailbirthday.sendmail.model.Employee;

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
