/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author FiJus
 */
public class Lend {
    private int lend_id;
    private int admin_role_store_id;
    private int client_id;
    private Date start_date;
    private Date end_date;
    private Date devolution_date;
    private int client_calification;
    private int admin_calification;

    public Lend() {
    }

    public int getLend_id() {
        return lend_id;
    }

    public void setLend_id(int lend_id) {
        this.lend_id = lend_id;
    }

    public int getAdmin_role_store_id() {
        return admin_role_store_id;
    }

    public void setAdmin_role_store_id(int admin_role_store_id) {
        this.admin_role_store_id = admin_role_store_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getDevolution_date() {
        return devolution_date;
    }

    public void setDevolution_date(Date devolution_date) {
        this.devolution_date = devolution_date;
    }

    public int getClient_calification() {
        return client_calification;
    }

    public void setClient_calification(int client_calification) {
        this.client_calification = client_calification;
    }

    public int getAdmin_calification() {
        return admin_calification;
    }

    public void setAdmin_calification(int admin_calification) {
        this.admin_calification = admin_calification;
    }
    
    
}
