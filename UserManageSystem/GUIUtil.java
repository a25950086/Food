package ntou.cs.java2021.UserManageSystem;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class GUIUtil {
    public static void toCenter(Component comp) {
        GraphicsEnvironment
                ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle
                rec=ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        comp.setLocation(((int)(rec.getWidth()-comp.getWidth())/2),
                ((int)(rec.getHeight()-comp.getHeight()))/2);
    }
}
/*
ps：本類中，toCenter(Component comp)函數傳入的參數不是JFrame，
而是其弗雷Component，完全是為了擴大本函數的適用範圍，
讓其適用於所有Component子類。
*/
