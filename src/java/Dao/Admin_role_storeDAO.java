/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Admin_role_store;
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
public class Admin_role_storeDAO {
    
     private Connection connection;

    public Admin_role_storeDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void createAdmin_role_store(Admin_role_store admin_role_store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into admin_role_store(admin_id,role_admin_id,store_id,deleted,creation_date) values (?,?,?,false,?)");
        preparedStatement.setInt(1, admin_role_store.getAdmin_id());
        preparedStatement.setInt(2, admin_role_store.getRole_admin_id());
        preparedStatement.setInt(3, admin_role_store.getStore_id());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public Admin_role_store readAdmin_role_store(String admin_role_store_id) throws SQLException, URISyntaxException {
        Admin_role_store admin_role_store = new Admin_role_store();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin_role_store where deleted=false and admin_role_store_id=" + admin_role_store_id);
        while (rs.next()) {
            admin_role_store.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            admin_role_store.setAdmin_id(rs.getInt("admin_id"));
            admin_role_store.setRole_admin_id(rs.getInt("role_admin_id"));
            admin_role_store.setStore_id(rs.getInt("store_id"));       
        }
        return admin_role_store;
    }

    public void deleteAdmin_role_store(String admin_role_store_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update admin_role_store set deleted=true,elimination_date=? where admin_role_store_id=" + admin_role_store_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }
    
}
