package dao;

public enum ColunasAdvogado {
	COL_DESCRICAO(1) ,
	COL_EMAIL(2) ,
	COL_NOME_COMPLETO(3) ,
	COL_TELEFONE(4),
	COL_DATA_NASCIMENTO(5),
	COL_UNIDADE_FEDERATIVA(6),
	COL_REGISTRO_OAB(7),
	COL_SENHA(8);
	
	public int indice_coluna;
	ColunasAdvogado(int indice_coluna){
		this.indice_coluna = indice_coluna;
	}
}
