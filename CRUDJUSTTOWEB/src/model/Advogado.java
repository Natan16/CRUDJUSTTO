package model;

import java.util.Calendar;

public class Advogado {
	
	private String nome;
	private String telefone;
	private String email;
	private Calendar dataNascimento;
	private RegistroOAB registroOAB;
	private String desc;
	private String senha;
	//TODO : colocar o escrit�rio ao qual ele � vinculado
	
	//TODO : importante atribuir id �nico a cada inst�ncia
	
	public Advogado() {
		
	}
	public Advogado(String senha) {
		this.setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegistroOAB() {
	}
	
	public RegistroOAB getRegistroOAB() {
		return registroOAB;
	}

	public void setRegistroOAB(RegistroOAB registroOAB) {
		this.registroOAB = registroOAB;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void criarRegistroOAB(String uf , String registro) {
		this.registroOAB = new RegistroOAB(uf, registro);
	}
	//TODO : a ideia � ser protected tamb�m e s� a fachada poder acessar 
	//a fachada vai ser com o banco de dados
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

	
	
}
