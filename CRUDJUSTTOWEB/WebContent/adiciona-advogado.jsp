<%@ page import="utils.Listagens,
				 java.util.List,
                  dao.*,
                  model.*" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="formato" %>


<html>
	<head>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
	</head>
     <body>
     
     	<form action="index.html" method="post" style="float:left;" >
			<input type="submit" value="IN�CIO" >
		</form>
		
		<form action="consulta-advogado.jsp" method="post"  style="float:right;">
			<input type="submit" value="BUSCAR ADVOGADO" >
		</form>
		<br><br>
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
		 
			 Nome:<br /> <input type="text" name="nome" placeholder="Nome Completo" required/><br /> 
         	 E-mail:<br />  <input type="text" name="email" placeholder="email@adv.oabuf.org.br" required/><br />
             Telefone:<br />  <input type="text" name="telefone" placeholder="(XX)XXXXX-XXXX"/><br />
             Data Nascimento:<br />  <formato:campoData id = "dataNascimento"/><br />
             Senha:<br>  <input type="password" name="senha" placeholder="***********" required/><br />
             
            <%--  <%	
             	if(modoEditar){
             		AdvogadoDao dao = new AdvogadoDao();
             	    String ufOAB = %>"${param.ufOAB}"<%	;
             		String registroOAB = %>	${param.registroOAB}"<% ;
             		Advogado advogado = dao.procurarPorRegistro(new RegistroOAB(ufOAB , registroOAB));
           		
             	} 
             %>
              --%>
             
                        &emsp;  UF &nbsp;&emsp;&emsp;&emsp;&emsp; Registro OAB <br />
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
