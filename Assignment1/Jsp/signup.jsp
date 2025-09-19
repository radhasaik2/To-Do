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
<h2>Sign Up</h2>
<% if (request.getAttribute("error") != null) { %>
    <p>${error}</p>
<% } %>
<form method="post" action="signupdata">
  Name: <input type="text" name="name" required/><br/>
  Email: <input type="email" name="email" required/><br/>
  Password: <input type="password" name="password" required/><br/>
  <input type="submit" value="Submit" />
</form>
<p>Already have an account? <a href="login">Login here</a></p>
</body>
</html>
