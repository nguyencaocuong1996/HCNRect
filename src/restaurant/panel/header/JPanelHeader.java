
package restaurant.panel.header;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import restaurant.MainFrame;
import restaurant.panel.booktable.JPanelBookTable;

public class JPanelHeader extends javax.swing.JPanel {
    protected JPanel jPanelBackTarget;
    protected JPanel jPanelBackHeaderTarget;
    protected boolean hasBack = false;
    protected String titleHeader;
    protected ImageIcon titleIcon;
    public JPanelHeader() {
        initComponents();
        jLabelBack.setOpaque(true);
    }

    public JPanelHeader(String titleHeader, ImageIcon titleIcon) {
        initComponents();
        this.titleHeader = titleHeader;
        this.titleIcon = titleIcon;
        customInit();
    }
    public JPanelHeader(String titleHeader, ImageIcon titleIcon, JPanel jPanelBackTarget, JPanel jPanelBackHeaderTarget) {
        initComponents();
        this.hasBack = true;
        this.titleHeader = titleHeader;
        this.titleIcon = titleIcon;
        this.jPanelBackTarget = jPanelBackTarget;
        this.jPanelBackHeaderTarget = jPanelBackHeaderTarget;
        this.jLabelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.getInstance().changeContentPanel(jPanelBackTarget);
                MainFrame.getInstance().changeHeaderPanel(jPanelBackHeaderTarget);
            }         
        });
        customInit();
    }
    public final void customInit(){
        jLabelBack.setOpaque(true);
        jLabelBack.setVisible(hasBack);
        jLabelTitleHeader.setText(titleHeader);
        jLabelTitleHeader.setIcon(titleIcon);
    }
    public JPanelHeader(boolean hasBack) {
        this.hasBack = hasBack;
        jLabelBack.setVisible(hasBack);
    }

    public boolean isHasBack() {
        return hasBack;
    }

    public void setHasBack(boolean hasBack) {
        this.hasBack = hasBack;
    }

    public String getTitleHeader() {
        return titleHeader;
    }

    public void setTitleHeader(String titleHeader) {
        this.titleHeader = titleHeader;
    }

    public ImageIcon getTitleIcon() {
        return titleIcon;
    }

    public void setTitleIcon(ImageIcon titleIcon) {
        this.titleIcon = titleIcon;
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
