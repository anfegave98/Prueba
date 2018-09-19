/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Labing
 */
public class MenuItem {

    private String ref;
    private String mdi_icon;
    private String title;

    public MenuItem(String ref, String mdi_icon, String title) {
        this.ref = ref;
        this.mdi_icon = mdi_icon;
        this.title = title;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMdi_icon() {
        return mdi_icon;
    }

    public void setMdi_icon(String mdi_icon) {
        this.mdi_icon = mdi_icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
