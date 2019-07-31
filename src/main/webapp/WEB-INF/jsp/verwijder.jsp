<!doctype html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Verwijder Job</title>
</head>
<body>

<main>
    <h2>Are you sure you want to delete this job?</h2>

    <th>Beschrijving</th>
    <th>Duur</th>
    <th>werkgever</th>
    <th>datum</th>
    <th>details job</th>

    </thead>
    <tbody>

    <tr>
        <td>${job.beschrijving}</td>
        <td>${job.duur}</td>
        <td>${job.werkgever.name} ${job.werkgever.lastName}</td>
        <td>${job.datum}</td>
        <td>${job.status}</td>
    <tr>

    <div>
        <a href="/aanpassen/verwijder/bevestigd/{id}">Yes</a>
        <a href="/overzicht">No</a>
    </div>
</main>


</body>
</html>