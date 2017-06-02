/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.receipt;

import restaurant.panel.ppackkage.material.*;
import java.sql.SQLException;
import restaurant.panel.provider.JPanelChooseProvider;
import restaurant.panel.provider.JPanelChooseProviderItem;
import view.VProvider;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderForReviewReceipt extends JPanelChooseProvider{
    public static JPanelChooseProviderForReviewReceipt instance;

    public static JPanelChooseProviderForReviewReceipt getInstance() {
        if (instance == null) {
            instance = new JPanelChooseProviderForReviewReceipt();
        }
        return instance;
    }

    public JPanelChooseProviderForReviewReceipt() {
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
            JPanelChooseProviderForReviewReceiptItem newJPCPI = new JPanelChooseProviderForReviewReceiptItem(id, name, phone);
            listJPChooseProviderItem.put(id, newJPCPI);
            
        });
        showView();
    }
}
