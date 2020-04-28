import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class PassengerGUI extends JFrame {
			
	//Helpful variables
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel,panelNames,panelAgeNumber,panelIdPassword,panelButtonsUp,panelButtonsDown;
	private JButton busesProgramButton,fastWayButton,ticketCalculationButton,ticketShopButton,profileConfigurationSaveButton,deletionButton,logoutButton;
	private JTextField firstnameField,lastnameField,ageField,phoneNumberField,passwordField;
	private JLabel firstnameLabel,lastnameLabel,ageLabel,phoneNumberLabel,idLabel,userId,passwordLabel;
	private JFrame mainMenuFrame;
	//Passenger when LoggedIn Page
	public PassengerGUI(Passenger passenger,JFrame mainMenuFrame) {
		frame= new JFrame();
		this.mainMenuFrame=mainMenuFrame;
		icon = new ImageIcon("p2.png");
		
		//Panels
		panel = new JPanel();
		panelNames = new JPanel();
		panelAgeNumber = new JPanel();
		panelIdPassword = new JPanel();
		panelButtonsUp=new JPanel();
		panelButtonsDown=new JPanel();
		
		//Labels
		firstnameLabel= new JLabel("Firstname:");
		lastnameLabel=new JLabel("Lastname:");
		ageLabel= new JLabel("Age:");
		phoneNumberLabel=new JLabel("Phone number:");
		idLabel= new JLabel("Id/Username:");
		userId=new JLabel(passenger.getId());
		userId.setForeground(Color.red);
		Border border=BorderFactory.createLineBorder(Color.DARK_GRAY);
		userId.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5,5,5,5)));
		passwordLabel=new JLabel("Password:");
		
		
		//Profile information
		firstnameField=new JTextField(passenger.getFirstName());
		lastnameField=new JTextField(passenger.getLastName());
		ageField=new JTextField(String.valueOf(passenger.getAge()));
		phoneNumberField=new JTextField(passenger.getPhoneNumber());
		passwordField=new JTextField(passenger.getPassword());

		
 /**/	//Bus Program
		busesProgramButton= new JButton("View buses program");
		busesProgramButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//APO SECRETARY
				
			}
			
		});
		
 /**/	//Fastest bus to destination
		fastWayButton = new JButton("Fastest bus to");
		fastWayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FastestBus();
			}
		});
		
		
		
 /**/	//calculateTicket
		ticketCalculationButton= new JButton("Ticket Calculator");
		ticketCalculationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TicketCalculation(passenger);
			}
		});
		
		
		
 /**/	//Ticket or Card Purchase
		ticketShopButton=new JButton("Buy Ticket/Card");
		ticketShopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				new TicketPurchase(passenger);
			}	
		});
		
		
		//Profile configuration
		profileConfigurationSaveButton= new JButton("Save configuration");
		/*profileConfigurationSaveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passenger.setInfo(firstnameField.getText(),lastnameField.getText(),Integer.valueOf(ageField.getText()),phoneNumberField.getText(),passwordField.getText());
				for(Passenger pas : passenger.getSec().getPassengersList()) {
					if((passenger.getId()).equals(pas.getId())) {
						pas=passenger;
					}
				}
			}	
		}); */
		
		
		//Profile Deletion
		deletionButton=new JButton("Delete profile");
		deletionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String[] buttons = { "Yes","No"};

				    int rc = JOptionPane.showOptionDialog(null, "Do you want delete account?", "Delete Account",
				        JOptionPane.WARNING_MESSAGE, 1, null, buttons, buttons[1]);

				    System.out.println(rc);
				    if(rc == 0) {
				    	System.out.println("delete");
				    }

				  }
			
		});

		
		logoutButton=new JButton("Logout");
		logoutButton.setBackground(Color.LIGHT_GRAY);
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mainMenuFrame.setVisible(true);
			}
			
		});
		
		
		//Profile info adding to sub-panels
		panelNames.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		panelNames.add(firstnameLabel);
		panelNames.add(firstnameField);
		panelNames.add(lastnameLabel);
		panelNames.add(lastnameField);
		panelAgeNumber.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		panelNames.add(ageLabel);
		panelNames.add(ageField);
		panelNames.add(phoneNumberLabel);
		panelNames.add(phoneNumberField);
		panelIdPassword.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		panelIdPassword.add(idLabel);
		panelIdPassword.add(userId);
		panelIdPassword.add(passwordLabel);
		panelIdPassword.add(passwordField);
		
		//Buttons adding to sub-panels
		panelButtonsUp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		panelButtonsUp.add(ticketShopButton);
		panelButtonsUp.add(ticketCalculationButton);
		panelButtonsUp.add(fastWayButton);
		panelButtonsDown.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		panelButtonsDown.add(busesProgramButton);
		panelButtonsDown.add(deletionButton);
		panelButtonsDown.add(profileConfigurationSaveButton);
		panelButtonsDown.add(logoutButton);
		
		//Sub-panels setting bounds
		panelNames.setLayout(null);
		firstnameLabel.setBounds(50,10,100,20);
		lastnameLabel.setBounds(250,10,100,20);
		firstnameField.setBounds(115,10,100,20);
		lastnameField.setBounds(315,10,100,20);
		ageLabel.setBounds(50,50,100,20);
		phoneNumberLabel.setBounds(220,50,100,20);
		ageField.setBounds(115,50,30,20);
		phoneNumberField.setBounds(315,50,100,20);
		
		panelIdPassword.setLayout(null);
		idLabel.setBounds(50,30,100,20);
		userId.setBounds(130,30,80,20);
		passwordLabel.setBounds(250,30,100,20);
		passwordField.setBounds(315,30,100,20);
		
		panelButtonsUp.setLayout(null);
		ticketCalculationButton.setBounds(50,20,150,20);
		fastWayButton.setBounds(280,20,150,20);
		ticketShopButton.setBounds(150,60,150,20);
		
		panelButtonsDown.setLayout(null);
		busesProgramButton.setBounds(50,20,150,20);
		deletionButton.setBounds(280,20,150,20);
		profileConfigurationSaveButton.setBounds(150,60,150,20);
		logoutButton.setBounds(380,60,100,20);
		
		
		//Sub-panels adding to panel
		panel.add(panelNames);
		panel.add(panelIdPassword);
		panel.add(panelButtonsUp);
		panel.add(panelButtonsDown);

		//Panel layout
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setSize(500,400);
		frame.setTitle("Passenger: "+passenger.getId());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
