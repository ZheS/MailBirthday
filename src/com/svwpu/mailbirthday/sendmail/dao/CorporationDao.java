package com.svwpu.mailbirthday.sendmail.dao;

import com.svwpu.mailbirthday.base.dao.BaseDao;
import com.svwpu.mailbirthday.sendmail.model.Corporation;

public interface CorporationDao extends BaseDao<Corporation, Long> {
    
    Corporation getCorporationByCode(int code);
}
