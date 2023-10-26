package com.shinhan.lastcontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.shinhan.dto.EmpVO;
import com.shinhan.model.EmpService;

//정의는 있고 구현은 없음
public interface CommonController {
	public String execute(Map<String, Object> data);
	
}
