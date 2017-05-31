/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import core.CEncrypt;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class MUser extends Model{
    protected int staffId;
    protected String userName;
    protected String passWord;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public MUser(ModalData md) {
        this.staffId = ((Long) md.get("MaNV")).intValue();
        this.userName = (String) md.get("TenDangNhap");
        this.passWord = (String) md.get("MatKhau");
    }
    
    public MUser(int staffId, String userName, String passWord) {
        this.staffId = staffId;
        this.userName = userName;
        this.passWord = passWord;
    }

    
    public MUser() {
    }
    
    public static MUser get(int id) throws SQLException{
        String sql = "SELECT * FROM tai_khoan WHERE MaNV = " + id;
        try {
            ModalData md = database.Database.modalSelect(sql);
            if(md.isEmpty()) return null;
            return new MUser();
        } catch (SQLException e) {
            throw e;
        }
    }
    public static MUser get(String userName, String passWord) throws SQLException{
        passWord = CEncrypt.md5(passWord);
        String sql = "SELECT * FROM tai_khoan WHERE TenDangNhap = '" + userName + "' AND MatKhau = '" + passWord+"'";
        ModalData md = database.Database.modalSelect(sql);
        if (md.isEmpty()) return null;
        return new MUser(md);
    }
    public static void main(String[] args) {
        try {
            ModalData md =  database.Database.modalSelect("SELECT * FROM tai_khoan WHERE TenDangNhap = '123123'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
