/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import assets.font.CFont;
import core.CDateTime;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import modal.MDepartment;
import modal.MStaff;
import modal.MUser;
import restaurant.panel.JPanelSidebar;
import restaurant.panel.PanelFactory;
import restaurant.panel.order.JPanelOrderPickTable;
import restaurant.panel.order.JPanelOrder;
/**
 *
 * @author WINDNCC
 */
public class MainFrame extends javax.swing.JFrame {
    private static MainFrame instance;
    public JPanelSidebar sidebar = new JPanelSidebar();
    public JPanelOrderPickTable listTable;
    public JPanelOrder jPanelOrder = JPanelOrder.getInstance();
    private MUser user;
    private MStaff staff;
    private MDepartment department;
    private JPanel currentJPHeader;
    private JPanel currentJPContent;
    private JPanel backJPHeader;
    private JPanel backJPContent;
    public MainFrame() {
        initComponents();
        UIManager.put("OptionPane.okButtonText", "Xác nhận");
        UIManager.put("OptionPane.yesButtonText", "Đồng ý");
        UIManager.put("OptionPane.noButtonText", "Hủy");
        UIManager.put("OptionPane.cancelButtonText", "Bỏ qua");
        setCurrentJPContent(PanelFactory.get(PanelFactory.ID.OVERVIEW));
        setCurrentJPHeader(PanelFactory.get(PanelFactory.ID.HEADER_OVERVIEW));
        jPanelHeader.add(PanelFactory.get(PanelFactory.ID.HEADER_OVERVIEW));
        jPanelContent.add(PanelFactory.get(PanelFactory.ID.OVERVIEW));
        JPanelSideBar.add(sidebar);
        customInit();
    }
    public final void customInit(){
        CFont.setStyleFont(jLabelClock, 14, Color.white);
        CFont.setStyleFont(jLabelOverView, 11, Color.white);
        ActionListener updateClockAction = (ActionEvent e) -> {
            CDateTime current = new CDateTime();
            jLabelClock.setText(current.getTime().toString() + " " +current.getDate().toDMY());
        };
        Timer t = new Timer(1000, updateClockAction);
        t.start();
    }
    public void back(){
        if (this.backJPContent != null && this.backJPHeader != null) {
            changeContentPanel(backJPContent);
            changeHeaderPanel(backJPHeader);
        }
    }
    public void changeContentPanel(JPanel targetPanel){
        setBackJPContent(currentJPContent);
        setCurrentJPContent(targetPanel);
        jPanelContent.removeAll();
        targetPanel.setVisible(true);
        jPanelContent.add(targetPanel);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }
    public void changeHeaderPanel(JPanel targetPanel){
        setBackJPHeader(currentJPHeader);
        setCurrentJPHeader(targetPanel);
        jPanelHeader.removeAll();
        jPanelHeader.add(targetPanel);
        jPanelHeader.revalidate();
        jPanelHeader.repaint();
    }
    public static MainFrame getInstance() {
        if(instance == null) instance = new MainFrame();
        return instance;
    }


    public JPanel getJPanelSideBar() {
        return JPanelSideBar;
    }

    public JPanel getjPanelUserInfo() {
        return jPanelUserInfo;
    }

    public JPanel getjPanelContent() {
        return jPanelContent;
    }

    public JPanel getjPanelHeader() {
        return jPanelHeader;
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        
        this.user = user;
    }

    public MStaff getStaff() {
        return staff;
    }

    public void setStaff(MStaff staff) {
        this.jLabelStaffName.setText(staff.getName());
        this.staff = staff;
    }

    public MDepartment getDepartment() {
        return department;
    }

    public void setDepartment(MDepartment department) {
        jLabelDepartment.setText(department.getName());
        System.out.println(department.getId() + department.getName());
        this.department = department;
    }

    public JPanel getCurrentJPHeader() {
        return currentJPHeader;
    }

    public final void setCurrentJPHeader(JPanel currentJPHeader) {
        this.currentJPHeader = currentJPHeader;
    }

    public JPanel getCurrentJPContent() {
        return currentJPContent;
    }

