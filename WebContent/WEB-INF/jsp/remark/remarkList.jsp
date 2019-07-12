<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论列表</title>
</head>
<body>
<c:choose>
	<c:when test="${fn:length(remarkList)==0}">
		<h1>暂无评论</h1>
	</c:when>

	<c:otherwise>
		<c:forEach var="remark" items="${remarkList}">
			<dl>
				
				<dd>
					评论内容：${remark.content}
				</dd>
				
				<dd>
					${remark.remarkdate}
				<dd/>
				
				<dd>
					<image src="images/${remark.movie.image}" width="100" height="100"></image>
				</dd>
				
		
				<dd>
					<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${remark.movie.mid}">${remark.movie.name}</a>
				</dd>
				
				<dd>
					<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${remark.user.uid}">${remark.user.username}</a>
				</dd>
				
				<c:if test="${sessionScope.adminLogin!=null}">
					<dd>
						<a href="${pageContext.request.contextPath}/admin/editRemark.do?rid=${remark.rid}">修改</a>
					<dd/>
					
					<dd>
						<a href="${pageContext.request.contextPath}/admin/deleteRemarkByRid.do?rid=${remark.rid}">删除</a>
					<dd/>
				</c:if>
			</dl>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>


</body>
</html>