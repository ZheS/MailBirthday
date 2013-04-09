package com.svwpu.mailbirthday.sendmail.dao;

import com.svwpu.mailbirthday.base.dao.BaseDao;
import com.svwpu.mailbirthday.sendmail.model.Employee;

public interface EmployeeDao extends BaseDao<Employee, Long> {

    Employee findByNumber(String number);
}
