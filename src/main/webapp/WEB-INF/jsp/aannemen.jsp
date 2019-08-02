<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
 <h1>Job aanbiedingen</h1>
<main>
    <table>
        <thead>
        <th><spring:message code="language.beschrijving"/></th>
        <th><spring:message code="language.duur"/></th>
        <th><spring:message code="language.werkgever"/></th>
        <th><spring:message code="language.datum"/></th>
        <th><spring:message code="language.details"/></th>
        <th><spring:message code="language.aannemen"/></th>
        </thead>
        <tbody>
        <c:forEach var="job" items="${jobs}">
            <tr>
                <td>${job.beschrijving}</td>
                <td>${job.duur}</td>
                <td>${job.werkgever.name}</td>
                <td>${job.datum}</td>
                <td><a href="/overzicht/details/${job.id}"><spring:message code="language.details"/></a></td>
                <td><a href="/aannemen/${job.id}"><spring:message code="language.dezejobaannemen"/></a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>