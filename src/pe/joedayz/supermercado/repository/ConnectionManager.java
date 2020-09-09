package pe.joedayz.supermercado.repository;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;

public class ConnectionManager {

    private static final String DATABASE = "supermercado";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "Dr3cVhcAB!d#6WqU";

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
