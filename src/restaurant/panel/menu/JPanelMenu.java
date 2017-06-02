
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JFrame;
import modal.MStaff;
import restaurant.panel.PanelFactory;

public class JPanelMenu extends javax.swing.JPanel {
    private static JPanelMenu instance;
    private MStaff staff;
    private ArrayList<JPanelMenuItem> listJPanelMenuItem = new ArrayList<>();;
    public JPanelMenu() {
        initComponents();
        //Create item
        JPanelMenuItem jpMIOrder = new JPanelMenuItem("Gọi món", IconResources.ORDER, 1);
        JPanelMenuItem jpMIBook = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE, 2);
        JPanelMenuItem jpMIPackage = new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, 3, SubMenuFactory.get("package"));
        JPanelMenuItem jpMIReport = new JPanelMenuItem("Báo cáo", IconResources.REPORT, 4, SubMenuFactory.get("report"));
        JPanelMenuItem jpMIPartner = new JPanelMenuItem("Đối tác", IconResources.PARTNER, 6, SubMenuFactory.get("partner"));
        JPanelMenuItem jpMICoins = new JPanelMenuItem("Giao dịch", IconResources.COINS, 7,SubMenuFactory.get("transaction"));
        JPanelMenuItem jpMIStaff = new JPanelMenuItem("Nhân viên", IconResources.STAFF, 8);

        //Add mouseListener
        jpMIOrder.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.ORDER_PICK_TABLE, PanelFactory.ID.HEADER_ORDER_PICK_TABLE));
        jpMIBook.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.BOOK_TABLE, PanelFactory.ID.HEADER_BOOK_TABLE));
        jpMIStaff.addMouseListener(new MouseListenerMenuItem(PanelFactory.ID.MANAGE_STAFF, PanelFactory.ID.HEADER_MANAGE_STAFF));
        jpMIPackage.addMouseListener(new MouseListenerMenuItem());
        jpMIReport.addMouseListener(new MouseListenerMenuItem());
        jpMIPartner.addMouseListener(new MouseListenerMenuItem());
        jpMICoins.addMouseListener(new MouseListenerMenuItem());
        //add to List
        listJPanelMenuItem.add(jpMIOrder);
        listJPanelMenuItem.add(jpMIBook);
        listJPanelMenuItem.add(jpMIPackage);
        listJPanelMenuItem.add(jpMIReport);
        listJPanelMenuItem.add(jpMIPartner);
        listJPanelMenuItem.add(jpMICoins);
        listJPanelMenuItem.add(jpMIStaff);
        listJPanelMenuItem.sort((JPanelMenuItem o1, JPanelMenuItem o2) -> {
            if (o1.getOrderInMenu() > o2.getOrderInMenu()){
                return 1;
            } else {
                if(o1.getOrderInMenu() < o2.getOrderInMenu())
                    return -1;
            }
            return 0;
        });
        
        //add to Panel
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

    public MStaff getStaff() {
        return staff;
    }

    public void setStaff(MStaff staff) {
        switch(staff.getDepartmentId())
        {
            case 3:
                listJPanelMenuItem.get(2).setVisible(false);
                listJPanelMenuItem.get(4).setVisible(false);
                listJPanelMenuItem.get(5).setVisible(false);
                listJPanelMenuItem.get(6).setVisible(false);
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
