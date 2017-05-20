/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.VDishOrdering;

public class JPanelOrderDetail extends javax.swing.JPanel {
    public ArrayList<JPanelOrderItem> listDishOrdering = new ArrayList<>();
    public JPanel targetPanel;
    private VDishOrdering vDishOrdering;
    private int tableId;

    public JPanelOrderDetail(int tableId) {
        initComponents();
        this.tableId = tableId;
        vDishOrdering = VDishOrdering.getByTableId(tableId);
        if(vDishOrdering.getData().size() > 0 ){
            vDishOrdering.getData().forEach((t) -> {
                Long qty = (Long) t.get("SoLuong");
                JPanelOrderItem jpOI = new JPanelOrderItem(this.tableId, (String) t.get("TenMA"), qty.intValue() , (Float) t.get("GiaMA"));
                addOrderItem(jpOI);
            });
        }
    }
    
    public JPanelOrderDetail(int tableId, JPanel targetPanel) {
        initComponents();
        this.targetPanel = targetPanel;
        this.tableId = tableId;
        vDishOrdering = VDishOrdering.getByTableId(tableId);
        if(vDishOrdering.getData().size() > 0 ){
            vDishOrdering.getData().forEach((t) -> {
                Long qty = (Long) t.get("SoLuong");
                JPanelOrderItem jpOI = new JPanelOrderItem(this.tableId, (String) t.get("TenMA"), qty.intValue() , (Float) t.get("GiaMA"));
                addOrderItem(jpOI);
            });
        }
    }
    public void setTargetPanel(JPanel targetPanel) {
        this.targetPanel = targetPanel;
        this.targetPanel.add(this);
        this.targetPanel.setPreferredSize(jPanelListOrdering.getPreferredSize());
    }
    public void addOrderItem(JPanelOrderItem jpOrderItem){
        listDishOrdering.add(jpOrderItem);
        jPanelListOrdering.add(jpOrderItem, 0);
        Dimension d = new Dimension(295, listDishOrdering.size() * 35);
        targetPanel.setPreferredSize(d);
        jPanelListOrdering.setPreferredSize(d);
    }
    public void removeOrderItem(JPanelOrderItem jpOrderItem){
        listDishOrdering.remove(jpOrderItem);
        jPanelListOrdering.remove(jpOrderItem);
        Dimension d = new Dimension(295, listDishOrdering.size() * 35);
        JPanelOrder.getInstance().getJpOrderDish().getListOrderDishItem().get(jpOrderItem.getDishId()).setExistsInOrdering(false);
        targetPanel.setPreferredSize(d);
        jPanelListOrdering.setPreferredSize(d);
    }
    public JPanelOrderDetail() {
        initComponents();
    }

    public JPanel getjPanelListOrdering() {
        return jPanelListOrdering;
    }

        public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelOrderDetail());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListOrdering = new javax.swing.JPanel();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(null);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelListOrdering.setBackground(new java.awt.Color(227, 227, 227));
        jPanelListOrdering.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jPanelListOrdering.setMinimumSize(new java.awt.Dimension(293, 243));
        jPanelListOrdering.setPreferredSize(new java.awt.Dimension(293, 243));
        jPanelListOrdering.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));
        add(jPanelListOrdering);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelListOrdering;
    // End of variables declaration//GEN-END:variables
}
