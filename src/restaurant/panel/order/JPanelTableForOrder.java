/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.main.table.JPanelTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelTableForOrder extends JPanelTable{

    
    public JPanelTableForOrder(int tableId, String tableName, int status) {
        super(tableId, tableName, status);
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Constructor in JPanelTableForOrder.java : Mã bàn " + tableId + " vừa được Click:");
                JPanelListTableForOrder.getInstance().setVisible(false);
                JPanelOrder.getInstance().setTableId(tableId);
                JPanelOrder.getInstance().setVisible(true);
                MainFrame.getInstance().changeContentPanel(JPanelOrder.getInstance());
                MainFrame.getInstance().changeHeaderPanel(PanelFactory.HEADER_ORDER);
            }
        };
        addMouseListener(mouseAdapter);
    }

}
