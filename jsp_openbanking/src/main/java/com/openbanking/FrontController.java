package com.openbanking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.openbanking.command.Command;
import com.openbanking.command.JoinCommand;
import com.openbanking.command.ListCommand;
import com.openbanking.command.LoginCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		/*일단 viewPage선언하고, 나중에 do에 따라 다른 page선택*/
		Command command = null;
		
		System.out.println("모디(초코)파이01(먹고싶다)");
		//확인을 위한 sysout
		
		String uri = request.getRequestURI();
		//uri = contextPath + 요청한 파일 이름
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		//conPath만큼 자르고, 프론트컨트롤러를 사용하기 위한 과정
		//command = uri - contextPath 길이만큼 빼면 요청한 파일 이름만 남는다

		//커맨드 패턴을 활용하여, 해당 클래스가 처리하도록함

		if(com.equals("/list.do")) {
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/join.do")) {
			command = new JoinCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/login.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = "loginCheck.do";
		} else if(com.equals("/loginCheck.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = "loginResult.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		/*포워딩을 사용하여 dispatcher 객체에 실어서 보냄*/
		dispatcher.forward(request, response);
	}
}
