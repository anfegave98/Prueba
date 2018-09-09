/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Admin;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author anfeg
 */
public class AdminDAO {

    private Connection connection;

    public AdminDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

       public boolean createAdmin(Admin admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into admin(password,email,name,last_name,deleted,creation_date) values (?,?,?,?,false,?)");
        preparedStatement.setString(1, admin.getPassword());
        preparedStatement.setString(2, admin.getEmail());
        preparedStatement.setString(3, admin.getName());
        preparedStatement.setString(4, admin.getLast_name());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        return true;
    }


    public Admin readAdmin(int admin_id) throws SQLException, URISyntaxException {
        Admin admin = new Admin();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin where deleted=false and admin_id=" + admin_id);
        while (rs.next()) {
            admin.setAdmin_id(rs.getInt("admin_id"));
            admin.setEmail(rs.getString("email"));
            admin.setName(rs.getString("name"));
            admin.setLast_name(rs.getString("last_name"));
        }
        return admin;
    }

    public void updateAdmin(Admin admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update admin set email=?,name=?,last_name=?,modification_date=?" + " where admin_id=?");
        preparedStatement.setString(1, admin.getEmail());
        preparedStatement.setString(2, admin.getName());
        preparedStatement.setString(3, admin.getLast_name());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(5, admin.getAdmin_id());
        preparedStatement.executeUpdate();
    }

    public void deleteAdmin(int admin_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update admin set deleted=true,elimination_date=? where admin_id=" + admin_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public boolean is(String email, String password) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin where email='" +email+"' and password='"+password+"'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public Admin readAdmin(String email) throws SQLException {
        Admin admin = new Admin();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin where deleted=false and email='" + email+"'");
        while (rs.next()) {
            admin.setAdmin_id(rs.getInt("admin_id"));
            admin.setEmail(rs.getString("email"));
            admin.setName(rs.getString("name"));
            admin.setLast_name(rs.getString("last_name"));
        }
        return admin;
    }
    public boolean getEmail(String email) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin where email='" +email+"'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

}
