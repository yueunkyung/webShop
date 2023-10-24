<%@page import="com.shinhan.dto.EmpVO"%>
<%@page import="com.shinhan.model.EmpDAO"%>
<%@page import="com.shinhan.model.JobDAO"%>
<%@page import="com.shinhan.dto.JobVO"%>
<%@page import="com.shinhan.model.DeptService"%>
<%@page import="com.shinhan.dto.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
EmpVO empvo = (EmpVO) request.getAttribute("emp");
List<DeptVO> dlist = (List<DeptVO>) request.getAttribute("dlist");
List<JobVO> joblist = (List<JobVO>) request.getAttribute("joblist");
List<EmpVO> mlist = (List<EmpVO>) request.getAttribute("mlist");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap : 세계적으로 가장 유명한 CSS framework -->
<!-- CDN(Content Delivery Network) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

html, body {
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
	font-family: 'Jeju Gothic', sans-serif;
}

ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.dis_flex {
	display: flex;
	align-items: center;
	justify-content: center;
}

#container {
	position: relative;
	width: 80%;
	max-width: 800px;
	border: 1px solid gray;
	padding-top: 74px;
	margin: 0 auto;
	border-radius: 15px;
	background: url("../html5-css3-master/07/images/bg1.png");
	background-color: rgba(255, 255, 255, 0.5);
}

h1 {
	position: absolute;
	top: 20px;
	left: 50%;
	margin: 0;
	transform: translateX(-50%);
	background-color: #fff;
	text-align: center;
	font-weight: bold;
}

fieldset {
	padding: 20px;
	margin: 15px;
	background-color: #fff;
	border: 4px solid green;
}

fieldset legend {
	font-weight: 700;
	font-size: 20px;
}

ul li {
	font-size: 14px;
	margin-bottom: 5px;
}

ul li:last-child {
	margin-bottom: 0;
}

ul li:after {
	content: '';
	display: block;
	clear: both;
}

ul li span {
	float: left;
	width: 150px;
	line-height: 35px;
	margin-right: 10px;
}

ul li input, ul li select {
	float: left;
	width: calc(100% - 160px);
	padding: 5px 10px;
	margin: 0;
	box-sizing: border-box;
}

.btn_wrap {
	margin: 30px 0 10px;
	text-align: center;
}
</style>
</head>

<body class="dis_flex">
	<div id="container">
		<h1>~직원 상세보기~</h1>
		<form name="empform" action="empInsert.jsp" method="get">
			<fieldset>
				<legend>직원의 기본사항</legend>
				<ul>
					<li><span>1.EMPLOYEE_ID:</span><input name="employee_id"
						type="number" value="<%=empvo.getEmployee_id()%>" disabled /></li>
					<li><span>2.FIRST_NAME:</span><input name="first_name"
						type="text" placeholder="이름/first name"
						value="<%=empvo.getFirst_name()%>" disabled /></li>
					<li><span>3.LAST_NAME:</span><input name="last_name"
						type="text" placeholder="성/last name"
						value="<%=empvo.getLast_name()%>" disabled /></li>
				</ul>
			</fieldset>
			<fieldset>
				<legend>직원의 추가정보</legend>
				<ul>
					<li><span>4.EMAIL:</span><input name="email" type="text"
						required placeholder="@(골뱅이) 전까지만" value="<%=empvo.getEmail()%>"
						disabled /></li>
					<li><span>5.PHONE_NUMBER:</span><input name="phone_number"
						type="tel" pattern="[0-9]{3}.[0-9]{3}.[0-9]{4}"
						placeholder="***.***.****" value="<%=empvo.getPhone_number()%>"
						disabled /></li>
					<li><span>6.HIRE_DATE:</span><input name="hire_date"
						type="date" value="<%=empvo.getHire_date()%>" disabled /></li>
					<li><span>7.JOB_ID:</span> <select name="job_id" disabled>
							<%
							for (JobVO job : joblist) {
							%>
							<option value="<%=job.getJob_id()%>>"
								<%=job.getJob_id().equals(empvo.getJob_id()) ? "selected" : ""%>><%=job.getJob_title()%></option>
							<%
							}
							%>
					</select></li>
					<li><span>8.SALARY:</span><input name="salary" type="number"
						placeholder="급여 정보" value="<%=empvo.getSalary()%>" disabled /></li>
					<li><span>9.COMMISSION_PCT:</span><input name="commission_pct"
						type="number" step="0.01" value="<%=empvo.getCommission_pct()%>"
						disabled /></li>
					<li><span>10.MANAGER_ID:</span> <select name="manager_id"
						disabled>
							<%
							for (EmpVO emp : mlist) {
							%>
							<option value="<%=emp.getEmployee_id()%>"
								<%=emp.getEmployee_id() == empvo.getManager_id() ? "selected" : ""%>>
								<%=emp.getFirst_name()%>
								<%=emp.getLast_name()%>
							</option>
							<%
							}
							%>
					</select></li>
					<li><span>11.DEPARTMENT_ID:</span> <select
						name="department_id" disabled>
							<%
							for (DeptVO dept : dlist) {
							%>
							<option value="<%=dept.getDepartment_id()%>"
								<%=dept.getDepartment_id() == empvo.getDepartment_id() ? "selected" : ""%>><%=dept.getDepartment_name()%></option>
							<%
							}
							%>
					</select></li>
				</ul>
				<div class="btn_wrap">
					<button class="btn btn-success" type="submit">등록하기♥</button>
					<input type="reset" class="btn btn-success" value="Reset Button" />
				</div>
			</fieldset>
		</form>
	</div>
	<!--//END_container-->
</body>

</html>