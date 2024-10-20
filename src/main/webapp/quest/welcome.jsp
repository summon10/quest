<html lang="en">
<head>
    <meta charset="UTF-8">
   <%@page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1>Welcome to Duke Nukem Quest!</h1>
<form action="/quest/welcome" method=POST>
<p>
<p><h2>Hello, Gamer! Enter the name of your character:</h2>

       <div class="input-group mb-3">
         <span class="input-group-text" id="basic-addon1">@</span>
         <input type="characterName" name="characterName" class="form-control" placeholder="Character Name" aria-label="Character Name" aria-describedby="basic-addon1">
       </div>
</p>

<button type="submit" class="btn btn-success">Lets begin!</button>
</form>



</p>
</body>
</html>