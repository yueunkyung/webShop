package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.DeptVO;
import com.shinhan.model.DeptService;

/**
 * Servlet implementation class deptInsertServlet
 */
@WebServlet("/html/deptInsert")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptId = convertData(request.getParameter("department_id"));
		String dept_name = request.getParameter("department_name");
		int mid = convertData(request.getParameter("manager_id"));
		int loc_id = convertData(request.getParameter("location_id"));
		
		DeptService service = new DeptService();
		DeptVO dept = new DeptVO(deptId, dept_name, mid, loc_id);
		int result = service.insertDept(dept);
		request.setAttribute("message", result>0?"insert 성공":"insert 실패");

		//위임하기(요청은 Servlet 받았지만 응답은 jsp에 넘기기)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../views/deptResult.jsp");
		rd.forward(request, response);
	}
	
	private int convertData(String data) {		
		return Integer.parseInt(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
