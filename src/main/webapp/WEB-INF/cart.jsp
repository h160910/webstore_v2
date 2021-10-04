<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="dat152-libs" prefix="ctg"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:set var="cart" scope="page" value="${sessionScope.cart}"/>
<c:set var="pricelist" scope="page" value="${sessionScope.pricelist}" />

<fmt:bundle basename="webstoretexts">

<html>
<head>
    <title><fmt:message key="cart"/></title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<p><jsp:include page="chooseLanguage.jsp"/></p>


    <h2><fmt:message key="cart"/></h2>
    <table>
        <tr>
            <th><fmt:message key="name" /></th>
            <th><fmt:message key="description" /></th>
            <th><fmt:message key="price" /></th>
            <th><fmt:message key="quantity" /></th>
            <th><fmt:message key="total" /></th>
        </tr>
<c:forEach var="item" items="${cart.content}">
    <tr>
        <td>
            <fmt:message key="product.${item.key.pid}.name" />
        </td>
        <td>
            <ctg:shorttext maxchars="10">
                <fmt:message key="product.${item.key.pid}.desc" />
            </ctg:shorttext>
        </td>
        <td> ${pricelist.get(item.key.pid)} </td>
        <td> ${item.value} </td>
        <td> <fmt:message key="total" /> </td>
    </tr>
</c:forEach>
    </table>

<p>
    <a href="${pageContext.request.contextPath}/home"><fmt:message key="home" /></a>
    <a href="${pageContext.request.contextPath}/products"><fmt:message key="products" /></a>
</p>
</fmt:bundle>

<p><jsp:include page="copyright.jsp"/></p>
</body>
</html>
