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
 * 后台账户表
 * 
 * @author SZ
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LoginUser extends BaseModel {

    private static final long serialVersionUID = -7375564782880882604L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 序号

    @Column(length = 255, nullable = false, unique = true)
    private String userID; // 账号

    @Column(length = 255, nullable = false)
    private String userPWD; // 密码

    @Column(length = 255, nullable = false)
    private String roleType; // 角色

    @Column(length = 255, nullable = true)
    private String bak; // 备注

    @Column(length = 255, nullable = true)
    private Integer corporationCode; // 所在企业

    @Column(length = 255, nullable = true)
    private Integer isValid; // 是否可用

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getUserID() {
	return userID;
    }

    public void setUserID(String userID) {
	this.userID = userID;
    }

    public String getUserPWD() {
	return userPWD;
    }

    public void setUserPWD(String userPWD) {
	this.userPWD = userPWD;
    }

    public String getRoleType() {
	return roleType;
    }

    public void setRoleType(String roleType) {
	this.roleType = roleType;
    }

    public String getBak() {
	return bak;
    }

    public void setBak(String bak) {
	this.bak = bak;
    }

    public Integer getCorporationCode() {
	return corporationCode;
    }

    public void setCorporationCode(Integer corporationCode) {
	this.corporationCode = corporationCode;
    }

    public Integer getIsValid() {
	return isValid;
    }

    public void setIsValid(Integer isValid) {
	this.isValid = isValid;
    }

}
