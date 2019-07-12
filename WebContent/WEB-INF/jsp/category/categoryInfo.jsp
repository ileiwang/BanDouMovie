<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类信息</title>
</head>
<body>
	<dl>
		<dt>
			<a href="${pageContext.request.contextPath}/findCategoryByCid.do?cid=${category.cid}"><h3>${category.cname}</h3></a>
		</dt>
		<c:forEach items="${category.movieList}" var="movie">
			
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
	</dl>
</body>
</html>