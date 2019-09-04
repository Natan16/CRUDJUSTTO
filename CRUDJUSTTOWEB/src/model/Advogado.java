package model;

import java.util.Calendar;

import web.CadastroInvalidoException;

import utils.AvaliadorDeFormatacao;

public class Advogado {
	
	private String nome;
	private String telefone;
	private String email;
	private Calendar dataNascimento;
	private RegistroOAB registroOAB;
	private String desc;
	private String senha;
	//TODO : colocar o escrit�rio ao qual ele � vinculado
	
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
		if (AvaliadorDeFormatacao.telefoneValido(telefone)) {
			this.telefone = telefone;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(AvaliadorDeFormatacao.emailOabValido(email)) {
			this.email = email;
		}else {
			throw new CadastroInvalidoException("o email OAB passado est� incorreto"); 
		}
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
		try {
			this.registroOAB = new RegistroOAB(uf, registro);
		}catch(CadastroInvalidoException e) {
			throw new CadastroInvalidoException("Numero de Registro Inv�lido");
		}
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
