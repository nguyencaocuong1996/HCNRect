
package restaurant.panel.menu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class JPanelSubMenuItem extends javax.swing.JPanel {

    public JPanelSubMenuItem(String name) {
        initComponents();
        customInit();
        jLabel1.setText(name);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("sub menu is clicked");
            }
            
});
    }
    public JPanelSubMenuItem() {
        initComponents();
        customInit();
    }
    private void customInit(){
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.white));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(34, 45, 68));
        setPreferredSize(new java.awt.Dimension(245, 40));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 10));

        jLabel1.setForeground(new java.awt.Color(240, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
