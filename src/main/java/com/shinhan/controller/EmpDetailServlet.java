package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;
import com.shinhan.util.DateUtil;

//@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empid = request.getParameter("empid");
		System.out.println("파라메터값:" + empid);

		int i_empid = Integer.parseInt(empid);
		EmpService eService = new EmpService();
		DeptService dService = new DeptService();
		JobDAO jDAO = new JobDAO();

		request.setAttribute("emp", eService.selectById(i_empid));
		request.setAttribute("dlist", dService.selectAll());
		request.setAttribute("joblist", jDAO.selectAll());
		request.setAttribute("mlist", eService.selectManagerAll());

		// JSP에 위임하기
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		EmpVO emp = makeEmp(request);
		EmpService eService = new EmpService();
		int result = eService.empUpdate(emp);
		request.setAttribute("message", result>0? "update success":"update fail");

		// JSP에 위임하기
		RequestDispatcher rd = request.getRequestDispatcher("empResult.jsp");
		rd.forward(request, response);
	}

	private EmpVO makeEmp(HttpServletRequest request) {

		int empid = convertInteger(request.getParameter("employee_id"));
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		Date hdate = DateUtil.convertDate(request.getParameter("hire_date")); // 날짜는 sql data로 변환해야함.
		String jobid = request.getParameter("job_id");
		int salary = convertInteger(request.getParameter("salary"));
		double comm = convertDouble(request.getParameter("commission_pct"));
		int mid = convertInteger(request.getParameter("manager_id"));
		int deptid = convertInteger(request.getParameter("department_id"));

		EmpVO emp = new EmpVO();
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setHire_date(hdate);
		emp.setJob_id(jobid);
		emp.setSalary(salary);
		emp.setCommission_pct(comm);
		emp.setManager_id(mid);
		emp.setDepartment_id(deptid);
		
		return emp;
	}

	private double convertDouble(String str) {
		if (str == null) {
			return 0;
		}
		return Double.parseDouble(str);
	}

	private int convertInteger(String str) {
		if (str == null)
			return 0;
		return Integer.parseInt(str);
	}

}
