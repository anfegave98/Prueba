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
public class Service_admin {
    
    private int service_admin_id;
    private String name;
    private boolean deleted;

    public Service_admin() {
    }

    public int getService_admin_id() {
        return service_admin_id;
    }

    public void setService_admin_id(int service_admin_id) {
        this.service_admin_id = service_admin_id;
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
