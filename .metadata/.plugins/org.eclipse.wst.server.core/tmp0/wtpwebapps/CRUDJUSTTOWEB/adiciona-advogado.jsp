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
      	<form action="adicionaAdvogado">
           <%--  <%	
				boolean modoEditar = true ;
 			%>
		 	<c:if test="${param.ufOAB == null}">
				<%	
             		modoEditar = false; 
                %> 		
			</c:if>
			
			<c:if test="${param.registroOAB == null}">
				<%	
					modoEditar = false; 
                %> 		
			</c:if> --%>
		 
			 Nome: <input type="text" name="nome" placeholder="Nome Completo" required/><br /> 
         	 E-mail: <input type="text" name="email" placeholder="email@oab" required/><br />
             Telefone: <input type="text" name="telefone" placeholder="(XX)XXXXX-XXXX"/><br />
             Data Nascimento: <input type="text" name="dataNascimento" placeholder="dd/MM/aaaa"/><br />
             Senha: <input type="password" name="senha" placeholder="***********" required/><br />
             
            <%--  <%	
             	if(modoEditar){
             		AdvogadoDao dao = new AdvogadoDao();
             	    String ufOAB = %>"${param.ufOAB}"<%	;
             		String registroOAB = %>	${param.registroOAB}"<% ;
             		Advogado advogado = dao.procurarPorRegistro(new RegistroOAB(ufOAB , registroOAB));
           		
             	} 
             %>
              --%>
             
                          UF &nbsp;&emsp; Registro OAB <br />
             <select name="ufOAB">
             	<%	
             	List<String> ufs = Listagens.getUfs();
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
             <%--  <%	
             	if(modoEditar){
          
              %>
             		<input   type="submit" value="Atualizar" />
             <%
             	}else {
             %>
             		<input   type="submit" value="Registrar" />
             <%
             	}
             %> --%>
         </form>
        
     </body>
 </html>
