/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.6
 * Generated at: 2023-06-26 23:25:27 UTC
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
import java.util.ArrayList;
import java.util.List;

public final class adminModify_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("kr.co.jspassign.MemberDTO");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>adminModify.jsp</title>\r\n");

	String sessionId = (String) session.getAttribute("sessionId");
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = MemberDAO.getInstance();
	List<MemberDTO> res = new ArrayList<MemberDTO>();
	res = dao.selectAll();

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>회원관리 페이지</h1>\r\n");
      out.write("<form action=\"logout.jsp\" method=\"post\">\r\n");
      out.write("	<input type=\"reset\" value=\"로그아웃\" onclick=\"javascript:window.location='logout.jsp'\">\r\n");
      out.write("</form>\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("	<col width=\"50\"><col width=\"100\"><col width=\"100\"><col width=\"100\">\r\n");
      out.write("	<col width=\"300\"><col width=\"150\"><col width=\"200\"><col width=\"50\"><col width=\"50\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>ID</th>\r\n");
      out.write("		<th>Name</th>\r\n");
      out.write("		<th>PW</th>\r\n");
      out.write("		<th>CP</th>\r\n");
      out.write("		<th>MAIL</th>\r\n");
      out.write("		<th>STATUS</th>\r\n");
      out.write("		<th>AUTHORITY</th>\r\n");
      out.write("		<th>회원정보수정</th>\r\n");
      out.write("		<th>회원정보삭제</th>\r\n");
      out.write("	</tr>\r\n");
	
	for(int i = 0; i<res.size(); i++){
		MemberDTO md = res.get(i);
		String marked = "010-XXXX-XXXX";

      out.write("\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>");
      out.print(md.getId() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(md.getName() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(md.getPw() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print( marked );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(md.getMail() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(md.getStatus() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(md.getAuthority() );
      out.write("</td>\r\n");
      out.write("		<td><input type=\"button\" value=\"정보수정\" onclick=\"javascript:window.location='adminModifyOk.jsp?id=");
      out.print(md.getId());
      out.write("'\"></td>\r\n");
      out.write("		<td><input type=\"button\" value=\"삭제\" onclick=\"javascript:window.location='adminDeleteOk.jsp?id=");
      out.print(md.getId());
      out.write("'\"></td>\r\n");
      out.write("	</tr>	\r\n");

	}

      out.write("\r\n");
      out.write("</table>\r\n");
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
