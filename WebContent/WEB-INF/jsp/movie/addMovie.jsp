<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加电影</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/saveMovie.do"
		method="post" enctype="multipart/form-data">
		
		<table>
			
			<tr>
				<td>
					电影名：</td>
				<td>
					<input type="text" name="name"/>
				</td>

			</tr>
			
			<tr>
				<td>
					地区：
				</td>
				<td>
					<input type="text" name="region"/>
				</td>

			</tr>
			
			<tr>
				<td>
					电影图片：</td>
				<td>
				<input type="file" name="file" /></td>
			</tr>
			
			<tr>
				<td>
					所属分类：</td>
				<td colspan="3">
					<select name="cid">
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.cid}">${category.cname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					电影描述：	
				</td>
				<td>
					<textarea name="mdesc" rows="5" cols="30"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit"  value="确定">添加</button>
					<button type="reset" value="重置">重置</button>

				</td>
			</tr>
		</table>
	</form>
</body>
</html>