package Util;

import Model.Company;
import com.mysql.jdbc.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection CONNECTION = null;

    public static Connection getConnection(String databas) throws SQLException, ClassNotFoundException, IOException {

        // Datos de conexión a base de datos local de PostgreSQL
        String host = "127.0.0.1";
        String database = databas;
        String user = "root";
        String pass = "root";
        String port = "3306";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databas, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CONNECTION;
    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONNECTION != null) {
                CONNECTION.close();
                CONNECTION = null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }

    }

    public void createDatabase(Company c) throws SQLException, ClassNotFoundException {
        String solucion = "AABGJJMO_BiStock_" + c.getCompany_id();
        Class.forName("com.mysql.jdbc.Driver");
        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
        Statement s = (Statement) Conn.createStatement();
        s.executeUpdate("CREATE DATABASE " + solucion + "");
    }

}
