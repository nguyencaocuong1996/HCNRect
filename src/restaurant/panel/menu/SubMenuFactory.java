/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author WINDNCC
 */
public class SubMenuFactory {
    
    public static JPanelSubMenu get(String type){
        ArrayList<JPanelSubMenuItem> listSubMenuItem = new ArrayList<>();
        switch(type){
            case "package" :
                listSubMenuItem.add(new JPanelSubMenuItem("Món ăn"));
                listSubMenuItem.add(new JPanelSubMenuItem("Nguyên liệu"));
                listSubMenuItem.add(new JPanelSubMenuItem("Bàn ăn"));
            break;
            case "report" :
                listSubMenuItem.add(new JPanelSubMenuItem("Thu chi"));
                listSubMenuItem.add(new JPanelSubMenuItem("Tồn kho"));
                break;
            case "partner":
                listSubMenuItem.add(new JPanelSubMenuItem("Khách hàng"));
                listSubMenuItem.add(new JPanelSubMenuItem("Nhà cung cấp"));
                break;
        }
        return new JPanelSubMenu(listSubMenuItem);
    }
}
