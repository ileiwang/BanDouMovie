<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>团购详细页</title>
</head>
<body>
<h1>团购基本信息</h1>
	<dd>
		<a href="${pageContext.request.contextPath}/findGroupbuyByGid.do?gid=${groupbuy.gid}">查看</a>
	</dd>
	
	<dd>
		<a href="${pageContext.request.contextPath}/joinGroupbuy.do?gid=${groupbuy.gid}">加入团购</a>
	</dd>
		
	<dd>
		创建时间： <fmt:formatDate value="${groupbuy.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</dd>
		
	<dd>
		团购人数：${fn:length(groupbuy.userList)}
	</dd>
	
	<hr>
	
	<h1>电影信息</h1>

		<dd>
			<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${groupbuy.movie.mid}">${groupbuy.movie.name}</a>
		</dd>
		<br>
		<dd>地区：${groupbuy.movie.region}</dd>
		<br>
		<dd>
			<image src="images/${groupbuy.movie.image}" width="50" height="50"></image>
		</dd>
		<br>
		<dd>
			加入时间：<fmt:formatDate value="${groupbuy.movie.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</dd>
		<br>
		<dd>
			简介：${groupbuy.movie.mdesc}
		</dd>
		

	<hr>
	<h1>团购成员</h1>
	<c:forEach items="${groupbuy.userList}" var="user">
		<dd>
			<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${user.uid}">${user.username}</a>
		</dd>
	</c:forEach>
						
	<br>
	<hr>
</body>
</html>