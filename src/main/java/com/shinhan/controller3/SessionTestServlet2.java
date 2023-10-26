package com.shinhan.controller3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session2")
public class SessionTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8"); //getWriter() 전에 작성해야 charset 적용이 됨.
		PrintWriter out = response.getWriter();
		
		out.println("<br>security1 : " + session.getAttribute("security1"));
		out.println("<br>security2 : " + session.getAttribute("security2"));
		out.println("<br>security3 : " + session.getAttribute("security3"));
		out.println("<br>security4 : " + session.getAttribute("security4"));
		
	}
}
