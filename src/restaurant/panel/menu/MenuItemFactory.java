
package restaurant.panel.menu;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MenuItemFactory {
    public static JPanelMenuItem get(String type) throws Exception{
        JPanelMenuItem jpi = new JPanelMenuItem();
        try{
        switch(type){
            case "order":
                jpi = new JPanelMenuItem("Đặt món", IconResources.ORDER);
                break;
            case "book":
                 jpi = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE);
                 break;
            case "partner":
                jpi = new JPanelMenuItem("Đối tác", IconResources.PARTNER);
                break;
            case "package":
                jpi =  new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, SubMenuFactory.get("package"));
                break;
            case "coins":
                jpi = new JPanelMenuItem("Giao dịch", IconResources.COINS);
                break;
            case "report":
                jpi =  new JPanelMenuItem("Báo cáo", IconResources.REPORT, SubMenuFactory.get("report"));
                break;
            case "staff":
                jpi = new JPanelMenuItem("Nhân viên", IconResources.STAFF);
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
