/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.images;
import javax.swing.ImageIcon;
/**
 *
 * @author WINDNCC
 */
public class ImageResources {
    public static ImageIcon getDishImage(String name){
        return new ImageIcon(ImageResources.class.getResource("dishs/"+name));
    }
    
}
