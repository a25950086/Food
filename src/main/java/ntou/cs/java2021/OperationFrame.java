package ntou.cs.java2021;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.Query;
import javax.swing.*;
import javax.swing.JComboBox;

/*操作界面*/
public class OperationFrame extends JFrame implements ActionListener {
    /************************定義各控制項******************************/
    private String welcomMsg="選擇如下操作:";
    private JLabel lblWelcome=new JLabel(welcomMsg);

    private JButton btSearch=new JButton("搜尋並新增食物");
    private JButton btQuery=new JButton("顯示詳細信息");
    private JButton btModify=new JButton("修改個人資料");
    private JButton btExit=new JButton("退出");
    public OperationFrame() {
        /****************************界面初始化************************/
        super("當前登錄: "+Conf.account);
        this.setLayout(new GridLayout(5,1));
        this.add(lblWelcome);
        this.add(btSearch);
        this.add(btQuery);
        this.add(btModify);
        this.add(btExit);
        this.setSize(520,380);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************增加監聽*******************************/
        btSearch.addActionListener(this);
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btSearch) {
            new SearchingDialog(this);
        }

        else if(e.getSource()==btQuery) {
           /* String message="您的詳細資料為:\n";
            message+="帳號："+Conf.account+"\n";
            message+="姓名："+Conf.name+"\n";
            message+="性別(男/女)："+Conf.gender+"\n";
            message+="年齡："+Conf.age+"\n";
            message+="身高："+Conf.height+"(cm)"+"\n";
            message+="體重："+Conf.weight+"(kg)"+"\n";

            //message+="食物："+Conf.food+"\n";
            JOptionPane.showMessageDialog(this,message);
            JComboBox cbFood=new JComboBox();*/
            new ShowDetailDialog(this);
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

