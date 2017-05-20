
package restaurant.panel.menu;

import assets.font.CFont;
import assets.images.icons.IconResources;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelMenuItem extends javax.swing.JPanel {
    public String actionName;
    protected ImageIcon icon;
    protected JPanelSubMenu jpSubMenu;
    protected boolean active = false;
    protected boolean hasSub = false;
    protected int orderInMenu = 0;
    public JPanelMenuItem(String actionName, ImageIcon icon, int orderInMenu, JPanelSubMenu subMenu) {
        initComponents();
        jLabelIconPlus.setIcon(IconResources.PLUS_X24);
        this.jpSubMenu = subMenu;
        this.add(this.jpSubMenu);
        hasSub = true;
        customInit( actionName,  icon,  orderInMenu);
    }
    
    public JPanelMenuItem(String actionName, ImageIcon icon, int orderInMenu) {
        initComponents();
        customInit( actionName,  icon,  orderInMenu);
    }
    public final void customInit(String actionName, ImageIcon icon, int orderInMenu){
        this.actionName = actionName;
        jLabelActionName.setText(actionName);
        jPanelActive.setVisible(false);
        jLabelIcon.setIcon(icon);
        CFont.setStyleFont(jLabelActionName, 15, Color.white);
        this.orderInMenu = orderInMenu;
    }

    public int getOrderInMenu() {
        return orderInMenu;
    }

    public void setOrderInMenu(int orderInMenu) {
        this.orderInMenu = orderInMenu;
    }
    
    public boolean isHasSub() {
        return hasSub;
    }

    
    public JLabel getjLabelIcon() {
        return jLabelIcon;
    }

    public JPanel getjPanelActive() {
        return jPanelActive;
    }
    
    public JPanelMenuItem() {
        initComponents();
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        if (jpSubMenu != null) {
            if (active) {
                Dimension newSize = new Dimension( 250, jpSubMenu.getPreferredSize().height + 40);
                this.setPreferredSize(newSize);
                this.setBackground(new Color(34, 45, 68));
            } else {
                this.setBackground(new Color(70, 92, 139));
                this.setPreferredSize(new Dimension(250, 40)); 
            }
            jpSubMenu.setVisible(active);
        }
        jPanelActive.setVisible(active);
        this.active = active;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelActive = new javax.swing.JPanel();
        jLabelIcon = new javax.swing.JLabel();
        jLabelActionName = new javax.swing.JLabel();
        jLabelIconPlus = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(70, 92, 139));
        setMinimumSize(new java.awt.Dimension(250, 50));
        setPreferredSize(new java.awt.Dimension(250, 50));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelActive.setBackground(new java.awt.Color(147, 193, 120));
        jPanelActive.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanelActive.setLayout(null);
        add(jPanelActive);

        jLabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcon.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelIcon.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelIcon.setPreferredSize(new java.awt.Dimension(70, 50));
        add(jLabelIcon);

        jLabelActionName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelActionName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelActionName.setPreferredSize(new java.awt.Dimension(100, 50));
        add(jLabelActionName);

        jLabelIconPlus.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jLabelIconPlus);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelActionName;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelIconPlus;
    private javax.swing.JPanel jPanelActive;
    // End of variables declaration//GEN-END:variables
}
