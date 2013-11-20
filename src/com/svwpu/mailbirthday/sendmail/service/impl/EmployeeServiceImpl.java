package com.svwpu.mailbirthday.sendmail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.svwpu.mailbirthday.base.service.BaseServiceImpl;
import com.svwpu.mailbirthday.sendmail.dao.EmployeeDao;
import com.svwpu.mailbirthday.sendmail.model.Employee;
import com.svwpu.mailbirthday.sendmail.service.EmployeeService;

@Service("employeeService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl extends BaseServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAllEmployee() {
	return employeeDao.loadAll();
    }

    @Override
    public Employee getById(Long id) {
	return employeeDao.get(id);
    }

    @Override
    public Employee getByNumber(String number) {
	return employeeDao.getByNumber(number);
    }

}
