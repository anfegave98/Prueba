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
public class queryState_asset {
    private int asset_store_id;
    private int quantity;

    public queryState_asset() {
    }

    public int getAsset_store_id() {
        return asset_store_id;
    }

    public void setAsset_store_id(int asset_store_id) {
        this.asset_store_id = asset_store_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "queryState_asset{" + "asset_store_id=" + asset_store_id + ", quantity=" + quantity + '}';
    }
}
    