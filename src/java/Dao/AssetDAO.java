/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset;
import Model.Asset_store;
import Util.Asset_available_report;
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
        
        PreparedStatement preparedStatement = connection.prepareStatement("insert into asset(name,codebar,principal_picture,description,creation_date,deleted) values (?,?,?,?,?,false)");
        preparedStatement.setString(1, asset.getName());
        preparedStatement.setString(2, asset.getCodebar());
        preparedStatement.setString(3, asset.getPrincipal_picture());
        preparedStatement.setString(4, asset.getDescription());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        
        return true;

    }

    public void deleteAsset(String codebar) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset set deleted=true,elimination_date=? where codebar=" + codebar);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void updateAsset(Asset asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update asset set name=?,codebar=?,principal_picture=?,description=?,modification_date=?" + " where asset_id=?");
        preparedStatement.setString(1, asset.getName());
        preparedStatement.setString(2, asset.getCodebar());
        preparedStatement.setString(3, asset.getPrincipal_picture());
        preparedStatement.setString(4, asset.getDescription());
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(6, asset.getAsset_id());
        preparedStatement.executeUpdate();
    }

    public Asset readAsset(int asset_id) throws SQLException {
        Asset asset = new Asset();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset where deleted=false and asset_id=" + asset_id);
        while (rs.next()) {
            asset.setAsset_id(asset_id);
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
        }
        return asset;
    }

    public Asset readAssetByCodebar(String codebar) throws SQLException {
        Asset asset = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset where deleted=false and codebar='" + codebar + "'");
        while (rs.next()) {
            asset = new Asset();
            asset.setAsset_id(rs.getInt("asset_id"));
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            ResultSet r=statement.executeQuery("select available,no_available from asset_store where asset_id="+asset.getAsset_id());
            while(r.next()){
                asset.setAvailable(r.getInt("availables")-rs.getInt("no_availables"));
            }
        }
        if (asset == null) {
            asset = new Asset();
            asset.setCodebar("0");
        }
        return asset;
    }

    public int rASidBCS(String codebar, int store_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select asset_store.asset_store_id from asset,asset_store where asset.asset_id=asset_store.asset_id"
                + " and asset.codebar='" + codebar + "' and asset.store_id=" + store_id);
        while (rs.next()) {
            return rs.getInt("asset_store_id");
        }

        return 0;
    }

    public ArrayList<Asset> getAllAsset() throws SQLException {
        ArrayList<Asset> assets = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset where deleted=false");
        while (rs.next()) {
            Asset asset = new Asset();
            asset.setAsset_id(rs.getInt("asset_id"));
            //asset.setAsset_parent_id(rs.getInt("asset_parent_id"));
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            assets.add(asset);
        }
        return assets;
    }

    public ArrayList<Asset_available_report> getAllAvailable() throws SQLException {
        ArrayList<Asset_available_report> assets = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select asset.name as name, asset_store.asset_store_id, asset.codebar as codebar, asset.principal_picture,asset.description,asset_store.available,asset_store.no_available from asset, asset_store where asset.asset_id=asset_store.asset_id and asset.deleted = false and asset_store.deleted=false");
        while (rs.next()) {
            Asset_available_report asset = new Asset_available_report();
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            asset.setAvailable(rs.getInt("available"));
            asset.setNo_available(rs.getInt("no_available"));
            asset.setAsset_store_id(rs.getInt("asset_store_id"));
            assets.add(asset);
        }
        return assets;
    }

    public boolean getCodebar(String codebar) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from asset where codebar='" + codebar + "'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public Asset_available_report getOneAvailable(int asset_id) throws SQLException {
        Asset_available_report asset = new Asset_available_report();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select asset.name as name, asset_store.asset_store_id, asset.codebar as codebar, asset.principal_picture,asset.description,asset_store.available,asset_store.no_available from asset, asset_store where asset.asset_id=asset_store.asset_id and asset.deleted = false and asset_store.deleted=false and asset_store.asset_store_id=" + asset_id);
        while (rs.next()) {

            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            asset.setAvailable(rs.getInt("available"));
            asset.setNo_available(rs.getInt("no_available"));
            asset.setAsset_store_id(rs.getInt("asset_store_id"));
        }
        return asset;
    }

    public Asset_available_report getOneAvailable(String codebar) throws SQLException {
        Asset_available_report asset = new Asset_available_report();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select asset.name as name, asset.codebar as codebar, asset.principal_picture,asset.description,asset_store.available,asset_store.no_available,asset_store.asset_store_id from asset, asset_store where asset.asset_id=asset_store.asset_id and asset.deleted = false and asset_store.deleted=false and asset.codebar='" + codebar + "'");
        while (rs.next()) {
            asset.setName(rs.getString("name"));
            asset.setCodebar(rs.getString("codebar"));
            asset.setPrincipal_picture(rs.getString("principal_picture"));
            asset.setDescription(rs.getString("description"));
            asset.setAsset_store_id(rs.getInt("asset_store_id"));
            asset.setAvailable(rs.getInt("available"));
            asset.setNo_available(rs.getInt("no_available"));
        }
        return asset;
    }
}
