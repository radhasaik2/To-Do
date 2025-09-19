<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (request.getAttribute("error") != null) { %>
    <p>${error}</p>
<% } %>
<form method="post" action="signupdata">
  Name: <input type="text" name="name" required/>
  Email: <input type="email" name="email" required/>
  Password: <input type="password" name="password" required/>
  <input type="submit" value="Submit" />
</form>
<p>Already have an account? <a href="login">Login here</a></p>
</body>
</html>
