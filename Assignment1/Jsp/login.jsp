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
    <p style="color: red;">${error}</p>
<% } %>
<form method="post" action="logindata">
  Email: <input type="email" name="email" required/>
  Password: <input type="password" name="password" required/>
  <input type="submit" value="Submit" />
</form>
<p>Don't have an account? <a href="signup">Sign up here</a></p>
</body>
</html>
