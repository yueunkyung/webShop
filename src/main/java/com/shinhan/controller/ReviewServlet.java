package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/html/reviewInsert")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		System.out.println("ReviewServlet 생성자");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ReviewServlet init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() { // 서버가 중단되면...
		System.out.println("ReviewServlet destroy");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// service 구현되어있으면 service만 수행
		// service 구현되어 있지 않으면 doGet(), doPost()

		System.out.println("요청방식" + request.getMethod());
		System.out.println("getRequestURI" + request.getRequestURI());
		System.out.println("getRemoteAddr" + request.getRemoteAddr());
		System.out.println("getContextPath" + request.getContextPath());
		System.out.println("getRealPath" + request.getRealPath("."));

		System.out.println("ReviewServlet doGet");

		String addr = request.getRemoteAddr();
		System.out.println("요청한 ip: " + addr);

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String age = request.getParameter("age");
		String massage = request.getParameter("massage");

		System.out.println(id + ":" + pwd);
		System.out.println(Arrays.toString(hobby));
		System.out.println(age + ":" + massage);

		/*
		 * response.setContentType("text/html; charset=utf-8"); PrintWriter out =
		 * response.getWriter();
		 * 
		 * out.write("<p>id ==>" + id + "</p>"); out.write("<p>id ==>" + pwd + "</p>");
		 * out.write("<p>id ==>" + Arrays.toString(hobby) + "</p>");
		 * out.write("<p>id ==>" + age + "</p>"); out.write("<p>id ==>" + massage +
		 * "</p>");
		 */

		request.setAttribute("resultMessage", "입력성공");

		// Servlet -> JSP에 위임하기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../views/review.jsp");
		rd.forward(request, response);
		
		/*
	 	HTML로 전송 시: text/html
		일반 텍스트로 전송 시: text/plain
		XML 데이터로 전송 시: application/xml
		*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReviewServlet doPost");
	}

}
