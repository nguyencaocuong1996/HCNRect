/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel;

import assets.images.icons.IconResources;
import javax.swing.JPanel;
import restaurant.panel.booktable.JPanelBookTable;
import restaurant.panel.header.JPanelHeader;
import restaurant.panel.header.JPanelHeaderOrder;
import restaurant.panel.main.JPanelWelcome;
import restaurant.panel.order.JPanelOrderPickTable;
import restaurant.panel.order.JPanelOrder;
/**
 *
 * @author WINDNCC
 */
public class PanelFactory {
    private static JPanelHeader headerOverview;
    private static JPanelHeader headerOrderPickTable;
    private static JPanelHeader headerOrder;
    private static JPanelHeader headerBookTable;
    private static JPanelWelcome overview;
    private static JPanelSidebar sidebar;
    
    public class ID{
            public static final int SIDEBAR = 1;
            //content
            public static final int ORDER = 111;
            public static final int ORDER_PICK_TABLE = 112;
            public static final int BOOK_TABLE = 121;
            public static final int OVERVIEW = 131;
            //header
            public static final int HEADER_OVERVIEW = 211;
            public static final int HEADER_ORDER_PICK_TABLE = 221;
            public static final int HEADER_ORDER = 231;
            public static final int HEADER_BOOK_TABLE = 241;
    }
    public static JPanel get(int panelId){
        JPanel jp = new JPanel();
        switch(panelId){
            case ID.SIDEBAR:
                if (sidebar == null) sidebar = new JPanelSidebar();
                jp = sidebar;
                break;
                
            case ID.OVERVIEW:
                if(overview == null) overview  = new JPanelWelcome();
                jp = overview;
                break;
                
            case ID.ORDER:
                jp = JPanelOrder.getInstance();
                break;
                
            case ID.ORDER_PICK_TABLE:
                jp = JPanelOrderPickTable.getInstance();
                break;
                
            case ID.BOOK_TABLE:
                jp = JPanelBookTable.getInstance();
                break;
                
            case ID.HEADER_OVERVIEW:
                if (PanelFactory.headerOverview == null) headerOverview = new JPanelHeader("Giới thiệu", IconResources.BOOKTABLE);
                jp = headerOverview;
                break;
                
            case ID.HEADER_ORDER:
                if(PanelFactory.headerOrder == null) headerOrder = new JPanelHeader("Gọi món", IconResources.ORDER, ID.ORDER_PICK_TABLE, ID.HEADER_ORDER_PICK_TABLE);
                jp = headerOrder;
                break;
                
            case ID.HEADER_BOOK_TABLE:
                if (headerBookTable == null) headerBookTable = new JPanelHeader("Danh sách đặt bàn", IconResources.BOOKTABLE);
                jp = headerBookTable;
                break;
                
            case ID.HEADER_ORDER_PICK_TABLE:
                if (headerOrderPickTable == null) headerOrderPickTable = new JPanelHeader("Chọn bàn", IconResources.BOOKTABLE);
                jp = headerOrderPickTable;
            default:
                break;
        }
        return jp;
    }
}
