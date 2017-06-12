/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.booktable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import restaurant.panel.main.table.JPanelTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelTableForBook extends JPanelTable{
    public JPanelTableForBook(int tableId, String tableName, int status) {
        super(tableId, tableName, status);
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(getStatus());
                if(getStatus() == 0){
                    super.mouseClicked(e);
                    System.out.println("Constructor in JPanelTableForBook.java : Mã bàn " + tableId + " vừa được Chọn:");
                    JPanelBookTable.getInstance().getmBookTable().setTableId(tableId);
                    JPanelBookTable.getInstance().getjDialogPickTable().setVisible(false);
                    JPanelBookTable.getInstance().getjLabelPickTable().setText(tableName);
                } else {
                    JOptionPane.showMessageDialog(JPanelBookTable.getInstance().getjDialogPickTable(), "Bàn này đang được sử dụng hoặc đã đặt trước!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        };
        addMouseListener(mouseAdapter);
    }
}
