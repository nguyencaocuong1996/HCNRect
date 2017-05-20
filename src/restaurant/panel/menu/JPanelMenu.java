
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;


public class JPanelMenu extends javax.swing.JPanel {
    private static JPanelMenu instance;
    private HashMap<Integer, JPanelMenuItem> listJPanelMenuItem;
    public JPanelMenu() {
        initComponents();
        try{
            listJPanelMenuItem = new HashMap<>();
            listJPanelMenuItem.put(1, MenuItemFactory.get("order"));
            listJPanelMenuItem.put(2, MenuItemFactory.get("book"));
            listJPanelMenuItem.put(3, MenuItemFactory.get("package"));
            listJPanelMenuItem.put(4, MenuItemFactory.get("coins"));
            listJPanelMenuItem.put(5, MenuItemFactory.get("report"));
            listJPanelMenuItem.put(6, MenuItemFactory.get("staff"));
            listJPanelMenuItem.put(7, MenuItemFactory.get("partner"));
//            JPanelMenuItem menuItemPackage = ;
//            JPanelMenuItem menuItemOrder = MenuItemFactory.get("order");
//            JPanelMenuItem menuItemBookTable = MenuItemFactory.get("book");
//            JPanelMenuItem menuItemCoins = MenuItemFactory.get("coins");
//            JPanelMenuItem menuItemReport = MenuItemFactory.get("report");
//            JPanelMenuItem menuItemStaff = MenuItemFactory.get("staff");
//            JPanelMenuItem menuItemPartner = MenuItemFactory.get("partner");
            MouseListenerMenuItem ml = new MouseListenerMenuItem(jPanelMenuContent);
            for (Map.Entry<Integer, JPanelMenuItem> entry : listJPanelMenuItem.entrySet()) {
                Integer key = entry.getKey();
                JPanelMenuItem value = entry.getValue();
                value.addMouseListener(ml);
                jPanelMenuContent.add(value, key);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
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

    public HashMap<Integer, JPanelMenuItem> getListJPanelMenuItem() {
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
