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

import com.shinhan.dto.DeptVO;

@WebServlet("/Session1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //True : 있으면 얻고 없으면 생성
		
		response.setContentType("text/html;charset=utf-8"); //getWriter() 전에 작성해야 charset 적용이 됨.
		PrintWriter out = response.getWriter();
		out.println("<br>생성 시간 : " + new Date(session.getCreationTime()));
		out.println("<br>마지막 접근 시간 : " + new Date(session.getLastAccessedTime()));
		out.println("<br>아이디 : " + session.getId());
		out.println("<br>신규인지 아닌지 : " + session.isNew());
		
		DeptVO dept = new DeptVO(10, "개발부", 100, 1700);

		session.setMaxInactiveInterval(3);	//session 유지 10초 설정
		session.setAttribute("security1", "비밀1");
		session.setAttribute("security2", "비밀2");
		session.setAttribute("security3", "비밀3");
		session.setAttribute("security4", dept);
	}
}
