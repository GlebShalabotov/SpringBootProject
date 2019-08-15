<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <title>Update Job</title>
</head>
<jsp:include page="header.jsp"/>
<body>
<main>
    <p>Updating job with id ${oldJob.id}</p>

    <c:if test="${errors!=null}">
        <div>
            <c:forEach items="${errors}" var="error">
                <p>${error.field}: ${error.defaultMessage}</p>
            </c:forEach>
        </div>
    </c:if>

<form class="myForm" action="/aanpassen/update/${oldJob.id}" method="POST" modelAttribute="job">



        <label>Beschrijving</label>
        <input type="text" name="beschrijving" value="${oldJob.beschrijving}"/>

        <label>Duur</label>
        <input type="text" name="duur" value="${oldJob.duur}"/>

        <label>Details</label>
        <input type="text" name="details" value="${oldJob.details}"/>


    <input type="hidden" name="id" value="${oldJob.id}">
    <%--<input type="hidden" name="werkgever" value="${oldJob.werkgever}">--%>
    <input type="hidden" name="datum" value="${oldJob.datum}">
    <input type="hidden" name="jobStatus" value="${oldJob.jobStatus}">



        <button class="btn btn-success" type="submit">Post</button>
        <a class="btn btn-danger" href="/overzicht">Overview </a>

</form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>