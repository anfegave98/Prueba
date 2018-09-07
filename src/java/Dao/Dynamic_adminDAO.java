/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Dynamic_admin;
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
public class Dynamic_adminDAO {
     private Connection connection;

    public Dynamic_adminDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addDynamic_admin(Dynamic_admin dynamic_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into dynamic_admin(admin_id,service_admin_id,text) values (?,?,?)");
        preparedStatement.setInt(1, dynamic_admin.getAdmin_id());
        preparedStatement.setInt(2, dynamic_admin.getAdmin_data_id());
        preparedStatement.setString(3, dynamic_admin.getText());
        preparedStatement.executeUpdate();
    }
    
    public void updateDynamic_admin(Dynamic_admin dynamic_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update dynamic_admin set text=?" + " where admin_id=? and admin_data_id=?");
        preparedStatement.setString(1, dynamic_admin.getText());
        preparedStatement.setInt(2, dynamic_admin.getAdmin_id());
        preparedStatement.setInt(2, dynamic_admin.getAdmin_data_id());
        preparedStatement.executeUpdate();
    }
    
    public Dynamic_admin readDynamic_admin(int admin_id,int admin_data_id) throws SQLException {
        Dynamic_admin dynamic_admin=new Dynamic_admin();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_admin where admin_data_id="+admin_data_id+" and admin_id="+admin_id);
        while(rs.next()){
            dynamic_admin.setAdmin_id(admin_id);
            dynamic_admin.setAdmin_data_id(admin_data_id);
            dynamic_admin.setText(rs.getString("text"));
        }
        return dynamic_admin;
    }
    
    public ArrayList<Dynamic_admin> getAllDynamic_admin() throws SQLException {
        ArrayList<Dynamic_admin> dynamic_admins=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_admin");
        while(rs.next()){
            Dynamic_admin dynamic_admin=new Dynamic_admin();
            dynamic_admin.setAdmin_id(rs.getInt("admin_id"));
            dynamic_admin.setAdmin_data_id(rs.getInt("admin_data_id"));
            dynamic_admin.setText(rs.getString("text"));
            dynamic_admins.add(dynamic_admin);
        }
        return dynamic_admins;
    }
}
