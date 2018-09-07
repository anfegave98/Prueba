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
public class Permission_client {
    private int role_client_id;
    private int service_client_id;

    public Permission_client() {
    }

    public int getRole_client_id() {
        return role_client_id;
    }

    public void setRole_client_id(int role_client_id) {
        this.role_client_id = role_client_id;
    }

    public int getService_client_id() {
        return service_client_id;
    }

    public void setService_client_id(int service_client_id) {
        this.service_client_id = service_client_id;
    }

}
