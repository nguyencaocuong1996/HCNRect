/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import restaurant.panel.main.table.JPanelListTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelListTableForOrder extends JPanelListTable{

    public JPanelListTableForOrder() {
        super();
        listTable.getData().forEach((t) -> {
            Integer tId = (Integer) t.get("MaBan");
            JPanelTableForOrder jpTFO = new JPanelTableForOrder(tId, (String) t.get("TenBan"), (Integer) t.get("TrangThai"));
            listJPanelTable.put(tId, jpTFO);
        });
        filter();
    }
        
        public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelListTableForOrder());
        jf.setVisible(true);
    }
}
