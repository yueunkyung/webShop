<%-- page directive --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Bootstrap 5 Website Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function f1() {
		alert("f1");
		// contextpath => http://localhost:9999/webShop
		$.ajax({
			type : "get",
			url : "${contextpath}/ajax/getEmpInfo.go",
			data : {
				empid : 100,
				email : "eunkyung211@naver.com"
			},
			success : function(responseData) {
				$("#here").html(responseData);
			}
		});
	}

	function f2() {
		alert("f2");
		// contextpath => http://localhost:9999/webShop?empid[0]=100&empid[1]=200
		// contextpath => http://localhost:9999/webShop?empid=100&empid=200 => $.ajaxSettings.traditional 사용하면 이렇게 인식이 됨.
		$.ajaxSettings.traditional = true;
		$.ajax({
			type : "get",
			url : "${contextpath}/ajax/getEmpInfo2.go",
			data : {
				empid : [ 100, 200, 215 ],
				email : "eunkyung211@naver.com"
			},
			success : function(responseData) {
				$("#here").html(responseData);
			}
		});
	}

	function f3() {
		alert("f3");
		var obj = {empid : 100, email : "eunkyung211@naver.com"};
		$.ajax({
			type : "get",
			url : "${contextpath}/ajax/getEmpInfo3.go",
			data : {
				empInfo : JSON.stringify(obj)
			},
			success : function(responseData) {
				$("#here").html(responseData);
			}
		});
	}
	
	function f4() {
		alert("f4");
		var obj = {deptid : 60, email : "eunkyung211@naver.com"};
		$.ajax({
			type : "get",
			url : "${contextpath}/ajax/getEmpInfo4.go",
			data : obj,
			success : function(responseData) {
				console.log("responseData", responseData);
				var obj = JSON.parse(responseData);
				var output = "<ul>";
				var arr= obj["mlist"];
				var email= obj["email"];
				var deptid= obj["deptid"];
				console.log("arr"+arr);
				var obj = JSON.parse(responseData);
				$.each(arr, function(index, item){
					output += "<li>"+item["fname"]+"</li>";
				});
				$("#here").html(output+"</ul>");
			}
		});
	}
</script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>
	<div class="p-5 bg-primary text-white text-center">
		<h1>My First Bootstrap 5 Page</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					href="javascript:f1();">ajax1(Parameter 기본)</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:f2();">ajax2(Parameter 배열)</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:f3();">ajax3(JSON 보내기)</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:f4();">ajax4(JSON 받기)</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4">
				<h2>About Me</h2>
				<h5>Photo of me:</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text about me in culpa qui officia deserunt mollit
					anim..</p>
				<h3 class="mt-4">Some Links</h3>
				<p>Lorem ipsum dolor sit ame.</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item">
						<button type="button" onclick="javascript:f1();"
							class="btn btn-primary">Ajax1</button>
					</li>
					<li class="nav-item">
						<button type="button" onclick="javascript:f2();"
							class="btn btn-primary">Ajax2</button>
					</li>
					<li class="nav-item">
						<button type="button" onclick="javascript:f3();"
							class="btn btn-primary">Ajax3</button>
					</li>
					<li class="nav-item"><button type="button" onclick="javascript:f4();"
							class="btn btn-primary">Ajax4</button>
					</li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<h2>TITLE HEADING</h2>
				<h5>Title description, Dec 7, 2020</h5>
				<div class="fakeimg" id="here" style="min-height: 200px; height: auto; padding: 20px; background-color: #e6f7ff">Fake Image</div>
				<!-- 
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>

				<h2 class="mt-5">TITLE HEADING</h2>
				<h5>Title description, Sep 2, 2020</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text..</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum
					consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco.</p>
				 -->
			</div>
		</div>
	</div>

	<div class="mt-5 p-4 bg-dark text-white text-center">
		<p>Footer</p>
	</div>

</body>
</html>
