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
public class Asset {

    private int asset_id;
    private int asset_parent_id;
    private String name;
    private String codebar;
    private String principal_picture;
    private String description;

    public Asset() {
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public int getAsset_parent_id() {
        return asset_parent_id;
    }

    public void setAsset_parent_id(int asset_parent_id) {
        this.asset_parent_id = asset_parent_id;
    }

    public String getName() {
        return name;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public void setName(String name) {
        this.name = name;
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

}
