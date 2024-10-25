<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quests</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <title>Auth Page For Quests access</title>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
<form action="/choosingQuest" method=POST>
<label class="control label"> Authorization </label>

<div class="row g-3 align-items-center">
  <div class="col-auto">
    <label for="inputUserName" class="col-form-label">User Name</label>
  </div>
  <div class="col-auto">
    <input type="username" name="username" id="inputUserName" class="form-control" aria-describedby="passwordHelpInline">
  </div>
</div>


<div class="row align-items-center">

  <div class="col-auto">
    <label for="inputPassword" class="col-form-label">Password</label>
  </div>
  <div class="col-auto">

    <input type="password" name="password" id="inputPassword" class="form-control" aria-describedby="passwordHelpInline">
  </div>

  <div class="col-auto">
    <span id="passwordHelpInline" class="form-text">

    </span>
  </div>

</div>

<button type="submit" class="btn btn-success">Enter To Quests</button>
</div>
</form>
</body>
</html>