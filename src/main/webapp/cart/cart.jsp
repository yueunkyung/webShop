<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니담기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  >
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"  ></script>
</head>
<body>
<h1>장바구니담기</h1>
<p>로그인한 사람: ${loginUser.manager_name}</p>
<form action="shopping.do" method="post">

<div class="form-check">
  <input class="form-check-input" type="radio" name="product" 
  id="product1" value="김밥" ${productName == "김밥"? "checked":""} />
  <label class="form-check-label" for="product1">
    김밥
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="product" 
  id="product2" value="햄버거" ${productName == "햄버거"? "checked":""} />
  <label class="form-check-label" for="product2">
    햄버거
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="product" 
  id="product3" value="콜라" ${productName == "콜라"? "checked":""} />
  <label class="form-check-label" for="product3">
    콜라
  </label>
</div>
 
 <input type="number" name="count" value="${productCount}"> <br>
 <input type="submit" type="button" class="btn btn-success" value="장바구니담기">
 <input type="button" type="button" class="btn btn-success" value="장바구니보기" 
         onclick="location.href='cartview.do';">
 <input type="button" type="button" class="btn btn-success" value="장바구니비우기" 
                type="button" class="btn btn-success" 
         onclick="location.href='cartremove.do';">
</form>
</body>
</html>




