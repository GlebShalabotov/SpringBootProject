<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>

<link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Overzicht</h2>


<table class="table">
    <thead class="thead-light">

    <th scope="col"><spring:message code="language.beschrijving"/></th>
    <th scope="col"><spring:message code="language.duur"/></th>
    <th scope="col"><spring:message code="language.werkgever"/></th>
    <th scope="col"><spring:message code="language.score"/></th>
    <th scope="col"><spring:message code="language.datum"/></th>
    <th scope="col"><spring:message code="language.details"/></th>

    </thead>
    <tbody>
    <c:forEach var="job" items="${jobs}">
        <tr scope="row">
            <td>${job.beschrijving}</td>
            <td>${job.duur}</td>
            <td>${job.werkgever.name}</td>
            <td>${job.werknemer.name}</td>
            <td>${job.datum}</td>
            <td>${job.jobStatus}</td>
            <td><a href="/overzicht/details/${job.id}">details</a></td>
        </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>