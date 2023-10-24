package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.DeptVO;
import com.shinhan.dto.EmpVO;
import com.shinhan.dto.JobVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpDAO;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;

@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empid = request.getParameter("empid");
		System.out.println("파라메터값:" + empid);
		
		int i_empid = Integer.parseInt(empid);		
		EmpService eService = new EmpService();
	    DeptService dService  = new DeptService();
		JobDAO jDAO = new JobDAO();
		
	   	request.setAttribute("emp", eService.selectById(i_empid));
	   	request.setAttribute("dlist", dService.selectAll());
	   	request.setAttribute("joblist", jDAO.selectAll());
	   	request.setAttribute("mlist", eService.selectManagerAll());
	   	
		//JSP에 위임하기
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

}
