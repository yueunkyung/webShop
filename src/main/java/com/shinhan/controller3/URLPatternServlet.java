package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	default : http://localhost:9999/webShop/aa/bb
 * 	/aa/bb
 * 	/*
 *	*.do
 */
@WebServlet("/aa/*")
public class URLPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ContextPath : " + request.getContextPath());
		System.out.println("URL : " + request.getRequestURL());
		System.out.println("URI : " + request.getRequestURI());
		System.out.println("RemotePort : " + request.getRemotePort());
		System.out.println("RemoteAddr : " + request.getRemoteAddr());
		System.out.println("Method : " + request.getMethod());  //get인지 post인지 method 확인
		System.out.println("ServletPath : " + request.getServletPath());
		System.out.println("QueryString : " + request.getQueryString());
		
		//MINE Type : 웹상에서 주고받는 타입은 이미 정해져 있다.
		//text/html
		//text/json
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
}
