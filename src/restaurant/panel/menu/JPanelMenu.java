
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.order.JPanelListTableForOrder;

public class JPanelMenu extends javax.swing.JPanel {
    private static JPanelMenu instance;
    private ArrayList<JPanelMenuItem> listJPanelMenuItem = new ArrayList<>();;
    public JPanelMenu() {
        initComponents();
        JPanelMenuItem jpMIOrder = new JPanelMenuItem("Gọi món", IconResources.ORDER, 1);
        JPanelMenuItem jpMIBook = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE, 2);
        JPanelMenuItem jpMIPackage = new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, 3, SubMenuFactory.get("package"));
        JPanelMenuItem jpMIReport = new JPanelMenuItem("Báo cáo", IconResources.REPORT, 4);
        JPanelMenuItem jpMIStaff = new JPanelMenuItem("Nhân viên", IconResources.STAFF, 5);
        JPanelMenuItem jpMICoins = new JPanelMenuItem("Giao dịch", IconResources.COINS, 6);
        jpMIOrder.addMouseListener(new MouseListenerMenuItem(JPanelListTableForOrder.getInstance(), PanelFactory.HEADER_PICK_TABLE));
        listJPanelMenuItem.add(jpMIOrder);
        listJPanelMenuItem.add(jpMIBook);
        listJPanelMenuItem.add(jpMIPackage);
        listJPanelMenuItem.add(jpMIReport);
        listJPanelMenuItem.add(jpMIStaff);
        listJPanelMenuItem.add(jpMICoins);
        listJPanelMenuItem.forEach((t) -> {
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

    public ArrayList<JPanelMenuItem> getListJPanelMenuItem() {
        return listJPanelMenuItem;
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
