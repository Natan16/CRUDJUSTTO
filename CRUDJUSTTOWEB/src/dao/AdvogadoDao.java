package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;

import model.Advogado;

public class AdvogadoDao {
	private Connection conn;
	private PreparedStatement stmt;
	public AdvogadoDao() {
		conn = new ConnectionFactory().getConexaoDB();
	}
	
	@SuppressWarnings("deprecation")
	public void inserir(Advogado advogado){
		String sql = "INSERT INTO advogados (descricao, email, nome , telefone , dataNascimento , uf , registro ) VALUES(?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, advogado.getDesc());
			stmt.setString(2, advogado.getEmail());
			stmt.setString(3, advogado.getNome());
			stmt.setString(4, advogado.getTelefone());	
			java.util.Date utilDate = advogado.getDataNascimento().getTime();
			java.sql.Date date = new java.sql.Date(utilDate.getYear() ,utilDate.getMonth() ,
					utilDate.getDay());
			System.out.println(advogado.getRegistroOAB().getUF());
			stmt.setDate(5, date , Calendar.getInstance() );
			//UF e n�mero compoem a minha PK
			stmt.setString(6, advogado.getRegistroOAB().getUF());
			stmt.setString(7, advogado.getRegistroOAB().getNumero());
			
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro na inser��o de Advogado :" + erro);
		}
	}
	public void alterar(Advogado advogado){
		String sql = "";
		try {
			
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 3 :" +erro);
		}
	}
	public void excluir(Advogado advogado){
		String sql = "";
		try {
			
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 4 :" +erro);
		}
	}
	public ArrayList<Advogado> listarTodos(Advogado advogado){
		String sql = "";
		try {
			
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 5 :" +erro);
		}
		return null;
	}
	
	public ArrayList<Advogado> listarTodosDescricao(String valor){
		String sql = "SELECT * FROM produto WHERE descricao_produto LIKE '%" + valor + "%'";
		try {
			
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 2 :" +erro);
		}
		return null;
	}
}
