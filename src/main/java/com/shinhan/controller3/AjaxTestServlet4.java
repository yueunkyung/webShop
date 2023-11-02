package com.shinhan.controller3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

@WebServlet("/ajax/getEmpInfo3.go")
public class AjaxTestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//JSON 받기
		String data = request.getParameter("empInfo");
		System.out.println("String data : "+data);
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(data);
			
			System.out.println("String data parse된 이후 : "+obj.get("empid"));
			System.out.println("String data parse된 이후 : "+obj.get("email"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(data);
	}

}
