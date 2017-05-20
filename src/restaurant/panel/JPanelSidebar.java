/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel;
import java.awt.Dimension;
import javax.swing.JFrame;
import restaurant.panel.menu.JPanelMenu;


public class JPanelSidebar extends javax.swing.JPanel {


    public JPanelSidebar() {
        initComponents();
        JPanelMenu jpMenu = JPanelMenu.getInstance();
        jPanelSidebarContent.add(jpMenu);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelSidebarHeader = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelSidebarContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(70, 92, 139));
        setMaximumSize(new java.awt.Dimension(250, 600));
        setMinimumSize(new java.awt.Dimension(250, 600));
        setPreferredSize(new java.awt.Dimension(250, 600));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        JPanelSidebarHeader.setBackground(new java.awt.Color(70, 92, 139));
        JPanelSidebarHeader.setPreferredSize(new java.awt.Dimension(250, 80));

        javax.swing.GroupLayout JPanelSidebarHeaderLayout = new javax.swing.GroupLayout(JPanelSidebarHeader);
        JPanelSidebarHeader.setLayout(JPanelSidebarHeaderLayout);
        JPanelSidebarHeaderLayout.setHorizontalGroup(
            JPanelSidebarHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelSidebarHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        JPanelSidebarHeaderLayout.setVerticalGroup(
            JPanelSidebarHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelSidebarHeaderLayout.createSequentialGroup()
                .addGap(0, 70, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(JPanelSidebarHeader);

        jPanelSidebarContent.setBackground(new java.awt.Color(70, 92, 139));
        jPanelSidebarContent.setMaximumSize(new java.awt.Dimension(250, 520));
        jPanelSidebarContent.setMinimumSize(new java.awt.Dimension(250, 520));
        jPanelSidebarContent.setPreferredSize(new java.awt.Dimension(250, 520));
        jPanelSidebarContent.setLayout(new javax.swing.BoxLayout(jPanelSidebarContent, javax.swing.BoxLayout.Y_AXIS));
        add(jPanelSidebarContent);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,600));
        JPanelSidebar js = new JPanelSidebar();
        js.setVisible(true);
        jf.add(js);
        jf.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelSidebarHeader;
    private javax.swing.JPanel jPanelSidebarContent;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
