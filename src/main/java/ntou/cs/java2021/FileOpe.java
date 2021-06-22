package ntou.cs.java2021;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

/*數據保存在「cus.inc」中，以「帳號=密碼#姓名#性別#年齡#身高#體重#食物」的格式保存，
便於Properties類來讀。讀文件類為FileOpe。負責讀文件，將信息保存到文件中*/
public class FileOpe {
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
            Conf.gender=infos[2];
            Conf.age=infos[3];
            Conf.height=infos[4];
            Conf.weight=infos[5];
        }

    }
    public static void updateCustomer(String account,String password,String name,String gender,String age,String height,String weight) {
        pps.setProperty(account,password+"#"+name+"#"+gender+"#"+age+"#"+height+"#"+weight);
        listInfo();

    }
    public static void addFood(String account, String password, String name, String gender, String age, String height, String weight, List<FoodData> addFood){
        String temp = "";
        for(FoodData i : addFood){
            temp += i.toString().substring(0, i.toString().length() - 1);
        }
        pps.setProperty(account,"#"+password+"#"+name+"#"+gender+"#"+age+"#"+height+"#"+weight+temp);
        listInfo();
    }

    public static UserData getUserData(String account){
        UserData userData;
        String cusInfo=pps.getProperty(account);
        String[] infos = cusInfo.split("#");
        userData = new UserData(infos[3], Double.valueOf(infos[4]), Double.valueOf(infos[5]), Double.valueOf(infos[6]));
        return userData;
    }

    public static List<FoodData> getFood(String account){
        List<FoodData> foodDataList = new ArrayList<>();
        FoodData temp;
        String cusInfo=pps.getProperty(account);
        if(cusInfo!=null) {
            String[] infos=cusInfo.split("#");
            String[] foodInfos;
            for(int i=7; i<infos.length; i++){
                temp = new FoodData();
                foodInfos = infos[i].split(" ");
                temp.setName(foodInfos[0]);
                temp.setCalories(Double.valueOf(foodInfos[1]));
                temp.setProtein(Double.valueOf(foodInfos[2]));
                temp.setCarbohydrates(Double.valueOf(foodInfos[3]));
                temp.setFat(Double.valueOf(foodInfos[4]));
                temp.setSaturatedFat(Double.valueOf(foodInfos[5]));
                temp.setTransFat(Double.valueOf(foodInfos[6]));
                temp.setSugar(Double.valueOf(foodInfos[7]));
                foodDataList.add(temp);
            }
        }
        return  foodDataList;
    }

}
//ps：本類中，靜態代碼塊中的代碼負責載入cus.inc中的數據

