package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*搜尋並新增食物界面*/
public class SearchingDialog extends JDialog implements ActionListener{
    private JLabel lbMsg = new JLabel("您的帳號為：");
    private JLabel lbAccount = new JLabel(Conf.account);
    private JLabel lbFood = new JLabel("請您搜尋食物");
    private JTextField tfFood=new JTextField(10);
    private JButton btSearch = new JButton("搜尋");
    private JComboBox cbFood=new JComboBox();
    //private JTextField cbFood = new JTextField(Conf.food,10);

    private JButton btAdd = new JButton("新增");
    private JButton btExit = new JButton("關閉");

    public SearchingDialog(JFrame frm) {
        super(frm, true);
        this.setLayout(new GridLayout(5, 1));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbFood);
        this.add(tfFood);
        this.add(btSearch);
        this.add(cbFood);
        /*cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客戶服務部");
        cbFood.addItem("銷售部");*/
        cbFood.setSelectedItem(Conf.food);
        this.add(btAdd);
        this.add(btExit);
        this.setSize(240, 300);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加監聽*******************************/
        btSearch.addActionListener(this);
        btAdd.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSearch) {
            try {
                //use
                FoodHandler handler = new FoodHandler();
                handler.initialize();
                List<Pharmacy> filteredClinicList = handler.findPharmacies(tfFood.getText());
                FoodDataHandler foodlist = new FoodDataHandler(filteredClinicList);
                //use
                for(FoodData i : foodlist.getFoodList()) {
                    System.out.println(i);
                }
            } catch (IOException | URISyntaxException f) {
                // TODO Auto-generated catch block
                System.err.println(f);
            }



            /*String password1 = new String(pfPassword.getPassword());
            String password2 = new String(pfPassword2.getPassword());

            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this, "兩個密碼不相同");
                return;
            }*/
            /*String name = tfName.getText();
            String gender = tfGender.getText();
            String age = tfAge.getText();
            String height = tfHeight.getText();
            String weight = tfWeight.getText();*/
            String weight = tfFood.getText();
            //String food = (String) cbFood.getText();
            //將新的值存入靜態變量
            /*Conf.password = password1;
            Conf.name = name;
            Conf.gender = gender;
            Conf.age = age;
            Conf.height = height;
            Conf.weight = weight;
            FileOpe.updateCustomer(Conf.account, password1, name, gender, age, height, weight);

            JOptionPane.showMessageDialog(this, "修改成功");*/
        }
        else{
            this.dispose();
        }
    }
}
