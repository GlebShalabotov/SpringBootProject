<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<link rel="stylesheet" type="text/css" href="./../../css/reset.css"/>
<link rel="stylesheet" type="text/css" href="./../../css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="./../../css/eigen.css"/>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">

<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="/overzicht"><spring:message code="language.headerOverzicht"/></a></li>
        <li class="nav-item"><a class="nav-link" href="/login"><spring:message code="language.headerLogin"/></a></li>
        <li class="nav-item"><a class="nav-link" href="/toevoegen"><spring:message code="language.headerToevoegen"/></a> </li>
        <c:if test="${not empty user}">
            <li class="nav-item"><a class="nav-link" href="/profiel"><spring:message code="language.headerProfiel"/></a></li>
        </c:if>
    </ul>
    </nav>


</header>