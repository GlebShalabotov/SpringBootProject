<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Toevoegen Jobs</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<p> toevoegen page</p>
<%--<table>
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
            <td>${job.jobID}</td>
            <td>${job.duur}</td>
            <td>${job.werkgever.name}</td>
            <td>${job.datum}</td>
            <td><a href="/overzicht/details/${job.jobID}">details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>--%>

<c:if test="${errors!=null}">
    <div>
        <c:forEach items="${errors}" var="error">
            <p>${error.field}: ${error.defaultMessage}</p>
        </c:forEach>
    </div>
</c:if>

<form action="/toevoegen/add" method="POST" modelAttribute="job">
    <div>
        <label>Beschrijving</label>
        <input type="text" name="beschrijving"/>
    </div>
    <div>
        <label>Duur</label>
        <input type="text" name="duur"/>
    </div>
    <div>
        <label>Details</label>
        <input type="text" name="deatails"/>
    </div>
    <div>
        <button type="reset">Cancel</button>
        <button type="submit">Post</button>
    </div>
</form>

</body>
</html>