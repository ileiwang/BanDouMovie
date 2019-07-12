<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>团购列表</title>
</head>
<body>

<c:choose>

	<c:when test="${fn:length(groupbuyList)==0}">
		<h1>暂无团购</h1>
	</c:when>

	<c:otherwise>
		<c:forEach items="${groupbuyList}" var="groupbuy">
			<dd>
				<a href="${pageContext.request.contextPath}/findGroupbuyByGid.do?gid=${groupbuy.gid}">查看</a>
			</dd>
			
			<dd>
				<a href="${pageContext.request.contextPath}/joinGroupbuy.do?gid=${groupbuy.gid}">加入</a>
			</dd>
				
			<dd>
				创建时间： <fmt:formatDate value="${groupbuy.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</dd>
				
			<dd>
				团购人数：${fn:length(groupbuy.userList)}
			</dd>
				团购成员
			<c:forEach items="${groupbuy.userList}" var="user">
				<dd>
					<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${user.uid}">${user.username}</a>
				</dd>
			</c:forEach>
								
			<br>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>