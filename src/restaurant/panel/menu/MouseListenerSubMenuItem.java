/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;

/**
 *
 * @author WINDNCC
 */
public class MouseListenerSubMenuItem extends MouseListenerMenuItem{

    public MouseListenerSubMenuItem(int targetPanelId, int targetHeaderPanelId) {
        super(targetPanelId, targetHeaderPanelId);
    }

    public MouseListenerSubMenuItem() {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel jpTarget = PanelFactory.get(targetPanelId);
        JPanel jpHeaderTarget = PanelFactory.get(targetHeaderPanelId);
        MainFrame.getInstance().changeContentPanel(jpTarget);
        MainFrame.getInstance().changeHeaderPanel(jpHeaderTarget);
    }
    @Override
    public void mouseEntered(MouseEvent me) {
//        super.mouseEntered(me); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        super.mouseExited(me); //To change body of generated methods, choose Tools | Templates.
    }

    
}
