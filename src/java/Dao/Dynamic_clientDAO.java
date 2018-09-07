/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Dynamic_client;
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
public class Dynamic_clientDAO {
     private Connection connection;

    public Dynamic_clientDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addDynamic_client(Dynamic_client dynamic_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into dynamic_client(client_id,service_client_id,text) values (?,?,?)");
        preparedStatement.setInt(1, dynamic_client.getClient_id());
        preparedStatement.setInt(2, dynamic_client.getClient_data_id());
        preparedStatement.setString(3, dynamic_client.getText());
        preparedStatement.executeUpdate();
    }
    
    public void updateDynamic_client(Dynamic_client dynamic_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update dynamic_client set text=?" + " where client_id=? and client_data_id=?");
        preparedStatement.setString(1, dynamic_client.getText());
        preparedStatement.setInt(2, dynamic_client.getClient_id());
        preparedStatement.setInt(2, dynamic_client.getClient_data_id());
        preparedStatement.executeUpdate();
    }
    
    public Dynamic_client readDynamic_client(int client_id,int client_data_id) throws SQLException {
        Dynamic_client dynamic_client=new Dynamic_client();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_client where client_data_id="+client_data_id+" and client_id="+client_id);
        while(rs.next()){
            dynamic_client.setClient_id(client_id);
            dynamic_client.setClient_data_id(client_data_id);
            dynamic_client.setText(rs.getString("text"));
        }
        return dynamic_client;
    }
    
    public ArrayList<Dynamic_client> getAllDynamic_client() throws SQLException {
        ArrayList<Dynamic_client> dynamic_clients=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_client");
        while(rs.next()){
            Dynamic_client dynamic_client=new Dynamic_client();
            dynamic_client.setClient_id(rs.getInt("client_id"));
            dynamic_client.setClient_data_id(rs.getInt("client_data_id"));
            dynamic_client.setText(rs.getString("text"));
            dynamic_clients.add(dynamic_client);
        }
        return dynamic_clients;
    }
}
