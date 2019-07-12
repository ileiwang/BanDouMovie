<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
</head>
<body>
	<dd>
		${user.username}
	</dd>
	
	<dd>
		${user.uname}
	<dd/>
	
	<dd>
		${user.email}
	<dd/>
	<dd>
		${user.phone}
	<dd/>
	<dd>
		${user.addr}
	<dd/>
	
	<dd>
		<a href="${pageContext.request.contextPath}/remarkListByUid.do?uid=${user.uid}">查看用户评论</a>
	<dd/>
	<dd>
		<a href="${pageContext.request.contextPath}/findMovieByUid.do?uid=${user.uid}">查看用户电影</a>
	<dd/>
	<dd>
		<a href="${pageContext.request.contextPath}/findGroupbuyListByUid.do?uid=${user.uid}">查看用户团购</a>
	<dd/>
	
<%-- 	<dd>
		<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${user.uid}">查看</a>
	<dd/>
	
	<dd>
		<a href="${pageContext.request.contextPath}/admin/showEditUser.do?uid=${user.uid}">修改</a>
	<dd/>
	
	<dd>
		<a href="${pageContext.request.contextPath}/admin/deleteUserByUid.do?uid=${user.uid}">删除</a>
	<dd/> --%>
</body>
</html>