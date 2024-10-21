<html lang="en">
<head>
    <meta charset="UTF-8">
   <%@page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Title</title>
</head>
<body>
<p>Current Character <%= session.getAttribute ("characterName")%><p>
<p>Current HP <%= session.getAttribute ("characterHP")%><p>
<p>Current Armor <%= session.getAttribute ("characterArmor")%><p>
<img src=/images/monster.jpg>
<h2><%= session.getAttribute("question")%></h2>
<form action="/quest/fight" method=POST>
<p><div class="form-check">
     <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="0">
     <label class="form-check-label" for="flexRadioDefault1">
      <%= session.getAttribute("answer0")%>
     </label>
   </div>
   <div class="form-check">
        <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="1">
        <label class="form-check-label" for="flexRadioDefault1">
          <%= session.getAttribute("answer1")%>
        </label>
      </div>
      <div class="form-check">
           <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="2">
           <label class="form-check-label" for="flexRadioDefault1">
            <%= session.getAttribute("answer2")%>
           </label>
         </div>
         <div class="form-check">
              <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="3">
              <label class="form-check-label" for="flexRadioDefault1">
               <%= session.getAttribute("answer3")%>
              </label>
            </div>
            <div class="form-check">
                 <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="4">
                 <label class="form-check-label" for="flexRadioDefault1">
                   <%= session.getAttribute("answer4")%>
                 </label>
               </div>

               <div class="form-check">
                    <input class="form-check-input" type="radio" name="Answer" id="flexRadioDefault1" value="5">
                    <label class="form-check-label" for="flexRadioDefault1">
                      <%= session.getAttribute("answer5")%>
                    </label>
                  </div>


   <button type="submit" class="btn btn-success">Next step</button>
 </p>
   </form>

<p>Cards For Doors Opening: <img hidden  id="redcard" src=/images/redcard.png width="70" height="40" >
                             <img hidden id="yellowcard" src=/images/yellowcard.png width="70" height="40"  >
                              <img hidden id="greencard" src=/images/greencard.png width="70" height="40"  ></p>

<% if (session.getAttribute("green")== (Boolean) true) %> <script> document.getElementById('greencard').hidden = false; </script>
<% if (session.getAttribute("red")== (Boolean) true) %> <script> document.getElementById('redcard').hidden = false; </script>
<% if (session.getAttribute("yellow")==(Boolean) true) %> <script> document.getElementById('yellowcard').hidden = false; </script>
</body>
</html>