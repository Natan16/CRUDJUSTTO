<%@ page import="utils.Listagens,
				 java.util.List,
                  dao.*,
                  model.*" %>

<html>
     <body>
     
     	<form action="index.html" method="post">
			<input type="submit" value="IN�CIO" >
		</form>
		
		<form action="consulta-advogado.jsp" method="post">
			<input type="submit" value="BUSCAR ADVOGADO" >
		</form>
          CADASTRO DE ADVOGADOS <br />
          
      	<form action="editaAdvogado">
			 
		 
			 Nome: <input type="text" name="nome" value="${param.nome}"  required/><br /> 
         	 E-mail: <input type="text" name="email" value="${param.email}" required/><br />
             Telefone: <input type="text" name="telefone" value="${param.telefone}"/><br />
             Data Nascimento: <input type="text" name="dataNascimento" placeholder="dd/MM/aaaa"/><br />
             Senha Antiga: <input type="password" name="senha" placeholder="***********" required/><br />
             Nova Senha: <input type="password" name="nova_senha" placeholder="***********"/><br />
            
             
                          UF &nbsp;&emsp; Registro OAB <br />
             <select name="ufOAB">
           		<option selected>${param.ufOAB}</option>
             	<%	
             	List<String> ufs = Listagens.getUfs();
			 	for (String uf : ufs ) {
                %>
                	<option value=<%=uf %>><%=uf%></option>
                <%
                }
                %> 
  			 </select>
  			 <input type="text" name="registroOAB" value = "${param.registroOAB}"/><br />
  			 <br />
			 
             Descri��o: <br />
             <textarea rows = "5" cols = "60" name = "desc"  value = "${param.descricao}"></textarea><br> 
             <input   type="submit" value="Atualizar" />
         </form>
        
     </body>
 </html>
