
package restaurant.panel.menu;

import java.util.ArrayList;

public class JPanelSubMenu extends javax.swing.JPanel {

    ArrayList<JPanelSubMenuItem> listSubMenuItem;
    public JPanelSubMenu(ArrayList<JPanelSubMenuItem> listSubMenuItem) {
        initComponents();
        this.listSubMenuItem = listSubMenuItem;
        this.listSubMenuItem.forEach((item)->{
            this.add(item);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(34, 45, 68));
        setPreferredSize(null);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
