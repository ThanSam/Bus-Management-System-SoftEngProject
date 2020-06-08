import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;


public class SecretaryLoginFrame extends JFrame {
	
	private JPanel panel;
	private ImageIcon icon;
	private JLabel img;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton LoginButton;
	private JButton ReturnButton;
	private JFrame mainMenuFrame;
	private Secretariat sec;
	public SecretaryLoginFrame(JFrame mainMenuFrame,Secretariat sec) {
		
		this.mainMenuFrame=mainMenuFrame;
		this.sec=sec;
		panel = new JPanel();
		panel.setLayout(null);
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
		
		
		img.setBounds(40, 20, 200, 200);
		usernameLabel.setBounds(105, 180, 150, 150);
		usernameField.setBounds(85, 270, 115, 20);
		passwordLabel.setBounds(105,235,150,150);
		passwordField.setBounds(85, 325, 115, 20);
		LoginButton.setBounds(93, 370, 100, 25);
		ReturnButton.setBounds(200,430,80,25);
		
		
		panel.add(img);
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(LoginButton);
		panel.add(ReturnButton);
		
		ButtonListener listener = new ButtonListener();
		LoginButton.addActionListener(listener);
		ReturnButton.addActionListener(listener);
		
		this.setFocusable(true);
		this.setContentPane(panel);
		this.setIconImage(icon.getImage());
		this.setTitle("Secretary Login");
		this.setSize(300,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			
			if(e.getSource().equals(LoginButton)) {
		
				MainSecretariatFrame mainSecretariatFrame = new MainSecretariatFrame(sec);
				mainSecretariatFrame.setSecreatariat(sec);
				dispose();
				
			}
			else if(e.getSource().equals(ReturnButton)) {
				
				dispose();
			 mainMenuFrame.setVisible(true);
			 
			}
		}
	}
	
}
