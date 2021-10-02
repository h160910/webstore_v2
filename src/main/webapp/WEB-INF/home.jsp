<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<p><jsp:include page="chooseLanguage.jsp"/></p>

<h1>Kaffekopper AS</h1>

<fmt:bundle basename="webstoretexts">
<h1><fmt:message key="welcome" /></h1>
</fmt:bundle>

<p>Have a look at our wonderful <a href="${pageContext.request.contextPath}/products">products</a></p>

</body>
</html>