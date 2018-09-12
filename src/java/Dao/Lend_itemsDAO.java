/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Lend_items;
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
 * @author FiJus
 */
public class Lend_itemsDAO {

    private Connection connection;

    public Lend_itemsDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void createLend_items(Lend_items lend_items) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into lend_items(lend_id,asset_store_id,lend_quantity,devolution_quantity) values (?,?,?,0)");
        preparedStatement.setInt(1, lend_items.getLend_id());
        preparedStatement.setInt(2, lend_items.getAsset_store_id());
        preparedStatement.setInt(3, lend_items.getLend_quantity());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Lend_items> readLend_items(int lend_id) throws SQLException {
        ArrayList<Lend_items> lend_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend_items where lend_id=" + lend_id);
        while (rs.next()) {
            Lend_items lend_items = new Lend_items();
            lend_items.setLend_id(lend_id);
            lend_items.setAsset_store_id(rs.getInt("asset_store_id"));
            lend_items.setCalification(rs.getInt("calification"));
            lend_items.setLend_quantity(rs.getInt("lend_quantity"));
            lend_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            lend_itemss.add(lend_items);
        }
        return lend_itemss;
    }

    public ArrayList<Lend_items> getAllLend_items() throws SQLException {
        ArrayList<Lend_items> lend_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend_items");
        while (rs.next()) {
            Lend_items lend_items = new Lend_items();
            lend_items.setLend_id(rs.getInt("lend_id"));
            lend_items.setAsset_store_id(rs.getInt("asset_store_id"));
            lend_items.setCalification(rs.getInt("calification"));
            lend_items.setLend_quantity(rs.getInt("lend_quantity"));
            lend_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            lend_itemss.add(lend_items);
        }
        return lend_itemss;
    }

    
    public ArrayList<Lend_items> getAllLend_items(int lend_id) throws SQLException {
        ArrayList<Lend_items> lend_itemss = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend_items where lend_id="+lend_id);
        while (rs.next()) {
            Lend_items lend_items = new Lend_items();
            lend_items.setLend_id(rs.getInt("lend_id"));
            lend_items.setAsset_store_id(rs.getInt("asset_store_id"));
            lend_items.setCalification(rs.getInt("calification"));
            lend_items.setLend_quantity(rs.getInt("lend_quantity"));
            lend_items.setDevolution_quantity(rs.getInt("devolution_quantity"));
            lend_itemss.add(lend_items);
        }
        return lend_itemss;
    }
    
    public void devolution(int lend_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend_items where lend_id=" + lend_id);
        while (rs.next()) {
            int lend_quantity=rs.getInt("lend_quantity");
            int asset_store_id=rs.getInt("asset_store_id");
            PreparedStatement preparedStatement = connection.prepareStatement("update lend_items set devolution_quantity=? where lend_quantity="+lend_quantity+" and asset_store_id="+asset_store_id);
            preparedStatement.setInt(1, lend_quantity);
            preparedStatement.executeUpdate();
        }
    }
}
