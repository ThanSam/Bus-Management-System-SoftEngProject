import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CreateDeleteDriverFrame extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JPanel deletePanel;
	private JPanel createPanel;

	private JButton createButton;
	private JButton deleteButton;
	private JButton backButton;

	private JTextField idField;
	private JTextField passwordField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField ageField;
	private JTextField phoneField;
	private JTextField deleteField;
	private Secretariat sec;
	private Driver aDriver;
	private ArrayList<Driver> driverList = new ArrayList<Driver>();

	public CreateDeleteDriverFrame() {
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		createPanel = new JPanel();
		deletePanel = new JPanel();

		createButton = new JButton("Create Driver");
		deleteButton = new JButton("Delete Driver");
		backButton = new JButton("Back");

		idField = new JTextField(10);
		passwordField = new JTextField(10);
		firstNameField = new JTextField(10);
	    lastNameField = new JTextField(10);
	    ageField = new JTextField(10);
	    phoneField = new JTextField(10);
	    
		idField.setText("Enter id");
		idField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (idField.getText().equals("Enter id")) {
					idField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (idField.getText().equals("")) {
					idField.setText("Enter id");
				}
			}}
		);
		
		passwordField.setText("Enter Password");
		passwordField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Enter Password")) {
					passwordField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (passwordField.getText().equals("")) {
					passwordField.setText("Enter Password");
				}
			}
		});
		firstNameField.setText("Enter First Name");
		firstNameField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (firstNameField.getText().equals("Enter First Name")) {
					firstNameField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (firstNameField.getText().equals("")) {
					firstNameField.setText("Enter First Name");
				}
			}
		});

		lastNameField.setText("Enter Last Name");
		lastNameField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (lastNameField.getText().equals("Enter Last Name")) {
					lastNameField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (lastNameField.getText().equals("")) {
					lastNameField.setText("Enter Last Name");
				}
			}
		});
		
		ageField.setText("Enter age");
		ageField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (ageField.getText().equals("Enter age")) {
					ageField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (ageField.getText().equals("")) {
					ageField.setText("Enter age");
				}
			}
		});
		
		phoneField.setText("Enter phone");
		phoneField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (phoneField.getText().equals("Enter phone")) {
					phoneField.setText("");
				}
			}

			public void focusLost(FocusEvent arg0) {
				if (phoneField.getText().equals("")) {
					phoneField.setText("Enter phone");
				}
			}
		});
		
		ButtonListener b1 = new ButtonListener();
		createButton.addActionListener(b1);
		deleteButton.addActionListener(b1);
		backButton.addActionListener(b1);
   
		createPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		createPanel.setBorder(new TitledBorder(new EtchedBorder(), "Create Driver Area"));
		createPanel.setLayout(new GridLayout(0, 1));
		
		createPanel.add(firstNameField);
		createPanel.add(lastNameField);
		createPanel.add(ageField);
		createPanel.add(phoneField);
		createPanel.add(idField);
		createPanel.add(passwordField);
		createPanel.add(createButton);
		

		deletePanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY));
		deletePanel.setBorder(new TitledBorder(new EtchedBorder(), "Delete Driver Area"));
		deletePanel.setLayout(new GridLayout(0, 1));
		deleteField = new JTextField("Enter id");
		deletePanel.add(deleteField);
		deletePanel.add(deleteButton);

		mainPanel.setLayout(null);
		
		createPanel.setBounds(0, 0, 270, 180);
		deletePanel.setBounds(0, 181, 270, 70);
		backButton.setBounds(190, 280, 75, 20);
		
		mainPanel.add(createPanel);
		mainPanel.add(deletePanel);
		mainPanel.add(backButton);
		
		this.setFocusable(true);
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(290, 350);
		this.setTitle("Create/Delete Driver");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	public void setSecreatariat(Secretariat secretariat) {
		this.sec = secretariat;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean ifexistDriver = false;
			String id;
		

			if (e.getSource().equals(createButton)) {
				String outcome = " ";
				 aDriver = new Driver(firstNameField.getText(), lastNameField.getText(),ageField.getText(), phoneField.getText(), idField.getText(),
						passwordField.getText(),sec);
			
				if (aDriver.getPassword().length() < 1) {
					outcome = "Your password should be 8 characters or more.";
				}
				driverList = sec.getDriverList();
				for (Driver driver : driverList) {
					if (aDriver.getId().equals(driver.getId())) {
						outcome = "Please choose a different id.";
						JOptionPane.showMessageDialog(null,outcome);
					}
				}
				if (outcome.equals(" ")) {
		             sec.addDriver(aDriver);
					JOptionPane.showMessageDialog(null, "You have create succesfully the driver: "+ aDriver.getId()+".");
					dispose();

				} else {

					JOptionPane.showMessageDialog(null,outcome);
				}
				
				
			}

			if (e.getSource().equals(deleteButton)) {
				ifexistDriver = sec.searchIdDriver(aDriver);
				if (ifexistDriver == true) {
					sec.deleteDriver(aDriver);
					JOptionPane.showMessageDialog(mainPanel,"The driver has been deleted");

				} else {
					JOptionPane.showMessageDialog(mainPanel, "The driver does not exist in the system.");

				}

			}
			if (e.getSource().equals(backButton)) {
				dispose();
			}

		}

	}
}