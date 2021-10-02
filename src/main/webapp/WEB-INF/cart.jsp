<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="cart" scope="page" value="${sessionScope.cart}"/>

<html>
<head>
    <title>Cart</title>
</head>
<body>

<c:forEach var="item" items="${cart.cart}">
    <p>${item.toString()}</p>
</c:forEach>

<p>
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <br>
    <a href="${pageContext.request.contextPath}/products">Products</a>
</p>
</body>
</html>
