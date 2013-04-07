package com.svwpu.manage.mailbirthday.core.base.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    private Mail() {
    }

    /**
     * none annex mail
     */
    private static void sendMailOne(String host, String username, String password, String title, String html,
	    InternetAddress from, InternetAddress[] receive, boolean create, String emailPath) throws Exception {
	Properties props = new Properties();
	props.setProperty("mail.debug", "true");
	props.setProperty("mail.smtp.auth", "true");
	props.setProperty("mail.transport.protocol", "smtp");
	Session session = Session.getInstance(props);

	Message msg = new MimeMessage(session);
	msg.setFrom(from);
	msg.setSubject(title);
	msg.setContent(html, "text/html;charset=gbk");

	Transport transport = session.getTransport();

	transport.connect(host, 25, username, password);
	transport.sendMessage(msg, receive);
	transport.close();
	if (create) {
	    OutputStream ops = new FileOutputStream(emailPath);
	    msg.writeTo(ops);
	    ops.close();
	}
    }

    /**
     * within annex mail
     */
    private static void sendMailTwo(String host, final String username, final String password, String title,
	    String html, MimeBodyPart[] mailAnnex, InternetAddress from, InternetAddress[] receive, boolean create,
	    String emailPath) throws Exception {
	Properties props = new Properties();
	props.setProperty("mail.debug", "true");
	props.setProperty("mail.smtp.auth", "true");
	props.setProperty("mail.transport.protocol", "smtp");
	props.setProperty("mail.host", host);

	Session session = Session.getInstance(props, new Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	    }
	});

	MimeMessage msg = new MimeMessage(session);

	msg.setFrom(from);
	msg.setSubject(title);
	msg.setRecipients(RecipientType.TO, receive);

	MimeMultipart mailMultipart = new MimeMultipart("mixed");
	msg.setContent(mailMultipart);

	MimeBodyPart mailContent = new MimeBodyPart();
	mailMultipart.addBodyPart(mailContent);
	if (mailAnnex != null) {
	    for (MimeBodyPart annex : mailAnnex) {
		mailMultipart.addBodyPart(annex);
	    }
	}

	mailContent.setContent(html, "text/html;charset=gbk");

	msg.saveChanges();

	Transport.send(msg);

	if (create) {
	    OutputStream ops = new FileOutputStream(emailPath);
	    msg.writeTo(ops);
	    ops.close();
	}
    }

    /**
     * within annex and img mail
     */
    private static void sendMailThree(String host, final String username, final String password, String title,
	    String html, MimeBodyPart[] mailAnnex, MimeBodyPart[] images, InternetAddress from,
	    InternetAddress[] receive, boolean create, String emailPath) throws Exception {
	Properties props = new Properties();
	props.setProperty("mail.debug", "true");
	props.setProperty("mail.smtp.auth", "true");
	props.setProperty("mail.transport.protocol", "smtp");
	props.setProperty("mail.host", host);

	Session session = Session.getInstance(props, new Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	    }
	});

	MimeMessage msg = new MimeMessage(session);

	msg.setFrom(from);
	msg.setSubject(title);
	msg.setRecipients(RecipientType.TO, receive);

	MimeMultipart mailMultipart = new MimeMultipart("mixed");
	msg.setContent(mailMultipart);

	MimeBodyPart mailContent = new MimeBodyPart();
	mailMultipart.addBodyPart(mailContent);
	if (mailAnnex != null) {
	    for (MimeBodyPart annex : mailAnnex) {
		mailMultipart.addBodyPart(annex);
	    }
	}

	MimeMultipart contentMultipart = new MimeMultipart("related");
	mailContent.setContent(contentMultipart);

	MimeBodyPart htmlContent = new MimeBodyPart();
	contentMultipart.addBodyPart(htmlContent);
	htmlContent.setContent(html, "text/html;charset=gbk");
	if (images != null) {
	    for (MimeBodyPart img : images) {
		contentMultipart.addBodyPart(img);
	    }
	}

	msg.saveChanges();

	Transport.send(msg);

	if (create) {
	    OutputStream ops = new FileOutputStream(emailPath);
	    msg.writeTo(ops);
	    ops.close();
	}
    }

    /**
     * execute send mail:1.only html;2.within annex;3.within annex and img;
     */
    public static void sendMail(int mailType, String host, final String username, final String password, String title,
	    String html, MimeBodyPart[] mailAnnex, MimeBodyPart[] images, InternetAddress from,
	    InternetAddress[] receive, boolean create, String emailPath) throws Exception {
	if (mailType == 1) {
	    sendMailOne(host, username, password, title, html, from, receive, create, emailPath);
	}
	if (mailType == 2) {
	    sendMailTwo(host, username, password, title, html, mailAnnex, from, receive, create, emailPath);
	}
	if (mailType == 3) {
	    sendMailThree(host, username, password, title, html, mailAnnex, images, from, receive, create, emailPath);
	}
    }

    /**
     * create mail's annex
     */
    public static MimeBodyPart createAnnex(String filePath, String fileName) throws Exception {
	MimeBodyPart annex = new MimeBodyPart();
	DataSource ds = new FileDataSource(filePath);
	DataHandler dh = new DataHandler(ds);
	annex.setDataHandler(dh);
	annex.setFileName(fileName);
	return annex;
    }

    /**
     * create mail's image content
     */
    public static MimeBodyPart createImage(String filePath, String fileName, String url) throws Exception {
	MimeBodyPart image = new MimeBodyPart();
	DataSource ds = new FileDataSource(filePath);
	DataHandler dh = new DataHandler(ds);
	image.setDataHandler(dh);
	image.setHeader("Content-Location", url);
	image.setFileName(fileName);
	return image;
    }
}
