package pe.joedayz.supermercado.dao;

import pe.joedayz.supermercado.exception.PersistenceException;

import java.sql.*;

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

    public static void closeAll(Connection conn){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (Exception ex){

        }
    }

    public static void closeAll(Connection conn, Statement stmt){
        try{
            if(conn!=null){
                conn.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }catch (Exception ex){

        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        try{
            if(conn!=null || stmt!=null){
                closeAll(conn, stmt);
            }
            if(rs!=null){
                rs.close();
            }
        }catch (Exception ex){

        }
    }
}
