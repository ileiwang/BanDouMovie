<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div>
		<ul>
			<c:choose>
				<c:when test="${userLogin==null}">
					<li>
						<a href="${pageContext.request.contextPath}/login.do">用户登录</a>|
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/register.do">用户注册</a>|
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/remarkList.do?page=1">评论</a>|
					</li>
				</c:when>
				
				<c:otherwise>
				
					<li>
						${userLogin.username}
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/findMovieByUid.do?uid=${userLogin.uid}">我的电影</a>|
					</li>
					
				    <li>
						<a href="${pageContext.request.contextPath}/myRemarkList.do">我的评论</a>|
				    </li>
				    
				    <div>
						<a href="${pageContext.request.contextPath}/myGroupbuy.do">我的团购</a>
					</div>
					
					<li>
						<a href="${pageContext.request.contextPath}/userLogout.do">退出</a>|
					</li>
					
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${adminLogin==null}">
					<li>
						<a href="${pageContext.request.contextPath}/admin/login.do">管理员登录</a>|
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/findAllMovie.do">电影列表</a>|
					</li>
				</c:when>
				
				<c:otherwise>
				
					<li>
						${adminLogin.username}
					</li>
					
					
				    <li>
						<a href="${pageContext.request.contextPath}/admin/index.do">后台管理</a>|
				    </li>

					<li>
						<a href="${pageContext.request.contextPath}/admin/adminLogout.do">退出</a>|
					</li>
					
				</c:otherwise>
			</c:choose>
			
			
		</ul>
	</div>
	
	<div>
		<form method="post" action="${pageContext.request.contextPath}/searchMovie.do" >
                <input type="text" value="请输入关键词" onfocus="this.value = '';"
                onblur="if (this.value == '') {this.value = '请输入关键词';}">
                <input type="submit" value="搜索">
        </form>
	</div>
</div>

<div>
	<ul>
		<li><a href="${pageContext.request.contextPath}/index.do">首页</a> |</li>
		<c:forEach var="category" items="${categoryList}">
			<li><a href="${pageContext.request.contextPath}/findCategoryByCid.do?cid=${category.cid}">${category.cname}</a> |</li>
		</c:forEach>
	</ul>
</div>