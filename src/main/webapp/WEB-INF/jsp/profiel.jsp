<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profiel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Welkom ${user.name} </h1>
<main>
    <div>
        <div><p>Naam</p><p>${user.name}</p></div>
        <div><p>Achternaam</p><p>${user.lastName}</p></div>
        <div><p>email</p><p>${user.email}</p></div>
        <p>${user.role}</p>
    </div>
<c:if test="${user.role == 'WERKNEMER'}">
    WERKNEMER lol
</c:if>
<c:if test="${user.role == 'WERKGEVER'}">
    WERKGEVER lol
</c:if>
</main>
</body>
</html>