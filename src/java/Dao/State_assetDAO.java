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
import java.util.ArrayList;

/**
 *
 * @author anfeg
 */
public class State_assetDAO {

    private Connection connection;

    public State_assetDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public int createState_asset(State_asset state_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into state_asset(admin_id,description,creation_date,deleted) values (?,?,?,false)");
        preparedStatement.setInt(1, state_asset.getAdmin_id());
        preparedStatement.setString(2, state_asset.getDescription());
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select MAX(state_asset_id) as state_asset_id,creation_date from state_asset");
        while (rs.next()) {
            return rs.getInt("state_asset_id");
        }
        return 0;

    }

    public State_asset readState_asset(int state_asset_id) throws SQLException, URISyntaxException {
        State_asset state_asset = new State_asset();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_asset where deleted=false and state_asset_id=" + state_asset_id);
        while (rs.next()) {
            state_asset.setState_asset_id(rs.getInt("state_asset_id"));
            state_asset.setDescription(rs.getString("description"));
            state_asset.setCreation_date(new Date(((Timestamp) rs.getObject("creation_date")).getTime()));
            state_asset.setAdmin_id(rs.getInt("admin_id"));
        }
        return state_asset;
    }

    public void updateState_asset(State_asset state_asset) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update state_asset set description=?,admin_id=?,deleted=?" + " where state_asset_id=?");
        preparedStatement.setString(1, state_asset.getDescription());
        preparedStatement.setInt(2, state_asset.getAdmin_id());
        preparedStatement.setBoolean(3, state_asset.isDeleted());
        preparedStatement.setInt(4, state_asset.getState_asset_id());
        preparedStatement.executeUpdate();
    }

    public int State_asset_quantity_by_ASID(int asset_store_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select sum(state_asset.quantity) - sum(state_asset.devolution_quantity) as 'maintenance' from state_asset,asset_store,asset \n"
                + "where asset.asset_id=asset_store.asset_id and asset_store.asset_store_id = state_asset.asset_store_id and asset_store.asset_store_id = " + asset_store_id + "\n"
                + "and state_asset.deleted = false");
        int quantity = 0;
        while (rs.next()) {
            quantity = rs.getInt("maintenance");
        }
        return quantity;

    }

    public ArrayList<State_asset> getActiveState_assets() throws SQLException {
        ArrayList<State_asset> state_assets = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_asset where deleted=false");
        while (rs.next()) {
            State_asset state_asset = new State_asset();
            state_asset.setState_asset_id(rs.getInt("state_asset_id"));
            state_asset.setAdmin_id(rs.getInt("admin_id"));
            state_asset.setDescription(rs.getString("description"));
            state_asset.setCreation_date(new Date(((Timestamp) rs.getObject("creation_date")).getTime()));
            state_assets.add(state_asset);
        }
        return state_assets;
    }

}
