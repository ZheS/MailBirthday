package com.svwpu.manage.mailbirthday.application.modules.sendmail.dao;

import com.svwpu.manage.mailbirthday.application.modules.sendmail.model.Employee;
import com.svwpu.manage.mailbirthday.core.base.dao.BaseDao;

public interface EmployeeDao extends BaseDao<Employee, Long> {

    Employee findByNumber(String number);
}
