<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改评论信息</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/admin/updateRemark.do">
	<table>
	<input type="hidden" name="rid" value=${remark.rid}>
	<input type="hidden" name="uid" value=${remark.uid}>
	<input type="hidden" name="mid" value=${remark.mid}>
	
	<tr>
		<th>内容</th>
		<td><textarea type="text" name="content" maxlength="200">${remark.content}</textarea></td>
	</tr>
	</table>
	<button type="submit">修改</button>
	<button type="reset">重置</button>
</form>
</body>
</html>