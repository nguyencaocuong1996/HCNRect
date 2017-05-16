/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.HashMap;
import database.Database;
/**
 *
 * @author WINDNCC
 */
public class Dish extends Model{
    protected static final String TABLE_NAME = "mon_an";
    private int id;
    private String name;
    private Float price;
    private String imageUrl;

    public Dish(int id, String name, Float price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    
    public Dish(String name, Float price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    void insert() {
        insertData = new HashMap();
        insertData.put("TenMA", this.getName());
        insertData.put("GiaMA", this.getPrice());
        insertData.put("DiaChiAnhMA", this.getImageUrl());
        Database.insert(getTableName(), insertData);
    }

    @Override
    void update() {
        updateData = new HashMap();
        updateData.put("TenMA", this.getName());
        updateData.put("GiaMA", this.getPrice());
        updateData.put("DiaChiAnhMA", this.getImageUrl());
        Database.update(getTableName(), updateData, "MaMA = " + getId());
    }

    @Override
    public void delete(){
        Database.delete(getTableName(), "MaMA = " + getId());
    }
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
    
}
