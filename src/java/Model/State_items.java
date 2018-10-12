/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Labing
 */
public class State_items {
    
    private int state_asset_id;
    private int asset_store_id;
    private int quantity;
    private int devolution_quantity;

    public State_items() {
    }

    public int getState_asset_id() {
        return state_asset_id;
    }

    public void setState_asset_id(int state_asset_id) {
        this.state_asset_id = state_asset_id;
    }

    public int getAsset_store_id() {
        return asset_store_id;
    }

    public void setAsset_store_id(int asset_stire_id) {
        this.asset_store_id = asset_stire_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDevolution_quantity() {
        return devolution_quantity;
    }

    public void setDevolution_quantity(int devolution_quantity) {
        this.devolution_quantity = devolution_quantity;
    }
    
    
}
