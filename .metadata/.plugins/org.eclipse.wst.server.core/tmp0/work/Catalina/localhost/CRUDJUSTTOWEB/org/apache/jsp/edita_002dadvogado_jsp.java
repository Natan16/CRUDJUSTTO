/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.96
 * Generated at: 2019-09-06 20:23:02 UTC
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
import dao.*;
import model.*;

public final class edita_002dadvogado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<link href=\"Estilo.css\" rel=\"stylesheet\" media=\"all\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("     <body>\r\n");
      out.write("     \r\n");
      out.write("     \t<form action=\"index.html\" method=\"post\" style=\"float:left;\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"INÍCIO\" >\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"consulta-advogado.jsp\" method=\"post\" style=\"float:right;\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"BUSCAR ADVOGADO\" >\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("          CADASTRO DE ADVOGADOS <br />\r\n");
      out.write("           ");
      out.write("\r\n");
      out.write("      \t");
      model.Advogado advogado = null;
      advogado = (model.Advogado) _jspx_page_context.getAttribute("advogado", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (advogado == null){
        advogado = new model.Advogado();
        _jspx_page_context.setAttribute("advogado", advogado, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("      \t\r\n");
      out.write("      \t<form action=\"editaAdvogado\">\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\t Nome:<br /> <input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  required/><br /> \r\n");
      out.write("         \t E-mail:<br /> <input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" required/><br />\r\n");
      out.write("             Telefone:<br /> <input type=\"text\" name=\"telefone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.telefone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/><br />\r\n");
      out.write("             Data Nascimento:<br /> <input type=\"text\" name=\"dataNascimento\" placeholder=\"dd/MM/aaaa\"/><br />\r\n");
      out.write("             Senha Antiga:<br /> <input type=\"password\" name=\"senha\" placeholder=\"***********\" required/><br />\r\n");
      out.write("             Senha Nova:<br /> <input type=\"password\" name=\"nova_senha\" placeholder=\"***********\"/><br />\r\n");
      out.write("            \r\n");
      out.write("             \r\n");
      out.write("                       &emsp; UF &nbsp;&emsp;&emsp;&emsp;&emsp; Registro OAB <br />\r\n");
      out.write("             <select name=\"ufOAB\">\r\n");
      out.write("           \t\t<option selected>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.ufOAB}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("             \t");
	
             	List<String> ufs = Listagens.getUfs();
			 	for (String uf : ufs ) {
                
      out.write("\r\n");
      out.write("                \t<option value=");
      out.print(uf );
      out.write('>');
      out.print(uf);
      out.write("</option>\r\n");
      out.write("                ");

                }
                
      out.write(" \r\n");
      out.write("  \t\t\t </select>\r\n");
      out.write("  \t\t\t <input type=\"text\" name=\"registroOAB\" value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.registroOAB}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/><br />\r\n");
      out.write("  \t\t\t <br />\r\n");
      out.write("\t\t\t \r\n");
      out.write("             Descrição: <br />\r\n");
      out.write("             <textarea rows = \"5\" cols = \"60\" name = \"desc\"  value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.descricao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></textarea><br> \r\n");
      out.write("             <input   type=\"submit\" value=\"Atualizar\" />\r\n");
      out.write("         </form>\r\n");
      out.write("        \r\n");
      out.write("     </body>\r\n");
      out.write(" </html>\r\n");
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
