package com.shinhan.controller3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

@WebServlet("/ajax/getEmpInfo2.go")
public class AjaxTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arr = request.getParameterValues("empid");
		String email = request.getParameter("email");
		EmpVO emp = null;
		List<EmpVO> elist = new ArrayList<>();
		for (String s : arr) {
			int eid = Integer.parseInt(s);
			emp = new EmpService().selectById(eid);
			elist.add(emp);
		}
		
		// 2.응답하는 데이터가 복잡한 경우 : JSP 만들어서 가져가기
		request.setAttribute("empInfo", emp);
		request.setAttribute("empList", elist);
		request.getRequestDispatcher("empData.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
