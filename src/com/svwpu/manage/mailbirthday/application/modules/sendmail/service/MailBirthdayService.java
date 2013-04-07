package com.svwpu.manage.mailbirthday.application.modules.sendmail.service;

import com.svwpu.manage.mailbirthday.core.base.service.BaseService;

public interface MailBirthdayService extends BaseService,Runnable {
	public void run();
}
