package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

/**
 * controller
 */
@WebServlet("/views/loginCheck.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int pswd = Integer.parseInt(request.getParameter("pswd"));
		String c = request.getParameter("remember");
		
		EmpService empService = new EmpService();
		EmpVO emp = empService.loginCheck(email, pswd);
		
		//session에 로그인 정보를 저장하기(있으며 얻고, 없으면 생성)
		HttpSession session = request.getSession();

		if(emp==null) {
			response.sendRedirect("loginCheck.do");
			return;
		}
		session.setAttribute("empInfo", emp);
		response.sendRedirect("../emp/empList.do");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
