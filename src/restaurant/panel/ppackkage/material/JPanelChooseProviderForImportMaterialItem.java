/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage.material;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import restaurant.panel.provider.JPanelChooseProviderItem;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderForImportMaterialItem extends JPanelChooseProviderItem{

    public JPanelChooseProviderForImportMaterialItem(int providerId, String providerName, String providerPhone) {
        super(providerId, providerName, providerPhone);
        customInit();
    }

    
    private void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelImportMaterial.getInstance().getjLabelProviderName().setText(providerName);
                JPanelImportMaterial.getInstance().getjDialogChooseProvider().setVisible(false);
                JPanelImportMaterial.getInstance().setProviderId(providerId);
                JPanelImportMaterial.getInstance().setProviderName(providerName);
            }
            
        });
    }
}
