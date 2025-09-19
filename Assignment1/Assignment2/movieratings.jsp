<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Ratings</title>
</head>
<body>
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<c:forEach items="${movies}" var="movie">
    <div class="movie-card">
        <h2>${movie.title} (${movie.releaseYear})</h2>
        <c:choose>
            <c:when test="${movie.averageRating > 0}">
                <p class="rating">Average Rating: ${String.format("%.1f", movie.averageRating)}/5</p>
            </c:when>
            <c:otherwise>
                <p class="no-rating">No ratings yet</p>
            </c:otherwise>
        </c:choose>
    </div>
</c:forEach>
</body>
</html>
