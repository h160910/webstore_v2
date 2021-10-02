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
        <img src="${product.imageFile}" alt="image_cup" width="200" height="200">
        <p>Name: ${product.name}</p>
        <p>Price: ${product.priceInEuros}</p>
        <p>Description: ITEM DESCRIPTION HERE</p>
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
