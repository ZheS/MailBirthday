package com.svwpu.mailbirthday.sendmail.service;

import java.util.List;

import com.svwpu.mailbirthday.base.service.BaseService;
import com.svwpu.mailbirthday.sendmail.model.Employee;

/**
 * 发送信息管理模块
 * 
 * @author SZ
 * 
 */
public interface EmployeeService extends BaseService {

    /**
     * 获得所有人员信息列表
     * 
     * @param
     * @return List<Employee>
     */
    List<Employee> findAllEmployee();

    /**
     * 根据id查询发送信息
     * 
     * @param id
     * @return Employee
     */
    Employee getById(Long id);

    /**
     * 根据number查询发送信息
     * 
     * @param number
     * @return Employee
     */
    Employee getByNumber(String number);

}
