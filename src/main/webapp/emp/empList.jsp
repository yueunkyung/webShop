<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>직원 목록</title>
<style>
#container {
	width: 90%;
	margin: 50px auto;
}

h1 {
	text-align: center;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
}

table th, table td {
	border: 1px solid #bbb;
	font-size: 14px;
	box-sizing: border-box;
}

table th {
	padding: 10px;
	background-color: #185422;
	color: white;
	letter-spacing: 0.05em;
}

table td {
	padding: 7px 10px;
	text-align: center;
}

table tbody tr:hover td {
	background-color: #ffffd7;
}

table tbody tr td:hover {
	background-color: #ffff9b;
}

/* 직원 이름이 'D'로 시작하면 글씨색을 red */
/* 한칸 이상의 공백은 자손을 의미한다 */
table tbody tr td[fname^="D"] {
	color: red;
}

/* tr의 seq 속성에 값이 5로 끝나면 스타일 바꾸기 */
table tbody tr[seq$="5"] {
	background-color: #eaeaea;
}

/* data 중에 짝수번째 row에 border 스타일 변경 */
table tbody tr:nth-of-type(even) {
	border: 2px dotted green;
}

/* data 중에 짝수번째 row에 border 스타일 변경 */
table tbody tr:nth-of-type(2n+1) {
	border: 2px dotted hotpink;
}

table tbody tr:First-child, table tbody tr:last-child {
	background-color: aqua;
}

p:only-child {
	font-size: 30px;
}

p:only-of-type {
	font-size: 50px;
	color: maroon;
}

#container h1::before, #container h1::after {
	content: "**********";
}

tbody {
	counter-reset: mycount;
}

.aa::before {
	counter-increment: mycount;
	content: "[[@@" counter(mycount) "@@]]";
}

.hotpink {
	background-color: hotpink;
}

.yellow {
	background-color: yellow;
}

.white {
	background-color: white;
}
</style>
<script>
	window.onload = call;	

	function call() {
		// onclick => event 속성
		// f1 => 이벤트핸들러, 이벤트리스너
		document.querySelector("#search1").onclick = f1;
		document.querySelector("#search2").onclick = f2;
		document.querySelector("#search3").onclick = f3;
		document.querySelector("#btnClearAll").onclick = f4;
		document.querySelector("#reload").onclick = function() {
			location.reload();
		};

		function f1() {
			var fname = document.querySelector("#fname").value.toLowerCase();
			alert(fname);
			var nodeList = document
					.querySelectorAll("tbody tr td:nth-child(3)");
			var bgColor = "hotpink";

			nodeList.forEach(function(ele) {
				if (ele.textContent.trim().toLowerCase().startsWith(fname))
					ele.className = bgColor;
				else {
					// ele.className = white;
					ele.classList.remove(bgColor);
					//**자리를 차지하지 않음 : display
					//ele.parentNode.style.display = "none";
					//**자리를 차지함 : visibility
					//ele.parentNode.style.visibility = "hidden";
				}
			});
		}
		;

		function f2(event) {
			var event = event || window.event;

			for ( let prop in event) {
				console.log("prop : ", prop, "========event[prop] : ",
						event[prop]);
			}

			var salary = Number(document.querySelector("#salary").value);
			alert(salary);
			var nodeList = document
					.querySelectorAll("tbody tr td:nth-child(9)");
			var bgColor = "yellow";

			nodeList.forEach(function(ele) {
				if (Number(ele.textContent.trim().startsWith(salary)))
					ele.className = bgColor;
				else {
					// ele.className = white;
					ele.classList.remove(bgColor);
				}
			});
		}
		;

		function f3() {
			//이벤트 호출
			document.querySelector("#search2").onclick();

			//함수 호출
			// f2();
		}

		function f4() {
			var nodeList = document.querySelectorAll("tbody tr td");

			nodeList.forEach(function(ele) {
				ele.classList.remove("hotpink", "yellow");
			});
		}
	}
</script>
</head>
<body>

	<!-- 1)인클루드 디렉티브 태그: 합쳐서 자바로 만든다.(변수 공유가 가능) -->
	<%@include file="../auth/logout.jsp" %>
	
	<!-- 2)jsp표준태그: 각각을 자바 파일로 만든다.(변수 공유 불가) -->
	<!--<jsp:include page="../auth/logout.jsp"></jsp:include>-->
	
	<div>
		<input id="fname" />
		<button id="search1">시작하는 이름찾기</button>
		<br> <input id="salary" />
		<button id="search2">&gt;=급여찾기</button>
		<button id="search3">&gt;=급여찾기2</button>
		<br> <br>
		<button id="btnClearAll">class 모두제거</button>
		<button id="reload">reset(새로고침)</button>
		<br>
		
	</div>
	<%--
	<div>
		<h1>p가 1개인 경우</h1>
		<p>Only Child</p>
	</div>
	--%>
	<br>
	<button onclick="location.href='empInsert.do';">신규직원등록</button>
	<div id="container">
		<h1>직원목록................${sessionScope.company}</h1>
		<table>
			<thead>
				<tr>
					<th>순서</th>
					<th>employee_id</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
					<th>phone_number</th>
					<th>salary</th>
					<th>job_id</th>
					<th>hire_date</th>
					<th>commition_pct</th>
					<th>manager_id</th>
					<th>department_id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emplist}" var="emp" varStatus="status">
					<tr seq="${status.count}">
						<td class="aa">${status.count}</td>
						<td><a href="empDetail.do?empid=${emp.employee_id}">
								${emp.employee_id}
						</a></td>
						<td fname="${emp.first_name}">${emp.first_name}</td>
						<td>${emp.last_name}</td>
						<td>${emp.email}</td>
						<td>${emp.phone_number}</td>
						<td>
							<fmt:formatNumber groupingUsed="true" value="${emp.salary}"></fmt:formatNumber>
						</td>
						<td>${fn:toLowerCase(emp.job_id)}</td>
						<td>${emp.hire_date}</td>
						<td>${emp.commission_pct}</td>
						<td>${emp.manager_id}</td>
						<td>${emp.department_id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		var str = "${param.message}";
		if(str != "") alert(str);
	</script>
</body>
</html>