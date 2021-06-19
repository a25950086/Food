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

/*搜尋食物界面*/
public class SearchingDialog extends JDialog implements ActionListener{
    private JLabel lbMsg = new JLabel("您的帳號為：");
    private JLabel lbAccount = new JLabel(Conf.account);
    private JLabel lbFood = new JLabel("請您修改食物");
    private JTextField cbFood = new JTextField(Conf.food,10);

    public SearchingDialog(JFrame frm) {
        super(frm, true);
        this.setLayout(new GridLayout(9, 1));
        this.add(lbMsg);
        this.add(lbFood);
        this.add(cbFood);
        cbFood.addItem("財務部");
        cbFood.addItem("行政部");
        cbFood.addItem("客戶服務部");
        cbFood.addItem("銷售部");
        cbFood.setSelectedItem(Conf.food);
    }
}
