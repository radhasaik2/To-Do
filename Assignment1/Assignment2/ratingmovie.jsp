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
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<c:choose>
    <c:when test="${hasRated}">
        <p>You have already rated this movie.</p>
        <c:if test="${not empty averageRating}">
            <p>Average Rating: ${String.format("%.1f", averageRating)}/5</p>
        </c:if>
    </c:when>
    <c:otherwise>
        <form method="post" action="submitRating">
            <input type="hidden" name="movieid" value="${movie.movieid}" />
            <label>Select your rating (1-5 stars):</label><br/>
            <input type="radio" name="rating" value="1" required> 1 Star
            <input type="radio" name="rating" value="2"> 2 Stars
            <input type="radio" name="rating" value="3"> 3 Stars
            <input type="radio" name="rating" value="4"> 4 Stars
            <input type="radio" name="rating" value="5"> 5 Stars
            <br/>
            <input type="submit" value="Submit Rating" />
        </form>
    </c:otherwise>
</c:choose>
<br/>
<a href="movies">Back to Movies</a> |
</body>
</html>
