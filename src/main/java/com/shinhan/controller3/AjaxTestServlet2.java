package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

@WebServlet("/ajax/getEmpInfo.go")
public class AjaxTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("empid"));
		EmpVO emp = new EmpService().selectById(eid);
		// 1.응답 데이터가 단순한 문자인 경우
		//response.setContentType("text/html; charset=utf-8");
		//response.getWriter().append(emp.getFirst_name());
		
		// 2.응답하는 데이터가 복잡한 경우 : JSP 만들어서 가져가기
		request.setAttribute("empInfo", emp);
		request.getRequestDispatcher("empData.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
