/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Asset_store;
import Model.State_asset;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author anfeg
 */
public class State_assetDAO {

    private Connection connection;

    public State_assetDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public boolean createState_asset(State_asset state_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into state_asset(asset_store_id,quantity,description,creation_date,admin_id,devolution_quantity,deleted) values (?,?,?,?,?,0,false)");
        preparedStatement.setInt(1, state_asset.getAsset_store_id());
        preparedStatement.setInt(2, state_asset.getQuantity());
        preparedStatement.setString(3, state_asset.getDescription());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(5, state_asset.getAdmin_id());
        preparedStatement.executeUpdate();
        return true;
        
    }
    
    
    

    public State_asset readState_asset(int state_asset_id) throws SQLException, URISyntaxException {
        State_asset state_asset = new State_asset();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_asset where deleted=false and state_asset_id=" + state_asset_id);
        while (rs.next()) {
            state_asset.setState_asset_id(rs.getInt("state_asset_id"));
            state_asset.setAsset_store_id(rs.getInt("asset_store_id"));
            state_asset.setQuantity(rs.getInt("quantity"));
            state_asset.setDescription(rs.getString("description"));
            state_asset.setCreation_date(new Date(((Timestamp)rs.getObject("creation_date")).getTime()));
            state_asset.setAdmin_id(rs.getInt("admin_id"));
        }
        return state_asset;
    }

    public void updateState_asset(State_asset state_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update state_asset set asset_store_id=?,quantity=?,description=?,admin_id=?" + " where state_asset_id=?");
        preparedStatement.setInt(1, state_asset.getAsset_store_id());
        preparedStatement.setInt(2, state_asset.getQuantity());    
        preparedStatement.setString(3, state_asset.getDescription());
        preparedStatement.setInt(4, state_asset.getAdmin_id());
        preparedStatement.setInt(5, state_asset.getState_asset_id());
        preparedStatement.executeUpdate();
    }
    
    
        
    

    
    
    
    
    
}

