/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author FiJus
 */
public class queryLend {
    private int asset_store_id;
    private int lend_quantity;

    public queryLend() {
    }

    public int getAsset_store_id() {
        return asset_store_id;
    }

    public void setAsset_store_id(int asset_store_id) {
        this.asset_store_id = asset_store_id;
    }

    public int getLend_quantity() {
        return lend_quantity;
    }

    public void setLend_quantity(int lend_quantity) {
        this.lend_quantity = lend_quantity;
    }

    @Override
    public String toString() {
        return "queryLend{" + "asset_store_id=" + asset_store_id + ", lend_quantity=" + lend_quantity + '}';
    }
    
    
}
