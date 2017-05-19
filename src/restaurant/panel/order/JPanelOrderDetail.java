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

public class JPanelOrderDetail extends javax.swing.JPanel {
    public ArrayList<JPanelOrderItem> listDishOrdering = new ArrayList<>();
    
    public JPanelOrderDetail() {
        initComponents();
        listDishOrdering.add(new JPanelOrderItem("cuong dep trai", 10, 110000));
        listDishOrdering.add(new JPanelOrderItem("huy xau trai", 10, 120000));
        jPanelListOrdering.setPreferredSize(new Dimension(295, listDishOrdering.size() * 35));
        listDishOrdering.forEach((t) -> {
            jPanelListOrdering.add(t);
        });
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

        setMaximumSize(new java.awt.Dimension(295, 245));
        setMinimumSize(new java.awt.Dimension(295, 245));
        setPreferredSize(new java.awt.Dimension(295, 245));
        add(jPanelListOrdering);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelListOrdering;
    // End of variables declaration//GEN-END:variables
}
