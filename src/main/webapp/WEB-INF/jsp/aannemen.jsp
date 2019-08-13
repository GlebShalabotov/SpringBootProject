<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>
<link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Aannemen Job</title>
</head>
<body>
 <jsp:include page="header.jsp"/>

<main>

    <div class="container"><h1><spring:message code="language.headerOverzicht"/></h1>
    <p><spring:message code="language.zoekenjob" </p>

    <form class="form-inline" action="/aannemen/beschrijving" method="post">
        <input class="form-control" type="text" name="beschrijving">
        <input type="submit" class="btn btn-info">
    </form>
    <table class="table">
        <thead class="thead-light">
        <th scope="col"><spring:message code="language.beschrijving"/></th>
        <th scope="col"><spring:message code="language.duur"/></th>
        <th scope="col"><spring:message code="language.werkgever"/></th>
        <th scope="col"><spring:message code="language.score"/></th>
        <th scope="col"><spring:message code="language.datum"/></th>
        <th scope="col"><spring:message code="language.details"/></th>
        <th scope="col"><spring:message code="language.aannemen"/></th>
        </thead>
        <tbody>
        <c:forEach var="job" items="${jobs}">
            <tr scope="row">
                <td>${job.beschrijving}</td>
                <td>${job.duur}</td>
                <td>${job.werkgever.name}</td>
                <td>${job.werkgever.score}</td>
                <td>${job.datum}</td>
                <td><a class="btn btn-secondary" href="/overzicht/details/${job.id}"><spring:message code="language.details"/></a></td>
                <td><a class="btn btn-primary" href="/aannemen/${job.id}"><spring:message code="language.dezejobaannemen"/></a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    </div>
</main>
</body>
</html>