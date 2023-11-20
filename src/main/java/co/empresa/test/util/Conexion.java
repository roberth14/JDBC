package co.empresa.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private Connection con = null;
	private PreparedStatement preparedStatement;
	private static Conexion db;

	private static final String url= "jdbc:mysql://localhost:3306/";
	private static final String dbName = "sistema";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "root";
    private static final String password = "";

	public Conexion() {
		try {
			Class.forName(driver).newInstance();
			con = (Connection) DriverManager.getConnection(url+dbName, userName, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion() {
		if(db == null) {
			db = new Conexion();
		}
		return db;
	}

	public ResultSet query() throws SQLException { // devuelve el resultado de una consulta
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

	public int execute() throws SQLException {// EJECUTA EL DML
		int result = preparedStatement.executeUpdate();
		return result;
	}

	public Connection getCon() { // DEVUELVE EL OBJETO CONEXION
		return this.con;
	}

	public PreparedStatement setPreparedStatement(String sql) throws SQLException {// INICIALIZAR EL PREPARED STATEMENT
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
	
}
