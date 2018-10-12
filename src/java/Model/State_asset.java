/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author anfeg
 */
public class State_asset {
    
    private int state_asset_id;
    private int admin_id;
    private String description;
    private Date creation_date;
    private boolean deleted;

    public State_asset() {
    }

    public int getState_asset_id() {
        return state_asset_id;
    }

    public void setState_asset_id(int state_asset_id) {
        this.state_asset_id = state_asset_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

   
    
    
}
