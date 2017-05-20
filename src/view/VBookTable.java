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
public class VBookTable extends View{

    public VBookTable(ViewData viewData) {
        this.data = viewData;
        this.filterData = (ViewData) this.data.clone();
    }

    public VBookTable() {
    }
    
    public static VBookTable getListBookTable(int page, int numRow){
        Long startRow =new Long(numRow * (page - 1));
        String query = "SELECT pdb.MaPDB, pdb.MaBan, pdb.MaKH, pdb.NgayGioDatBan, b.TenBan, kh.HoTenKH, kh.SDTKH, pdb.TrangThai " +
                        "FROM phieu_dat_ban as pdb " +
                        "LEFT JOIN ban as b ON b.MaBan = pdb.MaBan " +
                        "LEFT JOIN khach_hang as kh ON kh.MaKH = pdb.MaKH " +
                        "LIMIT " + startRow + "," + numRow + ";";
        try {
            ViewData viewData = database.Database.viewSelect(query);
            return new VBookTable(viewData);
        } catch (SQLException e) {
            System.out.println("getByDate in VBookTable: can't get from database");
        }
        return new VBookTable();
    }
    public static VBookTable getByDate(String date, int page, int numRow){
        Long startRow =new Long(numRow * (page - 1));
        String query = "SELECT pdb.MaPDB, pdb.MaBan, pdb.MaKH, pdb.NgayGioDatBan, b.TenBan, kh.HoTenKH, kh.SDTKH, pdb.TrangThai " + 
                        "FROM phieu_dat_ban as pdb " +
                        "LEFT JOIN ban as b ON b.MaBan = pdb.MaBan " +
                        "LEFT JOIN khach_hang as kh ON kh.MaKH = pdb.MaKH " +
                        "WHERE date(pdb.NgayGioDatBan) = '"+date+"' " +
                        "LIMIT " +startRow+ "," + numRow + ";";
        System.out.println(query);
        try {
            ViewData viewData = database.Database.viewSelect(query);
            return new VBookTable(viewData);
        } catch (SQLException e) {
            System.out.println("getByDate in VBookTable: can't get from database");
        }
        return new VBookTable();
    }
    
}
