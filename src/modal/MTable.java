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

    public MTable(ModalData md) {
        this.id = (Integer) md.get("MaBan");
        this.name = (String) md.get("TenBan");
        this.note = (String) md.get("GhiChu");
    }
    public static MTable getById(int id) throws SQLException{
        try {
            String sql = "SELECT * FROM ban WHERE MaBan = " + id;
            return new MTable(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    
    @Override
    void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
