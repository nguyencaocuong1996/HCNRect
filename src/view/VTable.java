/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DBConst;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import database.Database;
import java.math.BigDecimal;
/**
 *
 * @author WINDNCC
 */
public class VTable extends View{

    public VTable() {
    }

    
    public VTable(ViewData viewData) {
        data = viewData;
        data.forEach((ViewItem t) -> {
            Integer tableId = (Integer) t.get("MaBan");
            String tableName = (String) t.get("TenBan");
            BigDecimal dishOrderTable = (BigDecimal) t.get("SoMonDangDat");
            Integer dishOrderTableInt = dishOrderTable.intValue();
            BigDecimal dishSoPhieuDat = (BigDecimal) t.get("SoPhieuDatHomNayVaChuaToi");
            Integer dishSoPhieuDatInt = dishSoPhieuDat.intValue();
            Integer tableStatus;
            if (dishOrderTableInt > 0 ) {
                tableStatus = 1;
            } else {
                if (dishSoPhieuDatInt > 0) {
                    tableStatus = 2;
                } else {
                    tableStatus = 0;
                }
            }
            t.put("TrangThai", tableStatus);
            t.remove("SoMonDangDat");
            t.remove("SoPhieuDatHomNayVaChuaToi");
        });
        System.out.println("aa");
    }
    
    public static VTable searchByName(String keyWord){
        String sqlQuery = "SELECT b.MaBan, b.TenBan, ifnull(sum(ctdm.MaBan), 0) as SoMonDangDat, ifnull((pdb.MaBan), 0) as SoPhieuDatHomNayVaChuaToi FROM ban as b" +
                            " left join chi_tiet_dat_mon as ctdm on b.MaBan = ctdm.MaBan" +
                            " left join phieu_dat_ban as pdb on pdb.MaBan = b.MaBan and date(pdb.NgayGioDatBan) = curdate() and pdb.TrangThai = 0" +
                            " group by b.MaBan";
        System.out.println(sqlQuery);
        try{
        return new VTable(Database.viewSelect(sqlQuery));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VTable();
    }
    public static void main(String[] args) {
        VTable vt = VTable.searchByName("bàn");
        vt.data.forEach((ViewItem t) -> {
            String name = (String) t.get("TenBan");
            System.out.println(name);
        });
    }
}
