import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class ViewBalanceGUI extends JFrame{
	private JFormattedTextField textField;
	private Student student;
	
	private AddStudentGUI addStudent_Screen = new AddStudentGUI();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBalanceGUI balance_Screen = new ViewBalanceGUI();
					balance_Screen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewBalanceGUI() {
		student = AddStudentGUI.student;
		initialize();
	}
	
	private void initialize() {
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 622);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headingLabel = new JLabel("View Balance");
		headingLabel.setBounds(5, 5, 424, 43);
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(headingLabel);
		
		JLabel remaingBalanceLabel = new JLabel("Remaing Balance:");
		remaingBalanceLabel.setBounds(10, 122, 111, 20);
		contentPane.add(remaingBalanceLabel);
		
		textField = new JFormattedTextField();
		textField.setEditable(false);
		textField.setValue(addStudent_Screen.student.getCostOfTuition());
		textField.setBounds(119, 122, 90, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel paymentLabel = new JLabel("Payment Amt:");
		paymentLabel.setBounds(10, 245, 111, 14);
		contentPane.add(paymentLabel);
		
		NumberFormat amountFormat = NumberFormat.getCurrencyInstance();
		amountFormat.setMaximumFractionDigits(0);
		NumberFormatter formatter = new NumberFormatter(amountFormat);
		formatter.setMinimum(1.00);
		formatter.setMaximum(10000000.00);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		
		JFormattedTextField paymentTextField = new JFormattedTextField(formatter);
		paymentTextField.setBounds(119, 242, 90, 20);
		paymentTextField.setValue(0.00);
		contentPane.add(paymentTextField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI menu_Screen = new MenuGUI();
				menu_Screen.setVisible(true);
				Close();
			}
		});
		btnCancel.setBounds(76, 442, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Double)paymentTextField.getValue() > 0 && (Double)paymentTextField.getValue() <= student.getCostOfTuition()) {
					student.PayTuition((Double)paymentTextField.getValue());
				}else {
					JOptionPane.showMessageDialog(null, "Enter a valid amount");
				}
				textField.setText("" + addStudent_Screen.student.getCostOfTuition());
				paymentTextField.setValue(0.00);
			}
		});
		btnConfirm.setBounds(228, 442, 89, 23);
		contentPane.add(btnConfirm);
	}

	private void Close() {
		setVisible(false);
		dispose();
	}
}
