<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类列表</title>
</head>
<body>
<c:choose>

	<c:when test="${fn:length(categoryList)==0}">
		<h1>暂无分类</h1>
	</c:when>

	<c:otherwise>
		<c:forEach var="category" items="${categoryList}">
			<dl>
				<dt>
					<a href="${pageContext.request.contextPath}/findCategoryByCid.do?cid=${category.cid}"><h3>${category.cname}</h3></a>
				</dt>
				<dt>
					<a href="${pageContext.request.contextPath}/admin/editCategory.do?cid=${category.cid}"><h5>修改</h5></a>
				</dt>
				<dt>
					<a href="${pageContext.request.contextPath}/admin/deleteCategory.do?cid=${category.cid}"><h5>删除</h5></a>
				</dt>
			</dl>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>


</body>
</html>