import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PassengerRegistration extends JFrame {

	private Passenger p1;
	private ArrayList<Passenger> passengersList;
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel, panelFirstName, panelLastName, panelAge, panelNumber, panelId, panelPassword, panelButton;
	private JTextField firstnameField, lastnameField, ageField, phoneNumberField, idField, passwordField;
	private JLabel firstnameLabel, lastnameLabel, ageLabel, phoneNumberLabel, idLabel, passwordLabel;
	private JButton verificationButton, cancelButton;
	private Secretariat sec;
	
private JFrame mainMenuFrame;

	// PassengerRegistration GUI
	public PassengerRegistration(Secretariat sec,JFrame mainMenuFrame) {
		passengersList=sec.getPassengerList();
		this.mainMenuFrame= mainMenuFrame;
		this.sec = sec;
		frame = new JFrame();
		panel = new JPanel();
		icon = new ImageIcon("p2.png");
		panelFirstName = new JPanel();
		panelLastName = new JPanel();
		panelAge = new JPanel();
		panelNumber = new JPanel();
		panelId = new JPanel();
		panelPassword = new JPanel();
		panelButton = new JPanel();

		// Buttons
		verificationButton = new JButton("Verification");
		cancelButton = new JButton("Cancel");

		// Labels
		firstnameLabel = new JLabel("Firstname:");
		lastnameLabel = new JLabel("Lastname:");
		ageLabel = new JLabel("Age:");
		phoneNumberLabel = new JLabel("Phone number:");
		idLabel = new JLabel("Id/Username:");
		passwordLabel = new JLabel("Password:");

		// Profile information
		firstnameField = new JTextField("example");
		lastnameField = new JTextField("example");
		ageField = new JTextField("18");
		phoneNumberField = new JTextField("69xxxxx");
		idField = new JTextField("username");
		passwordField = new JTextField("password");

		// Registration of a new passenger
		verificationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p1=null;
				String outcome = " ";
				p1 = new Passenger(firstnameField.getText(), lastnameField.getText(),
						Integer.valueOf(ageField.getText()), phoneNumberField.getText(), idField.getText(),
						passwordField.getText(),sec);
				

				if (p1.getAge() < 6 || p1.getAge() > 99) {
					outcome = "Please enter a valid age.";
				}
				if (Character.getNumericValue((p1.getPhoneNumber()).charAt(0)) != 6
						|| Character.getNumericValue((p1.getPhoneNumber()).charAt(1)) != 9) {
					outcome = "Please enter a valid phone number.";
				}
				if (p1.getPassword().length() < 8) {
					outcome = "Your password should be 8 characters or more.";
				}
				passengersList = sec.getPassengerList();
				for (Passenger pas : passengersList) {
					if (pas.getPhoneNumber().equals(p1.getPhoneNumber())) {
						outcome = "Please choose a diferrent phone number.";
					}
					if (p1.getId().equals(pas.getId())) {
						outcome = "Please choose a different id.";
					}
				}
				
		
				if (outcome.equals(" ")) {
					PassengerGUI passengerGUI = new PassengerGUI(p1,mainMenuFrame,sec);
					sec.addPassenger(p1);
					JOptionPane.showMessageDialog(null, "You have registrated succesfully.");
					frame.dispose();

				} else {

					JOptionPane.showMessageDialog(null,outcome);
				}
			}
		});

		// Returning to LoginFrame
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				 new PassengerLoginFrame(sec,mainMenuFrame);
			}
		});

		// Adding to sub-panels
		panelFirstName.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.LIGHT_GRAY));
		panelFirstName.add(firstnameLabel);
		panelFirstName.add(firstnameField);
		panelLastName.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		panelLastName.add(lastnameLabel);
		panelLastName.add(lastnameField);
		panelAge.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		panelAge.add(ageLabel);
		panelAge.add(ageField);
		panelNumber.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		panelNumber.add(phoneNumberLabel);
		panelNumber.add(phoneNumberField);
		panelId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		panelId.add(idLabel);
		panelId.add(idField);
		panelPassword.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.LIGHT_GRAY));
		panelPassword.add(passwordLabel);
		panelPassword.add(passwordField);
		panelButton.add(verificationButton);
		panelButton.add(cancelButton);

		// Sub-panels setting bounds
		panelFirstName.setLayout(null);
		firstnameLabel.setBounds(110, 20, 100, 20);
		firstnameField.setBounds(175, 20, 100, 20);

		panelLastName.setLayout(null);
		lastnameLabel.setBounds(110, 20, 100, 20);
		lastnameField.setBounds(175, 20, 100, 20);

		panelAge.setLayout(null);
		ageLabel.setBounds(135, 20, 100, 20);
		ageField.setBounds(165, 20, 100, 20);

		panelNumber.setLayout(null);
		phoneNumberLabel.setBounds(80, 20, 100, 20);
		phoneNumberField.setBounds(175, 20, 100, 20);

		panelId.setLayout(null);
		idLabel.setBounds(90, 20, 100, 20);
		idField.setBounds(170, 20, 100, 20);

		panelPassword.setLayout(null);
		passwordLabel.setBounds(110, 20, 100, 20);
		passwordField.setBounds(175, 20, 100, 20);

		panelButton.setLayout(null);
		verificationButton.setBounds(20, 12, 100, 30);
		cancelButton.setBounds(270, 12, 100, 30);

		// Adding sub-panels in panel
		panel.add(panelFirstName);
		panel.add(panelLastName);
		panel.add(panelAge);
		panel.add(panelNumber);
		panel.add(panelId);
		panel.add(panelPassword);
		panel.add(panelButton);

		// Panel Layout
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setSize(400, 400);
		frame.setTitle("Passenger Registration");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
