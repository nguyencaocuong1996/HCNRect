/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;
import assets.images.ImageResources;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MDish;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.ppackkage.recipe.JPanelManagementRecipe;

/**
 *
 * @author WINDNCC
 */
public class JPanelDishRowItem extends javax.swing.JPanel {
    protected String dishName;
    protected int id;
    protected float price;
    protected String image;
    protected int menuId;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelDishRowItem() {
        initComponents();
    }
    public JPanelDishRowItem(int dishId, String dishName, float dishPrice, String dishImg, int menuId, boolean odd) {
        initComponents();
        this.id = dishId;
        this.dishName = dishName;
        this.price = dishPrice;
        this.menuId = menuId;
        this.image = dishImg;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelDishId.setText(this.id + "");
        jLabelDishName.setText("<html><p>" + this.dishName + "</p></html>");
        jLabelDishPrice.setText(this.price + "");
        jLabelDishImage.setIcon(ImageResources.getDishImage(image));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDishId = new javax.swing.JLabel();
        jLabelDishName = new javax.swing.JLabel();
        jLabelDishPrice = new javax.swing.JLabel();
        jLabelDishImage = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelShowRecipe = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDishId.setText("001");
        add(jLabelDishId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 59, 35));

        jLabelDishName.setText("Thịt xông khói");
        add(jLabelDishName, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 11, 198, 35));

        jLabelDishPrice.setText("120000000");
        add(jLabelDishPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 21, 100, -1));

        jLabelDishImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/dishs/Mint-drink.jpeg"))); // NOI18N
        jLabelDishImage.setText("jLabel4");
        jLabelDishImage.setMaximumSize(new java.awt.Dimension(57, 57));
        jLabelDishImage.setMinimumSize(new java.awt.Dimension(57, 57));
        jLabelDishImage.setPreferredSize(new java.awt.Dimension(57, 57));
        add(jLabelDishImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 0, 63, -1));

        jLabelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_darkgreen_x24.png"))); // NOI18N
        add(jLabelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 0, -1, 46));

        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_delete_dimgray_x32.png"))); // NOI18N
        jLabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteMouseClicked(evt);
            }
        });
        add(jLabelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 0, -1, 46));

        jLabelShowRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_bill_darkgreen_x32.png"))); // NOI18N
        jLabelShowRecipe.setText("CT");
        jLabelShowRecipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowRecipeMouseClicked(evt);
            }
        });
        add(jLabelShowRecipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 0, 26, 46));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận xóa món ăn!");
        if (check == JOptionPane.YES_OPTION) {
            try {
            MDish mDish = new MDish(id);
            mDish.delete();
            JPanelManagementDish.getInstance().getListJPDRI().remove(id);
            JPanelManagementDish.getInstance().getjPanelTableContent().remove(this);
            JPanelManagementDish.getInstance().getjPanelTableContent().revalidate();
            JPanelManagementDish.getInstance().getjPanelTableContent().repaint();
            } catch (SQLException e) {
                e.printStackTrace();
                 JOptionPane.showMessageDialog(this, "Xóa món ăn thành công!");
            }
        }
         
    }//GEN-LAST:event_jLabelDeleteMouseClicked

    private void jLabelShowRecipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowRecipeMouseClicked
        MDish mDish = new MDish(id);
        mDish.setName(getDishName());
        JPanelManagementRecipe.getInstance().setDish(mDish);
        MainFrame.getInstance().changeContentPanel(PanelFactory.get(PanelFactory.ID.PACKAGE_DISH_RECIPE));
        MainFrame.getInstance().changeHeaderPanel(PanelFactory.get(PanelFactory.ID.HEADER_PACKAGE_DISH_RECIPE));
    }//GEN-LAST:event_jLabelShowRecipeMouseClicked

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String name) {
        this.dishName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    
     public JLabel getjLabelEdit() {
        return jLabelEdit;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelDishId;
    private javax.swing.JLabel jLabelDishImage;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelDishPrice;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelShowRecipe;
    // End of variables declaration//GEN-END:variables
}
