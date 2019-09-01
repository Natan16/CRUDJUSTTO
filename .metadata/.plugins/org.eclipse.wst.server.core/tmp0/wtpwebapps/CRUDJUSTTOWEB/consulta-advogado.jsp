<%@ page import="utils.Listagens,
				 java.util.List,
                  dao.AdvogadoDao,
                  model.RegistroOAB,
                  model.Advogado" %>
<html>
	<head>
		<link href="EstiloConsulta.css" rel="stylesheet" media="all" />
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
    		<input type="image" src="images/search_icon.png"  width="20" height="20" value="" >
        <br />
        </form>
        <table>
            <%
            AdvogadoDao dao = new AdvogadoDao();
            List<Advogado> advogados = dao.listarTodos();

            for (Advogado advogado : advogados ) {
            	//s� os que se encaixam no filtro
            	if(true){
            %>
                <tr>
                    <td><%=advogado.getNome() %></td> 
                    <td><%=advogado.getEmail() %></td>
                    <td><%=advogado.getTelefone() %></td>
                    <td>
                    	<form action="edita-advogado.jsp" method="get">
               				<input type="hidden" name="nome" value=<%=advogado.getNome()%> />
        					<input type="hidden" name="email" value=<%=advogado.getEmail()%> />
        					<input type="hidden" name="telefone" value=<%=advogado.getTelefone()%> />
        					<input type="hidden" name="descricao" value=<%=advogado.getDesc()%> />
               
    						<input type="hidden" name="ufOAB" value=<%=advogado.getRegistroOAB().getUF()%> />
    						<input type="hidden" name="registroOAB" value=<%=advogado.getRegistroOAB().getNumero()%> />
    						
    						<input type="image" src="images/edit_icon.png"  width="20" height="20" value="" >
        				</form>
        				
        				<form action="excluiAdvogado" method="get">
        				    <input type="hidden" name="ufOAB" value=<%=advogado.getRegistroOAB().getUF()%> />
    						<input type="hidden" name="registroOAB" value=<%=advogado.getRegistroOAB().getNumero()%> />
    						<input type="image" src="images/delete_icon.png"  width="20" height="20" value="" >
        				</form>
        			</td>                  
                </tr>
                <tr>
                 <td>----------</td>
                </tr>
                                  
            <%
            	}
            }
            %>
        </table>
    </body>
</html>