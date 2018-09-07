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
public class Permission_admin {
    
    private int role_admin_id;
    private int service_admin_id;

    public Permission_admin() {
    }

    public int getRole_admin_id() {
        return role_admin_id;
    }

    public void setRole_admin_id(int role_admin_id) {
        this.role_admin_id = role_admin_id;
    }

    public int getService_admin_id() {
        return service_admin_id;
    }

    public void setService_admin_id(int service_admin_id) {
        this.service_admin_id = service_admin_id;
    }
    
    
}
