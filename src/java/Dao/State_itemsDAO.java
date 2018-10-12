/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.State_items;
import Util.DbUtil;
//import Util.State_items_report;
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
 * @author FiJus
 */
public class State_itemsDAO {

    private Connection connection;

    public State_itemsDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void createState_items(State_items state_items) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into state_items(state_asset_id,asset_store_id,quantity,devolution_quantity) values (?,?,?,0)");
        preparedStatement.setInt(1, state_items.getState_asset_id());
        preparedStatement.setInt(2, state_items.getAsset_store_id());
        preparedStatement.setInt(3, state_items.getQuantity());
        preparedStatement.setInt(4, state_items.getDevolution_quantity());
        preparedStatement.executeUpdate();
    }

    public ArrayList<State_items> readState_items(int state_asset_id) throws SQLException {
        ArrayList<State_items> state_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_items where state_asset_id=" + state_asset_id);
        while (rs.next()) {
            State_items state_items = new State_items();
            state_items.setState_asset_id(state_asset_id);
            state_items.setAsset_store_id(rs.getInt("asset_store_id"));
            state_items.setQuantity(rs.getInt("quantity"));
            state_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            state_itemss.add(state_items);
        }
        return state_itemss;
    }

    public ArrayList<State_items> getAllState_items() throws SQLException {
        ArrayList<State_items> state_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_items");
        while (rs.next()) {
            State_items state_items = new State_items();
            state_items.setState_asset_id(rs.getInt("state_asset_id"));
            state_items.setAsset_store_id(rs.getInt("asset_store_id"));
            state_items.setQuantity(rs.getInt("quantity"));
            state_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            state_itemss.add(state_items);
        }
        return state_itemss;
    }

    public ArrayList<State_items> getAllState_items(int state_asset_id) throws SQLException {
        ArrayList<State_items> state_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_items where state_asset_id=" + state_asset_id);
        while (rs.next()) {
            State_items state_items = new State_items();
            state_items.setState_asset_id(rs.getInt("state_asset_id"));
            state_items.setAsset_store_id(rs.getInt("asset_store_id"));
            state_items.setQuantity(rs.getInt("quantity"));
            state_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            state_itemss.add(state_items);
        }
        return state_itemss;
    }

    public void devolution(int state_asset_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from state_items where state_asset_id=" + state_asset_id);
        while (rs.next()) {
            int quantity = rs.getInt("quantity");
            int asset_store_id = rs.getInt("asset_store_id");
            PreparedStatement preparedStatement = connection.prepareStatement("update state_items set devolution_quantity=? where quantity=" + quantity + " and asset_store_id=" + asset_store_id);
            preparedStatement.setInt(1, quantity);
            preparedStatement.executeUpdate();
        }
    }

//    public ArrayList<State_items_report> getBorrowed_times_store(int store_id) throws SQLException {
//        ArrayList<State_items_report> state_items_reports = new ArrayList<>();
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("select asset.name,asset.codebar,sum(state_items.state_quantity) as borrowed_times from state_items,asset_store,asset,store\n"
//                + "where asset.asset_id=asset_store.asset_id and asset_store.asset_store_id = state_items.asset_store_id and\n"
//                + "store.store_id = asset_store.store_id and store.store_id=" + store_id + "\n"
//                + "group by state_items.asset_store_id order by borrowed_times desc limit 5");
//        while (rs.next()) {
//            State_items_report state_items_report = new State_items_report();
//            state_items_report.setName(rs.getString("name"));
//            state_items_report.setCodebar(rs.getString("codebar"));
//            state_items_report.setBorrowed_times(rs.getInt("borrowed_times"));
//            state_items_reports.add(state_items_report);
//        }
//        return state_items_reports;
//    }
//
//    public int State_Items_quantity_by_ASID(int asset_store_id) throws SQLException {
//        int quantity = 0;
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("select sum(state_items.state_quantity) - sum(state_items.devolution_quantity) as 'in_state' from asset_store,state_items\n"
//                + "where asset_store.asset_store_id = state_items.asset_store_id and asset_store.asset_store_id ="+ asset_store_id);
//        while (rs.next()) {
//            quantity = rs.getInt("in_state");
//            
//        }
//        return quantity;

   // }

}
