<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/admin/saveCategory.do">
		<table>
		<tr>
			<th>分类名</th>
			<td><input type="text" name="cname"></td>
		</tr>
		</table>
		<button type="submit">修改</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>