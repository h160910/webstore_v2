<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="productlist" scope="page" value="${requestScope.productlist}"/>

<html>
<head>
    <title>Products</title>
</head>
<body>

<div>
<c:forEach var="product" items="${productlist}">
    <div>
        <h3>${product.name}</h3>
        <span>${product.priceInEuros}</span>
        <form method="post">
            <button type="submit" name="pid" value="${product.pid}">Add to cart</button>
        </form>

    </div>
</c:forEach>
</div>

<p>
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <br>
    <a href="${pageContext.request.contextPath}/cart">Cart</a>
</p>
</body>
</html>
