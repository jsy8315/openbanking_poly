<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http=equiv="Content-Type" content="text/html; charset=UTF-8">
<title>join.jsp</title>
<script language="JavaScript" src="members.js"></script>
</head>
<body>
<h1>회원가입</h1>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디&nbsp;<input type="text" name="id" size="20"><br />
		이름&nbsp;<input type="text" name="name" size="10"><br>
		비밀번호&nbsp;<input type="password" name="pw" size="20"><br />
		비밀번호 확인&nbsp;<input type="password" name="pw_check" size="20"><br />
		전화번호&nbsp;<input type="text" name="cp" size="20"><br>
		이메일&nbsp;<input type="text" name="mail" size="50"><br>
		<input type="button" value="회원가입" onclick="infoConfirm()">
			<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">		
	</form>	
</body>
</html>