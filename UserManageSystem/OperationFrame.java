package ntou.cs.java2021.UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.Query;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*操作界面*/
public class OperationFrame extends JFrame implements ActionListener {
    /************************定義各控制項******************************/
    private String welcomMsg="選擇如下操作:";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btQuery=new JButton("顯示詳細信息");
    private JButton btModify=new JButton("修改個人資料");
    private JButton btExit=new JButton("退出");
    public OperationFrame() {
        /****************************界面初始化************************/
        super("當前登錄: "+Conf.account);
        this.setLayout(new GridLayout(4,1));
        this.add(lblWelcome);
        this.add(btQuery);
        this.add(btModify);
        this.add(btExit);
        this.setSize(520,380);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************增加監聽*******************************/
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btQuery) {
            String message="您的詳細資料為:\n";
            message+="帳號："+Conf.account+"\n";
            message+="姓名："+Conf.name+"\n";
            message+="食物："+Conf.food+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==btModify) {
            new ModifyDialog(this);
        }
        else {
            JOptionPane.showMessageDialog(this,"謝謝光臨");
            System.exit(0);
        }
    }
}

