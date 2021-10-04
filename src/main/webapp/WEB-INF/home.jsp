<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:bundle basename="webstoretexts">
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="home" /></title>
</head>
<body>
<p><jsp:include page="chooseLanguage.jsp"/></p>

<h1>Kaffekopper AS</h1>

<h3><fmt:message key="welcome" /></h3>

<p>
    <fmt:message key="browse" /> <a href="${pageContext.request.contextPath}/products"><fmt:message key="products" /></a>
</p>
</fmt:bundle>

<p><jsp:include page="copyright.jsp"/></p>
</body>
</html>