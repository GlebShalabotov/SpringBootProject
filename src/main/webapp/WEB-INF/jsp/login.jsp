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
    <link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>

    <link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <title>Login</title>
</head>
<body class="text-center">
<jsp:include page="header.jsp"/>

<div class="container">
<h1 class="h1 mb-3 font-weight-normal"><spring:message code="h1login"/></h1>
    <main>
<h2 class="h2 mb-2 font-weight-normal"><spring:message code="h2login"/></h2>
<div>
    <c:forEach items="${errors}" var="error">
        <p>${error.field}: ${error.defaultMessage}</p>
    </c:forEach>
</div>
<form class="form-signin loginBody" action="/login" method="POST">
    <input class = "form-control"  type="text" name= "email" placeholder="<spring:message code="begruikersemail"/>" />
    <input class="form-control"type="password" name="password" placeholder="<spring:message code="gebruikerswachtwoord"/>"/>
    <input class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="LOGIN" />
</form>

<div class="row justify-content-center" >
    <a href="/login?lang=en">login English</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=fr">login Francaise</a>
    &nbsp;|&nbsp;
    <a href="/login?lang=nl">login Nederlands</a>
</div>
    </main>
</div>

<jsp:include page="footer.jsp"/>
</body>

</html>