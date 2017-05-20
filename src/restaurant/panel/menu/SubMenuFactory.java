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
                listSubMenuItem.add(new JPanelSubMenuItem("pak 1"));
                listSubMenuItem.add(new JPanelSubMenuItem("pak 2"));
                listSubMenuItem.add(new JPanelSubMenuItem("pak 2"));
            break;
            case "report" :
                listSubMenuItem.add(new JPanelSubMenuItem("pak 1"));
                listSubMenuItem.add(new JPanelSubMenuItem("pak 2"));
                break;
        }
        return new JPanelSubMenu(listSubMenuItem);
    }
}
