<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav>
    <ul>
        <li><a href="/overzicht">Overzicht Jobs</a></li>
        <li><a href="/aanpassen">Aanpassen</a></li>
        <li><a href="/login">Login</a></li>
        <li><a href="/toevoegen">AddJob</a> </li>
        <c:if test="${not empty user}">
            <li><a href="/profiel">profiel</a></li></c:if>
    </ul>
    </nav>

</header>