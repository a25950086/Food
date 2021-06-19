package ntou.cs.java2021.UserManageSystem;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/*數據保存在「cus.inc」中，以「帳號=密碼#姓名#部門」的格式保存，
便於Properties類來讀。讀文件類為FileOpe。負責讀文件，將信息保存到文件中*/
public class FileOpe {
    private static String fileName="D://Applications//JetBrains//IdeaProjects//src//ntou//cs//java2021//UserManageSystem//cus.inc";
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
    private static void listInfo() {
        PrintStream ps=null;
        try {
            ps=new PrintStream(fileName);
            pps.list(ps);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"文件操作異常");
            System.exit(0);
        }
        finally {
            try { ps.close();
            }
            catch (Exception ex) {}
        }
    }
    public static void getInfoByAccount(String account) {
        String cusInfo=pps.getProperty(account);
        if(cusInfo!=null) {
            String[] infos=cusInfo.split("#");
            Conf.account=account;
            Conf.password=infos[0];
            Conf.name=infos[1];
            Conf.food=infos[2];
        }
    }
    public static void updateCustomer(String account,String password, String name,String dept) {
        pps.setProperty(account,password+"#"+name+"#"+dept);
        listInfo();
    }
}
//ps：本類中，靜態代碼塊中的代碼負責載入cus.inc中的數據

