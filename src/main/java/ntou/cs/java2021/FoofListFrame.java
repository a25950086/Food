package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.lang.String;

public class FoofListFrame {
    private static String fileName="cus.inc";
    private static Properties pps;

    static {
        pps=new Properties();
        FileReader reader=null;
        try {
            reader=new FileReader(fileName);
            pps.load(reader);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"文件操作異常");
            System.exit(0);
        }
        finally {
            try {
                reader.close();
            }
            catch (Exception ex) {}
        }
    }


    public static List<FoodData> addFood(String account){
        int i;
        int count=0;
        List<FoodData> addFood;
        String getInfo;
        getInfo=pps.getProperty(account);

        for(i=0 ; i<getInfo.length() ; i++){
            if(getInfo.charAt(i)=='#'){
                count++;
                if(count==8) break;


            }
        }
        for( ; i<getInfo.length() ; i++){

        }
    }
}
