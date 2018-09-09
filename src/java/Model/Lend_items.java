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
public class Lend_items {
    private int lend_id;
    private int asset_store_id;
    private int calification;
    private int lend_quantity;
    private int devolution_quantity;

    public Lend_items() {
    }

    public int getLend_id() {
        return lend_id;
    }

    public void setLend_id(int lend_id) {
        this.lend_id = lend_id;
    }

    public int getAsset_store_id() {
        return asset_store_id;
    }

    public void setAsset_store_id(int asset_store_id) {
        this.asset_store_id = asset_store_id;
    }

    
    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public int getLend_quantity() {
        return lend_quantity;
    }

    public void setLend_quantity(int lend_quantity) {
        this.lend_quantity = lend_quantity;
    }

    public int getDevolution_quantity() {
        return devolution_quantity;
    }

    public void setDevolution_quantity(int devolution_quantity) {
        this.devolution_quantity = devolution_quantity;
    }
    
    
}
