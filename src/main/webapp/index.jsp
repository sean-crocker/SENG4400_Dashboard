<%--
  Created by IntelliJ IDEA.
  User: Sean Crocker
  Date: 1/06/2022
  Time: 3:05 am

  Basic index java server page to display a link to the Controller servlet to issue a GET request.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="stylesheet.css" type="text/css">
  <title>Google App Engine</title>
</head>
<body>
  <div class="container">
    <div class="box">
      <p>Welcome</p>
      <a href="_ah/api/echo/v1/answer">View Answers</a>
    </div>
    <div class="drops">
      <div class="drop drop-1"></div>
      <div class="drop drop-2"></div>
      <div class="drop drop-3"></div>
      <div class="drop drop-4"></div>
      <div class="drop drop-5"></div>
    </div>
  </div>
</body>
</html>
