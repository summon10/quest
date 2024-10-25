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
<div class="position-absolute top-50 start-50 translate-middle">
<p><img src=/images/dead.gif></p>
<form action="/quest/welcome.jsp">
<button class="btn btn-secondary"> Try again </button>

</form>
<p>
<form action="/choosingQuest.jsp">
<button class="btn btn-secondary"> Choose Another Quest </button>
<% session.invalidate(); %>
</form>
</p>
</div>
</body>
</html>