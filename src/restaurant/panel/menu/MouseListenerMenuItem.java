
package restaurant.panel.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import restaurant.panel.menu.JPanelMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MouseListenerMenuItem extends MouseAdapter{
    protected JPanel jPanelTarget;
    public MouseListenerMenuItem(JPanel jPanelTarget) {
        this.jPanelTarget = jPanelTarget;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
            JPanelMenuItem jpMI = (JPanelMenuItem) e.getSource();
            if (!jpMI.isActive()) {
                JPanelMenu.getInstance().getListJPanelMenuItem().forEach((t, u) -> {
                        if(u.isActive()){
                            u.setActive(false);
                        }
                });
            }
            
            jpMI.setActive(!jpMI.isActive());
            if (jpMI.hasSub) {
                
            }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        super.mouseEntered(me); //To change body of generated methods, choose Tools | Templates.
        JPanelMenuItem jp = (JPanelMenuItem) me.getSource();
//        jp.getjPanelActive().setVisible(true);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        super.mouseExited(me); //To change body of generated methods, choose Tools | Templates.
        JPanelMenuItem jp = (JPanelMenuItem) me.getSource();
//        jp.getjPanelActive().setVisible(false);
    }
    
    
}
