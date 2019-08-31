package model;
//A - Inscri��o Suplementar
//B - Inscri��o por Transfer�ncia
//E - Inscri��o de Estagi�rio
//N - Inscri��o de Provisionado
//P - Inscri��o Provis�ria.
//se n�o tiver, considerar letra D
public class RegistroOAB {
	
	private String UF;
	private String numero;
	private int tipo;
	
	public RegistroOAB(String UF , String numero , char tipo){
		this.UF = UF; 
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	//TODO : aqui seria um bom canto pra chegar validade do registro?
}
