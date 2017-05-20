
package restaurant.panel.menu;

import java.awt.Dimension;
import java.util.ArrayList;

public class JPanelSubMenu extends javax.swing.JPanel {

    ArrayList<JPanelSubMenuItem> listSubMenuItem;
    public JPanelSubMenu(ArrayList<JPanelSubMenuItem> listSubMenuItem) {
        initComponents();
        this.listSubMenuItem = listSubMenuItem;
        this.listSubMenuItem.forEach((item)->{
            this.add(item);
        });
        int height = this.listSubMenuItem.size() * 44;
        this.setPreferredSize(new Dimension(250, height));
        setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(34, 45, 68));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
