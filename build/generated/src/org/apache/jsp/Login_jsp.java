package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/MenuBar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/form.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/menuBar.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("      \n");
      out.write("            <div class=\"preheader\"></div>\n");
      out.write("<!--            <input type=\"hidden\">-->\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <a  id=\"Home\" href=\"Home\">Home</a>\n");
      out.write("                <a  id=\"takeQuiz\"  href=\"takeQuiz\">Take Quiz</a>\n");
      out.write("                <a  id=\"makeQuiz\" href=\"makeQuiz\">Make Quiz</a>\n");
      out.write("                <a  id=\"manageQuiz\"  href=\"manageQuiz\" >Manage Quiz</a>\n");
      out.write("                <a  id=\"logOut\" class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type==null?\"hidden\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" href=\"Login\">Log Out</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                <div class=\"body\">\n");
      out.write("                    <div class=\"title\">Login Form</div>\n");
      out.write("                    <form action=\"Login\" method=\"POST\">\n");
      out.write("                        <div class=\"question\">\n");
      out.write("                            <div class=\"item1\">User Name:</div>\n");
      out.write("                            <div class=\"item2\"><input name=\"userName\" required></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"question\">\n");
      out.write("                            <div class=\"item1\">Password :</div>\n");
      out.write("                            <div class=\"item2\"><input type=\"password\" name=\"pass\" required></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"question\">\n");
      out.write("                            <div class=\"item1\"></div>\n");
      out.write("                            <div class=\"item2\"> <button class=\"button\" type=\"submit\">Sign In</button>\n");
      out.write("                                <a class=\"item2\" href=\"register\">Register</a></div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    <div><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${err}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
