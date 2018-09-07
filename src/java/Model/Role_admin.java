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
public class Role_admin {
    
    private int role_admin_id;
    private String name;
    private boolean deleted;

    public Role_admin() {
    }

    public int getRole_admin_id() {
        return role_admin_id;
    }

    public void setRole_admin_id(int role_admin_id) {
        this.role_admin_id = role_admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    
    
}
