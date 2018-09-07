/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Permission_client;
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
public class Permission_clientDAO {
    private Connection connection;

    public Permission_clientDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addPermission_client(Permission_client permission_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into permission_client(role_client_id,service_client_id) values (?,?)");
        preparedStatement.setInt(1, permission_client.getRole_client_id());
        preparedStatement.setInt(2, permission_client.getService_client_id());
        preparedStatement.executeUpdate();
    }
    
    public ArrayList<Permission_client> getAllPermission_client() throws SQLException {
        ArrayList<Permission_client> permission_clients=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from permission_client");
        while(rs.next()){
            Permission_client permission_client=new Permission_client();
            permission_client.setRole_client_id(rs.getInt("role_client_id"));
            permission_client.setService_client_id(rs.getInt("service_client_id"));
            permission_clients.add(permission_client);
        }
        return permission_clients;
    }
}
