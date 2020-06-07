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
import javax.swing.border.Border;

public class PassengerGUI extends JFrame {
			
	//GUI variables
	private JFrame frame,mainMenuFrame;
	private ImageIcon icon;
	private JPanel panel,panelNames,panelAgeNumber,panelIdPassword,panelButtonsUp,panelButtonsDown;
	private JButton busesProgramButton,fastWayButton,ticketCalculationButton,ticketShopButton,profileConfigurationSaveButton,deletionButton,logoutButton;
	private JTextField firstnameField,lastnameField,ageField,phoneNumberField,passwordField;
	private JLabel firstnameLabel,lastnameLabel,ageLabel,phoneNumberLabel,idLabel,userId,passwordLabel;

	private Passenger passenger;
	
	//Passenger when LoggedIn Page
	public PassengerGUI(Passenger passenger,JFrame mainMenuFrame) {
		
		//Variables Initialization
		frame= new JFrame();
		this.mainMenuFrame=mainMenuFrame;
		this.passenger=passenger;
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

		
		//Button Listener Creation
		ButtonListener listener= new ButtonListener();
		
		
		//Buttons Creation
		busesProgramButton= new JButton("View buses program");
		fastWayButton = new JButton("Fastest bus to");
		ticketCalculationButton= new JButton("Ticket Calculator");
		ticketShopButton=new JButton("Buy Ticket/Card");
		profileConfigurationSaveButton= new JButton("Save configuration");
		deletionButton=new JButton("Delete profile");
		logoutButton=new JButton("Logout");

		//Adding listener to buttons
		busesProgramButton.addActionListener(listener);
		fastWayButton.addActionListener(listener);
		ticketCalculationButton.addActionListener(listener);
		ticketShopButton.addActionListener(listener);
		profileConfigurationSaveButton.addActionListener(listener); 
		deletionButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		
		//Buttons Coloring
		logoutButton.setBackground(Color.LIGHT_GRAY);
		
		
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
		
		//Setting bounds in sub-panels
		//Sub-panel panelNames
		panelNames.setLayout(null);
		firstnameLabel.setBounds(50,10,100,20);
		lastnameLabel.setBounds(250,10,100,20);
		firstnameField.setBounds(115,10,100,20);
		lastnameField.setBounds(315,10,100,20);
		ageLabel.setBounds(50,50,100,20);
		phoneNumberLabel.setBounds(220,50,100,20);
		ageField.setBounds(115,50,30,20);
		phoneNumberField.setBounds(315,50,100,20);
		
		//Sub-panel panelIdPassword
		panelIdPassword.setLayout(null);
		idLabel.setBounds(50,30,100,20);
		userId.setBounds(130,30,80,20);
		passwordLabel.setBounds(250,30,100,20);
		passwordField.setBounds(315,30,100,20);
		
		//Sub-panel panelButtonsUp
		panelButtonsUp.setLayout(null);
		ticketCalculationButton.setBounds(50,20,150,20);
		fastWayButton.setBounds(280,20,150,20);
		ticketShopButton.setBounds(150,60,150,20);
		
		//Sub-panel panelButtonsDown
		panelButtonsDown.setLayout(null);
		busesProgramButton.setBounds(50,20,150,20);
		deletionButton.setBounds(280,20,150,20);
		profileConfigurationSaveButton.setBounds(150,60,150,20);
		logoutButton.setBounds(380,60,100,20);
		
		
		//Adding sub-panels to panel
		panel.add(panelNames);
		panel.add(panelIdPassword);
		panel.add(panelButtonsUp);
		panel.add(panelButtonsDown);

		//Panel layout
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		//Frame Configuration
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setSize(500,400);
		frame.setTitle("Passenger: "+passenger.getId());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//FastestBus
			if (e.getSource() == fastWayButton) {
				new FastestBus(passenger.getSecretariat().getBusLineList());
			}
			
			//View Bus Program
			else if (e.getSource() == busesProgramButton) {
				ArrayList<BusLine> linesList=passenger.getSecretariat().getBusLineList();
				String text="";
				int i=0;
				
				for(BusLine line: linesList) {
					text+="\n\n"+line.getLineID()+"     ||     ";
						for(double time: line.getTimes()) {
							text+=time+"          ";
					}
				}
				JOptionPane.showMessageDialog(null,text);
			}
			
			//TicketCalculation
			else if (e.getSource() == ticketCalculationButton) {
				new TicketCalculation(passenger);
			}
			
			//Ticket Shop 
			else if (e.getSource() == ticketShopButton) {
				new TicketPurchase(passenger);
			}
			
			//Save Profile Button
			else if (e.getSource() == profileConfigurationSaveButton) {
				
				passenger.setInfo(firstnameField.getText(),lastnameField.getText(),Integer.valueOf(ageField.getText()),phoneNumberField.getText(),passwordField.getText());
				passenger.getSecretariat().setPassenger(passenger);
				
			}
			
			//Deletion Button
			else if (e.getSource() == deletionButton) {
				
				String[] buttons = { "Yes","No"};

			    int rc = JOptionPane.showOptionDialog(null, "Do you want delete account?", "Delete Account",
			        JOptionPane.WARNING_MESSAGE, 1, null, buttons, buttons[1]);

			    if(rc == 0) {
			    	passenger.getSecretariat().deletePassenger(passenger);
			    	passenger.deletion();
			    	frame.dispose();
			    }

			}	
			
			//Logout Button
			else if( e.getSource() == logoutButton) {
				frame.dispose();
				mainMenuFrame.setVisible(true);
			}
			
		}

	}
}
