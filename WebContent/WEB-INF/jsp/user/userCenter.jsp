<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>
<h1>我看过的电影：</h1>
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
	
<h1>我的评论：</h1>
<c:forEach items="${remarkList}" var="remark">
	
	<dd>
		<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${remark.movie.mid}">${remark.movie.name}</a>
	</dd>
		
	<dd>
		${remark.content}
	</dd>
	
	<dd>
		${remark.remarkdate}
	<dd/>
						
	<br>
	<hr>
</c:forEach>

<h1>我的团购：</h1>
<c:forEach items="${groupbuyList}" var="groupbuy">
	
	<dd>
		<a href="${pageContext.request.contextPath}/findGroupbuyByGid.do?gid=${groupbuy.gid}">查看团购详细信息</a>
	</dd>
		
	<dd>
		${groupbuy.gid}
	</dd>
	
	<dd>
		${groupbuy.createdate}
	<dd/>
						
	<br>
	<hr>
</c:forEach>
</body>
</html>