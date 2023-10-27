<%@page import="com.shinhan.model.DeptService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- uri는 주소의 유일성을 보장한다.--%>>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%
DeptVO dept =new DeptVO(10, "개발부", 100, 1700);
request.setAttribute("deptInfo", dept);

List<String> week = new ArrayList<>();
week.add("월요일");
week.add("화요일");
week.add("금요일");
week.add("토요일");
week.add("토요일");
pageContext.setAttribute("weekInfo", week);

DeptService dServic = new DeptService();
List<DeptVO> dlist = dServic.selectAll();
pageContext.setAttribute("dlistInfo", dlist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>	
7. pageScope : ${pageScope.phone}
7. requestScope : ${requestScope.phone}
7. sessionScope : ${sessionScope.phone}
7. applicationScope : ${applicationScope.phone}
7. 누굴까?(가장 가까운순으로 값을 찾아감) pageScope>requestScope>sessionScope>applicationScope ${phone}
</pre>
<hr>
<pre>
1. param : ${param.userid}
2. paramValues : ${paramValues.product[0]}
2. paramValues : ${paramValues.product[1]}
<!-- http://localhost:9999/webShop/views/elTest2.jsp?userid=admin&product=aa&product=bb -->
3. Bean(객체)얻기 getAttribute()....toString()이 호출됨 : ${deptinfo}
3. Bean(객체)얻기 getAttribute()....getter()가 호출됨 : ${deptinfo.department_name}
4. List 정보 얻기 : ${weekInfo[0]}
					${weekInfo[1]}
					${weekInfo[2]}
					${weekInfo[3]}
					${weekInfo[4]}
</pre>
<%
	for(DeptVO w:dlist) {
		
	}
%>
<ul>
	<c:forEach items="${dlistInfo}" var="w">
		<li>${w}</li>
		<li>${w.department_name}</li>
	</c:forEach>
</ul>
</body>
</html>