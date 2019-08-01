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
        <div><p>Email:</p><p>${user.email}</p></div>
       <div><p>Role:</p><p>${user.role}</p></div>
    </div>
<c:if test="${user.role == 'ROLE_WERKNEMER'}">
    <c:choose>

        <c:when test="${not empty huidigejob}">
            <div>
                <h2>Uw momentele job</h2>
                <table>
                    <thead>
                    <th>Beschrijving</th>
                    <th>Duur</th>
                    <th>werkgever</th>
                    <th>datum</th>
                    <th>details job</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${huidigejob.beschrijving}</td>
                        <td>${huidigejob.duur}</td>
                        <td>${huidigejob.werkgever.name}</td>
                        <td>${huidigejob.datum}</td>
                        <td><a href="/overzicht/details/${huidigejob.id}">details</a></td>
                        <td><a href="/overzicht/finish/${huidigejob.id}">afwerken</a></td>
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
                            <td><a href="/overzicht/details/${job.id}">details</a></td>
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
                <table>
                    <thead>
                    <th>Beschrijving</th>
                    <th>Duur</th>
                    <th>werkgever</th>
                    <th>datum</th>
                    <th>Job Status</th>
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