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
public class Dynamic_admin {
    
    private int admin_id;
    private int admin_data_id;
    private String text;

    public Dynamic_admin() {
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getAdmin_data_id() {
        return admin_data_id;
    }

    public void setAdmin_data_id(int admin_data_id) {
        this.admin_data_id = admin_data_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
