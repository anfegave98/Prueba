/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FiJus
 */
public class Asset_store {
    private int asset_id;
    private int store_id;
    private String codebar;
    private int avaliable;
    private int no_avaliable;

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

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public int getAvaliable() {
        return avaliable;
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
    
    
}
