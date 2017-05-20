
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
import restaurant.MainFrame;

public class MouseListenerMenuItem extends MouseAdapter{
    protected JPanel jPanelTarget;
    protected JPanel jPanelHeaderTarget;
    public MouseListenerMenuItem(JPanel jPanelTarget, JPanel jPanelHeaderTarget) {
        this.jPanelTarget = jPanelTarget;
        this.jPanelHeaderTarget = jPanelHeaderTarget;
    }
    public MouseListenerMenuItem() {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            JPanelMenuItem jpMI = (JPanelMenuItem) e.getSource();
            if (!jpMI.isActive()) {
                JPanelMenu.getInstance().getListJPanelMenuItem().forEach((t) -> {
                        if(t.isActive()){
                            t.setActive(false);
                        }
                });
                
                jpMI.setActive(!jpMI.isActive());
                if (jPanelTarget != null && !jpMI.hasSub) {
                    MainFrame.getInstance().changeContentPanel(jPanelTarget);
                    MainFrame.getInstance().changeHeaderPanel(jPanelHeaderTarget);
                }
            } else {
                jpMI.setActive(false);
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
