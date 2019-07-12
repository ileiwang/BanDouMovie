<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/admin/adminLogin.do">
		<table>
			<tbody>
				<tr>
					<th>用户名</th>
					<td>
						<input type="text" id="username" name="username" maxlength="20">
					</td>
				</tr>
				<tr>
					<th>密&nbsp;&nbsp;码:</th>
					<td><input type="password" id="password" name="password" maxlength="20" autocomplete="off"></td>
				</tr>
				<tr>
			</tbody>
		</table>
		<button type="submit">登录</button>
	</form>
</body>
</html>