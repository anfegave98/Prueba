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
public class Client_data {
    private int client_data_id;
    private String title;
    private int data_type_id;
    private boolean login;
    private boolean obligatory;

    public Client_data() {
    }

    public int getClient_data_id() {
        return client_data_id;
    }

    public void setClient_data_id(int client_data_id) {
        this.client_data_id = client_data_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }
    
    
}
