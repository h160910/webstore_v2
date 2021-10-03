<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="pricelist" scope="page" value="${requestScope.pricelist}"/>

<html>
<head>
    <title>Products</title>
</head>
<body>
<fmt:bundle basename="webstoretexts">

<div>
<c:forEach var="item" items="${pricelist}">
    <div>
        <h3><fmt:message key="product.${item.key}.name" /></h3>
        <img src="${item.value[1]}" alt="image_cup" width="200" height="200">
        <p>Name: <fmt:message key="product.${item.key}.name" /></p>
        <p>Price: ${item.value[0]}</p>
        <p>Description: <fmt:message key="product.${item.key}.desc" /></p>

        <form method="post">
            <button type="submit" name="pid" value="${item.key}">Add to cart</button>
        </form>

    </div>
</c:forEach>
</div>

<p>
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <br>
    <a href="${pageContext.request.contextPath}/cart">Cart</a>
</p>

</fmt:bundle>
</body>
</html>
