package com.lec.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.commends.Commend;

public class mail_Service_cmd implements Commend{


	static final String user ="your mail";	  // google
	static final String password ="your mail"; // google 
	
	
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
	
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		String text = request.getParameter("text");
		
		
		gmailService(email, text, title, request);
			
		
		
		
	}
	
	
	//gmail service
	public static void gmailService(String email, String text, String title, HttpServletRequest request) {

	
		//Property에 smtp 서버 정보를 설정 
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", 465); 
		prop.put("mail.smtp.auth", "true"); 
		prop.put("mail.smtp.ssl.enable", "true"); 
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
			
		});

		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user)); //  메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); //수신자 메일
			
			message.setSubject(title); //제목 
			message.setText(text);
			
			Transport.send(message);
			request.setAttribute("mailok", 200);
			System.out.println("메세지 전송중");
		
		}catch (AddressException e) {
			e.printStackTrace();
			System.out.println("adress exception");
			request.setAttribute("mailok", 400);
		}catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Messaging exception");
			
			
		}
		
		request.setAttribute("mailok", 200);
		
	}	// end google Mail
	

}
