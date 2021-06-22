package ntou.cs.java2021;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*註冊界面*/
public class RegisterFrame extends JFrame implements ActionListener {
    /**********************定義各控制項********************************/
    private JLabel lbAccount=new JLabel("請您輸入帳號");
    private JTextField tfAccount=new JTextField(10);
    private JLabel lbPassword=new JLabel("請您輸入密碼");
    private JPasswordField pfPassword=new JPasswordField(10);
    private JLabel lbPassword2=new JLabel("輸入確認密碼");
    private JPasswordField pfPassword2=new JPasswordField(10);
    private JLabel lbName=new JLabel("請您輸入姓名");
    private JTextField tfName=new JTextField(10);
    private JLabel lbGender=new JLabel("請您輸入性別");
    private JTextField tfGender=new JTextField(10);
    private JLabel lbAge=new JLabel("請您輸入年齡");
    private JTextField tfAge=new JTextField(10);
    private JLabel lbHeight=new JLabel("請您輸入身高");
    private JTextField tfHeight=new JTextField(10);
    private JLabel lbWeight=new JLabel("請您輸入體重");
    private JTextField tfWeight=new JTextField(10);
    //private JLabel lbFood=new JLabel("請您輸入食物");
    //private JTextField tfFood=new JTextField(10);

    private JButton btRegister=new JButton("註冊");
    private JButton btLogin=new JButton("登錄");
    private JButton btExit=new JButton("退出");
    public RegisterFrame() {
        /******************界面初始化********************/
        super("註冊");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
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
        this.add(lbHeight);
        this.add(tfHeight);
        this.add(lbWeight);
        this.add(tfWeight);
        //this.add(lbFood);
        //this.add(tfFood);
        /*cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客服服務部");
        cbFood.addItem("銷售部");*/
        this.add(btRegister);
        this.add(btLogin);
        this.add(btExit);
        this.setSize(240,300);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /****************************增加監聽***********************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
            String password1=new String(pfPassword.getPassword());
            String password2=new String(pfPassword2.getPassword());
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"兩個密碼不相同");
                return;
            }
            String account=tfAccount.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account!=null) {
                JOptionPane.showMessageDialog(this,"用戶已經註冊");
                return;
            }
            String name=tfName.getText();
            String gender=(String)tfGender.getText();
            String age=(String)tfAge.getText();
            String height=(String)tfHeight.getText();
            String weight=(String)tfWeight.getText();

            //String food=(String)tfFood.getText();

            FileOpe.updateCustomer(account,password1,name,gender,age,height,weight);
            JOptionPane.showMessageDialog(this,"註冊成功");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new LoginFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"謝謝光臨");
            System.exit(0);
        }
    }
}


