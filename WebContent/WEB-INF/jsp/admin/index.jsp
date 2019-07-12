<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
</head>
<body>
	<h1>用户管理</h1>
	<a href="${pageContext.request.contextPath}/admin/findAllUser.do">用户列表</a>
	<a href="${pageContext.request.contextPath}/register.do">添加用户</a>
	<h1>分类管理</h1>
	<a href="${pageContext.request.contextPath}/findAllCategory.do">分类列表</a>
	<a href="${pageContext.request.contextPath}/admin/addCategory.do">添加分类</a>
	<h1>电影管理</h1>
	<a href="${pageContext.request.contextPath}/findAllMovie.do">电影列表</a>
	<a href="${pageContext.request.contextPath}/admin/showAddMovie.do">添加电影</a>
	<h1>评论管理</h1>
	<a href="${pageContext.request.contextPath}/remarkList.do">评论列表</a>
	<h1>团购管理</h1>
	<a href="${pageContext.request.contextPath}/findAllGroupbuy.do">团购列表</a>
</body>
</html>