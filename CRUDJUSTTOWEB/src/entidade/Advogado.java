package entidade;

import java.util.Calendar;

public class Advogado {
	
	private String nome;
	private String endereco;
	private String email;
	private Calendar dataNascimento;
	
	//TODO : importante atribuir id �nico a cada inst�ncia
	public Advogado() {
		
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
