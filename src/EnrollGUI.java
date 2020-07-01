import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EnrollGUI extends JFrame{
	private Student student;
	private AddStudentGUI addStudent_Screen = new AddStudentGUI();

	private JPanel contentPane;
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	private JTable table;
	
	public Object rowData[] = new Object[2];
	
	private String[] columns = {"Course Name", "Price", ""};
	private Object[][] data = {{"", "", ""}};
	private TableModel model = new DefaultTableModel(data, columns) ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollGUI enroll_screnn = new EnrollGUI();
					enroll_screnn.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EnrollGUI() {
		student = AddStudentGUI.student;
		initialize();
	}
	
	public void initialize() {
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headerEnroll = new JLabel("Enroll");
		headerEnroll.setBounds(0, 11, 444, 43);
		headerEnroll.setFont(new Font("Tahoma", Font.PLAIN, 35));
		headerEnroll.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(headerEnroll);
		
		JLabel courseLabel = new JLabel("Choose Course:");
		courseLabel.setBounds(10, 100, 106, 14);
		contentPane.add(courseLabel);
		comboBox.setBounds(10, 132, 89, 20);
		
		
		
		System.out.println(student.coursesEnrolledIn.size());
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MATH 1401", "MATH 1314", "ENG 1432", "ENG 1431", "SOCI 1316", "TX GOV 1301"}));
		contentPane.add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(109, 453, 77, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI menu_Screen = new MenuGUI();
				menu_Screen.setVisible(true);
				Close();
			}
		});
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.setBounds(254, 453, 77, 23);
		contentPane.add(btnEnroll);
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course = (String)comboBox.getSelectedItem();
				student.EnrollInCourse(course);				
				//Update and Reload 
				addCourseToTable();
				System.out.println(student.coursesEnrolledIn);
				System.out.println(student.getCostOfTuition());
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		
		
		JLabel headerCourses = new JLabel("Your Courses");
		headerCourses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		headerCourses.setHorizontalAlignment(SwingConstants.CENTER);
		headerCourses.setBounds(140, 197, 147, 31);
		contentPane.add(headerCourses);
		
		addCourseToTable();

		table = new JTable(model);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(10, 239, 424, 164);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tablePanel.add(table, BorderLayout.CENTER);
		contentPane.add(tablePanel);
		
		
		//contentPane.add(btnRemove);
	}
	
	

	private void Close() {
		setVisible(false);
		dispose();
	}
	
	private void createTable() {
		
	}
	
	private void addCourseToTable() {
		((DefaultTableModel) model).setRowCount(0);
		for(int i = 0; i <= student.coursesEnrolledIn.size()-1; i++) {
			rowData[0] = student.coursesEnrolledIn.get(i);
			rowData[1] = 500;
			((DefaultTableModel) model).addRow(rowData);
		}
	}
}
