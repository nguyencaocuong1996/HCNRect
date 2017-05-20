/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import java.awt.Dimension;
import javax.swing.JPanel;
import restaurant.panel.JPanelSidebar;
import restaurant.panel.header.JPanelHeaderOrder;
import restaurant.panel.order.JPanelListTableForOrder;
import restaurant.panel.order.JPanelOrder;
/**
 *
 * @author WINDNCC
 */
public class MainFrame extends javax.swing.JFrame {
    private static MainFrame instance;
    public JPanelSidebar sidebar = new JPanelSidebar();
    public JPanelListTableForOrder listTable;
    public JPanelOrder jPanelOrder = JPanelOrder.getInstance();
    public MainFrame() {
        initComponents();
        jPanelHeader.add(new JPanelHeaderOrder());
        JPanelSideBar.add(sidebar);
        listTable = JPanelListTableForOrder.getInstance();
        jPanelContent.add(listTable);
        jPanelOrder.setVisible(false);
        jPanelContent.add(jPanelOrder);
        jPanelContent.revalidate();
    }

    public static MainFrame getInstance() {
        if(instance == null) instance = new MainFrame();
        return instance;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return SizeConst.MAIN_FRAME_SIZE;
    }

    public JPanel getJPanelSideBar() {
        return JPanelSideBar;
    }

    public JPanel getjPanelContent() {
        return jPanelContent;
    }

    public JPanel getjPanelHeader() {
        return jPanelHeader;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        JPanelSideBar = new javax.swing.JPanel();
        jPanelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setPreferredSize(getPreferredSize());
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    // End of variables declaration//GEN-END:variables
}
