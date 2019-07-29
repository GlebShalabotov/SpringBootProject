<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
    <body>

    <jsp:include page="header.jsp"/>
    <div>
        <c:forEach items="${errors}" var="error">
            <p>${error.field}: ${error.defaultMessage}</p>
        </c:forEach>
    </div>
        <form action="/login" method="POST">
            <input type="text" name= "email" />
            <input type="password" name="password" />
            <input type="submit" name="submit" value="LOGIN" />
        </form>
    </body>
</html>