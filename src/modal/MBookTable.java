/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author WINDNCC
 */
public class MBookTable extends Model{
    protected static final String TABLE_NAME = "phieu_dat_ban";
    private int id;
    private int tableId;
    private int customerId;
    private String dateTimeBook;
    private int status = 0;
    private String message;

    public MBookTable() {
    }

    
    
    
    public MBookTable(int tableId, int customerId, String dateTimeBook, String message) {
        this.tableId = tableId;
        this.customerId = customerId;
        this.dateTimeBook = dateTimeBook;
        this.message = message;
    }

    public MBookTable(int id, int tableId, int customerId, String dateTimeBook, String message) {
        this.id = id;
        this.tableId = tableId;
        this.customerId = customerId;
        this.dateTimeBook = dateTimeBook;
        this.message = message;
    }

    public void reset(){
        this.id = 0;
        this.tableId = 0;
        this.customerId = 0;
        this.dateTimeBook = null;
        this.message = null;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("MaBan", tableId);
        insertData.put("MaKH", customerId);
        insertData.put("NgayGioDatBan", dateTimeBook);
        insertData.put("TrangThai", status);
        insertData.put("GhiChu", message);
        database.Database.insert(getTableName(), insertData);
    }

    @Override
    void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDateTimeBook() {
        return dateTimeBook;
    }

    public void setDateTimeBook(String dateTimeBook) {
        this.dateTimeBook = dateTimeBook;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
