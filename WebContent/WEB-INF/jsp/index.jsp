<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<h1>电影</h1>
<c:forEach var="category" items="${categoryList}">
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
				<image src="images/${movie.image}" width="100" height="100"></image>
			</dd>
			
<%-- 			<dd>
				${movie.mdesc}
			<dd/> --%>
			
			<dd>
				<fmt:formatDate value="${movie.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
			<dd/>
			<hr>
		</c:forEach>
	</dl>
	<hr>
</c:forEach>
<h1>评论</h1>
<c:forEach items="${remarkList}" var="remark">
		
	<dd>
		${remark.content}
	</dd>
	
	<dd>
		<image src="images/${remark.movie.image}" width="50" height="50"></image>
	</dd>
	
	<dd>
		${remark.remarkdate}
	<dd/>
	
	<dd>
		<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${remark.movie.mid}">${remark.movie.name}</a>
	</dd>
	
	<dd>
		<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${remark.user.uid}">${remark.user.username}</a>
	</dd>
	
						
	<br>
	<hr>
</c:forEach>
<h1>团购</h1>
<c:forEach items="${groupbuyList}" var="groupbuy">
		
	<dd>
		${groupbuy.gid}
	</dd>
	
	<dd>
		${groupbuy.createdate}
	<dd/>
	
	<dd>
		<image src="images/${groupbuy.movie.image}" width="50" height="50"></image>
	</dd>
	
	
	<dd>
		<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${groupbuy.movie.mid}">${groupbuy.movie.name}</a>
	</dd>
	
	<dd>
		<a href="${pageContext.request.contextPath}/findGroupbuyByGid?gid=${groupbuy.gid}">查看团购详细</a>
	</dd>
	
	<hr>
	<c:forEach items="${groupbuy.userList}" var="user">
	<dd>
		<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${user.uid}">${user.username}</a>
	</dd>
	</c:forEach>
	<hr>
	
						
	<br>
	<hr>
</c:forEach>
</body>
</html>