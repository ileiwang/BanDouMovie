<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影列表</title>
</head>
<body>

<c:choose>

	<c:when test="${fn:length(movieList)==0}">
		<h1>暂无电影</h1>
	</c:when>

	<c:otherwise>
		<c:forEach items="${movieList}" var="movie">
			
			<dd>
				<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${movie.mid}">${movie.name}</a>
			</dd>
				
			<dd>
				${movie.region}
			</dd>
			
			<dd>
				<image src="images/${movie.image}" width="50" height="50"></image>
			</dd>
			
			<dd>
				${movie.mdesc}
			<dd/>
			
			<dd>
				${movie.date}
			<dd/>
								
			<br>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>