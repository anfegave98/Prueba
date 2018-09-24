/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author super
 */
public class Asset_store_report {
    
    private int state_asset_id;
    private String name;
    private String codebar;
    private int available;
    private int no_available;
    private String description;

    public int getState_asset_id() {
        return state_asset_id;
    }

    public void setState_asset_id(int state_asset_id) {
        this.state_asset_id = state_asset_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getNo_available() {
        return no_available;
    }

    public void setNo_available(int no_available) {
        this.no_available = no_available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }
    
    
    
    
}
