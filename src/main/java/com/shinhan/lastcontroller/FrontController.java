package com.shinhan.lastcontroller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.EmpVO;
import com.shinhan.util.DateUtil;

@WebServlet("*.do")	//서블릿 요청들이 오도록 *.do 코딩
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청방식: get, post
		String method = request.getMethod();
		
		//요청주소
		String reqPath = request.getServletPath();
		
		//요청마다 저장하는 데이터가 다르다
		Map<String, Object> data = new HashMap<>();
		
		//모든 요청마다 업무 로직을 담당하는 Controller를 만듦
		CommonController controller = null;
		
		data.put("method", method);
		
		System.out.println("FrontController......"+reqPath);
		
		//요청의 주소에 따라 업무로직을 호출한다.
		switch (reqPath) {
		case "/emp/empList.do":
			controller = new EmpListController();
			break;
		case "/emp/empInsert.do":
			controller = new EmpInsertController();
			if(method.equalsIgnoreCase("post")) {
				data.put("emp", makeEmp(request));
			}
			break;
		case "/emp/empDetail.do":
			controller = new EmpDetailController();
			if(method.equalsIgnoreCase("post")) {
				data.put("emp", makeEmp(request));
			}else {
				data.put("empid", request.getParameter("empid"));
			}
			break;
		default:
			break;
		}
		
		String page = controller.execute(data);

		// data를 session 또는 request에 저장하기
		for(String key:data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		
		if(page.startsWith("redirect:")) {
			response.sendRedirect(page.substring(9));
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
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
