/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.provider.debt;

import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;
import restaurant.panel.provider.JPanelChooseProvider;
import view.VProvider;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderForRVP extends JPanelChooseProvider{
    public static JPanelChooseProviderForRVP instance;

    public static JPanelChooseProviderForRVP getInstance() {
        if (instance == null) {
            instance = new JPanelChooseProviderForRVP();
        }
        return instance;
    }

    public JPanelChooseProviderForRVP() {
        super();
        try {
            vProvider = VProvider.getAllProvider();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vProvider.getData().forEach((t) -> {
            int id = ((Long) t.get("MaNCC")).intValue();
            String name = (String) t.get("TenNCC");
            String phone = (String) t.get("SDTNCC");
            JPanelChooseProviderForRVPItem newJPCPI = new JPanelChooseProviderForRVPItem(id, name, phone);
            listJPChooseProviderItem.put(id, newJPCPI);
            
        });
        showView();
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        jf.add(JPanelChooseProviderForRVP.getInstance());
        jf.setVisible(true);
    }
}
