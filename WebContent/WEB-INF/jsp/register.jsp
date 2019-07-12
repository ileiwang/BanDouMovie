<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<script type="text/javascript">

	function checkForm() {
		
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		var checkImage = document.getElementById("checkImage").value;
		if (username == null || username == '') {
			alert("用户名不能为空");
			return false;
		}
		if (password == null || password == '') {
			alert("密码不能为空");
			return false;
		}
		if (repassword == null || repassword == '' || repassword != password) {
			alert("确认密码不能为空，或者两次密码不一样");
			return false;
		}
		
		if (checkImage == null || checkImage == '') {
			alert("验证码不能为空");
			return false;
		}

		return true;
	}
	
	function checkUsername() {
		var username = document.getElementById("username").value;
		var xmlHttp = creatXMLHttpreauest();
		xmlHttp.open("GET",
				"${pageContext.request.contextPath}/registerCheckUsername.do?username="+ username, true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				document.getElementById("span").innerHTML = xmlHttp.responseText;
			}
		}
	}
	function creatXMLHttpreauest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return ActiveXObject("Msxml2.XMLHttp");
			} catch (e) {
				try {
					return ActiveXObject("micoresoftxml2.XMLHttp");
				} catch (e) {
					throw e;
				}
			}
		}
	}
	function change(){
		var img = document.getElementById("checkImg");
		img.src="${pageContext.request.contextPath}/checkImg.do?"+new Date();
	}
</script>
</head>
<body>
<%-- 	<div>
		<%@ include file="menu.jsp"%>
	</div> --%>
	
<%-- 	<c:if test="${errors!=null}">
		<c:forEach items="${errors}" var="error">
			${error}
		</c:forEach>
	</c:if> --%>
	
<%-- 	<c:if test="${message!=null}">
			${message}
	</c:if> --%>
	<form method="post" action="${pageContext.request.contextPath}/registerUser.do" onsubmit="checkForm()">
		<table>
			<tbody>
				<tr>
					<th>用户名:</th>
					<td>
						<input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()">
						<span id="span" style="color:green;"></span>
					</td>
				</tr>
				
				<tr>
					<th>密&nbsp;&nbsp;码:</th>
					<td><input type="password" id="password" name="password" maxlength="20" autocomplete="off"></td>
				</tr>
				
				<tr>
					<th>确认密码:</th>
					<td><input type="password" id="repassword" name="repassword" maxlength="20" autocomplete="off"></td>
				</tr>
				
				<tr>
					<th>E-mail:</th>
					<td><input type="text" name="email" maxlength="200"></td>
				</tr>
				
				<tr>
					<th>姓名:</th>
					<td><input type="text" name="uname" maxlength="200"></td>
				</tr>
				
				<tr>
					<th>电话:</th>
					<td><input type="text" name="phone" ></td>
				</tr>

				<tr>
					<th>地址:</th>
					<td><input type="text" name="addr" maxlength="200"></td>
				</tr>
				
				<tr>
					<th>验证码:</th>
					<td>
						<input type="text" id="checkImage" name="checkImg" maxlength="4" autocomplete="off">
						<img id="checkImg" src="${pageContext.request.contextPath}/checkImg.do" title="点击更换验证码" onclick="change()">
					</td>
				</tr>

			</tbody>
		</table>
		
		<button type="submit">注册</button>
		
		<div>
			<dl>
				<dt>已经拥有账号了？</dt>
				<dd>
					<a href="${pageContext.request.contextPath}/login.do">立即登录</a>
				</dd>
			</dl>
		</div>
		
	</form>		
</body>
</html>