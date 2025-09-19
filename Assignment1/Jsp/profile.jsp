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
<% if (request.getAttribute("message") != null) { %>
    <p>${message}</p>
<% } %>
<p>User ID: ${user.userid}</p>
<p>Name: ${user.name}</p>
<p>Email: ${user.email}</p>
</body>
</html>
