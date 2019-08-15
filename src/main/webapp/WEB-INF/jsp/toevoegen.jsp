<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <title>Toevoegen Jobs</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1> Toevoegen van nieuwe job</h1>

<main>
<c:if test="${errors!=null}">
    <div>
        <c:forEach items="${errors}" var="error">
            <p>${error.field}: ${error.defaultMessage}</p>
        </c:forEach>
    </div>
</c:if>

<form class="myForm" action="/toevoegen/add" method="POST" modelAttribute="job">

        <label class="">Beschrijving</label>
        <input class="" type="text" name="beschrijving"/>


        <label class="">Duur</label>
        <input class="" type="text" name="duur"/>


        <label class="">Details</label>
        <input class="" type="text" name="details"/>


        <button class="btn btn-success m-3" type="submit">Post</button>
        <button class="btn btn-danger m-3" type="reset">Cancel</button>

</form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>