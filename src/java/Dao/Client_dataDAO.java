/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client_data;
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
public class Client_dataDAO {
    private Connection connection;

    public Client_dataDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addClient_data(Client_data client_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into client_data(title,data_type_id,login,obligatory) values (?,?,?,?)");
        preparedStatement.setString(1, client_data.getTitle());
        preparedStatement.setInt(2, client_data.getData_type_id());
        preparedStatement.setBoolean(3, client_data.isLogin());
        preparedStatement.setBoolean(4, client_data.isObligatory());
        preparedStatement.executeUpdate();
    }

    public void deleteClient_data(int client_data_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from client_data where client_data_id=" + client_data_id);
        preparedStatement.executeUpdate();
    }

    public void updateClient_data(Client_data client_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update client_data set title=?,data_type_id=?,login=?,obligatory=?" + " where client_data_id=?");
        preparedStatement.setString(1, client_data.getTitle());
        preparedStatement.setInt(2, client_data.getData_type_id());
        preparedStatement.setBoolean(3, client_data.isLogin());
        preparedStatement.setBoolean(4, client_data.isObligatory());
        preparedStatement.setInt(5, client_data.getClient_data_id());
        preparedStatement.executeUpdate();
    }

    public Client_data readClient_data(int client_data_id) throws SQLException {
        Client_data client_data=new Client_data();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from client_data where client_data_id="+client_data_id);
        while(rs.next()){
            client_data.setClient_data_id(client_data_id);
            client_data.setTitle(rs.getString("title"));
            client_data.setData_type_id(rs.getInt("data_type_id"));
            client_data.setLogin(rs.getBoolean("login"));
            client_data.setObligatory(rs.getBoolean("obligatory"));            
        }
        return client_data;
    }
    
    public ArrayList<Client_data> getAllClient_data() throws SQLException {
        ArrayList<Client_data> client_datas=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from client_data where deleted=false");
        while(rs.next()){
            Client_data client_data=new Client_data();
            client_data.setClient_data_id(rs.getInt("client_data_id"));
            client_data.setTitle(rs.getString("title"));
            client_data.setData_type_id(rs.getInt("data_type_id"));
            client_data.setLogin(rs.getBoolean("login"));
            client_data.setObligatory(rs.getBoolean("obligatory"));  
            client_datas.add(client_data);
        }
        return client_datas;
    }
}
