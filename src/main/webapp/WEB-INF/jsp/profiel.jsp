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
    <title>Profiel</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Welkom ${user.name} </h1>
<main>
    <div class="container">
        <div class="row"><p>Naam</p><p>${user.name}</p></div>
        <div class="row"><p>Achternaam</p><p>${user.lastName}</p></div>
        <div class="row"><p>Email:</p><p>${user.email}</p></div>
        <c:if test="${user.role == 'ROLE_WERKGEVER'}">
            <div class ="row">Score: ${user.score}</div>
        </c:if>
       <div class="row"><p>Role:</p><p>${user.role}</p></div>
    </div>
<c:if test="${user.role == 'ROLE_WERKNEMER'}">
    <c:choose>

        <c:when test="${not empty huidigejob}">
            <div>
                <h2>Uw momentele job</h2>
                <table class="table">
                    <thead>

                    <th scope="col"><spring:message code="language.beschrijving"/></th>
                    <th scope="col"><spring:message code="language.duur"/></th>
                    <th scope="col"><spring:message code="language.werkgever"/></th>
                    <th scope="col"><spring:message code="language.datum"/></th>
                    <th scope="col"><spring:message code="language.details"/></th>

                    </thead>
                    <tbody>
                    <tr scope="row">
                        <td scope="col">${huidigejob.beschrijving}</td>
                        <td>${huidigejob.duur}</td>
                        <td>${huidigejob.werkgever.name}</td>
                        <td>${huidigejob.datum}</td>
                        <td><a class="btn btn-secondary" href="/overzicht/details/${huidigejob.id}"><spring:message code="language.details"/></a></td>
                        <td><a class="btn btn-primary" href="/overzicht/finish/${huidigejob.id}">finish</a></td>


                    </tr>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <h2>Vind <a href="/overzicht">hier</a> een nieuwe job</h2>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${ not empty jobs}">
            <div>
                <h2>Deze jobs hebt u al voltooid</h2>
                <table class="table">
                    <thead class="thead-dark">
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
                            <td><a class="btn btn-primary" href="/overzicht/details/${job.id}">details</a></td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <h2>Nog geen jobs gedaan</h2>
            <p>Vind uw eerste job <a href="/overzicht">hier</a></p>
        </c:otherwise>
    </c:choose>
</c:if>
<c:if test="${user.role == 'ROLE_WERKGEVER'}">
    <c:choose>
        <c:when test="${ not empty jobs}">
            <div>
                <h2>Dit zijn uw geposte jobs</h2>
                <table class="table">
                    <thead class="thead-light">

                    <th scope="col"><spring:message code="language.beschrijving"/></th>
                    <th scope="col"><spring:message code="language.duur"/></th>
                    <th scope="col"><spring:message code="language.werkgever"/></th>
                    <th scope="col"><spring:message code="language.datum"/></th>
                    <th scope="col"><spring:message code="language.details"/></th>

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
                            <td> <a href="/aanpassen/update/${job.id}"> Update </a> </td>
                            <td> <a href="/aanpassen/verwijder/${job.id}"> Verwijder</a></td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <h2>Nog geen jobs gepost</h2>
            <p>Doe dat nu <a href="/toevoegen">hier</a></p>
        </c:otherwise>
    </c:choose>
</c:if>
</main>
</body>
</html>