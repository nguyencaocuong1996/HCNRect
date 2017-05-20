
package restaurant.panel.header;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import restaurant.panel.booktable.JPanelBookTable;

public class JPanelHeader extends javax.swing.JPanel {

    protected boolean hasBack;
    protected String titleHeader;
    
    public JPanelHeader() {
        initComponents();
        jLabelBack.setOpaque(true);
    }

    public JPanelHeader(boolean hasBack, String titleHeader) {
        this.hasBack = hasBack;
        this.titleHeader = titleHeader;
        
        jLabelBack.setOpaque(true);
        
    }

    public JPanelHeader(boolean hasBack) {
        this.hasBack = hasBack;
        jLabelBack.setVisible(hasBack);
    }
    
    
        public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(814, 500));
        jf.add(new JPanelHeader());
        jf.setVisible(true);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitleHeader = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(147, 193, 120));
        setMinimumSize(new java.awt.Dimension(770, 80));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitleHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitleHeader.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitleHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_order_white_x50.png"))); // NOI18N
        jLabelTitleHeader.setText("Đặt món");
        jLabelTitleHeader.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelTitleHeader.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelTitleHeader.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jLabelTitleHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 220, 60));

        jLabelBack.setBackground(new java.awt.Color(102, 102, 102));
        jLabelBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_back_white_x50.png"))); // NOI18N
        add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_avata_white_x50.png"))); // NOI18N
        jPanel1.add(jLabel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_down_white_fill_x24.png"))); // NOI18N
        jPanel1.add(jLabel3);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 100, 80));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelTitleHeader;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
