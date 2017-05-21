/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.booktable;

import restaurant.panel.main.table.JPanelListTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelBookTablePickTable extends JPanelListTable{
    private static JPanelBookTablePickTable instance;

    public JPanelBookTablePickTable() {
        super();
        listTable.getData().forEach((t) -> {
            Integer tId = (Integer) t.get("MaBan");
            JPanelTableForBook jpTFB = new JPanelTableForBook(tId, (String) t.get("TenBan"), (Integer) t.get("TrangThai"));
            listJPanelTable.put(tId, jpTFB);
        });
        filter();
    }

    public static JPanelBookTablePickTable getInstance() {
        if(instance == null) instance = new JPanelBookTablePickTable();
        return instance;
    }
    
    
}
