package frontController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Command.Command;
import Command.InsertUserCommand;
import Command.loginCommand;
import Command.MainCommand;
import Command.joinInputCommand;
import Command.loginInputCommand;

/**
 * Servlet implementation class frontController
 */

@WebServlet("*.bank")
public class frontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        actionDo(request, response);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        actionDo(request, response);
    }

    private void actionDo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = uri.substring(contextPath.length());
        // Command 객체 생성
        Command Command = null;
        System.out.println(command);
        if (command.equals("/join.bank")) {
            Command = new InsertUserCommand();
        } else if (command.equals("/main.bank")) {
            Command = new MainCommand();
        } else if (command.equals("/joinInput.bank")) {
            Command = new joinInputCommand();
        }
        else if (command.equals("/loginInput.bank")) {
            Command = new loginInputCommand();
        }
          else if (command.equals("/login.bank")) {
            Command = new loginCommand();
        } else {
            System.out.println("유효하지 않은 커맨드입니다.");
        }

        // Command 실행
        if (Command != null) {  
            Command.execute(request, response);
            String viewPage = Command.getViewPage();
            request.getRequestDispatcher(viewPage).forward(request, response); // 뷰 페이지로 포워딩

        } else {
            // 유효하지 않은 command 처리에 대한 예외 처리
            // 예: response.sendRedirect("error.jsp");
        }
    }
}

