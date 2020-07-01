import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class AddStudentGUI extends JFrame{
	public static Student student;
	private JTextField fNameField;
	private JTextField mNameField;
	private JTextField lNameField;
	
	private ButtonGroup btnGroup = new ButtonGroup();
	private JRadioButton btnMale = new JRadioButton("Male");
	private JRadioButton btnFemale = new JRadioButton("Female");
	private JDatePickerImpl datePicker;
	private JComboBox<Object> termField = new JComboBox<Object>();
	private JFormattedTextField phoneNumField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGUI window = new AddStudentGUI();
					window.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddStudentGUI() {
		initialize();
	}

	private void initialize() {
		new JFrame();
		setBounds(100, 100, 460, 622);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel headingLabel = new JLabel("Student Database");
		headingLabel.setBounds(76, 11, 300, 40);
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(117, 88, 70, 14);
		fNameField = new JTextField();
		fNameField.setBounds(205, 85, 137, 20);
		fNameField.setColumns(10);
		
		JLabel middleNameLabel = new JLabel("Middle Name:");
		middleNameLabel.setBounds(106, 127, 89, 14);
		mNameField = new JTextField  ();
		mNameField.setBounds(205, 124, 137, 20);
		mNameField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(117, 165, 68, 14);
		lNameField = new JTextField  ();
		lNameField.setBounds(205, 162, 137, 20);
		lNameField.setColumns(10);
		
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setBounds(133, 204, 68, 14);
		sexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		btnMale.setBounds(205, 200, 59, 23);
		btnFemale.setBounds(266, 200, 76, 23);
		btnGroup.add(btnMale);
		btnGroup.add(btnFemale);
		
		JLabel birthDateLabel = new JLabel("Birth Date:");
		birthDateLabel.setBounds(117, 239, 68, 26);
		UtilDateModel model = new UtilDateModel();
		model.setDate(2020, 06, 21);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(207, 239, 135, 23);
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, datePicker.getJFormattedTextField(), 0, SpringLayout.WEST, datePicker);
		
		JLabel termLabel = new JLabel("Term Yr.");
		termLabel.setBounds(135, 296, 68, 14);
		termField.setBounds(207, 292, 135, 22);
		termField.setModel(new DefaultComboBoxModel<Object>(new String[] {"Select...", "Freshman", "Sophomore", "Junior", "Senior"}));
		
		JLabel phoneNumLabel = new JLabel("Phone:");
		phoneNumLabel.setBounds(135, 347, 68, 14);
		phoneNumField = new JFormattedTextField(createFormatter("(###)###-####"));
		phoneNumField.setBounds(207, 344, 135, 20);
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.setBounds(162, 462, 125, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateFields();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnAdd);
		getContentPane().add(headingLabel);
		getContentPane().add(middleNameLabel);
		getContentPane().add(birthDateLabel);
		getContentPane().add(lastNameLabel);
		getContentPane().add(sexLabel);
		getContentPane().add(firstNameLabel);
		getContentPane().add(btnMale);
		getContentPane().add(btnFemale);
		getContentPane().add(fNameField);
		getContentPane().add(mNameField);
		getContentPane().add(lNameField);
		getContentPane().add(termLabel);
		getContentPane().add(phoneNumLabel);
		getContentPane().add(datePicker);
		getContentPane().add(termField);
		getContentPane().add(phoneNumField);
	}
	
	
	private MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
	
	public String getSelectedOption() {
	    Enumeration<AbstractButton> radioButtons = btnGroup.getElements();
	    while (radioButtons.hasMoreElements()) {
	        AbstractButton currentRadioButton = radioButtons.nextElement();
	        if (currentRadioButton.isSelected()) {
	            return currentRadioButton.getText();
	        }
	    }
	    return null;
	}

    private void currentSelectedOption() {
        String selected = getSelectedOption();
        if (selected == null) {
            System.out.println("There is something wrong! Nothing is selected");
            return;
        }
        switch (selected.toLowerCase()) {
            case "male":
                student.sex = 'M';
                break;
            case "female":
                student.sex = 'F';
                break;
            case "other":
                student.sex = 'O';
                break;
        }
    }

	private void validateFields() {
		String fName = fNameField.getText();
		String mName = mNameField.getText();
		String lName = lNameField.getText();
		String birthDate = datePicker.getJFormattedTextField().getText();
		String termYr = (String)termField.getSelectedItem();
		String phoneNumber = phoneNumField.getText();

		if(fName.equals("") || mName.equals("") || lName.equals("") || !btnMale.isSelected() && !btnFemale.isSelected()||birthDate.equals("") ||termYr.equals("Select...") || phoneNumber.equals("(   )   -    ") ) {
			JOptionPane.showMessageDialog(null, "One or more fields is empty");
		}
		else if(!fName.matches("[a-zA-Z]+") || !mName.matches("[a-zA-Z]+") || !lName.matches("[a-zA-Z]+")) {
		JOptionPane.showMessageDialog(null, "Please enter a valid name");
		}else{
			student = new Student();
			student.SetName(fName, mName,lName);
			currentSelectedOption(); // display Sex
			student.birthDate = birthDate;
			student.SetTermYr(termYr);
			student.phoneNum = phoneNumber;
			student.CreateStudentID(fName); 
			Student.studentList.add(student);
				
			//Debug Info
			for(Student s: Student.studentList) {
				System.out.println(s.name_Full);
				System.out.println(s.sex);
				System.out.println(s.birthDate);
				System.out.println(s.termYear);
				System.out.println(s.phoneNum);
				System.out.println("Student ID: " + s.ID);
			}
			MenuGUI menuFrame = new MenuGUI();
			menuFrame.setVisible(true);
	
			Close();
		}
	}
	
	private void Close() {
		setVisible(false);
		dispose();
	}
}
