/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Company;
import Util.DbUtil;
import Util.createDatabaseDAO;
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
 * @author anfeg
 */
public class CompanyDAO {

    private Connection connection;

    public CompanyDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }
    
    public int createCompany(Company company) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into company(name,primary_color,accent_color,sector_id,logo,email,password,basic_color,deleted,creation_date) values (?,?,?,?,?,?,?,?,false,?)");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setString(2, company.getPrimary_color());
        preparedStatement.setString(3, company.getAccent_color());
        preparedStatement.setInt(4, company.getSector_id());
        preparedStatement.setString(5, company.getLogo());
        preparedStatement.setString(6, company.getEmail());
        preparedStatement.setString(7, company.getPassword());
        preparedStatement.setBoolean(8, company.isBasic_color());
        preparedStatement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select MAX(company_id) as company_id,name from company");
        while(rs.next()){
            company.setCompany_id(rs.getInt("company_id"));
        }
        DbUtil dbutil=new DbUtil();
        dbutil.createDatabase(company);
        
        return company.getCompany_id();
    }

    public Company readCompany(int company_id) throws SQLException, URISyntaxException {
        Company company = new Company();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where deleted=false and company_id=" + company_id);
        while (rs.next()) {
            company.setCompany_id(rs.getInt("company_id"));
            company.setName(rs.getString("name"));
            company.setPrimary_color(rs.getString("primary_color"));
            company.setAccent_color(rs.getString("accent_color"));
            company.setSector_id(rs.getInt("sector_id"));
            company.setLogo(rs.getString("logo"));
            company.setEmail(rs.getString("email"));
            company.setBasic_color(rs.getBoolean("basic_color"));
        }
        return company;
    }

    public void updateCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set name=?,primary_color=?,accent_color=?,sector_id=?,logo=?,basic_color=?,modification_date=?" + " where company_id=?");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setString(2, company.getPrimary_color());
        preparedStatement.setString(3, company.getAccent_color());
        preparedStatement.setInt(4, company.getSector_id());
        preparedStatement.setString(5, company.getLogo());
        preparedStatement.setBoolean(6, company.isBasic_color());
        preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(8, company.getCompany_id());
        preparedStatement.executeUpdate();
    }
    public void updateCompanyWithoutName(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set primary_color=?,accent_color=?,sector_id=?,logo=?,basic_color=?,modification_date=?" + " where company_id=?");
        preparedStatement.setString(1, company.getPrimary_color());
        preparedStatement.setString(2, company.getAccent_color());
        preparedStatement.setInt(3, company.getSector_id());
        preparedStatement.setString(4, company.getLogo());
        preparedStatement.setBoolean(5, company.isBasic_color());
        preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(7, company.getCompany_id());
        preparedStatement.executeUpdate();
    }

    public void deleteCompany(int company_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set deleted=true where company_id=" + company_id);
        preparedStatement.executeUpdate();
    }

    public boolean getEmail(String email) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where email='" +email+"'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean is(int company_id,String email, String password) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where company_id="+company_id+" and email='" +email+"' and password='"+password+"'");
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public Object readCompany(String email) throws SQLException {
        Company company = new Company();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where deleted=false and email='" +email+"'");
        while (rs.next()) {
            company.setCompany_id(rs.getInt("company_id"));
            company.setName(rs.getString("name"));
            company.setPrimary_color(rs.getString("primary_color"));
            company.setAccent_color(rs.getString("accent_color"));
            company.setSector_id(rs.getInt("sector_id"));
            company.setLogo(rs.getString("logo"));
            company.setEmail(rs.getString("email"));
            company.setBasic_color(rs.getBoolean("basic_color"));
        }
        return company;
    }
     public Company readCompanyByName(String name) throws SQLException {
        Company company = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where deleted=false and name='"+name+"'");
        while (rs.next()) {
            company= new Company();   
            company.setName(rs.getString("name"));
        }
        if(company==null){
            company=new Company();
            company.setName("0");
        }
        return company;
    }
     public Company getByEmail(String email) throws SQLException, URISyntaxException {
        Company company= new Company();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where email='" +email+"'");
        while (rs.next()) {
            company.setCompany_id(rs.getInt("company_id"));
            company.setName(rs.getString("name"));
            company.setPrimary_color(rs.getString("primary_color"));
            company.setAccent_color(rs.getString("accent_color"));
            company.setSector_id(rs.getInt("sector_id"));
            company.setLogo(rs.getString("logo"));
            company.setEmail(rs.getString("email"));
            company.setBasic_color(rs.getBoolean("basic_color"));
        }
        return company;
    }
     
      public ArrayList<Company> getAllCompanys() throws SQLException {

        ArrayList<Company> companys = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where deleted=false");
        while (rs.next()) {
            Company company = new Company();
            company.setCompany_id(rs.getInt("company_id"));
            company.setName(rs.getString("name"));
            company.setPrimary_color(rs.getString("primary_color"));
            company.setAccent_color(rs.getString("accent_color"));
            company.setSector_id(rs.getInt("sector_id"));
            company.setLogo(rs.getString("logo"));
            company.setEmail(rs.getString("email"));
            company.setBasic_color(rs.getBoolean("basic_color"));      
            companys.add(company);
        }
        return companys;
    }

}
