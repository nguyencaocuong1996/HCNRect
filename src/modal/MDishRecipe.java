/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author WINDNCC
 */
public class MDishRecipe extends Model{
    protected static final String TABLE_NAME = "cong_thuc";
    protected int dishId;
    protected int materialId;
    protected float qty;
    protected String note;

    public MDishRecipe(int dishId, int materialId, float qty, String note) {
        this.dishId = dishId;
        this.materialId = materialId;
        this.qty = qty;
        this.note = note;
    }
    public MDishRecipe(ModalData md){
        this.dishId = ((Long) md.get("MaMA")).intValue();
        this.materialId = ((Long) md.get("MaNL")).intValue();
        this.qty = (Float) md.get("LuongCan");
        this.note = (String) md.get("GhiChu");
    }
    public static MDishRecipe get(int dishId, int materialId) throws SQLException{
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaMA = " + dishId + " AND MaNL = " + materialId;
        try {
            return new MDishRecipe(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    public static void main(String[] args) {
        try {
            MDishRecipe a = MDishRecipe.get(1, 2);
            System.out.println(a.getQty());
        } catch (SQLException e) {
        }
        
    }
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }
   

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("MaMA", this.getDishId());
        insertData.put("MaNL", this.getMaterialId());
        insertData.put("LuongCan", this.getQty());
        insertData.put("GhiChu", this.getNote());
        Database.insert(getTableName(), insertData);
    }

    @Override
    public void update() throws SQLException{
        updateData = new ModalData();
        updateData.put("LuongCan", this.getQty());
        updateData.put("GhiChu", this.getNote());
        try {
            Database.update(getTableName(), updateData, "MaNL = " + this.getMaterialId() + " AND MaMA = " + this.getDishId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaMA = " + getDishId() + " AND MaNL = " + getMaterialId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
}
