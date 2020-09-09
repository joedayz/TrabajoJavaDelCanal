package pe.joedayz.supermercado.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import pe.joedayz.supermercado.exception.PersistenceException;
import pe.joedayz.supermercado.models.TipoProducto;

import static pe.joedayz.supermercado.repository.ConnectionManager.createDataSource;

public class TipoProductoRepositoryImpl implements TipoProductoRepository {


	private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `tipo_producto` (\n" +
			"  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
			"  `nombre` VARCHAR(45) NULL DEFAULT NULL,\n" +
			"  PRIMARY KEY (`id`))\n" +
			"ENGINE = InnoDB\n" +
			"AUTO_INCREMENT = 3\n" +
			"DEFAULT CHARACTER SET = utf8";
	private final static String INSERT = "INSERT INTO tipo_producto (nombre) VALUES (?);";
	private final static String UPDATE = "UPDATE tipo_producto SET nombre=? WHERE id=?;";
	private final static String DELETE = "DELETE FROM tipo_producto WHERE id=?;";
	private final static String GET_ALL = "SELECT * FROM tipo_producto;";
	private final static String GET_BY_ID = "SELECT * FROM tipo_producto WHERE id=?;";
	private final static String GET_BY_NOMBRE = "SELECT * FROM tipo_producto WHERE nombre=?;";

	@Override
	public void save(TipoProducto tipoProducto) {
		if(tipoProducto==null){
			throw new PersistenceException("Error, TIPO_PRODUCTO null.");
		}
		DataSource ds = createDataSource();

		try (Connection connection = ds.getConnection();  ) {
			if(tipoProducto.getId()==null){
				try(PreparedStatement stmt = connection.prepareStatement(INSERT)){
					stmt.setString(1, tipoProducto.getNombre());
					stmt.executeUpdate();
				}
			}else{
				try(PreparedStatement stmt = connection.prepareStatement(UPDATE)){
					stmt.setString(1, tipoProducto.getNombre());
					stmt.setInt(2, tipoProducto.getId());
					stmt.executeUpdate();
				}
			}
		}
		catch (SQLException sqlException) {
			throw new PersistenceException("Error saving record in TIPO_PRODUCTO table.", sqlException);
		}
	}

	@Override
	public void remove(TipoProducto tipoProducto) {
		if(tipoProducto==null || tipoProducto.getId()==null){
			throw new PersistenceException("Error, el producto no existe en la BD.");
		}
		DataSource ds = createDataSource();

		try (Connection connection = ds.getConnection();  ) {
			try(PreparedStatement stmt = connection.prepareStatement(DELETE)){
				stmt.setInt(1, tipoProducto.getId());
				stmt.executeUpdate();
			}
		}
		catch (SQLException sqlException) {
			throw new PersistenceException("Error deleting record in TIPO_PRODUCTO table.", sqlException);
		}
	}

	@Override
	public List<TipoProducto> findAll() {

		DataSource ds = createDataSource();

		try (Connection connection = ds.getConnection();  ) {
			try(PreparedStatement stmt = connection.prepareStatement(GET_ALL)){
				List<TipoProducto> tiposProductos = new ArrayList<>();
				ResultSet resultSet = stmt.executeQuery();
				while (resultSet.next()) {
					TipoProducto tipoProducto = new TipoProducto();
					tipoProducto.setId(resultSet.getInt(1));
					tipoProducto.setNombre(resultSet.getString(2));
					tiposProductos.add(tipoProducto);
				}
				return tiposProductos;
			}
		}
		catch (SQLException sqlException) {
			throw new PersistenceException("Error getting records in TIPO_PRODUCTO table.", sqlException);
		}

	}

	@Override
	public TipoProducto findById(Integer id) {
		if (id == null || id < 0) {
			return null;
		}
		DataSource ds = createDataSource();
		try (Connection connection = ds.getConnection();  ) {
			try (PreparedStatement stmt = connection.prepareStatement(GET_BY_ID)) {
				stmt.setInt(1, id);
				ResultSet resultSet = stmt.executeQuery();
				TipoProducto tipoProducto = new TipoProducto();
				while(resultSet.next()){
					tipoProducto.setId(resultSet.getInt(1));
					tipoProducto.setNombre(resultSet.getString(2));
				}
				return tipoProducto;
			}
		}
		catch (SQLException sqlException) {
			throw new PersistenceException("Error getting record in TIPO_PRODUCTO table.", sqlException);
		}
	}

	@Override
	public void init() {
		DataSource ds = createDataSource();

		try (Connection connection = ds.getConnection();  ) {
			try(PreparedStatement stmt = connection.prepareStatement(CREATE_TABLE)){
				stmt.executeUpdate();
			}
		}
		catch (SQLException sqlException) {
			throw new PersistenceException("Error creating TIPO_PRODUCTO table.", sqlException);
		}

	}


}
