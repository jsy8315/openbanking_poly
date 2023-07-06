<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.co.jsplec.ex02.MemberDAO" %>
<%@ page import="kr.co.jsplec.ex02.MemberDTO" %>

<%
	request.setCharacterEncoding("EUC-KR");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw);
	if(checkNum == -1) {
%>
	<script language="javascript">
		alert("���̵� �������� �ʽ��ϴ�.")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 0) {
%>
	<script language="javascript">
		alert("��й�ȣ�� Ʋ���ϴ�")
		history.go(-1);
	</script>
<%
	} else if(checkNum == 1) {
		MemberDTO dto = dao.getMember(id);
		
		if(dto == null) {
%>
	<script language="javascript">
		alert("�������� �ʴ� ȸ���Դϴ�.")
		history.go(-1);
	</script>
<%
		}else {
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>