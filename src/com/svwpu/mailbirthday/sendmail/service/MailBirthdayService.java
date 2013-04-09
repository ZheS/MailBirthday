package com.svwpu.mailbirthday.sendmail.service;

import com.svwpu.mailbirthday.base.service.BaseService;

public interface MailBirthdayService extends BaseService,Runnable {
	public void run();
}
