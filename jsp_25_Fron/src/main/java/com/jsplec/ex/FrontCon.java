package com.jsplec.ex;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		System.out.println("uri" + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath" + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command: " + command);
		
		if(command.equals("/chelsea.do")) {
			System.out.println("Chelssia");
		} else if(command.equals("/mancity.do")) {
			System.out.println("MANCITY");
		} else if(command.equals("/arsenal.do")) {
			System.out.println("dogsenal");
		} else if(command.equals("/manunited.do")) {
			System.out.println("mangunited");
	}
}
}
