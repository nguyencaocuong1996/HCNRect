/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

/**
 *
 * @author WINDNCC
 */
public class JPanelSubMenuItem extends javax.swing.JPanel {

    public JPanelSubMenuItem(String name) {
        initComponents();
        jLabel1.setText(name);
    }
    public JPanelSubMenuItem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(34, 45, 68));
        setPreferredSize(new java.awt.Dimension(200, 35));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 15));

        jLabel1.setForeground(new java.awt.Color(240, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
