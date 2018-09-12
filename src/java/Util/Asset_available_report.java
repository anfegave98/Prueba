/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Labing
 */
public class Asset_available_report {
    
    private String name;
    private String codebar;
    private String principal_picture;
    private String description;
    private int available;
    private int no_available;

    public Asset_available_report() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public String getPrincipal_picture() {
        return principal_picture;
    }

    public void setPrincipal_picture(String principal_picture) {
        this.principal_picture = principal_picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getNo_available() {
        return no_available;
    }

    public void setNo_available(int no_available) {
        this.no_available = no_available;
    }
    
    
}
