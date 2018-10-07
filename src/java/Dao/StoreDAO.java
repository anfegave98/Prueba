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
import java.util.ArrayList;

/**
 *
 * @author anfeg
 */
public class StoreDAO {

    private Connection connection;

    public StoreDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public Boolean createStore(Store store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into store(name,lend,address,phone_1,phone_2,email,principal,creation_date,deleted) values (?,?,?,?,?,?,?,?,false)");
        preparedStatement.setString(1, store.getName());
        preparedStatement.setBoolean(2, store.isLend());
        preparedStatement.setString(3, store.getAddress());
        preparedStatement.setString(4, store.getPhone_1());
        preparedStatement.setString(5, store.getPhone_2());
        preparedStatement.setString(6, store.getEmail());
        preparedStatement.setBoolean(7, store.isPrincipal());
        preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        return true;
    }

    public Store readStore(String name) throws SQLException, URISyntaxException {
        Store store = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from store where deleted=false and name='" + name+"'");
        while (rs.next()) {
            store=new Store();
            store.setStore_id(rs.getInt("store_id"));
            store.setName(rs.getString("name"));
            store.setLend(rs.getBoolean("lend"));
            store.setAddress(rs.getString("address"));
            store.setPhone_1(rs.getString("phone_1"));
            store.setPhone_2(rs.getString("phone_2"));
            store.setEmail(rs.getString("email"));
            store.setPrincipal(rs.getBoolean("principal"));
        }
        return store;
    }

    public Boolean updateStore(Store store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update store set address=?,phone_1=?,phone_2=?,email=? where name=?");
        preparedStatement.setString(1, store.getAddress());
        preparedStatement.setString(2, store.getPhone_1());
        preparedStatement.setString(3, store.getPhone_2());
        preparedStatement.setString(4, store.getEmail());
        preparedStatement.setString(5, store.getName());
        preparedStatement.executeUpdate();
        return true;
    }

    public Boolean deleteStore(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update store set deleted=true,elimination_date=? where name='" + name+"'");
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean existsOne() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from store where deleted=false");
        while(rs.next()){
            return true;
        }
        return false;
    }
    
    public boolean exists(String name) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery("select * from store where deleted=false and name='"+name+"'");
        while (rs.next()){
            return true;
        }
        return false;
    }

    public ArrayList<Store> readAll() throws SQLException {
        ArrayList<Store> stores = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery("select * from store where deleted=false");
        while (rs.next()){
            Store store=new Store();
            store.setStore_id(rs.getInt("store_id"));
            store.setName(rs.getString("name"));
            store.setLend(rs.getBoolean("lend"));
            store.setAddress(rs.getString("address"));
            store.setPhone_1(rs.getString("phone_1"));
            store.setPhone_2(rs.getString("phone_2"));
            store.setEmail(rs.getString("email"));
            store.setPrincipal(rs.getBoolean("principal"));
            stores.add(store);
        }
        return stores;
    }
    
}
