/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import restaurant.panel.PanelFactory;
import restaurant.report.ReportResources;

/**
 *
 * @author WINDNCC
 */
public class SubMenuFactory {
    
    public static JPanelSubMenu get(String type){
        ArrayList<JPanelSubMenuItem> listSubMenuItem = new ArrayList<>();
        switch(type){
            case "package" :
                listSubMenuItem.add(new JPanelSubMenuItem("Món ăn"));
                listSubMenuItem.add(new JPanelSubMenuItem("Nguyên liệu"));
                listSubMenuItem.add(new JPanelSubMenuItem("Bàn ăn"));
                listSubMenuItem.get(0).addMouseListener(new MouseListenerSubMenuItem(PanelFactory.ID.OVERVIEW, PanelFactory.ID.HEADER_OVERVIEW));
            break;
            case "report" :
                listSubMenuItem.add(new JPanelSubMenuItem("Thu chi"));
                listSubMenuItem.add(new JPanelSubMenuItem("Tồn kho"));
                listSubMenuItem.add(new JPanelSubMenuItem("Món ăn"));
                listSubMenuItem.get(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    System.out.println("Mon an is clicked");
                    JasperReport jR = JasperCompileManager.compileReport(ReportResources.RP_TOP_DISH_BY_MOTH);
                    JasperPrint jP = JasperFillManager.fillReport(jR, null, database.Database.getConnection());
                    JasperViewer.viewReport(jP,false);
                } catch (JRException e) {
                    e.printStackTrace();
                }
                
            }
                    
});
                break;
            case "partner":
                listSubMenuItem.add(new JPanelSubMenuItem("Khách hàng"));
                listSubMenuItem.add(new JPanelSubMenuItem("Nhà cung cấp"));
                break;
        }
        return new JPanelSubMenu(listSubMenuItem);
    }
}
