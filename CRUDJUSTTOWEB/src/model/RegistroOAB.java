package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import utils.Listagens;

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
	
	//dicionarioTipo = new ArrayMap<Character , String>();//dicion�rio que mapeia os tipos nas descri��es dos tipos
	 
	//verifica se um determinado numero de registro � v�lido 
	public static boolean registroValido(String numero) {
		return numero.matches("[0-9]+[ABENPD]?[0-9]*");
	}
	
	public RegistroOAB(String UF , String numero) {
		this.UF = UF; 
		this.numero = numero;
		this.tipo = getTipoFromNumero(numero);
	}
	public RegistroOAB(String UF , String numero , char tipo){
		this(UF , numero);
		this.tipo = tipo;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String UF) {
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
