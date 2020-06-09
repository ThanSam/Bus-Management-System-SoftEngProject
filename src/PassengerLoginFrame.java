
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


public class PassengerLoginFrame extends JFrame {
	
	private JPanel panel;
	private ImageIcon icon;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel img;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton LoginButton;
	private JLabel question;
	private JButton AccountButton;
	private JButton ReturnButton;
	private Secretariat sec;
	private JFrame mainMenuFrame;
	private ArrayList<Passenger> passengerList;
	
	
	public PassengerLoginFrame(Secretariat sec) {
		this.mainMenuFrame=mainMenuFrame;
		this.sec=sec;
		
		passengerList=sec.getPassengerList();
		
		//Panel 
		panel = new JPanel();
		panel.setLayout(null);
		icon = new ImageIcon("p2.png");
		img = new JLabel(new ImageIcon("p3.png"));
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Username", Font.PLAIN, 16)); 
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Password", Font.PLAIN, 16));
		usernameField = new JTextField("1");
		passwordField = new JPasswordField("1");
		LoginButton = new JButton("Login");
		question = new JLabel("No account?");
		AccountButton = new JButton("Create one!");
		ReturnButton = new JButton("Back");
		
		img.setBounds(75, 0, 150, 150);
		usernameLabel.setBounds(115, 100, 150, 150);
		usernameField.setBounds(90, 200, 115, 20);
		passwordLabel.setBounds(115, 180, 150, 150);
		passwordField.setBounds(90, 280, 115, 20);
		LoginButton.setBounds(97, 330, 100, 25);
		question.setBounds(17, 365, 80, 90);
		AccountButton.setBounds(97, 400, 100, 20);
		ReturnButton.setBounds(200,430,80,25);
		

		
		panel.add(img);
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(LoginButton);
		panel.add(question);
		panel.add(AccountButton);
		panel.add(ReturnButton);
		
		ButtonListener listener = new ButtonListener();
		LoginButton.addActionListener(listener);
		AccountButton.addActionListener(listener);
		ReturnButton.addActionListener(listener);
		
		this.setFocusable(true);
		this.setContentPane(panel);
		this.setIconImage(icon.getImage());
		this.setTitle("Passenger Login");
		this.setSize(300,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			
			if(e.getSource().equals(LoginButton)) {
				
				boolean f=false;
				passengerList=sec.getPassengerList();
				Passenger p1= passengerList.get(0);
				String password=new String(passwordField.getPassword()); 
				String username=new String(usernameField.getText()); 
				
				for(Passenger pass:passengerList) {
					
					if(((pass.getId().equals(username))&&(password).equals(pass.getPassword()))) {
						p1=pass;
						f=true;
					}	
				}
				if(f) {
					PassengerGUI  PassengerGUI= new PassengerGUI(p1,sec);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"FAILED. Wrong id or password.\n	            Please try again.");
				}
			
			}
			else if(e.getSource().equals(AccountButton)) {
				PassengerRegistration passengerRegistration=new PassengerRegistration(sec);
				dispose();
			}
			else if(e.getSource().equals(ReturnButton)) {
				new MainFrame(sec);
				dispose();
			}
		}
	}
}