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
public class Dynamic_client {
    private int client_id;
    private int client_data_id;
    private String text;

    public Dynamic_client() {
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getClient_data_id() {
        return client_data_id;
    }

    public void setClient_data_id(int client_data_id) {
        this.client_data_id = client_data_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
