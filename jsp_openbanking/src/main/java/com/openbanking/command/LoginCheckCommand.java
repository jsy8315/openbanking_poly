package com.openbanking.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String checkRi = request.getParameter("ri");
		
	}

}
