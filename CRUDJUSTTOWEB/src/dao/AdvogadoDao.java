package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import model.Advogado;
import model.RegistroOAB;

public class AdvogadoDao {
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Advogado> queryAdvogados = new ArrayList<Advogado>();
	
	public AdvogadoDao() {
		conn = new ConnectionFactory().getConexaoDB();
	}
	
	@SuppressWarnings("deprecation")
	public void inserir(Advogado advogado){
		String sql = "INSERT INTO advogados (descricao, email, nome , telefone , dataNascimento , uf , registro , senha) VALUES(?,?,?,?,?,?,?,?)";
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
			stmt.setString(8, advogado.getSenha());
			
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro na inser��o de Advogado :" + erro);
		}
	}
	public void alterar(Advogado advogado, String senha){
		
		String sql = "UPDATE advogados SET descricao=?, email=?, nome=?, telefone=? , senha=?"
				+ " WHERE uf=? AND registro=?";
		try {
			//TODO : adicionar dataDeNascimento, que ainda est� dando problema
;			System.out.println(advogado.getRegistroOAB().getNumero());
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, advogado.getDesc() );
			stmt.setString(2 , advogado.getEmail());
			stmt.setString(3 , advogado.getNome());
			stmt.setString(4 , advogado.getTelefone());
			stmt.setString(5 , advogado.getSenha());
			stmt.setString(6 , advogado.getRegistroOAB().getUF());
			stmt.setString(7 , advogado.getRegistroOAB().getNumero());
			stmt.execute();
			stmt.close();
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 3 :" +erro);
		}
	}
	public void excluir(Advogado advogado){
		
		String sql = "DELETE FROM advogados WHERE uf=? AND registro=? ;";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, advogado.getRegistroOAB().getUF());
			preparedStmt.setString(2, advogado.getRegistroOAB().getNumero());
			preparedStmt.execute();  
		    conn.close();
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 4 :" +erro);
		}
	}
	//registro n�o est� sendo atualizado
	public ArrayList<Advogado> listarTodos(){
		String sql = "SELECT * FROM advogados";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				//fazer o extract do metodo que retorna Advogado a partir de uma query
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				Date dataNascimento = rs.getDate("dataNascimento");
				String uf = rs.getString("uf");
				String registro = rs.getString("registro");
				String senha = rs.getString("senha");
				//usar registro OAB n�o � legal, pois aumenta acoplamento
				//usar uma facade ou criar um construtor a mais em advogado
				Advogado advogado = new Advogado(senha);
				advogado.setNome(nome);
	            advogado.setTelefone(telefone);
	            advogado.setEmail(email);
	            //TODO : lidar com a convers�o da data de nascimento
	            //advogado.setDataNascimento(Calendar.getInstance().setTime(dataNascimento.to));
	            advogado.setDesc(descricao);
				advogado.criarRegistroOAB(uf ,registro);
				queryAdvogados.add(advogado);
			}
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 5 :" +erro);
		}
		return queryAdvogados;
	}
	
	public ArrayList<Advogado> listarTodosDescricao(String valor){
		
		//o mecanismo de busca vai listar todos os advogados que tenham algum dos par�metros
		//contendo as partes buscadas
		
		String sql = "SELECT * FROM advogados WHERE ";
		try {
			
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 2 :" +erro);
		}
		return null;
	}
	
	public Advogado procurarPorRegistro(RegistroOAB registroOAB ) {
		String uf = registroOAB.getUF();
		String registro = registroOAB.getNumero();
		
		String sql = "SELECT * FROM advogados WHERE uf=? AND registro=?";
		Advogado advogado = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				String descricao = rs.getString("descricao");
				String email = rs.getString("email");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				Date dataNascimento = rs.getDate("dataNascimento");
				String senha = rs.getString("senha");
				advogado = new Advogado(senha);
				advogado.setNome(nome);
	            advogado.setTelefone(telefone);
	            advogado.setEmail(email);
	            //TODO : lidar com a convers�o da data de nascimento
	            advogado.setDesc(descricao);
				advogado.criarRegistroOAB(uf ,registro);
				queryAdvogados.add(advogado);
			}
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro 2 :" +erro);
		}
		return advogado; 
		
		
	}
}
