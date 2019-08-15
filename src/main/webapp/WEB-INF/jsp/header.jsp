<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="/overzicht"><spring:message code="language.headerOverzicht"/></a></li>
        <li class="nav-item"><a class="nav-link" href="/toevoegen"><spring:message code="language.headerToevoegen"/></a> </li>
        <c:if test="${not empty user}">
            <li class="nav-item"><a class="nav-link" href="/profiel"><spring:message code="language.headerProfiel"/></a></li>
        </c:if>
        <li class="nav-item"><a class="nav-link" href="/login"><spring:message code="language.headerLogin"/></a></li>
    </ul>
    </nav>
</header>