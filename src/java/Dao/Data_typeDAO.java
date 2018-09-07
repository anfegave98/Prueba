/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Data_type;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anfeg
 */
public class Data_typeDAO {
    
    private Connection connection;

    public Data_typeDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void createData_type(Data_type data_type) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into data_type(title,db_type) values (?,?)");
        preparedStatement.setString(1, data_type.getTitle());
        preparedStatement.setString(2, data_type.getDb_type());
        preparedStatement.executeUpdate();
    }

    public Data_type readData_type(int data_type_id) throws SQLException, URISyntaxException {
        Data_type data_type = new Data_type();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from data_type where data_type_id=" + data_type_id);
        while (rs.next()) {
            data_type.setData_type_id(rs.getInt("data_type_id"));
            data_type.setTitle(rs.getString("title"));
            data_type.setDb_type(rs.getString("db_type"));       
        }
        return data_type;
    }

    public void updateData_type(Data_type data_type) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update data_type set title=?,db_type=?" + " where data_type_id=?");
        preparedStatement.setString(1, data_type.getTitle());
        preparedStatement.setString(2, data_type.getDb_type());      
        preparedStatement.setInt(3, data_type.getData_type_id());
        preparedStatement.executeUpdate();
    }

    public void deleteData_type(int data_type_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from data_type where data_type_id=" + data_type_id);
        preparedStatement.executeUpdate();
    }
}
