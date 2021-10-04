<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="pricelist" scope="page" value="${sessionScope.pricelist}" />
<c:set var="productlist" scope="page" value="${requestScope.productlist}" />

<fmt:bundle basename="webstoretexts">
<html>
<head>
    <title><fmt:message key="products" /></title>
</head>
<body>
<p><jsp:include page="chooseLanguage.jsp"/></p>

<div>
<c:forEach var="item" items="${productlist}">
    <div>
        <h3><fmt:message key="product.${item.pid}.name" /></h3>

        <img src="${item.imageFile}" alt="image_cup" width="200" height="200">

        <p><fmt:message key="name" />: <fmt:message key="product.${item.pid}.name" /></p>

        <p><fmt:message key="price" />: ${pricelist.get(item.pid)}</p>

        <p><fmt:message key="description" />: <fmt:message key="product.${item.pid}.desc" /></p>

        <form method="post">
            <button type="submit" name="pid" value="${item.pid}"><fmt:message key="addtocart" /></button>
        </form>

    </div>
</c:forEach>
</div>

<p>
    <a href="${pageContext.request.contextPath}/home"><fmt:message key="home" /></a>
    <a href="${pageContext.request.contextPath}/cart"><fmt:message key="cart"/></a>
</p>

</fmt:bundle>

<p><jsp:include page="copyright.jsp"/></p>
</body>
</html>
