
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import javax.swing.JFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.order.JPanelOrderPickTable;

public class MenuItemFactory {
    public static JPanelMenuItem get(String type) throws Exception{
        JPanelMenuItem jpi = new JPanelMenuItem();
        try{
        switch(type){
            case "order":
                jpi = new JPanelMenuItem("Đặt món", IconResources.ORDER, 1);
//                jpi.addMouseListener(new MouseListenerMenuItem(JPanelListTableForOrder.getInstance(), PanelFactory.HEADER_ORDER));
                break;
            case "book":
                 jpi = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE, 2);
//                 jpi.addMouseListener(new MouseListenerMenuItem(PanelFactory.CONTENT_OVERVIEW, PanelFactory.HEADER_OVERVIEW));
                 break;
            case "partner":
                jpi = new JPanelMenuItem("Đối tác", IconResources.PARTNER, 3);
                break;
            case "package":
                jpi =  new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, 4, SubMenuFactory.get("package"));
                break;
            case "coins":
                jpi = new JPanelMenuItem("Giao dịch", IconResources.COINS, 5);
                break;
            case "report":
                jpi =  new JPanelMenuItem("Báo cáo", IconResources.REPORT, 5, SubMenuFactory.get("report"));
                break;
            case "staff":
                jpi = new JPanelMenuItem("Nhân viên", IconResources.STAFF, 6);
                break;
            default:
                throw new Exception("Cannot get JPanelMenuItem " + type);
        }
//                    System.out.println(jpi);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return jpi;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        try {
            JPanelMenuItem jpm = MenuItemFactory.get("package");
            jf.add(jpm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        jf.setVisible(true);
    }
}
