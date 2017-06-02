/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage.material;

import java.sql.SQLException;
import restaurant.panel.provider.JPanelChooseProvider;
import restaurant.panel.provider.JPanelChooseProviderItem;
import view.VProvider;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderForImportMaterial extends JPanelChooseProvider{
    public static JPanelChooseProviderForImportMaterial instance;

    public static JPanelChooseProviderForImportMaterial getInstance() {
        if (instance == null) {
            instance = new JPanelChooseProviderForImportMaterial();
        }
        return instance;
    }

    public JPanelChooseProviderForImportMaterial() {
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
            JPanelChooseProviderForImportMaterialItem newJPCPI = new JPanelChooseProviderForImportMaterialItem(id, name, phone);
            listJPChooseProviderItem.put(id, newJPCPI);
            
        });
        showView();
    }
}
