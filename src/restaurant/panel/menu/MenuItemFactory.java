
package restaurant.panel.menu;

import assets.images.icons.IconResources;

public class MenuItemFactory {
    public static JPanelMenuItem get(String type) throws Exception{
        JPanelMenuItem jpi;
        try{
        switch(type){
            case "order":
                jpi = new JPanelMenuItem("Đặt món", IconResources.ORDER);
                break;
            case "book":
                 jpi = new JPanelMenuItem("Đặt bàn", IconResources.BOOKTABLE);
                 break;
            case "partner":
                jpi = new JPanelMenuItem("Đối tác", IconResources.PARTNER, true);
                break;
            case "package":
                jpi =  new JPanelMenuItem("Hàng hóa", IconResources.PACKAGE, true);
                jpi.addMouseListener(new MouseListenerMenuItem(jpi));
                break;
            case "coins":
                jpi = new JPanelMenuItem("Giao dịch", IconResources.COINS, true);
                break;
            case "report":
                jpi =  new JPanelMenuItem("Báo cáo", IconResources.REPORT, true);
                break;
            case "staff":
                jpi = new JPanelMenuItem("Nhân viên", IconResources.STAFF);
                break;
            default:
                throw new Exception("Cannot get JPanelMenuItem " + type);
        }
                    System.out.println(jpi);
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return jpi;
    }
}
