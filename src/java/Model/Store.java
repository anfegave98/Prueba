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
public class Store {
    
    private int store_id;
    private String company;
    private String name;
    private boolean sell;
    private boolean lend;
    private boolean rental;
    private String address;
    private String phone_1;
    private String phone_2;
    private String email;
    private boolean principal;

    public Store(int store_id, String company, String name, boolean sell, boolean lend, boolean rental, String address, String phone_1, String phone_2, String email, boolean principal) {
        this.store_id = store_id;
        this.company = company;
        this.name = name;
        this.sell = sell;
        this.lend = lend;
        this.rental = rental;
        this.address = address;
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.email = email;
        this.principal = principal;
    }

    public Store() {
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public boolean isLend() {
        return lend;
    }

    public void setLend(boolean lend) {
        this.lend = lend;
    }

    public boolean isRental() {
        return rental;
    }

    public void setRental(boolean rental) {
        this.rental = rental;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
    
}
