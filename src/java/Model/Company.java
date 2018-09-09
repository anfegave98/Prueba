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
public class Company {
    
   private int company_id;
   private String name;
   private String primary_color;
   private String accent_color;
   private int sector_id;
   private String logo;
   private String email;
   private String password;
   private boolean basic_color;
   private boolean deleted;

   

    public Company() {
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public String getAccent_color() {
        return accent_color;
    }

    public void setAccent_color(String accent_color) {
        this.accent_color = accent_color;
    }

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBasic_color() {
        return basic_color;
    }

    public void setBasic_color(boolean basic_color) {
        this.basic_color = basic_color;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
   
   
    
}
