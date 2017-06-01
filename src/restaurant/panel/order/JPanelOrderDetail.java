/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import restaurant.panel.booktable.JPanelBookTablePickTable;
import view.VDishOrdering;

public class JPanelOrderDetail extends javax.swing.JPanel {
    public ArrayList<JPanelOrderItem> listDishOrdering = new ArrayList<>();
    public JPanel targetPanel;
    private VDishOrdering vDishOrdering;
    private int tableId;
    private int numDish;
    public JPanelOrderDetail(int tableId) {
        initComponents();
        this.tableId = tableId;
        vDishOrdering = VDishOrdering.getByTableId(tableId);
        numDish = vDishOrdering.getData().size();
        if( numDish > 0 ){
            vDishOrdering.getData().forEach((t) -> {
                Long qty = (Long) t.get("SoLuong");
                JPanelOrderItem jpOI = new JPanelOrderItem((Integer) t.get("MaMA"), (String) t.get("TenMA"), qty.intValue() , (Float) t.get("GiaMA"));
                addOrderItem(jpOI, false);
            });
        }
    }
    public JPanelOrderDetail(int tableId, JPanel targetPanel) {
        initComponents();
        this.targetPanel = targetPanel;
        this.tableId = tableId;
        vDishOrdering = VDishOrdering.getByTableId(tableId);
        if(vDishOrdering.getData().size() > 0 ){
            vDishOrdering.getData().forEach((t) -> {
                Long qty = (Long) t.get("SoLuong");
                Long dishId = (Long) t.get("MaMA");
                JPanelOrderItem jpOI = new JPanelOrderItem(dishId.intValue() , (String) t.get("TenMA"), qty.intValue() , (Float) t.get("GiaMA"));
                addOrderItem(jpOI, false);
            });
        }
    }
    public float getTotalBill(){
        float total = 0;
        if (listDishOrdering.size() > 0) {
                for(JPanelOrderItem jpOI : listDishOrdering){
                    total += jpOI.getTotalPrice();
                }
        }
        return total;
    }
    public void setTargetPanel(JPanel targetPanel) {
        this.targetPanel = targetPanel;
        this.targetPanel.add(this);
        this.targetPanel.setPreferredSize(jPanelListOrdering.getPreferredSize());
    }
    public void addOrderItem(JPanelOrderItem jpOrderItem, boolean addToDB){
        if(numDish == 0){
            System.out.println("addOrderItem in JPanelOrderDetail.java: 1 món vừa được chọn hoặc tìm thấy trong database, chuyển trạng thái thành đang sử dụng (1)");
            JPanelOrderPickTable.getInstance().updateTableStatus(this.tableId, 1); // cap nhat trang thai ban realtime order
            JPanelBookTablePickTable.getInstance().updateTableStatus(this.tableId, 1); //cap nhat trang thai ban realtime booktable
        }
        if(addToDB == true) jpOrderItem.dbAdd();
        listDishOrdering.add(jpOrderItem);
        jPanelListOrdering.add(jpOrderItem, 0);
        Dimension d = new Dimension(295, listDishOrdering.size() * 35);
        targetPanel.setPreferredSize(d);
        jPanelListOrdering.setPreferredSize(d);
        numDish = listDishOrdering.size();
    }
    public void addOrderItem(JPanelOrderItem jpOrderItem){
        addOrderItem(jpOrderItem, true);
    }
    public void removeOrderItem(JPanelOrderItem jpOrderItem){
        if(numDish <= 1){
            System.out.println("removeOrderItem in JPanelOrderDetail.java: vừa xóa tất cả các món, chuyển trạng thái thành rảnh (0)");
            JPanelOrderPickTable.getInstance().updateTableStatus(this.tableId, 0); // cap nhat trang thai ban realtime order
            JPanelBookTablePickTable.getInstance().updateTableStatus(this.tableId, 0); //cap nhat trang thai ban realtime booktable
            System.out.println("up date ve 0");
        }
        if(numDish >=1){
            listDishOrdering.remove(jpOrderItem);
            jPanelListOrdering.remove(jpOrderItem);
            Dimension d = new Dimension(295, listDishOrdering.size() * 35);
            targetPanel.setPreferredSize(d);
            jPanelListOrdering.setPreferredSize(d);
            numDish = listDishOrdering.size();
        }
    }
    
    /**
     *description : Xóa toàn bộ các món ăn đang đặt và đặt lại trạng thái bàn là rảnh (Dùng khi gọi hàm thanh toán)
     * 
     * 
     */
    public void removeAllOrderItem(){
        listDishOrdering.removeAll(listDishOrdering);
        jPanelListOrdering.removeAll();
        JPanelOrderPickTable.getInstance().updateTableStatus(this.tableId, 0); // cap nhat trang thai ban realtime order
        JPanelBookTablePickTable.getInstance().updateTableStatus(this.tableId, 0); //cap nhat trang thai ban realtime booktable
    }
    
    public ArrayList<JPanelOrderItem> getListDishOrdering() {
        return listDishOrdering;
    }
    
    
    
    public JPanelOrderDetail() {
        initComponents();
    }

    public JPanel getjPanelListOrdering() {
        return jPanelListOrdering;
    }

        public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelOrderDetail());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListOrdering = new javax.swing.JPanel();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(null);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelListOrdering.setBackground(new java.awt.Color(227, 227, 227));
        jPanelListOrdering.setMaximumSize(new java.awt.Dimension(9999, 9999));
        jPanelListOrdering.setMinimumSize(new java.awt.Dimension(293, 243));
        jPanelListOrdering.setPreferredSize(new java.awt.Dimension(293, 243));
        jPanelListOrdering.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));
        add(jPanelListOrdering);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelListOrdering;
    // End of variables declaration//GEN-END:variables
}
