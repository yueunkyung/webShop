<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

{ "dept":${param.deptid},
  "email":"${param.email}",
  "mlist":[
<c:forEach items="${mlist}" var="emp" varStatus="st">
	{"empid":"${emp.employee_id}",
	"fname":"${emp.first_name}",
	"email":"${emp.email}",
	"salary":"${emp.salary}",
	"job":"${emp.job_id}"
	}${st.last==false?",":""}
	
</c:forEach>
]}
