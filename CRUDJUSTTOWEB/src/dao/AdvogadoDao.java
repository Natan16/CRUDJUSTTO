package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Advogado;

public class AdvogadoDao {
	private Connection conn;
	private PreparedStatement stmt;
	public AdvogadoDao() {
		conn = new ConnectionFactory().getConexaoDB();
	}
	
	public void inserir(Advogado advogado){
		String sql = "INSERT INTO advogado (descricao_produto , preco_produto) VALUES(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			//stmt.setString(1, );
			//stmt.setDate(2 ,);
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 2 :" +erro);
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
