/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.util.ArrayList;
import java.util.Comparator;
import restaurant.panel.PanelFactory;

/**
 *
 * @author WINDNCC
 */
public class ListMenu extends ArrayList<JPanelMenuItem>{
    public static ListMenu instance;

    public static ListMenu getInstance() {
        if (instance==null) {
            instance = new ListMenu();
        }
        return instance;
    }
    
    public ListMenu() {
        //Create item
        JPanelMenuItem jpMIOrder = new JPanelMenuItem("Gọi món", IconResources.ORDER, 1);
        JPanelMenuItem jpMIBook = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE, 2);
        JPanelMenuItem jpMIPackage = new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, 3, SubMenuFactory.get("package"));
        JPanelMenuItem jpMIReport = new JPanelMenuItem("Báo cáo", IconResources.REPORT, 4, SubMenuFactory.get("report"));
        JPanelMenuItem jpMIPartner = new JPanelMenuItem("Đối tác", IconResources.PARTNER, 6, SubMenuFactory.get("partner"));
        JPanelMenuItem jpMICoins = new JPanelMenuItem("Giao dịch", IconResources.COINS, 7,SubMenuFactory.get("transaction"));
        JPanelMenuItem jpMIStaff = new JPanelMenuItem("Nhân viên", IconResources.STAFF, 8);

        //Add mouseListener
        jpMIOrder.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.ORDER_PICK_TABLE, PanelFactory.ID.HEADER_ORDER_PICK_TABLE));
        jpMIBook.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.BOOK_TABLE, PanelFactory.ID.HEADER_BOOK_TABLE));
        jpMIStaff.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.MANAGE_STAFF, PanelFactory.ID.HEADER_MANAGE_STAFF));
        jpMIPackage.addMouseListener(new MouseListenerMenuItem());
        jpMIReport.addMouseListener(new MouseListenerMenuItem());
        jpMIPartner.addMouseListener(new MouseListenerMenuItem());
        jpMICoins.addMouseListener(new MouseListenerMenuItem());
        //add to List
        add(jpMIOrder);
        add(jpMIBook);
        add(jpMIPackage);
        add(jpMIReport);
        add(jpMIPartner);
        add(jpMICoins);
        add(jpMIStaff);
        sort((JPanelMenuItem o1, JPanelMenuItem o2) -> {
            if (o1.getOrderInMenu() > o2.getOrderInMenu()){
                return 1;
            } else {
                if(o1.getOrderInMenu() < o2.getOrderInMenu())
                    return -1;
            }
            return 0;
        });
    }
}
