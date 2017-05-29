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
        this.type = ((Integer) md.get("ChucVu"));
    }
    
    public MUser(int staffId, String userName, String passWord, int type) {
        this.staffId = staffId;
        this.userName = userName;
        this.passWord = passWord;
        this.type = type;
    }

    
    public MUser() {
    }
    
    
    
    public static MUser get(int id) throws SQLException{
        String sql = "SELECT * FROM tai_khoan WHERE MaNV = " + id;
        try {
            return new MUser(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    public static MUser get(String userName, String passWord) throws SQLException{
        String sql = "SELECT * FROM tai_khoan WHERE TenDangNhap = '" + userName + "' AND MatKhau = '" + passWord+"'";
        try {
            return new MUser(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        MUser n = new MUser();
        
        System.out.println(n.get("nguyentk", "nguyen11").userName);
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
