/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Store;
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
public class StoreDAO {

    private Connection connection;

    public StoreDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void createStore(Store store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into store(company,name,sell,lend,rental,address,phone_1,phone_2,email,principal,deleted,create_date) values (?,?,?,?,?,?,?,?,?,?,false,?)");
        preparedStatement.setString(1, store.getCompany());
        preparedStatement.setString(2, store.getName());
        preparedStatement.setBoolean(3, store.isSell());
        preparedStatement.setBoolean(4, store.isLend());
        preparedStatement.setBoolean(5, store.isRental());
        preparedStatement.setString(6, store.getAddress());
        preparedStatement.setString(7, store.getPhone_1());
        preparedStatement.setString(8, store.getPhone_2());
        preparedStatement.setString(9, store.getEmail());
        preparedStatement.setBoolean(10, store.isPrincipal());
        preparedStatement.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public Store readStore(int store_id) throws SQLException, URISyntaxException {
        Store store = new Store();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from store where deleted=false and store_id=" + store_id);
        while (rs.next()) {
            store.setStore_id(rs.getInt("store_id"));
            store.setCompany(rs.getString("company"));
            store.setName(rs.getString("name"));
            store.setSell(rs.getBoolean("sell"));
            store.setLend(rs.getBoolean("lend"));
            store.setRental(rs.getBoolean("rental"));
            store.setAddress(rs.getString("address"));
            store.setPhone_1(rs.getString("phone_1"));
            store.setPhone_2(rs.getString("phone_2"));
            store.setEmail(rs.getString("email"));
            store.setPrincipal(rs.getBoolean("principal"));
        }
        return store;
    }

    public void updateStore(Store store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update store set name=?,sell=?,lend=?,rental=?,address=?,phone_1=?,phone_2=?,email=?,principal=?" + " where store_id=?");
        preparedStatement.setString(1, store.getName());
        preparedStatement.setBoolean(2, store.isSell());
        preparedStatement.setBoolean(3, store.isLend());
        preparedStatement.setBoolean(4, store.isRental());
        preparedStatement.setString(5, store.getAddress());
        preparedStatement.setString(6, store.getPhone_1());
        preparedStatement.setString(7, store.getPhone_2());
        preparedStatement.setString(8, store.getEmail());
        preparedStatement.setBoolean(9, store.isPrincipal());
        preparedStatement.setInt(10, store.getStore_id());
        preparedStatement.executeUpdate();
    }

    public void deleteStore(int store_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update store set deleted=true,elimination_date=? where store_id=" + store_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }
}
