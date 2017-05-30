/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import core.CString;
import database.Database;
import java.sql.SQLException;

/**
 *
 * @author khanhnguyen
 */
public class VStaff extends View {
    public VStaff() {
    }
    
    public VStaff(ViewData viewData) {
        data = viewData;
        filterData = (ViewData) data.clone();
    }
    
    public static VStaff getAllStaff(){
        String sqlQuery = "SELECT nv.MaNV, nv.HoTenNV, nv.SDTNV, nv.DiaChiNV, nv.MaPB FROM nhan_vien as nv;";
//        System.out.println(sqlQuery);
        try{
            return new VStaff(Database.viewSelect(sqlQuery));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VStaff();
    }
    public void filter(String name){
        super.filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                String viName = (String) o.get("HoTenNV");
                viName = CString.removeAccent(viName).toLowerCase();
                return viName.contains(CString.removeAccent(name).toLowerCase());
            }
            
        });
    }
}
