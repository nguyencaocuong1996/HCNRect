/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import restaurant.panel.menu.JPanelMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author WINDNCC
 */
public class MouseListenerMenuItem extends MouseAdapter{
    protected JPanel jPanelTarget;
    public MouseListenerMenuItem(JPanel jPanelTarget) {
        this.jPanelTarget = jPanelTarget;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Menu Item clicked!");
    }
    
}
