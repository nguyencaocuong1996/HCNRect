
package restaurant.panel.menu;

import java.awt.Dimension;
import javax.swing.JFrame;
import modal.MStaff;

public class JPanelMenu extends javax.swing.JPanel {
    private static JPanelMenu instance;
    private MStaff staff;
    private final ListMenu listMenu = ListMenu.getInstance();
    public JPanelMenu() {
        initComponents();
        //add to Panel
        listMenu.forEach((t) -> {
            jPanelMenuContent.add(t);
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(70, 92, 139));
        setPreferredSize(new java.awt.Dimension(245, 250));

        jPanelMenuContent.setBackground(new java.awt.Color(70, 92, 139));
        jPanelMenuContent.setPreferredSize(new java.awt.Dimension(250, 500));
        add(jPanelMenuContent);
    }// </editor-fold>//GEN-END:initComponents

    public static JPanelMenu getInstance() {
        if(instance == null) instance = new JPanelMenu();
        return instance;
    }

    public ListMenu getListJPanelMenuItem() {
        return listMenu;
    }

    public MStaff getStaff() {
        return staff;
    }

    public void setStaff(MStaff staff) {
        switch(staff.getDepartmentId())
        {
            case 3:
                listMenu.get(2).setVisible(false);
                listMenu.get(4).setVisible(false);
                listMenu.get(5).setVisible(false);
                listMenu.get(6).setVisible(false);
            break;
        }
        this.staff = staff;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        JPanelMenu jpm = JPanelMenu.getInstance();
        jf.add(jpm);
        jf.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelMenuContent;
    // End of variables declaration//GEN-END:variables
}
