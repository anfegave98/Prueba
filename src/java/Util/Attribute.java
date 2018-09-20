/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author green
 */
public class Attribute {
    private String title;
    private String data;
    private String type;
    private String description;
    private boolean required;
    private boolean identifier;
    private boolean table;

    public Attribute() {
    }

    public Attribute(String title, String data, String type, String description, boolean required, boolean identifier, boolean table) {
        this.title = title;
        this.data = data;
        this.type = type;
        this.description = description;
        this.required = required;
        this.identifier = identifier;
        this.table = table;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isIdentifier() {
        return identifier;
    }

    public void setIdentifier(boolean identifier) {
        this.identifier = identifier;
    }

    public boolean isTable() {
        return table;
    }

    public void setTable(boolean table) {
        this.table = table;
    }

    
    
    
}
