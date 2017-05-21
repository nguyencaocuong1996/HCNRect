/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import restaurant.panel.main.table.JPanelListTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelOrderPickTable extends JPanelListTable{
    private static JPanelOrderPickTable instance;
    public JPanelOrderPickTable() {
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
        jf.add(new JPanelOrderPickTable());
        jf.setVisible(true);
    }

    public static JPanelOrderPickTable getInstance() {
        if(instance == null) instance = new JPanelOrderPickTable();
        return instance;
    }
        
}
