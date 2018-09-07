/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Service_client;
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
public class Service_clientDAO {
    private Connection connection;

    public Service_clientDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addService_client(Service_client service_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into service_client(name,deleted) values (?,false)");
        preparedStatement.setString(1, service_client.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteService_client(int service_client_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update service_client set deleted=true where service_client_id=" + service_client_id);
        preparedStatement.executeUpdate();
    }

    public void updateService_client(Service_client service_client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update service_client set name=?" + " where service_client_id=?");
        preparedStatement.setString(1, service_client.getName());
        preparedStatement.setInt(2, service_client.getService_client_id());
        preparedStatement.executeUpdate();
    }

    public Service_client readService_client(int service_client_id) throws SQLException {
        Service_client service_client=new Service_client();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from service_client where deleted=false and service_client_id="+service_client_id);
        while(rs.next()){
            service_client.setService_client_id(rs.getInt("service_client_id"));
            service_client.setName(rs.getString("name"));
        }
        return service_client;
    }
    
    public ArrayList<Service_client> getAllService_client() throws SQLException {
        ArrayList<Service_client> service_clients=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from service_client where deleted=false");
        while(rs.next()){
            Service_client service_client=new Service_client();
            service_client.setService_client_id(rs.getInt("service_client_id"));
            service_client.setName(rs.getString("name"));
            service_clients.add(service_client);
        }
        return service_clients;
    }
}
