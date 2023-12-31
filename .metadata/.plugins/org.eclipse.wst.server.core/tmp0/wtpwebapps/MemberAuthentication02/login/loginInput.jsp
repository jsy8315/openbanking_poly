<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %> 
<title>Login</title>
<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f2f2f2;
	}
h1 {
	text-align: center;
}

form {
	width: 300px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
}

table td {
	padding: 5px;
}

input[type="text"],
input[type="password"] {
	width: 90%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	width: 100%;
	padding: 8px;
	border: none;
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
	border-radius: 4px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<form action="login.bank" method="post">
		<h1>로그인</h1>
		<hr>
		<table>
			<tr>
				<td><b>아이디 : </b></td>
				<td><input type="text" name="id" placeholder="아이디" required></td>
			</tr>
			<tr>
				<td><b>비밀번호 : </b></td>
				<td><input type="password" name="password" placeholder="비밀번호" required></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
		  	<%
    			String clientId = "OeudOcIy6D5r8PXWPnVA";//애플리케이션 클라이언트 아이디값";
    			String redirectURI = URLEncoder.encode("http://192.168.123.2:8080/MemberAuthentication/naverLoginCallback.jsp", "UTF-8");
    			SecureRandom random = new SecureRandom();
    			String state = new BigInteger(130, random).toString();
    			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    			apiURL += "&client_id=" + clientId;
    			apiURL += "&redirect_uri=" + redirectURI;
    			apiURL += "&state=" + state;
    			session.setAttribute("state", state);
 		  	%>
 		  <a href="<%=apiURL%>"><img height="30" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
	</form>
</body>
</html>