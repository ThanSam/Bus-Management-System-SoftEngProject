import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DriverLoginFrame extends JFrame {
	private JFrame mainMenuFrame;
	private JPanel panel;
	private ImageIcon icon;
	private JLabel UserIdLabel;
	private JTextField userIdField;
	private JLabel PasswordLabel;
	private JLabel img;
	private JButton LogInButton;
	private JButton ReturnButton;

	private Secretariat sec;
	private Driver aDriver;
	private JPasswordField passwordField;
	private ArrayList<Driver> driverList = new ArrayList<Driver>();

	public DriverLoginFrame(Secretariat aSecretariat, Driver aDriver, JFrame mainMenuFrame) {
		this.mainMenuFrame = mainMenuFrame;
		this.aDriver = aDriver;
		this.sec = aSecretariat;

		panel = new JPanel();
		panel.setLayout(null);
		icon = new ImageIcon("p2.png");
		UserIdLabel = new JLabel("User ID");
		UserIdLabel.setFont(new Font("Username", Font.PLAIN, 16));
		userIdField = new JTextField("1");
		PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Username", Font.PLAIN, 16));
		passwordField = new JPasswordField("1");
		img = new JLabel(new ImageIcon("p4.png"));
		LogInButton = new JButton("Login");
		ReturnButton = new JButton("Back");


		ButtonListener b1 = new ButtonListener();
		LogInButton.addActionListener(b1);
		ReturnButton.addActionListener(b1);

		img.setBounds(40, 20, 200, 180);
		UserIdLabel.setBounds(115, 180, 150, 150);
		userIdField.setBounds(85, 270, 115, 20);
		PasswordLabel.setBounds(115, 235, 150, 150);
		passwordField.setBounds(85, 325, 115, 20);
		LogInButton.setBounds(93, 370, 100, 25);
		ReturnButton.setBounds(200, 430, 80, 25);

		panel.add(img);
		panel.add(UserIdLabel);
		panel.add(userIdField);
		panel.add(PasswordLabel);
		panel.add(passwordField);
		panel.add(LogInButton);
		panel.add(ReturnButton);

		this.setFocusable(true);
		this.setContentPane(panel);
		this.setIconImage(icon.getImage());
		this.setTitle("Driver Login");
		this.setSize(300, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
          String outcome=" ";
          userIdField.setText("1");       
          passwordField.setText("1");
			if (e.getSource().equals(LogInButton)) {
				driverList = sec.getDriverList();
				for (Driver driver : driverList) {
					if ((userIdField.getText().equals(driver.getId()))
							&& (passwordField.getText().equals(driver.getPassword()))) {
						DriverGUI driverGUI = new DriverGUI(driver, sec);
						outcome="ok";
						dispose();
						break;
					}
				}
				if(outcome==" ") {
				JOptionPane.showMessageDialog(null, "Invalid ID or password");
				}
			} else if (e.getSource().equals(ReturnButton)) {
				mainMenuFrame.setVisible(true);
				dispose();
			}

		}
	}
}
