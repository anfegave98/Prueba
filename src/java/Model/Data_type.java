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
public class Data_type {
    
    private int data_type_id;
    private String title;
    private String db_type;

    public Data_type() {
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDb_type() {
        return db_type;
    }

    public void setDb_type(String db_type) {
        this.db_type = db_type;
    }
    
    
    
}
