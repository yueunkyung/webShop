package com.shinhan.lastcontroller;

import java.net.URLEncoder;
import java.util.Map;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;

public class EmpDetailController implements CommonController{
	
	@Override
	public String execute(Map<String, Object> data) {
		//data는 객체로 들어오니 (String) 캐스팅 해줘야 사용 가능함.
		String method = (String)data.get("method");
		String page = "";
		if(method.equalsIgnoreCase("get")) {
			String empid = (String)data.get("empid");

			int i_empid = Integer.parseInt(empid);
			EmpService eService = new EmpService();
			DeptService dService = new DeptService();
			JobDAO jDAO = new JobDAO();

			data.put("emp", eService.selectById(i_empid));
			data.put("dlist", dService.selectAll());
			data.put("joblist", jDAO.selectAll());
			data.put("mlist", eService.selectManagerAll());

			// JSP에 위임하기
			page= "empDetail.jsp";
		} else {

			EmpVO emp = (EmpVO)data.get("emp");
			EmpService eService = new EmpService();
			int result = eService.empUpdate(emp);

			//한글은 url인코딩해줘야 함			
			//URLEncoder.encode("update성공", "UTF-8");
			
			String str = result>0? "insert success":"insert fail";
			
			//Redirect : 새로운 요청하기(주소창이 바뀐다.)
			//Redirect: 라는 문자는 정해진 것이 아니고 개발자가 임으로 정함
			page = "redirect:empList.do?message=" + str;
		}
		
		return page;
	}
}
