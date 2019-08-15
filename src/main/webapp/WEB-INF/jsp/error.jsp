<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<jsp:include page="header.jsp"/>
<body >
<main>
<div class="alert alert-warning" role="alert">
<p><spring:message code="errorPage"/></p>
<a href="/index"><spring:message code="errorPageBtn"/></a>
</div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
