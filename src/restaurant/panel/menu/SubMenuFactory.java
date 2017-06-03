/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.util.ArrayList;
import restaurant.panel.PanelFactory;

/**
 *
 * @author WINDNCC
 */
public class SubMenuFactory {
    
    public static JPanelSubMenu get(String type){
        ArrayList<JPanelSubMenuItem> listSubMenuItem = new ArrayList<>();
        switch(type){
            case "package" :
                listSubMenuItem.add(new JPanelSubMenuItem("Món ăn",PanelFactory.ID.PACKAGE_DISH,PanelFactory.ID.HEADER_PACKAGE_DISH));
                listSubMenuItem.add(new JPanelSubMenuItem("Nguyên liệu",PanelFactory.ID.PACKAGE_MATERIAL,PanelFactory.ID.HEADER_PACKAGE_MATERIAL));
                listSubMenuItem.add(new JPanelSubMenuItem("Bàn ăn",PanelFactory.ID.PACKAGE_TABLE,PanelFactory.ID.HEADER_PACKAGE_TABLE));
                break;
            case "report" :
                listSubMenuItem.add(new JPanelSubMenuItem("Cuối ngày", PanelFactory.ID.REPORT_END_OF_DAY, PanelFactory.ID.HEADER_REPORT));
                listSubMenuItem.add(new JPanelSubMenuItem("Chi tiết", PanelFactory.ID.REPORT_DETAILS, PanelFactory.ID.HEADER_REPORT));
                break;
            case "partner":
                listSubMenuItem.add(new JPanelSubMenuItem("Khách hàng", PanelFactory.ID.MANAGE_CUSTOMER, PanelFactory.ID.HEADER_MANAGE_CUSTOMER));
                listSubMenuItem.add(new JPanelSubMenuItem("Nhà cung cấp", PanelFactory.ID.MANAGE_SUPPLIER, PanelFactory.ID.HEADER_MANAGE_SUPPLIER));
                break;
            case "transaction":
                listSubMenuItem.add(new JPanelSubMenuItem("Phiếu chi NCC", PanelFactory.ID.TRANS_RVP, PanelFactory.ID.HEADER_TRANS_RVP));
                listSubMenuItem.add(new JPanelSubMenuItem("Hóa đơn khách hàng", PanelFactory.ID.TRANS_BILL, PanelFactory.ID.HEADER_TRANS_BILL));
                listSubMenuItem.add(new JPanelSubMenuItem("Phiếu nhập hàng", PanelFactory.ID.TRANS_RECEIPT, PanelFactory.ID.HEADER_TRANS_RECEIPT_NOTE));
                listSubMenuItem.add(new JPanelSubMenuItem("Phiếu khuyến mãi", PanelFactory.ID.TRANS_COUPON, PanelFactory.ID.HEADER_TRANS_COUPON));
                break;
        }
        return new JPanelSubMenu(listSubMenuItem);
    }
}
