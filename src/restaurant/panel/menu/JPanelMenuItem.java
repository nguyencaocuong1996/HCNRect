
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelMenuItem extends javax.swing.JPanel {
    public String actionName;
    protected ImageIcon icon;
    protected boolean active = false;
    
    public JPanelMenuItem(String actionName, ImageIcon icon, boolean hasSub) {
        initComponents();
        jLabelActionName.setText(actionName);
        jLabelIcon.setIcon(icon);
        jPanelActive.setVisible(false);
        if(hasSub == true)
        {
            jLabelIconPlus.setIcon(IconResources.PLUS_X24);
        }
    }
    
    public JPanelMenuItem(String actionName, ImageIcon icon) {
        initComponents();
        jLabelActionName.setText(actionName);
        jPanelActive.setVisible(false);
        jLabelIcon.setIcon(icon);
    }
    
    public JPanelMenuItem() {
        initComponents();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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
        jPanelActive.setPreferredSize(new java.awt.Dimension(15, 50));
        jPanelActive.setLayout(null);
        add(jPanelActive);

        jLabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcon.setMaximumSize(new java.awt.Dimension(70, 50));
        jLabelIcon.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabelIcon.setPreferredSize(new java.awt.Dimension(70, 50));
        add(jLabelIcon);

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
