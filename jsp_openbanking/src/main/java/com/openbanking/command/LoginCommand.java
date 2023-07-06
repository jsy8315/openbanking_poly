package com.openbanking.command;

import com.openbanking.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("id");
		String mPw = request.getParameter("pw");
		
		MemberDao memberdao = new MemberDao();
		memberdao.login(mId, mPw); //ri return 받음
		
	}
 
}
