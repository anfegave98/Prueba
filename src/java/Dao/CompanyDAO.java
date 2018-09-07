/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Company;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author anfeg
 */
public class CompanyDAO {

    private Connection connection;

    public CompanyDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public void createCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into company(company_id,name,primary_color,accent_color,sector_id,logo,email,password,basic_color,deleted,creation_date) values (?,?,?,?,?,?,?,?,?,false,?)");
        preparedStatement.setString(1, company.getCompany_id());
        preparedStatement.setString(2, company.getName());
        preparedStatement.setString(3, company.getPrimary_color());
        preparedStatement.setString(4, company.getAccent_color());
        preparedStatement.setString(5, company.getSector_id());
        preparedStatement.setString(6, company.getLogo());
        preparedStatement.setString(7, company.getEmail());
        preparedStatement.setString(8, company.getPassword());
        preparedStatement.setBoolean(9, company.isBasic_color());
        preparedStatement.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

    public Company readCompany(String company_id) throws SQLException, URISyntaxException {
        Company company = new Company();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from company where deleted=false and company_id=" + company_id);
        while (rs.next()) {
            company.setCompany_id(rs.getString("company_id"));
            company.setName(rs.getString("name"));
            company.setPrimary_color(rs.getString("primary_color"));
            company.setAccent_color(rs.getString("accent_color"));
            company.setSector_id(rs.getString("sector_id"));
            company.setLogo(rs.getString("logo"));
            company.setEmail(rs.getString("email"));
            company.setBasic_color(rs.getBoolean("basic_color"));
        }
        return company;
    }

    public void updateCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set name=?,primary_color=?,accent_color=?,sector_id=?,logo=?,email=?,password=?,basic_color=?,modification_date=?" + " where company_id=?");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setString(2, company.getPrimary_color());
        preparedStatement.setString(3, company.getAccent_color());
        preparedStatement.setString(4, company.getSector_id());
        preparedStatement.setString(5, company.getLogo());
        preparedStatement.setString(6, company.getEmail());
        preparedStatement.setString(7, company.getPassword());
        preparedStatement.setBoolean(8, company.isBasic_color());
        preparedStatement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(10, company.getCompany_id());
        preparedStatement.executeUpdate();
    }

    public void deleteCompany(String company_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set deleted=true,elimination_date=? where company_id=" + company_id);
        preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }

}
