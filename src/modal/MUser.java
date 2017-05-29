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
public class MUser extends Model{
    protected int staffId;
    protected String userName;
    protected String passWord;
    protected int type;

    public MUser(ModalData md) {
        this.staffId = ((Long) md.get("MaNV")).intValue();
        this.userName = (String) md.get("TenDangNhap");
        this.passWord = (String) md.get("MatKhau");
        this.type = ((Long) md.get("ChucVu")).intValue();
    }
    
    public MUser(int staffId, String userName, String passWord, int type) {
        this.staffId = staffId;
        this.userName = userName;
        this.passWord = passWord;
        this.type = type;
    }

    
    public MUser() {
    }
    
    
    
    public MUser get(int id) throws SQLException{
        String sql = "SELECT * FROM tai_khoan WHERE MaNV = " + id;
        try {
            return new MUser(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    public MUser get(String userName, String passWord) throws SQLException{
        String sql = "SELECT * FROM tai_khoan WHERE TenTaiKhoan = " + userName + " AND MatKhau = " + passWord;
        try {
            return new MUser(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void main(String[] args) {
        
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
    
}
