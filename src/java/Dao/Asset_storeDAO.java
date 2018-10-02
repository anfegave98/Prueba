/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset_store;
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
public class Asset_storeDAO {

    private Connection connection;

    public Asset_storeDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void createAsset_store(Asset_store asset_store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asset_store(asset_id,store_id,available,no_available,creation_date,deleted) values (?,?,?,0,?,false)");
        preparedStatement.setInt(1, asset_store.getAsset_id());
        preparedStatement.setInt(2, asset_store.getStore_id());
        preparedStatement.setInt(3, asset_store.getAvaliable());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void deleteAsset_store(int asset_id, int store_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset_store set deleted=true,elimination_date=? where asset_id=" + asset_id + " and store_id=" + store_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void updateAsset_store(Asset_store asset_store) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset_store set available=?,no_available=?" + " where asset_store_id=?");
        preparedStatement.setInt(1, asset_store.getAvaliable());
        preparedStatement.setInt(2, asset_store.getNo_avaliable());
        preparedStatement.setInt(3, asset_store.getAsset_store_id());
        preparedStatement.executeUpdate();
    }

    public Asset_store readAsset_store(int asset_id, int store_id) throws SQLException, URISyntaxException {
        Asset_store asset_store = new Asset_store();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset_store where deleted=false and asset_id=" + asset_id + " and store_id=" + store_id);
        while (rs.next()) {
            asset_store.setAsset_store_id(rs.getInt("asset_store_id"));
            asset_store.setAsset_id(rs.getInt("asset_id"));
            asset_store.setStore_id(rs.getInt("store_id"));
            asset_store.setAvaliable(rs.getInt("available"));
            asset_store.setNo_avaliable(rs.getInt("no_available"));
        }
        return asset_store;
    }
    
    public Asset_store readAsset_store(int asset_store_id) throws SQLException, URISyntaxException {
        Asset_store asset_store = new Asset_store();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset_store where deleted=false and asset_store_id=" + asset_store_id );
        while (rs.next()) {                              
            asset_store.setAsset_store_id(rs.getInt("asset_store_id"));
            asset_store.setAsset_id(rs.getInt("asset_id"));
            asset_store.setStore_id(rs.getInt("store_id"));
            asset_store.setAvaliable(rs.getInt("available"));
            asset_store.setNo_avaliable(rs.getInt("no_available"));
        }
        return asset_store;
    }
    
    public ArrayList<Asset_store> readAsset_store() throws SQLException, URISyntaxException {
        ArrayList<Asset_store> asset_stores=new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset_store where deleted=false");
        while (rs.next()) {
            Asset_store asset_store = new Asset_store();
            asset_store.setAsset_store_id(rs.getInt("asset_store_id"));
            asset_store.setAsset_id(rs.getInt("asset_id"));
            asset_store.setStore_id(rs.getInt("store_id"));
            asset_store.setAvaliable(rs.getInt("avaliable"));
            asset_store.setNo_avaliable(rs.getInt("no_avaliable"));
            asset_stores.add(asset_store);
        }
        return asset_stores;
    }

}
