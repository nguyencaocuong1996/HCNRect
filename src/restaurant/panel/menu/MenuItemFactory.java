/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import assets.images.icons.IconResources;

/**
 *
 * @author WINDNCC
 */
public class MenuItemFactory {
    public static JPanelMenuItem get(String type) throws Exception{
        JPanelMenuItem jpi;
        try{
        switch(type){
            case "order":
                jpi = new JPanelMenuItem("Đặt bàn", IconResources.ORDER);
                break;
            case "package":
                jpi =  new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE);
                jpi.addMouseListener(new MouseListenerMenuItem(jpi));
                break;
            case "coins":
                jpi = new JPanelMenuItem("Giao dịch", IconResources.COINS);
                break;
            case "report":
                jpi =  new JPanelMenuItem("Báo cáo", IconResources.REPORT);
                break;
            case "staff":
                jpi = new JPanelMenuItem("Nhân viên", IconResources.STAFF);
                break;
            default:
                throw new Exception("Cannot get JPanelMenuItem " + type);
        }
                    System.out.println(jpi);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return jpi;
    }
}
