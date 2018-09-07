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
public class Admin_data {
    
    private int admin_data_id;
    private String title;
    private int data_type_id;
    private boolean login;
    private boolean obligatory;

    public Admin_data() {
    }

    public int getAdmin_data_id() {
        return admin_data_id;
    }

    public void setAdmin_data_id(int admin_data_id) {
        this.admin_data_id = admin_data_id;
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
