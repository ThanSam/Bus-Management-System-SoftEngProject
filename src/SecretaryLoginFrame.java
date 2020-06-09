import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class SecretaryLoginFrame extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JLabel img;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton LoginButton;
	private JButton ReturnButton;
	private Secretariat sec;

	public SecretaryLoginFrame(Secretariat sec) {

		this.sec = sec;
		
		//Create panels, Labels, JTextField, Buttons.
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		icon = new ImageIcon("p2.png");
		img = new JLabel(new ImageIcon("p5.png"));
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Username", Font.PLAIN, 16));
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Username", Font.PLAIN, 16));
		usernameField = new JTextField("Secretariat1");
		passwordField = new JPasswordField("Secretariat1");
		LoginButton = new JButton("Login");
		ReturnButton = new JButton("Back");

		//Set Size...
		img.setBounds(40, 20, 200, 200);
		usernameLabel.setBounds(105, 180, 150, 150);
		usernameField.setBounds(85, 270, 115, 20);
		passwordLabel.setBounds(105, 235, 150, 150);
		passwordField.setBounds(85, 325, 115, 20);
		LoginButton.setBounds(93, 370, 100, 25);
		ReturnButton.setBounds(200, 430, 80, 25);

		//Add in mainPanel other components.
		mainPanel.add(img);
		mainPanel.add(usernameLabel);
		mainPanel.add(usernameField);
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);
		mainPanel.add(LoginButton);
		mainPanel.add(ReturnButton);

		//ButtonListener for all Buttons.
		ButtonListener listener = new ButtonListener();
		LoginButton.addActionListener(listener);
		ReturnButton.addActionListener(listener);

		this.setFocusable(true);
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setTitle("Secretary Login");
		this.setSize(300, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//LoginButton Function.
			if (e.getSource().equals(LoginButton)) {

				MainSecretariatFrame mainSecretariatFrame = new MainSecretariatFrame(sec);
				mainSecretariatFrame.setSecreatariat(sec);
				dispose();

				//ReutrnButton Function.
			} else if (e.getSource().equals(ReturnButton)) {

				dispose();

				new MainFrame(sec);

			}
		}
	}
}
