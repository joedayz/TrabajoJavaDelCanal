package pe.joedayz.supermercado.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.joedayz.supermercado.dao.ConnectionManager;
import pe.joedayz.supermercado.dao.TipoProductoDAO;
import pe.joedayz.supermercado.exception.PersistenceException;

public class TipoProductoDAOImpl implements TipoProductoDAO {


	private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `tipo_producto` (\n" +
			"  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
			"  `nombre` VARCHAR(45) NULL DEFAULT NULL,\n" +
			"  PRIMARY KEY (`id`))\n" +
			"ENGINE = InnoDB\n" +
			"AUTO_INCREMENT = 3\n" +
			"DEFAULT CHARACTER SET = utf8";


	@Override
	public void save(TipoProducto tipoProducto) {

	}

	@Override
	public void remove(TipoProducto tipoProducto) {

	}

	@Override
	public List<TipoProducto> all() {
		return null;
	}

	@Override
	public TipoProducto findById(Integer id) {
		return null;
	}

	@Override
	public void init() {
		try (Connection connection = ConnectionManager.getConnection();
			 PreparedStatement stmt = connection.prepareStatement(CREATE_TABLE){
			stmt.executeUpdate();
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	private static PreparedStatement createStatement(Connection connection, String query) throws SQLException {
		if (connection == null) {
			return null;
		}
		return connection.prepareStatement(query);
	}
}
