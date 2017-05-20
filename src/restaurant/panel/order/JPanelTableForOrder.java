/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import restaurant.MainFrame;
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
                JPanelListTableForOrder.getInstance().setVisible(false);
                System.out.println(tableId);
                JPanelOrder.getInstance().setTableId(tableId);
                JPanelOrder.getInstance().setVisible(true);
//                MainFrame.getInstance().getjPanelContent().revalidate();
//                MainFrame.getInstance().getjPanelContent().repaint();
                System.out.println("order action");
            }
        };
        addMouseListener(mouseAdapter);
    }

}
