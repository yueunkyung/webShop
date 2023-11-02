<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%-- JSP주석... 이부분은 JSP가 해석안함 --%>
    <!-- HTML 주석이다. 이 부분은 JSP가 해석한다. ${empInfo.first_name} -->
<div>
	<ul>
		<li>이름: ${empInfo.first_name}</li>
		<li>이메일: ${empInfo.email}</li>
		<li>급여: ${empInfo.salary}</li>
	    <%-- parameter로 받을 경우 param으로 시작해야함 --%>
		<li>파라메터로 받은 email:${param.email}</li>
	</ul>
	<hr>
	<table border="1">
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.employee_id}</td>
				<td>${emp.first_name}</td>
				<td>${emp.salary}</td>
			</tr>
		</c:forEach>
		
	</table>
</div>