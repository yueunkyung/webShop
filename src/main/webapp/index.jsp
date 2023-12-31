<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("loginResult", "");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.html 페이지</title>
</head>
<body>
	<h1>JSP/Servlet을 이용한 web application 만들기(은경)</h1>
	
	<ul>
		<li>1.get요청하기(주소창에서 요청)</li>
		<li><a href="/webShop/second">2.get요청(a태그이용-절대경로)</a></li>	 <!-- 절대경로 -->
		<li><a href="second">2.get요청(a태그이용-상대경로)</a></li>		 <!-- 상대경로 -->
		<li>
			<form action="second" method="get">	<!-- 상대경로 -->
				<input type="submit" value="3.get요청(form이용)" />
			</form>
		</li>
		<li>
			<form action="second" method="post"> <!-- 상대경로 -->
				<input type="submit" value="4.post요청(form이용)" />
			</form>
		</li>
		<li>			
			<button id="loginBtn">로그인하기</button>
		</li>
		<li>			
			<button id="deptInputBtn">부서 입력</button>
		</li>
		<li>			
			<button onclick="location.href='dept/deptList.do';">부서 조회</button>
		</li>
		<li>			
			<button id="reviewBtn">복습!!!</button>
		</li>
		<li>			
			<button id="empListBtn">직원조회</button>
		</li>
	</ul>
	<script>
		document.querySelector("#loginBtn").onclick = function() {
			location.href = "auth/loginCheck.do";
		};
		
		document.querySelector("#deptInputBtn").onclick = function() {
			location.href = "dept/deptInsert.do";
		};
		
		document.querySelector("#reviewBtn").onclick = function() {
			location.href = "html/input2.html";
		};
		
		document.querySelector("#empListBtn").onclick = function() {
			location.href = "./emp/empList.do";
		};
	</script>
</body>
</html>