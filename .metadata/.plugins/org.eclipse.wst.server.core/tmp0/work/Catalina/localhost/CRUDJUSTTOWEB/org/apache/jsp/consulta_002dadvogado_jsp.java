/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.96
 * Generated at: 2019-09-01 00:37:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Listagens;
import java.util.List;
import dao.AdvogadoDao;
import model.RegistroOAB;
import model.Advogado;

public final class consulta_002dadvogado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <body>\r\n");
      out.write("    \t<form action=\"index.html\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"INÍCIO\" >\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"adiciona-advogado.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"CADASTRAR ADVOGADO\" >\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("    \t<form action=\"consulta-advogado.jsp\" method=\"get\">\r\n");
      out.write("    \t\t<input type=\"text\" name=\"filtro\" >\r\n");
      out.write("    \t\t<input type=\"image\" src=\"images/search_icon.png\"  width=\"20\" height=\"20\" value=\"\" >\r\n");
      out.write("        <br />\r\n");
      out.write("        </form>\r\n");
      out.write("        <table>\r\n");
      out.write("            ");

            AdvogadoDao dao = new AdvogadoDao();
            List<Advogado> advogados = dao.listarTodos();

            for (Advogado advogado : advogados ) {
            	//só os que se encaixam no filtro
            	if(true){
            
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print(advogado.getNome() );
      out.write("</td> \r\n");
      out.write("                    <td>");
      out.print(advogado.getEmail() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(advogado.getTelefone() );
      out.write("</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                    \t<form action=\"edita-advogado.jsp\" method=\"get\">\r\n");
      out.write("               \t\t\t\t<input type=\"hidden\" name=\"nome\" value=");
      out.print(advogado.getNome());
      out.write(" />\r\n");
      out.write("        \t\t\t\t\t<input type=\"hidden\" name=\"email\" value=");
      out.print(advogado.getEmail());
      out.write(" />\r\n");
      out.write("        \t\t\t\t\t<input type=\"hidden\" name=\"telefone\" value=");
      out.print(advogado.getTelefone());
      out.write(" />\r\n");
      out.write("        \t\t\t\t\t<input type=\"hidden\" name=\"descricao\" value=");
      out.print(advogado.getDesc());
      out.write(" />\r\n");
      out.write("               \r\n");
      out.write("    \t\t\t\t\t\t<input type=\"hidden\" name=\"ufOAB\" value=");
      out.print(advogado.getRegistroOAB().getUF());
      out.write(" />\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"hidden\" name=\"registroOAB\" value=");
      out.print(advogado.getRegistroOAB().getNumero());
      out.write(" />\r\n");
      out.write("    \t\t\t\t\t\t\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"image\" src=\"images/edit_icon.png\"  width=\"20\" height=\"20\" value=\"\" >\r\n");
      out.write("        \t\t\t\t</form>\r\n");
      out.write("        \t\t\t\t\r\n");
      out.write("        \t\t\t\t<form action=\"excluiAdvogado\" method=\"get\">\r\n");
      out.write("        \t\t\t\t\t        \t\t\t\t    <input type=\"hidden\" name=\"ufOAB\" value=");
      out.print(advogado.getRegistroOAB().getUF());
      out.write(" />\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"hidden\" name=\"registroOAB\" value=");
      out.print(advogado.getRegistroOAB().getNumero());
      out.write(" />\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"image\" src=\"images/delete_icon.png\"  width=\"20\" height=\"20\" value=\"\" >\r\n");
      out.write("        \t\t\t\t</form>\r\n");
      out.write("        \t\t\t</td>                  \r\n");
      out.write("                </tr>\r\n");
      out.write("                                  \r\n");
      out.write("            ");

            	}
            }
            
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
