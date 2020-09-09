package pe.joedayz.supermercado.dao;

import pe.joedayz.supermercado.exception.PersistenceException;

import java.sql.*;

import javax.sql.DataSource;

public class ConnectionManager {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "supermercado";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws PersistenceException {
        Connection conn = null;
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
            return conn;
        }catch(ClassNotFoundException  ex){
            String errorMsg = "Driver (JDBC) no found";
            throw new PersistenceException(errorMsg, ex);
        }catch (SQLException ex){
            String errorMsg = "Error getting conexion";
            throw new PersistenceException(errorMsg, ex);
        }
    }

	public static DataSource createDataSource(){

		HikariDataSource hikariDs = new HikariDataSource();
		hikariDs.setJdbcUrl("jdbc:mysql://localhost:3306/" + DATABASE);
		hikariDs.setUsername(USER);
		hikariDs.setPassword(PASSWORD);

		DataSource proxyDataSource = ProxyDataSourceBuilder.create(hikariDs)
				.logQueryToSysOut()
				.build();

		return proxyDataSource;
	}
}
