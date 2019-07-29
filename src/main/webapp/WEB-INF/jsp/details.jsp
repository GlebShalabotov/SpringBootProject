<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Details Job</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Details job</h2>

<main>
    <p>${job.details}</p>
    <div>${job.werkgever.name} ${job.werkgever.lastName} ${job.werkgever.telefoon}</div>


</main>

</body>
</html>