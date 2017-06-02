/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VReceiptNote extends View{

    public VReceiptNote(ViewData vd) {
        data = vd;
        this.filterData = (ViewData) vd.clone();
    }
    public static VReceiptNote get(String date, int providerId) throws SQLException{
        String sql = "SELECT * FROM phieu_nhap_hang WHERE";
        if (!"".equals(date)) {
            sql += " NgayNhapHang = '" + date + "'";
            if (providerId != 0) {
                sql += " AND MaNCC = " + providerId;
            }
        } else {
            sql += " MaNCC = " + providerId;
        }
        
        ViewData vd = database.Database.viewSelect(sql);
        return new VReceiptNote(vd);
    }
    public static VReceiptNote get(int providerId) throws SQLException{
        return get("", providerId);
    }
    public static VReceiptNote get(String date) throws SQLException{
        return get(date, 0);
    }
}
