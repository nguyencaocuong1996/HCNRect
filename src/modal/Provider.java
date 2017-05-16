/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author WINDNCC
 */
public class Provider {
    protected int id;
    protected String name;
    protected String phone;
    protected String address;
    protected String description;

    public Provider(int id, String name, String phone, String address, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

    public Provider(String name, String phone, String address, String description) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
