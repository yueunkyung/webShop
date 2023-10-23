package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

/**
 * controller
 */
@WebServlet("/html/loginCheck")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		int pswd = Integer.parseInt(request.getParameter("pswd"));
		String c = request.getParameter("remember");
		
		EmpService empService = new EmpService();
		EmpVO emp = empService.loginCheck(email, pswd);
		
		//request문서에 "empInfo" 이름으로 값을 저장한다.
		request.setAttribute("empInfo", emp); //저장한다
		request.setAttribute("message", emp==null? "로그인 실패" : "로그인 성공"); //저장한다
		
		//위임하기(요청은 Servlet 받았지만 응답은 jsp에 넘기기)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../views/loginResult.jsp");
		rd.forward(request, response);
		//주소창은 변경되지 않고 내용은 forward 된 페이지가 보인다.
		
		
		/* Servlet응답하기.... MVC1 모델 
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append("<p>이메일은 " + email + "</p>")
		.append("<p>이름은 " + emp.getFirst_name() + "</p>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
