package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdvogadoDao;
import model.Advogado;
import utils.ConverteTexto;

@WebServlet("/excluiAdvogado")
public class ExcluiAdvogadoServlet extends HttpServlet {
	
		public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        log("Iniciando a servlet");
	    }
	
	    public void destroy() {
	        super.destroy();
	        log("Destruindo a servlet");
	    }
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			// buscando os par�metros no request
			//HttpServletRequest req = (HttpServletRequest) request;
			//String path = req.getRequestURI().substring(request.getContextPath().length());
            //TODO : pra n�o precisar criar um advogado aqui, seria melhor usar fa�ade
			String ufOAB = request.getParameter("ufOAB");    
            String registroOAB = request.getParameter("registroOAB");
            Advogado advogado = new Advogado();
            advogado.criarRegistroOAB(ufOAB, registroOAB);
            
            AdvogadoDao dao = new AdvogadoDao();
            dao.excluir(advogado);

            
            response.sendRedirect("http://localhost:8080/CRUDJUSTTOWEB/consulta-advogado.jsp");
            

		}
}
