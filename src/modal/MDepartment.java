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
public class MDepartment extends Model{
    protected int id;
    protected String name;
    protected String note;
    protected static final String TABLE_NAME = "phong_ban";
    public MDepartment(ModalData md) {
        this.id = ((Long) md.get("MaPB")).intValue();
        this.name = (String) md.get("TenPB");
        this.note = (String) md.get("GhiChuPB");
    }

    
    public static MDepartment get(int id) throws SQLException{
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaPB = " + id;
        ModalData md = database.Database.modalSelect(sql);
        if (md.isEmpty()) return null;
        return new MDepartment(md);
    }
    @Override
    void insert() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
