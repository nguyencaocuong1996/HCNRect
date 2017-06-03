
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
import restaurant.panel.PanelFactory;
import restaurant.panel.booktable.JPanelBookTable;
import restaurant.panel.order.JPanelOrder;

public class MouseListenerMenuItem extends MouseAdapter{
    protected int targetPanelId;
    protected int targetHeaderPanelId;
    public MouseListenerMenuItem(int targetPanelId, int targetHeaderPanelId) {
        this.targetPanelId = targetPanelId;
        this.targetHeaderPanelId = targetHeaderPanelId;
    }
    public MouseListenerMenuItem() {
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
            JPanel jpTarget = PanelFactory.get(targetPanelId);
            JPanel jpHeaderTarget = PanelFactory.get(targetHeaderPanelId);
            JPanelMenuItem jpMI = (JPanelMenuItem) e.getSource();
            if (!jpMI.isActive()) {               
                JPanelMenu.getInstance().getListJPanelMenuItem().forEach((t) -> {
                        if(t.isActive()){
                            t.setActive(false);
                        }
                });
                
                jpMI.setActive(!jpMI.isActive());
                if (jpTarget != null && !jpMI.hasSub) {
                    MainFrame.getInstance().changeContentPanel(jpTarget);
                    MainFrame.getInstance().changeHeaderPanel(jpHeaderTarget);
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
