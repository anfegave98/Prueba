/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class ClientDAO {

    private Connection connection;

    public ClientDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public boolean createClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into client(email,password,name,last_name,role_client_id,deleted,creation_date) values (?,?,?,?,1,false,?)");
        preparedStatement.setString(1, client.getEmail());
        preparedStatement.setString(2, client.getPassword());
        preparedStatement.setString(3, client.getName());
        preparedStatement.setString(4, client.getLast_name());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean deleteClient(String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update client set deleted=true,elimination_date=? where email='" +email+"'");
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        return true;
    }

    public void updateClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update client set name=?,last_name=?,modification_date=?" + " where email='"+client.getEmail()+"'");
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getLast_name());
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public Client readClient(int client_id) throws SQLException {
        Client client = new Client();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where deleted=false and client_id=" + client_id);
        while (rs.next()) {
            client.setClient_id(client_id);
            client.setEmail(rs.getString("email"));
            client.setName(rs.getString("name"));
            client.setLast_name(rs.getString("last_name"));
        }
        return client;
    }

    public ArrayList<Client> getAllClient() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where deleted=false");
        while (rs.next()) {
            Client client = new Client();
            client.setClient_id(rs.getInt("client_id"));
            client.setEmail(rs.getString("email"));
            client.setName(rs.getString("name"));
            client.setLast_name(rs.getString("last_name"));
            clients.add(client);
        }
        return clients;
    }

    public boolean is(String email, String password) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where email='" + email + "' and password='" + password + "'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public Client readClient(String email) throws SQLException {
        Client client = new Client();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where deleted=false and email='" + email + "'");
        while (rs.next()) {
            client.setClient_id(rs.getInt("client_id"));
            client.setEmail(rs.getString("email"));
            client.setName(rs.getString("name"));
            client.setLast_name(rs.getString("last_name"));
        }
        return client;
    }

    public boolean getEmail(String email) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where email='" + email + "'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public ArrayList<Client> getAll() throws SQLException {

        ArrayList<Client> clients = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where deleted=false");
        while (rs.next()) {
            Client client = new Client();
            client.setClient_id(rs.getInt("client_id"));
            client.setEmail(rs.getString("email"));
            client.setName(rs.getString("name"));
            client.setLast_name(rs.getString("last_name"));
            client.setRole_client_id(rs.getInt("role_client_id"));
            clients.add(client);
        }
        return clients;
    }

    public Client getByEmail(String email) throws SQLException, URISyntaxException {
        Client client = new Client();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from client where email='" + email + "'");
        while (rs.next()) {
            client.setClient_id(rs.getInt("client_id"));
            client.setEmail(rs.getString("email"));
            client.setName(rs.getString("name"));
            client.setLast_name(rs.getString("last_name"));
            client.setRole_client_id(rs.getInt("role_client_id"));
        }
        return client;
    }
}
