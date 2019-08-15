
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
    <title>Job Afwerken</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>

    <h2>Gefliciteerd met het afwerken van uw job </h2>
    <h3>Wilt u uw begeleider nog een score geven, dan gaat dit : </h3>
    <form action="/overzicht/finish/${job.id}" method="post" >
    <div>${wg.name} ${wg.lastName} </div>
    <select name="score" id="score">

        <option selected>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
    </select>
        <button type="sumbit">FINISH</button>
    </form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>