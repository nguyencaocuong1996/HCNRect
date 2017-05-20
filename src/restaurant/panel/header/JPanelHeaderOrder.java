
package restaurant.panel.header;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import restaurant.panel.order.JPanelListTableForOrder;
import restaurant.panel.order.JPanelOrder;

public class JPanelHeaderOrder extends javax.swing.JPanel {
    
    
    public JPanelHeaderOrder() {
        initComponents();
        jLabelBack.setOpaque(true);
        jLabelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelOrder.getInstance().setVisible(false);
                JPanelListTableForOrder.getInstance().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(147, 193, 120));
        setPreferredSize(new java.awt.Dimension(770, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_order_white_x50.png"))); // NOI18N
        jLabel1.setText("Đặt món");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 220, 60));

        jLabelBack.setBackground(new java.awt.Color(102, 102, 102));
        jLabelBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_back_white_x50.png"))); // NOI18N
        add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBack;
    // End of variables declaration//GEN-END:variables
}
