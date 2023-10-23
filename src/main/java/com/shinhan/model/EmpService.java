package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.EmpVO;

public class EmpService {
	EmpDAO dao = new EmpDAO();
	public EmpVO loginCheck(String email, int password) {
		return dao.loginCheck(email, password);
	}
	public EmpVO selectById(int empid) {
		return dao.selectById(empid) ;
	}

	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}

	public List<EmpVO> selectManagerAll() {
		return dao.selectManagerAll();		
	}
}