<%@ page import="utils.Lista,
				 java.util.List,
                  dao.*,
                  model.*" %>

<html>
     <body>
         CADASTRO DE ADVOGADOS
         <form action="adicionaAdvogado" method="post">
             Nome: <input type="text" name="nome" placeholder="Nome Completo" required/><br />
             E-mail: <input type="text" name="email" placeholder="email@oab"/><br />
             Telefone: <input type="text" name="telefone" placeholder="(XX)XXXXX-XXXX"/><br />
             Data Nascimento: <input type="text" name="dataNascimento" placeholder="dd/MM/aaaa"/><br />
             
                          UF &nbsp;&emsp; Registro OAB <br />
             <select name="ufOAB">
             	<%	
             	List<String> ufs = Lista.getUfs();
			 	for (String uf : ufs ) {
                %>
                	<option value=<%=uf %>><%=uf%></option>
                <%
                }
                %>
  			 </select>
  			 <input type="text" name="registroOAB" /><br />
  			 <br />
			 
             Descri��o: <br />
             <textarea rows = "5" cols = "60" name = "desc"></textarea><br> 
             <input   type="submit" value="Registrar" />
         </form>
     </body>
 </html>
