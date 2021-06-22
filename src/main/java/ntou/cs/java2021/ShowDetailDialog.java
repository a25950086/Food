package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*資料呈現介面*/
public class ShowDetailDialog extends JDialog implements ActionListener {
    private String welcomMsg="詳細信息:";
    private JLabel lblWelcome=new JLabel(welcomMsg);

    private JLabel lbAcount = new JLabel("             帳號：");
    private JLabel lbAcount1 = new JLabel(Conf.account);
    private JLabel lbName = new JLabel("               姓名: ");
    private JLabel lbName1 = new JLabel(Conf.name);
    private JLabel lbGender = new JLabel("性別: ");
    private JLabel lbGender1 = new JLabel(Conf.gender);
    private JLabel lbAge = new JLabel("年齡: ");
    private JLabel lbAge1 = new JLabel(Conf.age);
    private JLabel lbHeight = new JLabel("身高: ");
    private JLabel lbHeight1 = new JLabel(Conf.height);
    private JLabel lbWeight = new JLabel("體重: ");
    private JLabel lbWeight1 = new JLabel(Conf.weight);
    //private JLabel lbFood = new JLabel("食物: ");
    private JButton btFood=new JButton("食物");

    private JButton btExit = new JButton("關閉");

    public ShowDetailDialog(JFrame frm) {
        /***********************界面初始化***************************/
        super(frm, true);
        this.setLayout(new GridLayout(10, 1));
        this.add(lbAcount);
        this.add(lbAcount1);
        this.add(lbName);
        this.add(lbName1);
        this.add(lbGender);
        this.add(lbGender1);
        this.add(lbAge);
        this.add(lbAge1);
        this.add(lbWeight);
        this.add(lbWeight1);
        this.add(lbHeight);
        this.add(lbHeight1);
        /*this.add(lbFood);
        this.add(cbFood);
        /*cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客戶服務部");
        cbFood.addItem("銷售部");
        cbFood.setSelectedItem(Conf.food);*/
        this.add(btFood);
        this.add(btExit);
        this.setSize(240, 300);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加監聽*******************************/
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
