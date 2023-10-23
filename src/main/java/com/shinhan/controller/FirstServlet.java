package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @WebServlet : 브라우저에서 요청한 주소의미
 * 반드시 /(슬래시)로 시작한다.
 */
//@WebServlet({ "/FirstServlet", "/first", "/first2" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
    	System.out.println("FirstServlet 생성자");
    }

	public void init(ServletConfig config) throws ServletException {
    	System.out.println("FirstServlet 초기화!!!");
	}


	public void destroy() {
    	System.out.println("FirstServlet 소멸자");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("FirstServlet service");
	}
	/* service가 구현되어 있지 않으면 => doGet(), doPost()
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost");		
	}

}
