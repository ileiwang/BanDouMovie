<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updateUser.do">
	<table>
	<input type="hidden" name="uid" value=${user.uid}>
	<input type="hidden" name="code" value="">
	<input type="hidden" name="state" value=${1}>
	<tr>
		<th>用户名:</th>
		<td>
			<input type="text" id="username" value=${user.username} name="username" maxlength="20" onblur="checkUsername()">
			<span id="span" style="color:green;"></span>
		</td>
	</tr>
	
	<tr>
		<th>E-mail:</th>
		<td><input type="text" name="email" maxlength="200" value=${user.email}></td>
	</tr>
	
	<tr>
		<th>姓名:</th>
		<td><input type="text" name="uname" maxlength="200" value=${user.uname} }></td>
	</tr>
	
	<tr>
		<th>密码:</th>
		<td><input type="password" name="password" maxlength="200" value=${user.password} }></td>
	</tr>
	
	<tr>
		<th>电话:</th>
		<td><input type="text" name="phone" value=${user.phone}></td>
	</tr>

	<tr>
		<th>地址:</th>
		<td><input type="text" name="addr" maxlength="200" value=${user.addr}></td>
	</tr>
	</table>
	<button type="submit">修改</button>
	<button type="reset">重置</button>
	</form>
</body>
</html>