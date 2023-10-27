package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConexionMysql {

	private Connection conn;
	
	public ConexionMysql() throws SQLException {
		String host = "localhost";
	    String baseDatos = "deinsa";
	    String usuario = "root";
	    String password = "dm2";
	    String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
	    conn = DriverManager.getConnection(cadenaConexion, usuario, password);
	    conn.setAutoCommit(true);
	}
	public Connection getConexion() {
        return conn;
    }

	
}
