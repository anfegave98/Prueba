/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Dynamic_asset;
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
public class Dynamic_assetDAO {
     private Connection connection;

    public Dynamic_assetDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addDynamic_asset(Dynamic_asset dynamic_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into dynamic_asset(asset_id,service_asset_id,text) values (?,?,?)");
        preparedStatement.setInt(1, dynamic_asset.getClient_id());
        preparedStatement.setInt(2, dynamic_asset.getClient_data_id());
        preparedStatement.setString(3, dynamic_asset.getText());
        preparedStatement.executeUpdate();
    }
    
    public void updateDynamic_asset(Dynamic_asset dynamic_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update dynamic_asset set text=?" + " where asset_id=? and asset_data_id=?");
        preparedStatement.setString(1, dynamic_asset.getText());
        preparedStatement.setInt(2, dynamic_asset.getClient_id());
        preparedStatement.setInt(2, dynamic_asset.getClient_data_id());
        preparedStatement.executeUpdate();
    }
    
    public Dynamic_asset readDynamic_asset(int asset_id,int asset_data_id) throws SQLException {
        Dynamic_asset dynamic_asset=new Dynamic_asset();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_asset where asset_data_id="+asset_data_id+" and asset_id="+asset_id);
        while(rs.next()){
            dynamic_asset.setClient_id(asset_id);
            dynamic_asset.setClient_data_id(asset_data_id);
            dynamic_asset.setText(rs.getString("text"));
        }
        return dynamic_asset;
    }
    
    public ArrayList<Dynamic_asset> getAllDynamic_asset() throws SQLException {
        ArrayList<Dynamic_asset> dynamic_assets=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from dynamic_asset");
        while(rs.next()){
            Dynamic_asset dynamic_asset=new Dynamic_asset();
            dynamic_asset.setClient_id(rs.getInt("asset_id"));
            dynamic_asset.setClient_data_id(rs.getInt("asset_data_id"));
            dynamic_asset.setText(rs.getString("text"));
            dynamic_assets.add(dynamic_asset);
        }
        return dynamic_assets;
    }
}

