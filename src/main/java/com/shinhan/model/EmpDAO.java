package com.shinhan.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.EmpVO;
import com.shinhan.util.DBUtil;

//DAO(Data Access Object) CRUD작업 (Create Read Update Delete)
//						  insert into~, select~, update~, delete
//POJO(Plain Old Java Object) : 정해진 규칙없이 자바로 만들어진 class
//JDBC를 이용하여 만든 JAVA코드이다... 계속 사용예정..
public class EmpDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		String sql = "select * from employees where employee_id = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnection(conn, st, rs);
		}
		return emp;
	}
	
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<>();
		String sql = "select * from employees";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnection(conn, st, rs);
		}
		return emplist;
	}
	
	public List<EmpVO> selectManagerAll() {
		List<EmpVO> emplist = new ArrayList<>();
		String sql = "select *"
					+ " from employees"
					+ " where employee_id in("
					+ " select DISTINCT manager_id from employees)";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnection(conn, st, rs);
		}
		return emplist;
	}
	
	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));
		return emp;
	}

}