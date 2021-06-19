package ntou.cs.java2021.UserManageSystem;
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
    private JLabel lbFood = new JLabel("請您修改食物");
    private JTextField cbFood = new JTextField(Conf.food,10);

    private JButton btModify = new JButton("修改");
    private JButton btExit = new JButton("關閉");

    public ModifyDialog(JFrame frm) {
        /***********************界面初始化***************************/
        super(frm, true);
        this.setLayout(new GridLayout(6, 2));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbFood);
        this.add(cbFood);
        /*cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客戶服務部");
        cbFood.addItem("銷售部");
        cbFood.setSelectedItem(Conf.food);*/
        this.add(btModify);
        this.add(btExit);
        this.setSize(240, 200);
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
            String food = (String) cbFood.getText();
            //將新的值存入靜態變量
            Conf.password = password1;
            Conf.name = name;
            Conf.food = food;
            FileOpe.updateCustomer(Conf.account, password1, name, food);

            JOptionPane.showMessageDialog(this, "修改成功");
        }
        else{
            this.dispose();
        }
    }
}



