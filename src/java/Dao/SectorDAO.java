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
        ResultSet rs=statement.executeQuery("select * from sector");
        while(rs.next()){
            Sector sector=new Sector();
            sector.setSector_id(rs.getInt("sector_id"));
            sector.setName(rs.getString("name"));
            sectors.add(sector);
        }
        connection.close();
        return sectors;
    }
}
