<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Huidige job</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Jouw huidige job</h1>
<main>
    <p>Op dit moment is dit je huidige baan</p>
    <p>Ben je klaar? Meld dit dan zeker tegen uw begeleider</p>

    <table>
        <thead>
            <th><spring:message code="language.beschrijving"/></th>
            <th><spring:message code="language.duur"/></th>
            <th><spring:message code="language.werkgever"/></th>
            <th><spring:message code="language.datum"/></th>
            <th><spring:message code="language.details"/></th>
        </thead>
        <tbody>
        <tr>
            <td>${job.beschrijving}</td>
            <td>${job.duur}</td>
            <td>${job.werkgever.name}</td>
            <td>${job.datum}</td>
            <td><a href="/overzicht/details/${job.id}">details</a></td>
            <td><a href="/overzicht/finish/${job.id}">afwerken</a></td>
        </tr>
        </tbody>
    </table>
</main>
</body>
</html>