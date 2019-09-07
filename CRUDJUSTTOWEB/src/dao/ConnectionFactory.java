package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Driver;
//TODO : implementar interface com mysql
public class ConnectionFactory {
	
	public Connection getConexaoDB() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/registros?useTimezone=true&serverTimezone=UTC","root","N@t@nCC@16");
		} catch ( SQLException erro ) {
			throw new RuntimeException("Erro: " + erro );
		}
	}
	
}
