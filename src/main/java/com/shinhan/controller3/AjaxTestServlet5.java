package com.shinhan.controller3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

@WebServlet("/ajax/getEmpInfo4.go")
public class AjaxTestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptid = request.getParameter("deptid");
		String email = request.getParameter("email");
		List<EmpVO> mlist = new EmpService().selectManagerAll();
		//JSON 보내기2(JSP 이용하기)
		request.setAttribute("mlist", mlist);
		request.getRequestDispatcher("jsonMake.jsp").forward(request, response);
		
		//JSON 보내기(직접 JSON을 만들기)
		/*
		JSONArray jArr = new JSONArray(); //[]
		for(EmpVO emp : mlist) {
			JSONObject j_obj = new JSONObject();
			j_obj.put("empid", emp.getEmployee_id());
			j_obj.put("fname", emp.getFirst_name());
			j_obj.put("email", emp.getEmail());
			j_obj.put("salary", emp.getSalary());
			j_obj.put("job", emp.getJob_id()); //여기까지는 Object {}
			jArr.add(j_obj); //[{"empid":100}, {"fname":"steven"}, {}]
		}
		
		JSONObject j_obj = new JSONObject();
		
		j_obj.put("mlist",jArr);	//{키:[]}
		j_obj.put("deptid",deptid);	//{키:[],"deptid":""}
		j_obj.put("email",email);	//{키:[], "deptid":"", "email":""}
		
		String jsonStr =  j_obj.toJSONString(); //여기는 String "{키:[]}"
		response.getWriter().append(jsonStr);
		*/
		
		
	}
	

}
