/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset_data;
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
public class Asset_dataDAO {
     private Connection connection;

    public Asset_dataDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addAsset_data(Asset_data asset_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asset_data(title,data_type_id) values (?,?)");
        preparedStatement.setString(1, asset_data.getTitle());
        preparedStatement.setInt(2, asset_data.getData_type_id());
        preparedStatement.executeUpdate();
    }

    public void deleteAsset_data(int asset_data_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from asset_data where asset_data_id=" + asset_data_id);
        preparedStatement.executeUpdate();
    }

    public void updateAsset_data(Asset_data asset_data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset_data set title=?,data_type_id=?" + " where asset_data_id=?");
        preparedStatement.setString(1, asset_data.getTitle());
        preparedStatement.setInt(2, asset_data.getData_type_id());
        preparedStatement.setInt(3, asset_data.getAsset_data_id());
        preparedStatement.executeUpdate();
    }

    public Asset_data readAsset_data(int asset_data_id) throws SQLException {
        Asset_data asset_data=new Asset_data();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from asset_data where asset_data_id="+asset_data_id);
        while(rs.next()){
            asset_data.setAsset_data_id(asset_data_id);
            asset_data.setTitle(rs.getString("title"));
            asset_data.setData_type_id(rs.getInt("data_type_id"));       
        }
        return asset_data;
    }
    
    public ArrayList<Asset_data> getAllAsset_data() throws SQLException {
        ArrayList<Asset_data> asset_datas=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from asset_data where deleted=false");
        while(rs.next()){
            Asset_data asset_data=new Asset_data();
            asset_data.setAsset_data_id(rs.getInt("asset_data_id"));
            asset_data.setTitle(rs.getString("title"));
            asset_data.setData_type_id(rs.getInt("data_type_id")); 
            asset_datas.add(asset_data);
        }
        return asset_datas;
    }
}
