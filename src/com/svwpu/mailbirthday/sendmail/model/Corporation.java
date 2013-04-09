package com.svwpu.mailbirthday.sendmail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.svwpu.mailbirthday.base.model.BaseModel;

/**
 * 企业信息
 * 
 * @author SZ
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Corporation extends BaseModel {

    private static final long serialVersionUID = -3653013436442770142L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 序号
    
    @Column(nullable = false)
    private Integer code; // 企业编码
    
    @Column(length = 255, nullable = false)
    private String name; // 企业名称
    
    @Column(length = 255, nullable = false)
    private String shortName; // 企业简称
    
    @Column(length = 255, nullable = false)
    private String host; // 邮箱host

    @Column(length = 50, nullable = false)
    private String username; // 邮箱账号

    @Column(length = 50, nullable = false)
    private String password; // 邮箱密码
    
    @Column(length = 255, nullable = false)
    private String mailAddress; // 邮箱地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
