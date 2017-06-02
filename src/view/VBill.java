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
public class VBill extends View{

    public VBill(ViewData vd) {
        data = vd;
        filterData = (ViewData) data.clone();
    }
    
    public static VBill getByCustomer(int customerId) throws SQLException{
        String sql = "SELECT * FROM hoa_don WHERE MaKH = " + customerId;
        ViewData vd = database.Database.viewSelect(sql);
//        System.out.println(sql);
        return new VBill(vd);
    }
    public static VBill getByDate(String date) throws SQLException{
        String sql = "SELECT * FROM hoa_don WHERE DATE(NgayLapHD) = '" + date +"'";
        ViewData vd = database.Database.viewSelect(sql);
//        System.out.println(sql);
        return new VBill(vd);
    }
    public static VBill getByCustomerAndDate(int customerId, String date) throws SQLException{
        String sql = "SELECT * FROM hoa_don WHERE DATE(NgayLapHD) = '" + date +"' AND MaKH = " + customerId;
        ViewData vd = database.Database.viewSelect(sql);
//        System.out.println(sql);
        return new VBill(vd);
    }
}
