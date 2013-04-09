package com.svwpu.mailbirthday.sendmail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.svwpu.mailbirthday.base.dao.BaseDaoImpl;
import com.svwpu.mailbirthday.sendmail.dao.CorporationDao;
import com.svwpu.mailbirthday.sendmail.model.Corporation;

@Repository("corporationDao")
public class CorporationDaoImpl extends BaseDaoImpl<Corporation, Long> implements CorporationDao {

    @SuppressWarnings("unchecked")
    @Override
    public Corporation getCorporationByCode(int code) {
	String hql = "";
	hql = "from Corporation c where c.code='" + code + "'";
	List<Corporation> ls = find(hql);
	if (ls.size() > 0)
	    return ls.get(0);
	else
	    return null;
    }
}
