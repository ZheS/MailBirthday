package com.svwpu.manage.mailbirthday.application.modules.sendmail.dao;

import com.svwpu.manage.mailbirthday.application.modules.sendmail.model.Corporation;
import com.svwpu.manage.mailbirthday.core.base.dao.BaseDao;

public interface CorporationDao extends BaseDao<Corporation, Long> {
    
    Corporation getCorporationByCode(int code);
}
