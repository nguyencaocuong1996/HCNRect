/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel;

import assets.images.icons.IconResources;
import restaurant.panel.header.JPanelHeader;
import restaurant.panel.header.JPanelHeaderOrder;
import restaurant.panel.main.JPanelWelcome;
import restaurant.panel.order.JPanelListTableForOrder;
/**
 *
 * @author WINDNCC
 */
public class PanelFactory {
    public static JPanelHeader HEADER_OVERVIEW = new JPanelHeader(false, "Giới thiệu", IconResources.BOOKTABLE);
    public static JPanelHeaderOrder HEADER_ORDER = new JPanelHeaderOrder();
    public static final JPanelWelcome CONTENT_OVERVIEW = new JPanelWelcome();
    
    public static final JPanelSidebar SIDEBAR = new JPanelSidebar();
    
    public static final JPanelListTableForOrder CONTENT_LIST_TABLE_FOR_ORDER = JPanelListTableForOrder.getInstance();
}
