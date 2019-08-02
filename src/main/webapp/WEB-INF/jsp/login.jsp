<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div >
    <a href="/login?lang=en">login English</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=fr">login Française</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=nl">login Nederlands</a>
</div>
<h1><spring:message code="h1login"/></h1>
<h2><spring:message code="h2login"/></h2>
<div>
    <c:forEach items="${errors}" var="error">
        <p>${error.field}: ${error.defaultMessage}</p>
    </c:forEach>
</div>
<form action="/login" method="POST">
    <label > <spring:message code="begruikersemail"/> </label>
    <input type="text" name= "email" />
    <label> <spring:message code="gebruikerswachtwoord"/> </label>
    <input type="password" name="password" />
    <input type="submit" name="submit" value="LOGIN" />
</form>
</body>

</html>