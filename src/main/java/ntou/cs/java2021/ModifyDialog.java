package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
修改界面
注意ModifyDialog是一個模態對話框
*/
public class ModifyDialog extends JDialog implements ActionListener {
    /*******************************定義各控制項**************************/

    private JLabel lbMsg = new JLabel("您的帳號為：");
    private JLabel lbAccount = new JLabel(Conf.account);
    private JLabel lbPassword = new JLabel("請您輸入密碼");
    private JPasswordField pfPassword = new JPasswordField(Conf.password, 10);
    private JLabel lbPassword2 = new JLabel("輸入確認密碼");
    private JPasswordField pfPassword2 = new JPasswordField(Conf.password, 10);
    private JLabel lbName = new JLabel("請您修改姓名");
    private JTextField tfName = new JTextField(Conf.name, 10);
    private JLabel lbGender = new JLabel("請您修改性別");
    private JTextField tfGender = new JTextField(Conf.gender, 10);
    private JLabel lbAge = new JLabel("請您修改年齡");
    private JTextField tfAge = new JTextField(Conf.age, 10);
    private JLabel lbHeight = new JLabel("請您修改身高");
    private JTextField tfHeight = new JTextField(Conf.height, 10);
    private JLabel lbWeight = new JLabel("請您修改體重");
    private JTextField tfWeight = new JTextField(Conf.weight, 10);
    /*private JLabel lbFood = new JLabel("請您修改食物");
    private JTextField cbFood = new JTextField(Conf.food,10);*/

    private JButton btModify = new JButton("修改");
    private JButton btExit = new JButton("關閉");

    public ModifyDialog(JFrame frm) {
        /***********************界面初始化***************************/
        super(frm, true);
        this.setLayout(new GridLayout(9, 1));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbGender);
        this.add(tfGender);
        this.add(lbAge);
        this.add(tfAge);
        this.add(lbWeight);
        this.add(tfWeight);
        this.add(lbHeight);
        this.add(tfHeight);
        /*this.add(lbFood);
        this.add(cbFood);*/
        /*cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客戶服務部");
        cbFood.addItem("銷售部");
        cbFood.setSelectedItem(Conf.food);*/
        this.add(btModify);
        this.add(btExit);
        this.setSize(240, 300);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加監聽*******************************/
        btModify.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btModify) {
            String password1 = new String(pfPassword.getPassword());
            String password2 = new String(pfPassword2.getPassword());

            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this, "兩個密碼不相同");
                return;
            }
            String name = tfName.getText();
            String gender = tfGender.getText();
            String age = tfAge.getText();
            String height = tfHeight.getText();
            String weight = tfWeight.getText();
            //String food = (String) cbFood.getText();
            //將新的值存入靜態變量
            Conf.password = password1;
            Conf.name = name;
            Conf.gender = gender;
            Conf.age = age;
            Conf.height = height;
            Conf.weight = weight;
            FileOpe.updateCustomer(Conf.account, password1, name, gender, age, height, weight);

            JOptionPane.showMessageDialog(this, "修改成功");
        }
        else{
            this.dispose();
        }
    }
}



