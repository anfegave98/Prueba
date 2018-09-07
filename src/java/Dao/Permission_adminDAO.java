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

/**
 *
 * @author anfeg
 */
public class Permission_adminDAO {
    
    private Connection connection;

    public Permission_adminDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void createPermission_admin(Permission_admin permission_admin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into permission_admin(role_admin_id,service_admin) values (?,?)");
        preparedStatement.setInt(1, permission_admin.getRole_admin_id());
        preparedStatement.setInt(2, permission_admin.getService_admin_id());
        preparedStatement.executeUpdate();
    }
}
