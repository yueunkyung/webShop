package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;

/**
 * default : http://localhost:9999/webShop
 * http://localhost:9999/webShop/dept/deptDetail.do?deptid=10
 */
@WebServlet("/dept/deptDetail.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("deptid"));
		// System.out.println("파라메터값:" + did);

		DeptService dService = new DeptService();

		// JSP에 알려줄 Data 저장하기
		request.setAttribute("mlist", new EmpService().selectManagerAll());
		request.setAttribute("dept", dService.selectById(did));

		// JSP에 위임하기(요청은 서블릿이 받고 응답은 JSP가 한다.)
		RequestDispatcher rd = request.getRequestDispatcher("deptDetail.jsp");
		rd.forward(request, response);
	}
}
