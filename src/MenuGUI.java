import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

public class MenuGUI extends JFrame{
	private AddStudentGUI addStudent_Screen = new AddStudentGUI();
	private Student student;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		
					MenuGUI window = new MenuGUI();
					window.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuGUI() {
		student = AddStudentGUI.student;
		initialize();
	}
	
	private void initialize() {
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 622);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel headingLabel = new JLabel("Menu");
		headingLabel.setBounds(172, 11, 98, 43);
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.setBounds(147, 129, 133, 32);
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollGUI enroll_Screen = new EnrollGUI();
				enroll_Screen.setVisible(true);	
				Close();
			}
		});
		
		JButton btnViewBal = new JButton("View Balance");
		btnViewBal.setBounds(147, 187, 133, 32);
		btnViewBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBalanceGUI balance_Screen = new ViewBalanceGUI();
				balance_Screen.setVisible(true);	
				Close();
			}
		});
		
		JButton btnViewStudents = new JButton("View Students");
		btnViewStudents.setBounds(147, 245, 133, 32);
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentGUI viewStudent_Screen = new ViewStudentGUI();
				viewStudent_Screen.setVisible(true);
				Close();
			}
		});
		
		JButton btnAdd = new JButton("Add Student");
		btnAdd.setBounds(147, 296, 133, 32);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent_Screen = new AddStudentGUI();
				addStudent_Screen.setVisible(true);
				Close();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(headingLabel);
		contentPane.add(btnEnroll);
		contentPane.add(btnViewBal);
		contentPane.add(btnViewStudents);
		contentPane.add(btnAdd);
	}

	public void Close() {
		setVisible(false);
		dispose();
	}
}
