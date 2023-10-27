<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("phone", "page12345");
request.setAttribute("phone", "request3333");
session.setAttribute("phone", "session4444");
application.setAttribute("phone", "application7777");
%>

<body>
<h1>EL(Expression Language)</h1>
<pre>
1. 정답은 ${1+2} 입니다.
2. 문자랑 더하기 ${100+"200"}
3. 비교 연산자 : ${10>20}
4. div : ${10 / 3}
5. div : ${10 mod 3}
6. eq : ${10==10} 혹은 ${10 eq 100}
7. pageScope : ${pageScope.phone}
7. requestScope : ${requestScope.phone}
7. sessionScope : ${sessionScope.phone}
7. applicationScope : ${applicationScope.phone}
7. 누굴까?(가장 가까운순으로 값을 찾아감) pageScope>requestScope>sessionScope>applicationScope ${phone} 
<jsp:forward page ="elTest2.jsp"></jsp:forward>
</pre>
</body>
</html>