<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="loginOk.jsp">
		<jsp:param name="id" value="tester"/>
		<jsp:param name="passwd" value="1234"/>
	</jsp:forward>
</body>
</html>