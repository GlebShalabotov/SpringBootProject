<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Details Job</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2><spring:message code="language.details"/></h2>

<main>
    <p>${job.details}</p>
    <div>${job.werkgever.name} ${job.werkgever.lastName} ${job.werkgever.telefoon}</div>
    <c:if test="${user.role == 'ROLE_WERKNEMER'}"> <a href="/aannemen/${job.id}">Deze job aannemen</a></c:if>
</main>

</body>
</html>