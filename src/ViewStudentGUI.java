import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ViewStudentGUI extends JFrame{
	private static Student student;
	private JPanel contentPane;
	
	private JTable table;
	public Object rowData[] = new Object[5];
	private JButton btnBack;
	
	private final String[] columns = {"Name", "ID", "Term Yr", "BirthDate", "Phone Num"};
	private final Object[][] data = {{"","","","",""}};
	private final TableModel model = new DefaultTableModel(data, columns);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentGUI view_Screen = new ViewStudentGUI();
					view_Screen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewStudentGUI() {
		student = AddStudentGUI.student;
		initialize();
		
	}
	
	public void initialize() {
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 622);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGUI menu_Screen = new MenuGUI();
				menu_Screen.setVisible(true);
				Close();
			}
		});
		
		btnBack.setBounds(172, 495, 89, 23);
		contentPane.add(btnBack);
		
		table = new JTable(model);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true); // sorting of the rows on a particular column
		table.setBounds(20, 119, 411, 16);
		
		((DefaultTableModel) model).setRowCount(0);
		for(Student s: student.studentList) {
			rowData[0] = s.GetName();
			rowData[1] = s.ID;
			rowData[2] = s.getTermYr();
			rowData[3] = s.birthDate;
			rowData[4] = s.getPhoneNum();
			((DefaultTableModel) model).addRow(rowData);
		}
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(10, 63, 414, 299);
		contentPane.add(tablePanel);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tablePanel.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Students");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 52);
		contentPane.add(lblNewLabel);
	}
	
	private void Close() {
		setVisible(false);
		dispose();
	}
}
