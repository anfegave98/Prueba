/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Sector;
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
public class SectorDAO {

    private Connection connection;

    public SectorDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void addSector(Sector sector) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into sector(name,deleted) values (?,false)");
        preparedStatement.setString(1, sector.getName());
        preparedStatement.executeUpdate();
    }

    public void deleteSector(int sector_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update sector set deleted=true where sector_id=" + sector_id);
        preparedStatement.executeUpdate();
    }

    public void updateSector(Sector sector) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update sector set name=?" + " where sector_id=?");
        preparedStatement.setString(1, sector.getName());
        preparedStatement.setInt(2, sector.getSector_id());
        preparedStatement.executeUpdate();
    }

    public Sector readSector(int sector_id) throws SQLException {
        Sector sector=new Sector();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from sector where deleted=false and sector_id="+sector_id);
        while(rs.next()){
            sector.setSector_id(sector_id);
            sector.setName(rs.getString("name"));
        }
        return sector;
    }
    
    public ArrayList<Sector> getAllSector() throws SQLException {
        ArrayList<Sector> sectors=new ArrayList<>();
        Statement statement= connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from sector where deleted=false");
        while(rs.next()){
            Sector sector=new Sector();
            sector.setSector_id(rs.getInt("sector_id"));
            sector.setName(rs.getString("name"));
            sectors.add(sector);
        }
        return sectors;
    }
}
