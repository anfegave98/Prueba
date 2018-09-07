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
public class Dynamic_asset {
    private int asset_id;
    private int asset_data_id;
    private String text;

    public Dynamic_asset() {
    }

    public int getClient_id() {
        return asset_id;
    }

    public void setClient_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public int getClient_data_id() {
        return asset_data_id;
    }

    public void setClient_data_id(int asset_data_id) {
        this.asset_data_id = asset_data_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}

