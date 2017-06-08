/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.HashMap;
import database.Database;
import java.sql.SQLException;
import view.VDishRecipe;
import view.ViewItem;
/**
 *
 * @author WINDNCC
 */
public class MDish extends Model{
    protected static final String TABLE_NAME = "mon_an";
    private int id;
    private String name;
    private Float price;
    private String imageUrl;
    protected int menuID;

    public MDish(int id){
        this.id = id;
    }
    
    public MDish(int id, String name, Float price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    
    public MDish(String name, Float price, String imageUrl, int menuID) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.menuID = menuID;                
    }
    
    public MDish(String name, Float price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    
    public int getId() {
        return id;
    }
    
    public int getMenuID(){
        return menuID;
    }
    
    public void setMenuID(int menuID){
        this.menuID = menuID;
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
    public MDish(ModalData md){
        this.id = ((Long) md.get("MaMA")).intValue();
        this.name = (String)md.get("TenMA");
        this.imageUrl = (String)md.get("DiaChiAnhMA");
        this.price = (Float) md.get("GiaMA");
        
    }
    public static void main(String[] args) {
        try {
            MDish d = MDish.get(2);
            System.out.println(d.checkCanOrder(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public boolean checkCanOrder(int qty) throws SQLException{
        VDishRecipe vDR = VDishRecipe.get(id);
        for(ViewItem vi : vDR.getData()){
            int materialId = ((Long) vi.get("MaNL")).intValue();
            float luongCan = ((float) vi.get("LuongCan") * qty);
            try {
                MMaterial mM = MMaterial.get(materialId);
                if(mM.getInStock() < luongCan){
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return true;
    }
    public static MDish get(int id) throws SQLException{
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaMA = " + id;
        try {
            return new MDish(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("TenMA", this.getName());
        insertData.put("GiaMA", this.getPrice());
        insertData.put("DiaChiAnhMA", this.getImageUrl());
        insertData.put("MaTD", this.getMenuID());
        Database.insert(getTableName(), insertData);
    }

    @Override
    public void update() throws SQLException{
        updateData = new ModalData();
        updateData.put("TenMA", this.getName());
        updateData.put("GiaMA", this.getPrice());
        updateData.put("DiaChiAnhMA", this.getImageUrl());
        try {
            Database.update(getTableName(), updateData, "MaMA = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaMA = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
    
}
