
package restaurant.panel.menu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;

public class JPanelSubMenuItem extends javax.swing.JPanel {
    public String name;
    public int targetPanelId = 0;
    public int targetPanelHeaderId = 0;
    public JPanelSubMenuItem(String name, int targetId, int targetHeaderId){
        initComponents();
        this.name = name;
        this.targetPanelId = targetId;
        this.targetPanelHeaderId = targetHeaderId;
        customInit();
    }
    public JPanelSubMenuItem(String name) {
        initComponents();
        this.name = name;
        customInit();
    }
    public JPanelSubMenuItem() {
        initComponents();
        customInit();
    }
    private void customInit(){
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.white));
        jLabelActionName.setText(this.name);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("sub menu is clicked");
                if(targetPanelId!=0){
                    MainFrame.getInstance().changeContentPanel(PanelFactory.get(targetPanelId));
                }
                if(targetPanelHeaderId!=0){
                    MainFrame.getInstance().changeHeaderPanel(PanelFactory.get(targetPanelHeaderId));
                }
        }});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelActionName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(34, 45, 68));
        setPreferredSize(new java.awt.Dimension(245, 40));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 10));

        jLabelActionName.setForeground(new java.awt.Color(240, 255, 255));
        jLabelActionName.setText("jLabel1");
        add(jLabelActionName);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelActionName;
    // End of variables declaration//GEN-END:variables
}
