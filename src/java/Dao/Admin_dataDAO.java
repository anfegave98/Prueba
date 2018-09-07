/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Admin_data;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author anfeg
 */
public class Admin_dataDAO {

    private Connection connection;

    public Admin_dataDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void createAdmin_data(Admin_data admin_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into admin_data(title,data_type_id,login,obligatory) values (?,?,?,?)");
        preparedStatement.setString(1, admin_data.getTitle());
        preparedStatement.setInt(2, admin_data.getData_type_id());
        preparedStatement.setBoolean(3, admin_data.isLogin());
        preparedStatement.setBoolean(4, admin_data.isObligatory());
        preparedStatement.executeUpdate();
    }

    public Admin_data readAdmin_data(int admin_data_id) throws SQLException, URISyntaxException {
        Admin_data admin_data = new Admin_data();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from admin_data where admin_data_id=" + admin_data_id);
        while (rs.next()) {
            admin_data.setAdmin_data_id(rs.getInt("admin_data_id"));
            admin_data.setTitle(rs.getString("title"));
            admin_data.setData_type_id(rs.getInt("data_type_id"));
            admin_data.setLogin(rs.getBoolean("login"));
            admin_data.setObligatory(rs.getBoolean("obligatory"));
        }
        return admin_data;
    }

    public void updateAdmin_data(Admin_data admin_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update admin_data set title=?,data_type_id=?,login=?,obligatory=?" + " where admin_data_id=?");
        preparedStatement.setString(1, admin_data.getTitle());
        preparedStatement.setInt(2, admin_data.getData_type_id());
        preparedStatement.setBoolean(3, admin_data.isLogin());
        preparedStatement.setBoolean(4, admin_data.isObligatory());
        preparedStatement.setInt(5, admin_data.getAdmin_data_id());
        preparedStatement.executeUpdate();
    }

    public void deleteAdmin_data(int admin_data_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from admin_data where admin_data_id=" + admin_data_id);
        preparedStatement.executeUpdate();
    }

}
