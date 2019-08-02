<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<header>
    <nav>
    <ul>
        <li><a href="/overzicht"><spring:message code="language.headerOverzicht"/></a></li>
        <li><a href="/login"><spring:message code="language.headerLogin"/></a></li>
        <li><a href="/toevoegen"><spring:message code="language.headerToevoegen"/></a> </li>
        <c:if test="${not empty user}">
            <li><a href="/profiel"><spring:message code="language.headerProfiel"/></a></li></c:if>
    </ul>
    </nav>


</header>