package com.svwpu.mailbirthday.sendmail.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.svwpu.mailbirthday.base.model.BaseModel;

/**
 * 职工信息
 * 
 * @author SZ
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Employee extends BaseModel {

    private static final long serialVersionUID = -7375564782880882604L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 序号

    @Column(length = 50, nullable = false, unique = true)
    private String number; // 人员编码

    @Column(length = 50, nullable = false)
    private String name; // 姓名

    @Column(length = 50, nullable = true)
    private String sex; // 性别

    @Column(nullable = false)
    private Integer corporationCode;// 所在企业
    
    @Column(length = 255, nullable = false)
    private String department; // 所在部门

    @Column(length = 255, nullable = true)
    private String position; // 岗位

    @Column(nullable = false)
    private Date birthday; // 出生日期

    @Column(length = 50, nullable = false)
    private String email; // 邮箱

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCorporationCode() {
        return corporationCode;
    }

    public void setCorporationCode(Integer corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
