
package restaurant.panel.menu;

public class JPanelSubMenuItem extends javax.swing.JPanel {

    public JPanelSubMenuItem(String name) {
        initComponents();
        jLabel1.setText(name);
    }
    public JPanelSubMenuItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(34, 45, 68));
        setPreferredSize(new java.awt.Dimension(245, 59));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 15));

        jLabel1.setForeground(new java.awt.Color(240, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