    public final void setCurrentJPContent(JPanel currentJPContent) {
        this.currentJPContent = currentJPContent;
    }

    public JPanel getBackJPHeader() {
        return backJPHeader;
    }

    public void setBackJPHeader(JPanel backJPHeader) {
        this.backJPHeader = backJPHeader;
    }

    public JPanel getBackJPContent() {
        return backJPContent;
    }

    public void setBackJPContent(JPanel backJPContent) {
        this.backJPContent = backJPContent;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUserInfo = new javax.swing.JPanel();
        jLabelStaffName = new javax.swing.JLabel();
        jLabelDepartment = new javax.swing.JLabel();
        jLabelDoLogout = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        JPanelSideBar = new javax.swing.JPanel();
        jPanelContent = new javax.swing.JPanel();
        jPanelFooter = new javax.swing.JPanel();
        jLabelClock = new javax.swing.JLabel();
        jLabelOverView = new javax.swing.JLabel();

        jPanelUserInfo.setBackground(new java.awt.Color(102, 102, 102));
        jPanelUserInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelStaffName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStaffName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_id_card_white_x32.png"))); // NOI18N
        jLabelStaffName.setText("cường đẹp trai");
        jPanelUserInfo.add(jLabelStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 20));

        jLabelDepartment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDepartment.setText("Giám đốc");
        jPanelUserInfo.add(jLabelDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, -1));

        jLabelDoLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_import_white_x32.png"))); // NOI18N
        jLabelDoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoLogoutMouseClicked(evt);
            }
        });
        jPanelUserInfo.add(jLabelDoLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 40, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        setMinimumSize(getPreferredSize());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeader.setBackground(new java.awt.Color(147, 193, 120));
        jPanelHeader.setMaximumSize(new java.awt.Dimension(770, 80));
        jPanelHeader.setMinimumSize(new java.awt.Dimension(770, 80));
        jPanelHeader.setPreferredSize(SizeConst.MF_HEADER_SIZE);
        jPanelHeader.setLayout(new javax.swing.OverlayLayout(jPanelHeader));
        getContentPane().add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 770, 80));

        JPanelSideBar.setBackground(new java.awt.Color(51, 255, 0));
        JPanelSideBar.setMinimumSize(restaurant.SizeConst.MF_SIDE_BAR_SIZE);
        JPanelSideBar.setPreferredSize(SizeConst.MF_SIDE_BAR_SIZE);
        JPanelSideBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        getContentPane().add(JPanelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 600));

        jPanelContent.setBackground(new java.awt.Color(204, 204, 255));
        jPanelContent.setPreferredSize(SizeConst.MF_CONTENT_SIZE);
        jPanelContent.setLayout(new javax.swing.OverlayLayout(jPanelContent));
        getContentPane().add(jPanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 770, 520));

        jPanelFooter.setBackground(new java.awt.Color(70, 92, 139));
        jPanelFooter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jLabelClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClock.setText("CLOCK");
        jLabelClock.setPreferredSize(new java.awt.Dimension(250, 20));
        jPanelFooter.add(jLabelClock);

        jLabelOverView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOverView.setText("Phần mềm quản lý nhà hàng ---- Th.S Lê Thanh Trọng  ---- Sinh viên:  Nguyễn Cao Cường, Trần Khánh Nguyên, Võ Quang Huy");
        jLabelOverView.setPreferredSize(new java.awt.Dimension(770, 14));
        jPanelFooter.add(jLabelOverView);

        getContentPane().add(jPanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1020, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoLogoutMouseClicked
        LoginFrame.getInstance().setVisible(true);
        MainFrame.getInstance().dispose();
    }//GEN-LAST:event_jLabelDoLogoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame.getInstance().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelSideBar;
    private javax.swing.JLabel jLabelClock;
    private javax.swing.JLabel jLabelDepartment;
    private javax.swing.JLabel jLabelDoLogout;
    private javax.swing.JLabel jLabelOverView;
    private javax.swing.JLabel jLabelStaffName;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelUserInfo;
    // End of variables declaration//GEN-END:variables
}
