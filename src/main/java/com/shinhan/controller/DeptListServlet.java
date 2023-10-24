package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.StandardService;

import com.shinhan.model.DeptService;

// 서블릿 기본주소 ==> http://localhost:9999/webShop 
// 뒤에 /(슬래시)가 없으므로 /가 들어가야 함.
//http://localhost:9999/webShop/dept/deptList.do
@WebServlet("/dept/deptList.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptService dService = new DeptService();

		// 요청의 영역에 저장하기, 키 이름은 dlist, 값은 모든 부서 정보
		// key : dlist
		// value : 모든 부서 정보
		request.setAttribute("dlist", dService.selectAll());

		// JSP에 위임하기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptlist.jsp");
		rd.forward(request, response);

	}
}
