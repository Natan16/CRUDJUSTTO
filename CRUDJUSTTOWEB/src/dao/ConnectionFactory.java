package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//TODO : implementar interface com mysql
public class ConnectionFactory {
	
	public Connection getConexaoDB() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/cadastros","root","a102030a");
		} catch ( SQLException erro ) {
			throw new RuntimeException("Erro: " + erro );
		}
		
	}
	
}