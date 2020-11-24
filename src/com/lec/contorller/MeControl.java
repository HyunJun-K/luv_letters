package com.lec.contorller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.commends.Commend;
import com.lec.service.mail_Service_cmd;

@WebServlet("*.ME")
public class MeControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MeControl() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ationME(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ationME(request, response);
	}
	
	
	
	private void ationME(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
			
			String url = request.getRequestURI();
			String conPath = request.getContextPath();
			String com = url.substring(conPath.length());
		
			Commend	cmd = null;
			String viewPage = null; 
			
			
			
			switch(com) {
			
			
			
			case "/View/mail_Service.ME":
			cmd = new mail_Service_cmd();
			cmd.excute(request, response);
			viewPage = "mail_Service.jsp";
			break;
			
			
			
			}
			
	}
	
	
	

}
