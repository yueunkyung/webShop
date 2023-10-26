package com.shinhan.lastcontroller;

import java.util.Map;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.DeptService;
import com.shinhan.model.EmpService;
import com.shinhan.model.JobDAO;

public class EmpInsertController implements CommonController{
	
	@Override
	public String execute(Map<String, Object> data) {
		String method = (String)data.get("method");
		String page = "";
		if(method.equalsIgnoreCase("get")) {

			DeptService dService = new DeptService();
			JobDAO jDAO = new JobDAO();
			EmpService eService = new EmpService();

			data.put("dlist", dService.selectAll());
			data.put("joblist", jDAO.selectAll());
			data.put("mlist", eService.selectAll());

			page= "empInsert_real.jsp";
			
		} else {
			EmpService eService = new EmpService();
			EmpVO emp = (EmpVO) data.get("emp");
			int result = eService.empInsert(emp);
			data.put("message", result>0? "insert success":"insert fail");
			
			//Redirect : 새로운 요청하기
			page = "redirect:empList.do";
		}
		
		return page;
	}
}
