package com.shinhan.controller3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart/shopping.do")
public class CartTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.isNew()) {
			session.setAttribute("productName", "김밥");
			session.setAttribute("productCount", 0);
		}
		
		request.getRequestDispatcher("cart.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니 담기
		// 필터 생성으로 주석처리 함
		// request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		String key = request.getParameter("product");
		Integer count = Integer.parseInt(request.getParameter("count"));
		
		session.setAttribute("productName", key);
		session.setAttribute("productCount", count);
		
		Map<String, Integer> cart  = null;
		
		if(obj == null) {
			cart = new HashMap<>();
			cart.put(key, count);
		} else {
			cart = (Map<String, Integer>)obj;
			Integer originalCnt = cart.get(key);
			if(originalCnt == null)  originalCnt = 0;
			cart.put(key, originalCnt + count);			
		}
		
		session.setAttribute("cart", cart);
		response.sendRedirect("shopping.do");
	}

}
