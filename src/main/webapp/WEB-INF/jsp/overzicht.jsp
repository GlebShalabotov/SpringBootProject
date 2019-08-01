<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <th>Beschrijving</th>
    <th>Duur</th>
    <th>werkgever</th>
    <th>datum</th>
    <th>details job</th>

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