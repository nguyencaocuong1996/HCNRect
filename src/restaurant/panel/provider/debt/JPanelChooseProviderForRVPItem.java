/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.provider.debt;

import restaurant.panel.ppackkage.material.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import modal.MProvider;
import restaurant.panel.provider.JPanelChooseProviderItem;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderForRVPItem extends JPanelChooseProviderItem{

    public JPanelChooseProviderForRVPItem(int providerId, String providerName, String providerPhone) {
        super(providerId, providerName, providerPhone);
        customInit();
    }

    
    private void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MProvider p = new MProvider();
                p.setId(providerId);
                p.setName(providerName);
                JPanelManagementReceiptVoucherProvider.getInstance().setProvider(p);
                JPanelManagementReceiptVoucherProvider.getInstance().getjDialogChooseProvider().setVisible(false);
            }
            
        });
    }
}
