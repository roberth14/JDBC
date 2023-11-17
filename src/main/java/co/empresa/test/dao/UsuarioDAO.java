package co.empresa.test.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.Conexion;

public class UsuarioDAO {

	private Conexion conexion;
	private static final String INSERT_USUARIO_SQL="INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?);";
	private static final String DELETE_USUARIO_SQL="DELETE FROM usuario WHERE id= ?;";
	private static final String UPDATE_USUARIO_SQL="UPDATE usuario SET nombre= ?, email= ?, pais= ? WHERE id = ? ;";
	private static final String SELECT_USUARIO_BY_ID="SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS="SELECT * FROM usuario ;";

	public UsuarioDAO() {
		this.conexion = conexion.getConexion();
	}
	
	
	public void insert (Usuario usuario) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
		}catch (SQLException e) {
			
		}
	}
	
}
