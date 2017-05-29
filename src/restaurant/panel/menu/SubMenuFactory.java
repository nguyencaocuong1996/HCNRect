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
                listSubMenuItem.add(new JPanelSubMenuItem("Món ăn",PanelFactory.ID.PACKAGE_DISH,PanelFactory.ID.HEADER_PACKAGE_DISH));
                listSubMenuItem.add(new JPanelSubMenuItem("Nguyên liệu",PanelFactory.ID.PACKAGE_MATERIAL,PanelFactory.ID.HEADER_PACKAGE_MATERIAL));
                listSubMenuItem.add(new JPanelSubMenuItem("Bàn ăn",PanelFactory.ID.PACKAGE_TABLE,PanelFactory.ID.HEADER_PACKAGE_TABLE));
                break;
            case "report" :
                listSubMenuItem.add(new JPanelSubMenuItem("Cuối ngày", PanelFactory.ID.REPORT_END_OF_DAY, PanelFactory.ID.HEADER_REPORT));
                listSubMenuItem.add(new JPanelSubMenuItem("Chi tiết", PanelFactory.ID.REPORT_DETAILS, PanelFactory.ID.HEADER_REPORT));
                break;
            case "partner":
                listSubMenuItem.add(new JPanelSubMenuItem("Khách hàng"));
                listSubMenuItem.add(new JPanelSubMenuItem("Nhà cung cấp"));
                break;
        }
        return new JPanelSubMenu(listSubMenuItem);
    }
}
