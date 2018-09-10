/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createDatabaseDAO {

    private Connection connection;

    public createDatabaseDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }

    public boolean createDatabase(String database) throws SQLException {
        //Store
        String table = "create table Store(\n"
                + "store_id int PRIMARY key auto_increment,\n"
                + "company_id int,\n"
                + "name varchar(50),\n"
                + "sell bool,\n"
                + "lend bool,\n"
                + "rental bool,\n"
                + "address varchar(100) ,\n"
                + "phone_1 varchar(20),\n"
                + "phone_2 varchar(20),\n"
                + "email varchar(100),\n"
                + "principal boolean,\n"
                + "creation_date timestamp,\n"
                + "modification_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "deleted bool\n"
                + ");";
        PreparedStatement preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Data_type
        table = "create table Data_type(\n"
                + "data_type_id int PRIMARY key auto_increment,\n"
                + "title varchar(20),\n"
                + "db_type varchar(20)\n"
                + ");\n";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Admin
        table = "create table Admin(\n"
                + "admin_id int primary key auto_increment, \n"
                + "password varchar(500),\n"
                + "email varchar(100),\n"
                + "name varchar(50),\n"
                + "last_name varchar(50),\n"
                + "creation_date timestamp,\n"
                + "modification_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "deleted bool\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Admin_data
        table = "create table Admin_Data(\n"
                + "admin_data_id int primary key auto_increment, \n"
                + "title varchar(50),\n"
                + "data_type_id int,\n"
                + "login bool,\n"
                + "obligatory bool,\n"
                + "foreign key(data_type_id) references data_type(data_type_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Dynamic_admin
        table = "create table Dynamic_Admin(\n"
                + "admin_id int,\n"
                + "admin_data_id int,\n"
                + "text varchar(50),\n"
                + "foreign key(admin_id) references admin(admin_id),\n"
                + "foreign key(admin_data_id) references admin_data(admin_data_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Sevice_admin
        table = "create table Service_Admin(\n"
                + "service_admin_id int primary key auto_increment,\n"
                + "name varchar(50),\n"
                + "deleted boolean\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Role_admin
        table = "create table Role_Admin(\n"
                + "role_admin_id int primary key auto_increment,\n"
                + "name varchar(50),\n"
                + "deleted bool\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        table = "insert into role_admin(name,deleted) values('Default',false)";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Permission_admin
        table = "create table Permission_Admin(\n"
                + "service_admin_id int,\n"
                + "role_admin_id int,\n"
                + "foreign key(service_admin_id) references service_admin(service_admin_id),\n"
                + "foreign key(role_admin_id) references role_admin(role_admin_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Admin_role_store
        table = "create table Admin_Role_Store(\n"
                + "admin_role_store_id int primary key auto_increment,\n"
                + "admin_id int,\n"
                + "store_id int,\n"
                + "role_admin_id int,\n"
                + "creation_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "foreign key(admin_id) references admin(admin_id),\n"
                + "foreign key(store_id) references store(store_id),\n"
                + "foreign key(role_admin_id) references role_admin(role_admin_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Service_client
        table = "create table Service_Client(\n"
                + "service_client_id int primary key auto_increment,\n"
                + "name varchar(50),\n"
                + "deleted bool\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Role_Client
        table = "create table Role_Client(\n"
                + "role_client_id int primary key auto_increment,\n"
                + "name varchar(50),\n"
                + "deleted bool\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        table = "insert into role_client(name,deleted) values('Default',false)";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Permission_Client
        table = "create table Permission_Client(\n"
                + "role_client_id int,\n"
                + "service_client_id int,\n"
                + "foreign key(service_client_id) references service_client(service_client_id),\n"
                + "foreign key(role_client_id) references role_client(role_client_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Client
        table = "create table Client(\n"
                + "client_id int primary key auto_increment,\n"
                + "password varchar(500),\n"
                + "email varchar(100),\n"
                + "name varchar(50),\n"
                + "last_name varchar(50),\n"
                + "role_client_id int,\n"
                + "creation_date timestamp,\n"
                + "modification_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "deleted bool,\n"
                + "foreign key(role_client_id) references role_client(role_client_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Client_Data
        table = "create table Client_Data(\n"
                + "client_data_id int primary key auto_increment,\n"
                + "title varchar(20),\n"
                + "data_type_id int,\n"
                + "login bool,\n"
                + "obligatory bool,\n"
                + "foreign key(data_type_id) references data_type(data_type_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Dynamic_Client
        table = "create table Dynamic_Client(\n"
                + "client_id int,\n"
                + "client_data_id int,\n"
                + "text varchar(50),\n"
                + "foreign key(client_id) references client(client_id),\n"
                + "foreign key(client_data_id) references client_data(client_data_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Asset
        table = "create table Asset(\n"
                + "asset_id int primary key auto_increment,\n"
                + "codebar varchar(300),\n"
                + "asset_parent_id int,\n"
                + "name varchar(100),\n"
                + "principal_picture varchar(500),\n"
                + "description varchar(500),\n"
                + "creation_date timestamp,\n"
                + "modification_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "deleted bool,\n"
                + "foreign key(asset_parent_id) references asset(asset_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Asset_Data
        table = "create table Asset_Data(\n"
                + "asset_data_id int primary key auto_increment,\n"
                + "title varchar(50),\n"
                + "data_type_id int,\n"
                + "foreign key(data_type_id) references data_type(data_type_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Dynamic_Asset
        table = "create table Dynamic_Asset(\n"
                + "asset_id int,\n"
                + "asset_data_id int,\n"
                + "text varchar(50),\n"
                + "foreign key(asset_id) references asset(asset_id),\n"
                + "foreign key(asset_data_id) references asset_data(asset_data_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Asset_Store
        table = "create table Asset_Store(\n"
                + "asset_store_id int primary key auto_increment,\n"
                + "asset_id int,\n"
                + "store_id int,\n"
                + "available int,\n"
                + "no_available int,\n"
                + "creation_date timestamp,\n"
                + "elimination_date timestamp,\n"
                + "deleted bool, \n"
                + "foreign key(asset_id) references asset(asset_id),\n"
                + "foreign key(store_id) references store(store_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //State_Asset
        table = "create table State_Asset(\n"
                + "state_asset_id int primary key auto_increment,\n"
                + "asset_store_id int,\n"
                + "admin_id int,\n"
                + "codebar varchar(300),\n"
                + "quantity int,\n"
                + "devolution_quantity int,\n"
                + "description varchar(300),\n"
                + "creation_date timestamp,\n"
                + "deleted bool,\n"
                + "foreign key(admin_id) references admin(admin_id),\n"
                + "foreign key(asset_store_id) references asset_store(asset_store_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Lend
        table = "create table Lend(\n"
                + "lend_id int primary key auto_increment,\n"
                + "admin_role_store_id int,\n"
                + "client_id int,\n"
                + "start_date timestamp,\n"
                + "end_date timestamp,\n"
                + "devolution_date timestamp,\n"
                + "client_calification int,\n"
                + "admin_calification int,\n"
                + "foreign key(admin_role_store_id) references admin_role_store(admin_role_store_id),\n"
                + "foreign key(client_id) references Client(client_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        //Lend_Items
        table = "create table Lend_Items(\n"
                + "lend_id int,\n"
                + "asset_store_id int,\n"
                + "codebar varchar(300),\n"
                + "calification int,\n"
                + "lend_quantity int,\n"
                + "devolution_quantity int,\n"
                + "foreign key(lend_id) references Lend(lend_id),\n"
                + "foreign key(asset_store_id) references asset_store(asset_store_id)\n"
                + ");";
        preparedStatement = connection.prepareStatement(table);
        preparedStatement.executeUpdate();
        return true;
    }
}

