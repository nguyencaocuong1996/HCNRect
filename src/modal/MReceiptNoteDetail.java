/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;

/**
 *
 * @author khanhnguyen
 */
public class MReceiptNoteDetail extends Model{

    protected int receiptNoteId;
    protected int materialId;
    protected float qty;
    protected float price;

    public MReceiptNoteDetail(int receiptNoteId, int materialId, float qty, float price) {
        this.receiptNoteId = receiptNoteId;
        this.materialId = materialId;
        this.qty = qty;
        this.price = price;
    }

    
    
    public int getReceiptNoteId() {
        return receiptNoteId;
    }

    public void setReceiptNoteId(int receiptNoteId) {
        this.receiptNoteId = receiptNoteId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public void insert() throws SQLException {
        InsertData insData = new InsertData(this);
        insData.execute();
    }

    @Override
    void update() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void delete() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
