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
import web.CadastroInvalidoException;
import dao.ColunasAdvogado;
//TODO : pesquisar se existe um tipo de dados pr�prio pra armazenar senha em mysql
public class AdvogadoDao {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Advogado> queryAdvogados = new ArrayList<Advogado>();
	
	public AdvogadoDao(Connection connection) {
		this.conn = connection;
	}
	
	public AdvogadoDao() {
		conn = new ConnectionFactory().getConexaoDB();
	}
	
	@SuppressWarnings("deprecation")
	public void inserir(Advogado advogado){
		String sql = "INSERT INTO advogados (descricao, email, nome , telefone , dataNascimento , uf , registro , senha) VALUES(?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(ColunasAdvogado.COL_DESCRICAO.indice_coluna , advogado.getDesc());
			stmt.setString(ColunasAdvogado.COL_EMAIL.indice_coluna, advogado.getEmail());
			stmt.setString(ColunasAdvogado.COL_NOME_COMPLETO.indice_coluna, advogado.getNome());
			stmt.setString(ColunasAdvogado.COL_TELEFONE.indice_coluna, advogado.getTelefone());	
			java.util.Date utilDate = advogado.getDataNascimento().getTime();
			java.sql.Date date = new java.sql.Date(utilDate.getYear() ,utilDate.getMonth() ,
					utilDate.getDay());
			System.out.println(advogado.getRegistroOAB().getUf());
			stmt.setDate(ColunasAdvogado.COL_DATA_NASCIMENTO.indice_coluna, date , Calendar.getInstance() );
			//UF e n�mero compoem a minha PK
			stmt.setString(ColunasAdvogado.COL_UNIDADE_FEDERATIVA.indice_coluna, advogado.getRegistroOAB().getUf());
			stmt.setString(ColunasAdvogado.COL_REGISTRO_OAB.indice_coluna, advogado.getRegistroOAB().getNumero());
			stmt.setString(ColunasAdvogado.COL_SENHA.indice_coluna, advogado.getSenha());
			
			stmt.execute();
			stmt.close();
		}catch(Exception erro) {
			throw new RuntimeException("Erro na inser��o de registro :" + erro);
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
			stmt.setString(6 , advogado.getRegistroOAB().getUf());
			stmt.setString(7 , advogado.getRegistroOAB().getNumero());
			stmt.execute();
			stmt.close();
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro ao alterar registro :" +erro);
		}
	}
	public void excluir(Advogado advogado){
		
		String sql = "DELETE FROM advogados WHERE uf=? AND registro=? ;";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, advogado.getRegistroOAB().getUf());
			preparedStmt.setString(2, advogado.getRegistroOAB().getNumero());
			preparedStmt.execute();  
		    conn.close();
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro ao excluir registro :" +erro);
		}
	}
	//registro n�o est� sendo atualizado
	public ArrayList<Advogado> getLista(){
		String sql = "SELECT * FROM advogados";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				try {
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
			
				}catch(CadastroInvalidoException erro) {
					System.out.println(erro);
				}
			}
			
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro ao listar todos os registros :" +erro);
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
			throw new RuntimeException("Erro ao filtrar registros :" +erro);
		}
		return null;
	}
	
	public Advogado procurarPorRegistro(RegistroOAB registroOAB ) {
		String uf = registroOAB.getUf();
		String registro = registroOAB.getNumero();
		
		String sql = "SELECT * FROM advogados WHERE uf=? AND registro=?";
		Advogado advogado = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				try {
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
				}catch(CadastroInvalidoException erro) {
					System.out.println(erro);
				}
			}
		}catch(Exception erro) {
			//TODO : trocar texto da excess�o por algo mais descritivo
			throw new RuntimeException("Erro ao procurar por registro :" +erro);
		}
		return advogado; 
			
	}
}
