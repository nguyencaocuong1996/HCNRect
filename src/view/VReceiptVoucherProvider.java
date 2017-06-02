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
public class VReceiptVoucherProvider extends View{

    public VReceiptVoucherProvider(ViewData vd) {
        this.data = vd;
        this.filterData = (ViewData) data.clone();
    }
    public static VReceiptVoucherProvider getByProvider(int providerId) throws SQLException{
        String sql = "SELECT * FROM phieu_chi_ncc WHERE MaNCC = " + providerId;
        ViewData vd = database.Database.viewSelect(sql);
        return new VReceiptVoucherProvider(vd);
    }
}
