
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="utils.Listagens,
				 java.util.List,
                  dao.AdvogadoDao,
                  model.RegistroOAB,
                  model.Advogado" %>
                  
<c:url value="/images/delete_icon.png" var="delete"/>
<c:url value="/images/edit_icon.png" var="edit"/>
<c:url value="/images/search_icon.png" var="search"/>
<html>
	<head>
		<link href="Estilo.css" rel="stylesheet" media="all" />
		<script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
	</head>
    <body>
    	<form action="index.html" method="post"  style="float:left;">
			<input type="submit" value="IN�CIO"  >
		</form>
		
		<form action="adiciona-advogado.jsp" method="post"  style="float:right;">
			<input type="submit" value="CADASTRAR ADVOGADO" >
		</form>
		<br><br>
    	<form action="consulta-advogado.jsp" method="get">
    		<input type="text" name="filtro" >
    		<input type="image" src="${search}"  width="20" height="20" value="" >
        <br />
        </form>
        <table>
        
        	<jsp:useBean id="dao" class="dao.AdvogadoDao"/>
        	
        	<c:forEach var="advogado" items="${dao.lista}">
        		<tr>
                    <td>${advogado.nome}</td> 
                    <td><a href="mailto:email@email.com">${advogado.email}</a></td>
                    <td>${advogado.telefone}</td>
                    <td>
                    	<form action="edita-advogado.jsp" method="get">
               				<input type="hidden" name="nome" value="${advogado.nome}" />
        					<input type="hidden" name="email" value="${advogado.email}"/>
        					<input type="hidden" name="telefone" value="${advogado.telefone}" />
        					<input type="hidden" name="descricao" value="${advogado.desc}" />
    						<input type="hidden" name="ufOAB" value="${advogado.registroOAB.uf}" />
    						<input type="hidden" name="registroOAB" value="${advogado.registroOAB.numero}" />
    						<input type="image" src="${edit}"  width="20" height="20" value="" >
        				</form>
        				
        				<form action="excluiAdvogado" method="get">
        				    <input type="hidden" name="ufOAB" value="${advogado.registroOAB.uf}" />
    						<input type="hidden" name="registroOAB" value="${advogado.registroOAB.numero}" />

    						<input type="image" src="${delete}"  width="20" height="20" value="" >
        				</form>
        			</td>                  
                </tr>	
    		
    		
      
                
               
                <tr>
                 <td><br></td>
                 <td>----------------------------</td>
                </tr>
            </c:forEach>
                                  
 
        </table>
    </body>
</html>