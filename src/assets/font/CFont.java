
package assets.font;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class CFont {
    
    public static float defaultFontSize;
    public static Color defaultFontColor;
    
    public static void setStyleFont (Component component, float fontSize, Color color)
    {
        try {
        //create the font to use. Specify the size!
        java.awt.Font customFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File("src/assets/font/Comfortaa-Regular.ttf")).deriveFont(fontSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //register the font
        ge.registerFont(customFont);
        
        component.setFont(customFont);
        component.setForeground(color);
        
        } catch (IOException e) {
        e.printStackTrace();
        } catch(FontFormatException e) {
        e.printStackTrace();
        }   
    }
    
    public static void setStyleFont (Component component)
    {
        setStyleFont(component, defaultFontSize, defaultFontColor);
    }
    
    public static void setStyleFont (Component component, float fontSize)
    {
            setStyleFont(component, fontSize, defaultFontColor);
    }
    
    public static void setStyleFont (Component component, Color color)
    {
            setStyleFont(component,defaultFontSize, color);
    }
}
