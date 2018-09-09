/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset;
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
public class AssetDAO {
     private Connection connection;

    public AssetDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public boolean createAsset(Asset asset) throws SQLException {
        if(asset.getAsset_parent_id()== 0){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into asset(asset_parent_id,name,codebar,principal_picture,description,creation_date,deleted) values (NULL,?,?,?,?,?,false)");
        preparedStatement.setString(1, asset.getName());
        preparedStatement.setString(2, asset.getPrincipal_picture());
        preparedStatement.setString(3, asset.getCodebar());
        preparedStatement.setString(4, asset.getDescription());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        }else{
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asset(asset_parent_id,name,principal_picture,description,creation_date,deleted) values (?,?,?,?,?,false)");
        preparedStatement.setInt(1, asset.getAsset_parent_id());
        preparedStatement.setString(2, asset.getName());
        preparedStatement.setString(3, asset.getPrincipal_picture());
        preparedStatement.setString(4, asset.getDescription());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        }
        return true;
        
    }

    public void deleteAsset(int asset_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset set deleted=true,elimination_date=? where asset_id=" + asset_id);
        preparedStatement.setTimestamp(1,  new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void updateAsset(Asset asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset set asset_parent_id=?,name=?,codebar,principal_picture=?,description=?,modification_date=?" + " where asset_id=?");
        preparedStatement.setInt(1, asset.getAsset_parent_id());
        preparedStatement.setString(2, asset.getName());
        preparedStatement.setString(3, asset.getCodebar());
        preparedStatement.setString(4, asset.getPrincipal_picture());
        preparedStatement.setString(5, asset.getDescription());
        preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(7, asset.getAsset_id());
        preparedStatement.executeUpdate();
    }

    public Asset readAsset(int asset_id) throws SQLException {
        Asset asset=new Asset();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from asset where deleted=false and asset_id="+asset_id);
        while(rs.next()){
            asset.setAsset_id(asset_id);
            asset.setAsset_parent_id(rs.getInt("asset_parent_id"));
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
        }
        return asset;
    }
    
    public ArrayList<Asset> getAllAsset() throws SQLException {
        ArrayList<Asset> assets=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from asset where deleted=false");
        while(rs.next()){
            Asset asset=new Asset();
            asset.setAsset_id(rs.getInt("asset_id"));
            asset.setAsset_parent_id(rs.getInt("asset_parent_id"));
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            assets.add(asset);
        }
        return assets;
    }
    public boolean getName(String name) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset where name='" +name+"'");
        while (rs.next()) {
            return true;
        }
        return false;
    }
}
