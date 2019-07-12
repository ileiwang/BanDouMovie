<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${movie.name}</title>
</head>
<body>

	<dd>
		<a href="${pageContext.request.contextPath}/findMovieByMid.do?mid=${movie.mid}">${movie.name}</a>
	</dd>
	<br>
	<dd>地区：${movie.region}</dd>
	<br>
	<dd>
		<image src="images/${movie.image}" width="50" height="50"></image>
	</dd>
	<br>
	<dd>
		加入时间：<fmt:formatDate value="${movie.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</dd>
	<br>
	<dd>
		简介：${movie.mdesc}
	</dd>

<hr>

<button><a href="${pageContext.request.contextPath}/createGroupbuy.do?mid=${movie.mid}">创建团购</a></button>
<button><a href="${pageContext.request.contextPath}/createGroupbuy.do?mid=${movie.mid}">看过</a></button>
<hr>

<h3>看过的人</h3>

<c:choose>
	<c:when test="${userflag==0}">
		<h3>暂时无看过的用户</h3>
	</c:when>
	<c:otherwise>
		<c:forEach items="${userList}" var="user">
			<dd>
				<a href="${pageContext.request.contextPath}/findUserByUid.do?uid=${user.uid}">${user.username}</a>
			</dd>
			
				
			<dd>
				${user.email}
			</dd>
				
			<dd>
				${user.phone}
			</dd>
				
			<dd>
				${user.addr}
			</dd>					
			<br>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>

<h3>评论信息</h3>

<c:choose>

	<c:when test="${remarkflag==0}">
		<h3>暂无评论信息</h3>
	</c:when>
	
	<c:otherwise>
		<c:forEach items="${remarkList}" var="remark">
			<dd>
			评论者：
				<a href="${pageContext.request.contextPath}/findRemarkByRid.do?rid=${remark.rid}">${remark.user.username}</a>
			</dd>
				
			<dd>
				评论内容：${remark.content}
			</dd>
				
			<dd>
				评论时间： <fmt:formatDate value="${remark.remarkdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</dd>
								
			<br>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>
<h3>我要评论</h3>
<form method="post" action="${pageContext.request.contextPath}/saveReamrk.do">
<input type="hidden" name="mid" value=${movie.mid}>
	<table>
	<tr>
		<th>评论内容</th>
		<td><input type="text" name="content"></td>
	</tr>
	</table>
	<button type="submit">修改</button>
	<button type="reset">重置</button>
</form>

<h3>团购信息</h3>
<c:choose>

	<c:when test="${groupbuyflag==0}">
		<h3>暂无团购信息</h3>
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
								
			<br>
			<hr>
		</c:forEach>
	</c:otherwise>
</c:choose>



</body>
</html>