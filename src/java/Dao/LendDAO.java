/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Lend;
import Util.DbUtil;
import Util.Lend_report;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FiJus
 */
public class LendDAO {

    private Connection connection;

    public LendDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public int createLend(Lend lend) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into lend(admin_role_store_id,client_id,start_date,end_date,deleted) values (?,?,?,?,false)");
        preparedStatement.setInt(1, lend.getAdmin_role_store_id());
        preparedStatement.setInt(2, lend.getClient_id());
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setDate(4, new java.sql.Date(lend.getEnd_date().getTime()));
        preparedStatement.executeUpdate();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select MAX(lend_id) as lend_id,start_date from lend");
        while (rs.next()) {
            return rs.getInt("lend_id");
        }
        return 0;
    }

    public Lend readLend(int lend_id) throws SQLException {
        Lend lend = new Lend();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend where lend_id=" + lend_id);
        while (rs.next()) {
            lend.setLend_id(lend_id);
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            lend.setDevolution_date(new Date(((Timestamp) rs.getObject("devolution_date")).getTime()));
            lend.setEnd_date(new Date(((Timestamp) rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
        }
        return lend;
    }

    public ArrayList<Lend> getAllLend() throws SQLException {
        ArrayList<Lend> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend");
        while (rs.next()) {
            Lend lend = new Lend();
            lend.setLend_id(rs.getInt("lend_id"));
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            lend.setDevolution_date(new Date(((Timestamp) rs.getObject("devolution_date")).getTime()));
            lend.setEnd_date(new Date(((Timestamp) rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
            lends.add(lend);
        }
        return lends;
    }

    public ArrayList<Lend> getInactiveLendByClient(int client_id) throws SQLException {
        ArrayList<Lend> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend where deleted=true and client_id=" + client_id);
        while (rs.next()) {
            Lend lend = new Lend();
            lend.setLend_id(rs.getInt("lend_id"));
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            //      lend.setDevolution_date(new Date(((Timestamp)rs.getObject("devolution_date")).getTime()));
            //      lend.setEnd_date(new Date(((Timestamp)rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
            lends.add(lend);
        }
        return lends;
    }

    public ArrayList<Lend> getActiveLends() throws SQLException {
        ArrayList<Lend> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend where deleted=false");
        while (rs.next()) {
            Lend lend = new Lend();
            lend.setLend_id(rs.getInt("lend_id"));
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
//            lend.setDevolution_date(new Date(((Timestamp)rs.getObject("devolution_date")).getTime()));
            lend.setEnd_date(new Date(((Timestamp) rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
            lends.add(lend);
        }
        return lends;
    }

    public ArrayList<Lend_report> getActiveLendsFull() throws SQLException {
        ArrayList<Lend_report> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select client.name,client.last_name,lend.start_date,COUNT(lend_items.asset_store_id) as cuenta "
                + "from client,lend,lend_items where lend.deleted=false and client.client_id=lend.client_id and lend.lend_id=lend_items.lend_id "
                + "group by lend_items.lend_id");
        while (rs.next()) {
            Lend_report lend = new Lend_report();
            lend.setName(rs.getString("name"));
            lend.setLast_name(rs.getString("last_name"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            lend.setCuenta(rs.getInt("cuenta"));
            lends.add(lend);
        }
        return lends;
    }

    public ArrayList<Lend> getInactiveLends() throws SQLException {
        ArrayList<Lend> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend where deleted=true");
        while (rs.next()) {
            Lend lend = new Lend();
            lend.setLend_id(rs.getInt("lend_id"));
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            //           lend.setDevolution_date(new Date(((Timestamp)rs.getObject("devolution_date")).getTime()));
            //           lend.setEnd_date(new Date(((Timestamp)rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
            lends.add(lend);
        }
        return lends;
    }

    public ArrayList<Lend> getActiveLendByClient(int client_id) throws SQLException {
        ArrayList<Lend> lends = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from lend where deleted=false and client_id=" + client_id);
        while (rs.next()) {
            Lend lend = new Lend();
            lend.setLend_id(rs.getInt("lend_id"));
            lend.setAdmin_role_store_id(rs.getInt("admin_role_store_id"));
            lend.setClient_id(rs.getInt("client_id"));
            lend.setStart_date(new Date(((Timestamp) rs.getObject("start_date")).getTime()));
            //          lend.setDevolution_date(new Date(((Timestamp)rs.getObject("devolution_date")).getTime()));
            //          lend.setEnd_date(new Date(((Timestamp)rs.getObject("end_date")).getTime()));
            lend.setClient_calification(rs.getInt("client_calification"));
            lend.setAdmin_calification(rs.getInt("admin_calification"));
            lends.add(lend);
        }
        return lends;
    }

    public int getAll_lends_ended() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select count(lend.deleted) as count from lend where lend.deleted = true");
        int total = 0;
        while (rs.next()) {
            total = rs.getInt("count");
        }
        return total;

    }

    public void finishLend(int lend_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update lend set end_date=?,deleted=true where lend_id=" + lend_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public void updateEnd_date(Lend lend) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update lend set end_date=? where lend_id='" + lend.getLend_id() + "'");
        preparedStatement.setDate(1, new java.sql.Date(lend.getEnd_date().getTime()));
        preparedStatement.executeUpdate();

    }
}
