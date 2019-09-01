
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdvogadoDao;
import model.Advogado;
import model.RegistroOAB;
import utils.ConverteTexto;

@WebServlet("/adicionaAdvogado")
public class AdicionaAdvogadoServlet extends HttpServlet {
	    /**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		//URLBuilder urlb = new URLBuilder("www.example.com");
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
            String nome = request.getParameter("nome");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String dataEmTexto = request.getParameter("dataNascimento");
            String senha = request.getParameter("senha");
            String ufRegistroOAB = request.getParameter("ufOAB");
            String registroOABEmTexto = request.getParameter("registroOAB");
            String descricao = request.getParameter("desc");
            
            
            Calendar dataNascimento = null;
            
            
            //suporte.email@oabsp.org.br
            //Em caso de qualquer erro no preenchimento, deixar em vermelho
            //o que est� errado, falor o que est� errado e requisitar denovo
            //fazendo a convers�o da data
            try {
                
            	Date date = ConverteTexto.textoParaData(dataEmTexto);
            	System.out.println(date.toString());
                dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(date);
                
            } catch (ParseException e) {
                out.println("Formato de data incorreto");
                return; 
            }
            
           
            //TODO : verificar se registro duplicado
            //TODO : adicionar confirma��o por email
            //TODO : a outra entidade que poderia ter no banco de dados � o escrit�rio
            //monta uma URL com os parametros que j� tinha 
            //e indicando qual est� no padr�o errado
            //response.sendRedirect("http://localhost:8080/CRUDJUSTTOWEB/adiciona-advogado.jsp");
            
    
            // monta um objeto Advogado
            
            Advogado advogado = new Advogado(senha);
            if (RegistroOAB.registroValido(registroOABEmTexto)) {
            	
           
            } else {
            	//j� adiciona na lista de par�metros inadequados
            	
            }
            
            try {
            	advogado.criarRegistroOAB(ufRegistroOAB ,registroOABEmTexto);
            	advogado.setNome(nome);
                advogado.setTelefone(telefone);
                advogado.setEmail(email);
                advogado.setDataNascimento(dataNascimento);
                advogado.setDesc(descricao);
            } catch(CadastroInvalidoException e) {
            	out.println("Preenchimento Incorreto :" + e);
                return; 
            }
            
            
            //salva o registro
            AdvogadoDao dao = new AdvogadoDao();
            dao.inserir(advogado);
            
            
            
            // imprime o nome do advogado que foi adicionado
//            out.println("<html>");
//            out.println("<body>");
//            out.println("Advogado " + advogado.getNome() +
//                    " adicionado com sucesso");
//            out.println("</body>");
//            out.println("</html>");
            
            response.sendRedirect("http://localhost:8080/CRUDJUSTTOWEB/consulta-advogado.jsp?nome =" + advogado.getNome());
            

		}
}
