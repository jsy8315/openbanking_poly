/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.6
 * Generated at: 2023-06-26 08:50:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import kr.co.jspassign.MemberDAO;
import kr.co.jspassign.MemberDTO;

public final class loginOk_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.co.jspassign.MemberDAO");
    _jspx_imports_classes.add("kr.co.jspassign.MemberDTO");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String authority = request.getParameter("authority");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw); //로그인 확인
	int authcheckNum = dao.authorityCheck(id); //관리자, 사용자 확인
	
	if(checkNum == -1) {

      out.write("\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("		alert(\"아이디가 존재하지 않습니다.\")\r\n");
      out.write("		history.go(-1);\r\n");
      out.write("	</script>\r\n");

	} else if(checkNum == 0) {

      out.write("\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("		alert(\"비밀번호가 틀립니다\")\r\n");
      out.write("		history.go(-1);\r\n");
      out.write("	</script>\r\n");

	} else if(checkNum == 2) {

      out.write("\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("		alert(\"회원님의 계정이 일시정지 상태입니다. 관리자에게 문의하세요.\")\r\n");
      out.write("		history.go(-1);\r\n");
      out.write("	</script>\r\n");

	} else if(checkNum == 3) {

      out.write("\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("		alert(\"회원님의 계정이 아직 승인되지 않았습니다. 승인은 관리자맘입니다. 메롱\")\r\n");
      out.write("		history.go(-1);\r\n");
      out.write("	</script>\r\n");

	} else if(checkNum == 1) {
		MemberDTO dto = dao.getMember(id);
		
		if(dto == null) {

      out.write("\r\n");
      out.write("	<script language=\"javascript\">\r\n");
      out.write("		alert(\"존재하지 않는 회원입니다.\")\r\n");
      out.write("		history.go(-1);\r\n");
      out.write("	</script>\r\n");

		} else {
			
			if(authcheckNum == 1) {

      out.write("\r\n");
      out.write("			<script language=\"javascript\">\r\n");
      out.write("				alert(\"관리자입니다.\")\r\n");
      out.write("			</script>\r\n");
				
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("adminMain.jsp");
			} else if(authcheckNum == 0){

      out.write("\r\n");
      out.write("				<script language=\"javascript\">\r\n");
      out.write("					alert(\"일반사용자입니다.\")\r\n");
      out.write("				</script>\r\n");

			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("userMain.jsp");
			} else {

      out.write("\r\n");
      out.write("				<script language=\"javascript\">\r\n");
      out.write("					alert(\"아이디가 존재하지 않습니다.\")\r\n");
      out.write("					history.go(-1);\r\n");
      out.write("				</script>\r\n");

				}
			}
		}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>loginOk.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
