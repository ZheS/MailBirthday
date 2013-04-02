package com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.svwpu.manage.mailbirthday.application.modules.sendmail.dao.CorporationDao;
import com.svwpu.manage.mailbirthday.application.modules.sendmail.model.Corporation;
import com.svwpu.manage.mailbirthday.core.base.dao.BaseDaoImpl;

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
