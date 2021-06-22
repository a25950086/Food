package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Properties;
import javax.swing.*;
import java.lang.String;

public class FoodListFrame extends JDialog implements ActionListener{
    private JPanel foodPanel;
    private JComboBox foods = new JComboBox();

    private JPanel typePanel;
    private JLabel Calories;
    private JLabel Protein;
    private JLabel Carbohydrates;
    private JLabel Fat;
    private JLabel SaturatedFat;
    private JLabel TransFat;
    private JLabel Sugar;

    private JPanel havePanel;
    private JLabel haveCalories;
    private JLabel haveProtein;
    private JLabel haveCarbohydrates;
    private JLabel haveFat;
    private JLabel haveSaturatedFat;
    private JLabel haveTransFat;
    private JLabel haveSugar;

    private JPanel needPanel;
    private JLabel needCalories;
    private JLabel needProtein;
    private JLabel needCarbohydrates;
    private JLabel needFat;
    private JLabel needSaturatedFat;
    private JLabel needTransFat;
    private JLabel needSugar;

    private JButton btExit;

    public FoodListFrame(JFrame jFrame){
        super(jFrame, true);
        this.setLayout(new GridLayout(10, 2));
        String account = Conf.account;
        List<FoodData> list = FileOpe.getFood(account);
        foodPanel = new JPanel();
        foods.removeAllItems();
        for(int i=0; i<list.size(); i++){
            foods.addItem(list.get(i).getName());
        }
        foodPanel.add(foods);
        btExit = new JButton("離開");
        foodPanel.add(btExit);
        this.add(foodPanel);

        typePanel = new JPanel();
        typePanel.setLayout(new GridLayout(1, 6));
        Calories = new JLabel("卡路里(單位:千卡)");
        Protein = new JLabel("蛋白質(單位:克)");
        Carbohydrates = new JLabel("碳水化合物(單位:克)");
        Fat = new JLabel("脂肪(單位:克)");
        SaturatedFat = new JLabel("飽和脂肪(單位:克)");
        TransFat = new JLabel("反式脂肪(單位:克)");
        Sugar = new JLabel("糖(單位:克)");
        typePanel.add(Calories);
        typePanel.add(Protein);
        typePanel.add(Carbohydrates);
        typePanel.add(Fat);
        typePanel.add(SaturatedFat);
        typePanel.add(TransFat);
        typePanel.add(Sugar);
        this.add(typePanel);


        havePanel = new JPanel();
        havePanel.setLayout(new GridLayout(1, 6));
        haveCalories = new JLabel(String.valueOf(SearchingDialog.getFood().getCalories()));
        haveProtein = new JLabel(String.valueOf(SearchingDialog.getFood().getProtein()));
        haveCarbohydrates = new JLabel(String.valueOf(SearchingDialog.getFood().getCarbohydrates()));
        haveFat = new JLabel(String.valueOf(SearchingDialog.getFood().getFat()));
        haveSaturatedFat = new JLabel(String.valueOf(SearchingDialog.getFood().getSaturatedFat()));
        haveTransFat = new JLabel(String.valueOf(SearchingDialog.getFood().getTransFat()));
        haveSugar = new JLabel(String.valueOf(SearchingDialog.getFood().getSugar()));
        havePanel.add(haveCalories);
        havePanel.add(haveProtein);
        havePanel.add(haveCarbohydrates);
        havePanel.add(haveFat);
        havePanel.add(haveSaturatedFat);
        havePanel.add(haveTransFat);
        havePanel.add(haveSugar);
        this.add(havePanel);

        UserData userData = FileOpe.getUserData(account);
        needPanel = new JPanel();
        needPanel.setLayout(new GridLayout(1, 6));
        needCalories = new JLabel(String.valueOf(userData.getNeedCalories()));
        needProtein = new JLabel(String.valueOf(userData.getNeedProtein()));
        needCarbohydrates = new JLabel(String.valueOf(userData.getNeedCarbohydrates()));
        needFat = new JLabel(String.valueOf(userData.getNeedFat()));
        needSaturatedFat = new JLabel(String.valueOf(userData.getNeedSaturatedFat()));
        needTransFat = new JLabel(String.valueOf(userData.getNeedTransFat()));
        needSugar = new JLabel(String.valueOf(userData.getNeedSugar()));
        needPanel.add(needCalories);
        needPanel.add(needProtein);
        needPanel.add(needCarbohydrates);
        needPanel.add(needFat);
        needPanel.add(needSaturatedFat);
        needPanel.add(needTransFat);
        needPanel.add(needSugar);
        this.add(needPanel);

        btExit.addActionListener(this);

        this.setSize(800, 400);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
