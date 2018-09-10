/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset_store_report;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class Asset_store_reportDAO {
    
     private Connection connection;

    public Asset_store_reportDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    
    
    public ArrayList<Asset_store_report>  Generate_asset_store_report(int store_id) throws SQLException{
        ArrayList<Asset_store_report> asset_store_reports = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select asset.name, asset_store.available,state_asset.quantity as no_available,state_asset.description from asset,asset_store,state_asset where asset.asset_id = asset_store.asset_id and asset_store.asset_store_id = state_asset.asset_store_id and asset_store.store_id ="+store_id+ " and state_asset.deleted= false");
        while (rs.next()) {
            Asset_store_report asset_store_report = new Asset_store_report();
            asset_store_report.setName(rs.getString("name"));
            asset_store_report.setAvailable(rs.getInt("available"));
            asset_store_report.setNo_available(rs.getInt("no_available"));
            asset_store_report.setDescription("description");
            asset_store_reports.add(asset_store_report);
        }
        return asset_store_reports;
    }
    
}
