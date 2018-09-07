/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Role_admin;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class Role_adminDAO {
    private Connection connection;

    public Role_adminDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addRole_admin(Role_admin role_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into role_admin(name,deleted) values (?,false)");
        preparedStatement.setString(1, role_admin.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteRole_admin(int role_admin_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update role_admin set deleted=true where role_admin_id=" + role_admin_id);
        preparedStatement.executeUpdate();
    }

    public void updateRole_admin(Role_admin role_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update role_admin set name=?" + " where role_admin_id=?");
        preparedStatement.setString(1, role_admin.getName());
        preparedStatement.setInt(2, role_admin.getRole_admin_id());
        preparedStatement.executeUpdate();
    }

    public Role_admin readRole_admin(int role_admin_id) throws SQLException {
        Role_admin role_admin=new Role_admin();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from role_admin where deleted=false and role_admin_id="+role_admin_id);
        while(rs.next()){
            role_admin.setRole_admin_id(rs.getInt("role_admin_id"));
            role_admin.setName(rs.getString("name"));
        }
        return role_admin;
    }
    
    public ArrayList<Role_admin> getAllRole_admin() throws SQLException {
        ArrayList<Role_admin> role_admins=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from role_admin where deleted=false");
        while(rs.next()){
            Role_admin role_admin=new Role_admin();
            role_admin.setRole_admin_id(rs.getInt("role_admin_id"));
            role_admin.setName(rs.getString("name"));
            role_admins.add(role_admin);
        }
        return role_admins;
    }
}
