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
public class Asset_store {
    private int asset_store_id;
    private int asset_id;
    private int store_id;
    private int avaliable;
    private int no_avaliable;
    private Date creation_date;
    private Date elimnation_date;
    private boolean deleted;

    public int getAsset_store_id() {
        return asset_store_id;
    }

    public void setAsset_store_id(int asset_store_id) {
        this.asset_store_id = asset_store_id;
    }

    public Asset_store() {
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }


    public int getAvaliable() {
        return avaliable;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getElimnation_date() {
        return elimnation_date;
    }

    public void setElimnation_date(Date elimnation_date) {
        this.elimnation_date = elimnation_date;
    }
    
    public void setAvaliable(int avaliable) {
        this.avaliable = avaliable;
    }

    public int getNo_avaliable() {
        return no_avaliable;
    }

    public void setNo_avaliable(int no_avaliable) {
        this.no_avaliable = no_avaliable;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Asset_store{" + "asset_store_id=" + asset_store_id + ", asset_id=" + asset_id + ", store_id=" + store_id + ", avaliable=" + avaliable + ", no_avaliable=" + no_avaliable + ", creation_date=" + creation_date + ", elimnation_date=" + elimnation_date + ", deleted=" + deleted + '}';
    }
    
    
    
}
