<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
<jsp:include page="header.jsp"/>
<body class="container">
<p><spring:message code="errorPage"/></p>
<a href="/index"><spring:message code="errorPageBtn"/></a>
</body>
</html>
