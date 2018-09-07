/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author anfeg
 */
public class Admin_role_store {
    
    private int admin_role_store_id;
    private int admin_id;
    private int role_admin_id;
    private int store_id;
    private boolean deleted;

    public Admin_role_store() {
    }

    public int getAdmin_role_store_id() {
        return admin_role_store_id;
    }

    public void setAdmin_role_store_id(int admin_role_store_id) {
        this.admin_role_store_id = admin_role_store_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getRole_admin_id() {
        return role_admin_id;
    }

    public void setRole_admin_id(int role_admin_id) {
        this.role_admin_id = role_admin_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    
    
}
