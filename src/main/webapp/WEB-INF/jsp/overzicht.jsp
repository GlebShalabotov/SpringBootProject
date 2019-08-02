<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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


<table>
    <thead>

    <th><spring:message code="language.beschrijving"/></th>
    <th><spring:message code="language.duur"/></th>
    <th><spring:message code="language.werkgever"/></th>
    <th><spring:message code="language.datum"/></th>
    <th><spring:message code="language.details"/></th>

    </thead>
    <tbody>
    <c:forEach var="job" items="${jobs}">
        <tr>
            <td>${job.beschrijving}</td>
            <td>${job.duur}</td>
            <td>${job.werkgever.name}</td>
            <td>${job.datum}</td>
            <td>${job.jobStatus}</td>
            <td><a href="/overzicht/details/${job.id}">details</a></td>
        </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>