/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class MTable extends Model{
    protected static final String TABLE_NAME = "ban";
    protected int id;
    protected String name;
    protected String note;
    public MTable(int id){
        this.id = id;
    }
    public MTable(){
        
    }
    public MTable(ModalData md) {
        this.id = (Integer) md.get("MaBan");
        this.name = (String) md.get("TenBan");
        this.note = (String) md.get("GhiChu");
    }
    public MTable(String name, String note){
        this.name = name;
        this.note = note;
    }
    public static void main(String[] args) {
        try {
            System.out.println(MTable.getLast()+"áddsa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static MTable getById(int id) throws SQLException{
        try {
            String sql = "SELECT * FROM "+ TABLE_NAME +" WHERE MaBan = " + id;
            return new MTable(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    public static MTable getLast() throws SQLException{
        try {
            String sql = "SELECT * FROM "+TABLE_NAME + " ORDER BY MaBan DESC";
            System.out.println(sql);
            return new MTable(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    
    @Override
    public void insert() throws SQLException{
        try {
            insertData = new ModalData();
            insertData.put("TenBan", name);
            insertData.put("GhiChu", note);
            database.Database.insert(TABLE_NAME, insertData);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void update() throws SQLException {
        try {
            updateData = new ModalData();
            updateData.put("TenBan", name);
            updateData.put("GhiChu", note);
            database.Database.update(TABLE_NAME, updateData, "MaBan = " + id);
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void delete() throws SQLException {
        try {
            database.Database.delete(TABLE_NAME, "MaBan = " + this.id);
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
