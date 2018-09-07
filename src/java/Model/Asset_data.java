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
public class Asset_data {
    private int asset_data_id;
    private String title;
    private int data_type_id;

    public Asset_data() {
    }

    public int getAsset_data_id() {
        return asset_data_id;
    }

    public void setAsset_data_id(int asset_data_id) {
        this.asset_data_id = asset_data_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }
    
    
}
