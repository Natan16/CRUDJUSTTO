<%@ page import="utils.Listagens,
				 java.util.List,
                  dao.AdvogadoDao,
                  model.*" %>
<html>
    <body>
        <table>
            <%
            AdvogadoDao dao = new AdvogadoDao();
            List<Advogado> advogados = dao.listarTodos();

            for (Advogado advogado : advogados ) {
            %>
                <tr>
                    <td><%=advogado.getNome() %></td> 
                    <td><%=advogado.getEmail() %></td>
                    <td><%=advogado.getTelefone() %></td>
   
                </tr>
            <%
            }
            %>
        </table>
    </body>
</html>