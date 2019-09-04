package model;



import utils.Listagens;

import web.CadastroInvalidoException;

//A - Inscrição Suplementar
//B - Inscrição por Transferência
//E - Inscrição de Estagiário
//N - Inscrição de Provisionado
//P - Inscrição Provisória.
//se não tiver, considerar letra D
public class RegistroOAB {
	
	private String UF;
	private String numero;
	private int tipo;
	
	//dicionarioTipo = new ArrayMap<Character , String>();//dicionário que mapeia os tipos nas descrições dos tipos
	 //TODO : impedir que alguém se registre com registro de outra pessoa
	//verifica se um determinado numero de registro é válido 
	public static boolean registroValido(String numero)   {
		return numero.matches("[0-9]+[ABENPD]?[0-9]*");
	}
	
	public RegistroOAB(String UF , String numero) throws CadastroInvalidoException {
		if(registroValido(numero)){
			this.UF = UF; 
			this.numero = numero.toUpperCase();
			this.tipo = getTipoFromNumero(numero.toUpperCase());
		} else {
			throw new CadastroInvalidoException("Numero de Registro Inválido");
		}
	
	}
	public RegistroOAB(String UF , String numero , char tipo) throws CadastroInvalidoException{
		this(UF , numero);
		if(getTipoFromNumero(numero) == tipo) {
			this.tipo = tipo;
		} else {
			throw new CadastroInvalidoException("Tipo de registro incompatível");
		}
	}

	public String getUf() {
		return UF;
	}

	public void setUf(String UF) {
		this.UF = UF;
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
	
	private char getTipoFromNumero(String numero) {
		numero = numero.toUpperCase();
		for (char tipo : Listagens.getTiposDeRegistro() ) {
			if( numero.contains(String.valueOf(tipo)) )
				return tipo;
		}
		return 'D';
		
	}
	//TODO : aqui seria um bom canto pra chegar validade do registro?
}
