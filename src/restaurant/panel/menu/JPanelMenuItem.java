/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author WINDNCC
 */
public class JPanelMenuItem extends javax.swing.JPanel {
    public String actionName;
    protected ImageIcon icon;
    
    public JPanelMenuItem(String actionName, ImageIcon icon) {
        initComponents();
        jLabelActionName.setText(actionName);
        jLabelIcon.setIcon(icon);
    }
    public JPanelMenuItem() {
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelIcon = new javax.swing.JLabel();
        jLabelActionName = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(70, 92, 139));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(250, 50));
        setPreferredSize(new java.awt.Dimension(200, 50));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(147, 193, 120));
        jPanel1.setLayout(null);
        add(jPanel1);

        jLabelIcon.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabelIcon.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabelIcon.setPreferredSize(new java.awt.Dimension(32, 32));
        add(jLabelIcon);

        jLabelActionName.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabelActionName);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelActionName;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
