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

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		String text = request.getParameter("text");
		
	
		//email naver, gamil 구분 
		//String potal = email.substring(, );		
		//System.out.println(potal);
		
		
		
		//gmailService(email, text, name, title);
		
	}
	
	
	//gmail service
	public static void gmailService(String email, String text, String name, String title) {

		//발신자 메일 서비스 
		final String user ="";
		final String password ="";
		
	
		//Property에 smtp 서버 정보를 설정 
		
		Properties prop = new Properties();
		prop.put("mail.stmp.host", "stmp.gmail.com"); // stmp server
		prop.put("mail.stmp.port", 465); // google 465, naver 587 
		prop.put("mail.stmp.auth", "true");
		prop.put("mail.stmp.ssl.enable", "true");
		prop.put("mail.stmp.ssl.trust", "stmp.gmail.com");
		
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
			
		});

		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email)); // 수신자 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("luv_letter@letterServer.com")); //발신자 메일
			
			message.setSubject(title); //제목 
			message.setText(text);
			
			Transport.send(message);
			System.out.println("메세지 전송중");
			
		}catch (AddressException e) {
			e.printStackTrace();
			System.out.println("adress exception");
		}catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Messaging exception");
			
		}
		
		
	}
	

}
