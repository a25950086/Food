package ntou.cs.java2021.UserManageSystem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

/*登錄界面*/
public class LoginFrame extends JFrame implements ActionListener {
    /****************************定義各控制項**************************/
    private Icon welcomeIcon=new ImageIcon("D://Applications//JetBrains//IdeaProjects//src//ntou//cs//java2021//UserManageSystem//welcome.png");
    private JLabel lbWelcome=new JLabel(welcomeIcon);
    private JLabel lbAccount=new JLabel("請您輸入帳號");
    private JTextField tfAccount=new JTextField(10);
    private JLabel lbPassword=new JLabel("請您輸入密碼");
    private JPasswordField pfPassword=new JPasswordField(10);
    private JButton btLogin=new JButton("登錄");
    private JButton btRegister=new JButton("立即註冊");
    private JButton btExit=new JButton("退出");
    public LoginFrame() {
        /**********************界面初始化*****************************/
        super("登錄");
        this.setLayout(new FlowLayout());
        this.add(lbWelcome);
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegister);
        this.add(btExit);
        this.setSize(520,380);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        /*****************************增加監聽************************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=new String(pfPassword.getPassword());
            FileOpe.getInfoByAccount(account);
            if(Conf.account==null ||! Conf.password.equals(password)) {   // "||!" = or not
                JOptionPane.showMessageDialog(this,"登錄失敗");
                return;
            }
            JOptionPane.showMessageDialog(this,"登錄成功");
            this.dispose();
            new OperationFrame();
        }
        else if(e.getSource()==btRegister) {
            this.dispose();
            new RegisterFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"謝謝光臨");
            System.exit(0);
        }
    }
}
/*
ps：本類中this.dispose();表示讓本界面消失，釋放內存，但是程序不結束。
System.exit(0);表示整個程序退出。
 */
