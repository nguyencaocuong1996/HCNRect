/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import database.Database;
import modal.InsertData;
import java.util.HashMap;
import modal.Dish;
import modal.Material;
import modal.Provider;

public class Restaurant {
    
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setSize(Config.MAIN_FRAME_SIZE);
        mf.setVisible(true);
    }
    
}
