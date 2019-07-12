<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
function checkUsername() {
	
	var username = document.getElementById("username").value;

	var xmlHttp = creatXMLHttpreauest();
	xmlHttp.open("GET",
			"${pageContext.request.contextPath}/loginCheckUsername.do?username="
					+ username, true);
	xmlHttp.send(null); 
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			document.getElementById("span1").innerHTML = xmlHttp.responseText;
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
<form method="post" action="${pageContext.request.contextPath}/userLogin.do">
	<table>
		<tbody>
			<tr>
				<th>用户名</th>
				<td>
					<input type="text" id="username" name="username"
					class="text" maxlength="20"  onblur="checkUsername()">
					<span id="span1" style="color:green;"></span>
				</td>
			</tr>
			<tr>
				<th>密&nbsp;&nbsp;码:</th>
				<td><input type="password" id="password" name="password" maxlength="20" autocomplete="off"></td>
			</tr>
			<tr>
				<th>验证码:</th>
				<td>
					<input type="text" name="checkImg" maxlength="4" autocomplete="off">
					<img id="checkImg" src="${pageContext.request.contextPath}/checkImg.do" title="点击更换验证码" onclick="change()"> 
				</td>
			</tr>
			<tr>
		</tbody>
	</table>
	<button type="submit">登录</button>
</form>

</body>
</html>