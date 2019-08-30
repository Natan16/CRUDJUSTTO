package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Advogado;

import java.text.ParseException;

@WebServlet("/adicionaAdvogado")
public class AdicionaAdvogadoServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			
			// buscando os par�metros no request
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            String dataEmTexto = request.getParameter("dataNascimento");
            Calendar dataNascimento = null;

            // fazendo a convers�o da data
//            try {
//                Date date =
//                        new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
//                dataNascimento = Calendar.getInstance();
//                dataNascimento.setTime(date);
//            } catch (ParseException e) {
//                out.println("Erro de convers�o da data");
//                return; //para a execu��o do m�todo
//            }

            // monta um objeto Advogado
            Advogado advogado = new Advogado();
            advogado.setNome(nome);
            advogado.setEndereco(endereco);
            advogado.setEmail(email);
            advogado.setDataNascimento(dataNascimento);

            //salva o registro
//            AdvogadoDao dao = new AdvogadoDao();
//            dao.adiciona(contato);
            
            // imprime o nome do contato que foi adicionado
            out.println("<html>");
            out.println("<body>");
            out.println("Advogado " + advogado.getNome() +
                    " adicionado com sucesso");
            out.println("</body>");
            out.println("</html>");
            

		}
}
