
package restaurant.panel.header;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;

public class JPanelHeader extends javax.swing.JPanel {
    protected int jPanelBackTargetId;
    protected int jPanelBackHeaderTargetId;
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
        hasBack = true;
        this.jLabelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.getInstance().back();
            }
        });
        customInit();
    }
    public JPanelHeader(String titleHeader, ImageIcon titleIcon, int jPanelBackTargetId, int jPanelBackHeaderTargetId) {
        initComponents();
        this.hasBack = true;
        this.titleHeader = titleHeader;
        this.titleIcon = titleIcon;
        this.jPanelBackTargetId = jPanelBackTargetId;
        this.jPanelBackHeaderTargetId = jPanelBackHeaderTargetId;
        this.jLabelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.getInstance().changeContentPanel(PanelFactory.get(jPanelBackTargetId));
                MainFrame.getInstance().changeHeaderPanel(PanelFactory.get(jPanelBackHeaderTargetId));
            }         
        });
        customInit();
    }
    public final void customInit(){
        jPanelUserInfo.setVisible(false);
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
        jPanelShowUserInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelUserInfo = new javax.swing.JPanel();

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
        add(jLabelTitleHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 320, 60));

        jLabelBack.setBackground(new java.awt.Color(102, 102, 102));
        jLabelBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_back_white_x50.png"))); // NOI18N
        add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 80));

        jPanelShowUserInfo.setBackground(new java.awt.Color(102, 102, 102));
        jPanelShowUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelShowUserInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelShowUserInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelShowUserInfoMouseExited(evt);
            }
        });
        jPanelShowUserInfo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_avata_white_x50.png"))); // NOI18N
        jPanelShowUserInfo.add(jLabel2);

        add(jPanelShowUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 100, 80));

        jPanelUserInfo.setBackground(new java.awt.Color(102, 102, 102));
        add(jPanelUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 210, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelShowUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelShowUserInfoMouseClicked
        if (this.getParent().getParent() != null) {
            JPanel jp = MainFrame.getInstance().getjPanelUserInfo();
            jPanelUserInfo.setVisible(!jPanelUserInfo.isVisible());
            if (!(jp.getParent() == jPanelUserInfo)) {
                jPanelUserInfo.add(jp);
                repaint();
            } else {
                jPanelUserInfo.remove(jp);
                repaint();
            }
        }
        
//        JDialog jd = MainFrame.getInstance().getjDialogUserInfo();
//        jd.setVisible(!jd.isVisible());
    }//GEN-LAST:event_jPanelShowUserInfoMouseClicked

    private void jPanelShowUserInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelShowUserInfoMouseEntered
        
    }//GEN-LAST:event_jPanelShowUserInfoMouseEntered

    private void jPanelShowUserInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelShowUserInfoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelShowUserInfoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelTitleHeader;
    private javax.swing.JPanel jPanelShowUserInfo;
    private javax.swing.JPanel jPanelUserInfo;
    // End of variables declaration//GEN-END:variables
}
