<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav>
    <ul>
        <li><a href="/overzicht">Overzicht</a></li>
        <li><a href="/login">logIn</a></li>
        <li><a href="/toevoegen">AddJob</a> </li>
    </ul>
    </nav>
    <p><sec:authorize acces="hasRole('WERKNEMER')"> het lukte</sec:authorize></p>
</header>