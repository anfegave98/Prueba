/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Service_admin;
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
public class Service_adminDAO {
    private Connection connection;

    public Service_adminDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addService_admin(Service_admin service_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into service_admin(name,deleted) values (?,false)");
        preparedStatement.setString(1, service_admin.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteService_admin(int service_admin_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update service_admin set deleted=true where service_admin_id=" + service_admin_id);
        preparedStatement.executeUpdate();
    }

    public void updateService_admin(Service_admin service_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update service_admin set name=?" + " where service_admin_id=?");
        preparedStatement.setString(1, service_admin.getName());
        preparedStatement.setInt(2, service_admin.getService_admin_id());
        preparedStatement.executeUpdate();
    }

    public Service_admin readService_admin(int service_admin_id) throws SQLException {
        Service_admin service_admin=new Service_admin();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from service_admin where deleted=false and service_admin_id="+service_admin_id);
        while(rs.next()){
            service_admin.setService_admin_id(rs.getInt("service_admin_id"));
            service_admin.setName(rs.getString("name"));
        }
        return service_admin;
    }
    
    public ArrayList<Service_admin> getAllService_admin() throws SQLException {
        ArrayList<Service_admin> service_admins=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from service_admin where deleted=false");
        while(rs.next()){
            Service_admin service_admin=new Service_admin();
            service_admin.setService_admin_id(rs.getInt("service_admin_id"));
            service_admin.setName(rs.getString("name"));
            service_admins.add(service_admin);
        }
        return service_admins;
    }
}

