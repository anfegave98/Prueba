/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Role_client;
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
public class Role_clientDAO {
    private Connection connection;

    public Role_clientDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addRole_client(Role_client role_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into role_client(name,deleted) values (?,false)");
        preparedStatement.setString(1, role_client.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteRole_client(int role_client_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update role_client set deleted=true where role_client_id=" + role_client_id);
        preparedStatement.executeUpdate();
    }

    public void updateRole_client(Role_client role_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update role_client set name=?" + " where role_client_id=?");
        preparedStatement.setString(1, role_client.getName());
        preparedStatement.setInt(2, role_client.getRole_client_id());
        preparedStatement.executeUpdate();
    }

    public Role_client readRole_client(int role_client_id) throws SQLException {
        Role_client role_client=new Role_client();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from role_client where deleted=false and role_client_id="+role_client_id);
        while(rs.next()){
            role_client.setRole_client_id(rs.getInt("role_client_id"));
            role_client.setName(rs.getString("name"));
        }
        return role_client;
    }
    
    public ArrayList<Role_client> getAllRole_client() throws SQLException {
        ArrayList<Role_client> role_clients=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from role_client where deleted=false");
        while(rs.next()){
            Role_client role_client=new Role_client();
            role_client.setRole_client_id(rs.getInt("role_client_id"));
            role_client.setName(rs.getString("name"));
            role_clients.add(role_client);
        }
        return role_clients;
    }
}
