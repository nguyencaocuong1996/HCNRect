
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;


public class JPanelMenu extends javax.swing.JPanel {
    public JPanelMenu() {
        initComponents();
        try{
            JPanelMenuItem menuItemPackage = MenuItemFactory.get("package");
            JPanelMenuItem menuItemOrder = MenuItemFactory.get("order");
            JPanelMenuItem menuItemCoins = MenuItemFactory.get("coins");
            JPanelMenuItem menuItemReport = MenuItemFactory.get("report");
            JPanelMenuItem menuItemStaff = MenuItemFactory.get("staff");
            menuItemOrder.setActive(true);
            jPanelMenuContent.add(menuItemOrder);
            jPanelMenuContent.add(menuItemPackage);
            jPanelMenuContent.add(menuItemCoins);
            jPanelMenuContent.add(menuItemReport);
            jPanelMenuContent.add(menuItemStaff);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(70, 92, 139));
        setPreferredSize(new java.awt.Dimension(245, 250));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jPanelMenuContent.setBackground(new java.awt.Color(70, 92, 139));
        jPanelMenuContent.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanelMenuContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        add(jPanelMenuContent);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        JPanelMenu jpm = new JPanelMenu();
        jf.add(jpm);
        jf.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelMenuContent;
    // End of variables declaration//GEN-END:variables
}
