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

import model.Advogado;
import model.RegistroOAB;
import utils.ConverteTexto;

@WebServlet("/adicionaAdvogado")
public class AdicionaAdvogadoServlet extends HttpServlet {
	
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
            } catch (ParseException e) {
                out.println("Formato de data incorreto");
                return; //para a execu��o do m�todo
            }
            
            RegistroOAB registroOAB = ConverteTexto.textoParaRegistroOAB(ufRegistroOAB , 
            		registroOABEmTexto) ;
            //objeto registro OAB tem n�mero
            //qual a UF correspondente 
            //e se � de estagi�rio
            
            //TODO : verificar se registro duplicado
            //TODO : adicionar confirma��o por email
            //TODO : a outra entidade que poderia ter no banco de dados � o escrit�rio
            // monta um objeto Advogado
             //tem que ter alguns par�metros obrigat�rios
//            A - Inscri��o Suplementar
//            B - Inscri��o por Transfer�ncia
//            E - Inscri��o de Estagi�rio
//            N - Inscri��o de Provisionado
//            P - Inscri��o Provis�ria.
            //se n�o tiver, considerar letra D
            Advogado advogado = new Advogado();
            advogado.setRegistroOAB(registroOAB);
            advogado.setNome(nome);
            advogado.setTelefone(telefone);
            advogado.setEmail(email);
            advogado.setDataNascimento(dataNascimento);
            
            //salva o registro
            //AdvogadoDao dao = new AdvogadoDao();
            //dao.inserir(advogado);
            
            // imprime o nome do contato que foi adicionado
            out.println("<html>");
            out.println("<body>");
            out.println("Advogado " + advogado.getNome() +
                    " adicionado com sucesso");
            out.println("</body>");
            out.println("</html>");
            

		}
}