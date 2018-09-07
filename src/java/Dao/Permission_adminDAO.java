/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Permission_admin;
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
public class Permission_adminDAO {
    private Connection connection;

    public Permission_adminDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addPermission_admin(Permission_admin permission_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into permission_admin(role_admin_id,service_admin_id) values (?,?)");
        preparedStatement.setInt(1, permission_admin.getRole_admin_id());
        preparedStatement.setInt(2, permission_admin.getService_admin_id());
        preparedStatement.executeUpdate();
    }
    
    public ArrayList<Permission_admin> getAllPermission_admin() throws SQLException {
        ArrayList<Permission_admin> permission_admins=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from permission_admin");
        while(rs.next()){
            Permission_admin permission_admin=new Permission_admin();
            permission_admin.setRole_admin_id(rs.getInt("role_admin_id"));
            permission_admin.setService_admin_id(rs.getInt("service_admin_id"));
            permission_admins.add(permission_admin);
        }
        return permission_admins;
    }
}
