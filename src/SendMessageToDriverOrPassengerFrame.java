import java.awt.Checkbox; 
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SendMessageToDriverOrPassengerFrame extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JPanel passengersPanel;
	private JPanel passengerSpecificPanel;
	private JPanel driversPanel;
	private JPanel driverSpecificPanel;
	private JPanel checkBoxDriverPanel;
	private JPanel checkBoxPassengerPanel;
	private JButton sendMessageToSpecificDriverButton;
	private JButton sendMessageToPassengersButton;
	private JButton sendMessageToSpecificPassengerButton;
	private JButton sendMessageToAllDriversButton;
	private JTextField passengerMessageText;
	private JTextField driverIdText;
	private JTextField driverMessageText;
	private JTextField passengerIDText;
	private JLabel messageToPassenger;
	private JLabel passengerIdLabel;
	private JLabel messageToDriver;
	private JLabel driverIdLabel;
	private Secretariat sec;
	private Checkbox checkBox2;
	private Checkbox checkBox1;
	private Checkbox checkBox4;
	private Checkbox checkBox3;
	private JLabel label;
	private JButton backButton;

	public SendMessageToDriverOrPassengerFrame(Secretariat sec) {
		this.sec = sec;
		
		backButton= new JButton("Back");
		passengersPanel = new JPanel();
		driversPanel = new JPanel();
		driverSpecificPanel = new JPanel();
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		checkBoxDriverPanel = new JPanel();
		checkBoxPassengerPanel = new JPanel();
	 passengerSpecificPanel = new JPanel();
		sendMessageToSpecificDriverButton = new JButton("Send Message");
		sendMessageToAllDriversButton= new JButton("Send Message");
		sendMessageToPassengersButton = new JButton("Send Message");
		sendMessageToSpecificPassengerButton = new JButton("Send Message");
		driverIdLabel = new JLabel("Driver's ID");
		passengerIdLabel = new JLabel("Passenger's ID");
		messageToPassenger = new JLabel("Message:");
		driverIdText = new JTextField(5);
		passengerIDText = new JTextField(5);
		driverMessageText = new JTextField(10);
		messageToDriver = new JLabel("Message:");
		passengerMessageText = new JTextField(10);

		ButtonListener b1 = new ButtonListener();
		sendMessageToSpecificDriverButton.addActionListener(b1);
		sendMessageToAllDriversButton.addActionListener(b1);
		backButton.addActionListener(b1);

		
		CheckboxGroup cbg = new CheckboxGroup();
		checkBox1 = new Checkbox("All Drivers", cbg, false);
		checkBox1.setBounds(100, 100, 50, 50);
		checkBox2 = new Checkbox("Specific Driver", cbg, false);
		checkBox2.setBounds(100, 150, 50, 50);
		checkBox3 = new Checkbox("All Passengers", cbg, false);
		checkBox3.setBounds(100, 100, 50, 50);
		checkBox4 = new Checkbox("Specific Passenger", cbg, false);
		checkBox4.setBounds(100, 150, 50, 50);
		
		checkBoxPassengerPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		checkBoxPassengerPanel.setBorder(new TitledBorder(new EtchedBorder(), " Check All Or Specific Passenger"));
		checkBoxPassengerPanel.add(checkBox3);
		checkBoxPassengerPanel.add(checkBox4);
		
		checkBoxDriverPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		checkBoxDriverPanel.setBorder(new TitledBorder(new EtchedBorder(), " Check All Or Specific Driver"));
		checkBoxDriverPanel.add(checkBox1);
		checkBoxDriverPanel.add(checkBox2);
		
		
		checkBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				passengerSpecificPanel.setVisible(false);
				passengersPanel.setVisible(true);
				passengersPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
				passengersPanel.setBorder(new TitledBorder(new EtchedBorder(), " Send Message To All Passengers Area"));
				passengersPanel.add(messageToPassenger);
				passengersPanel.add(passengerMessageText);
				passengersPanel.add(sendMessageToPassengersButton);


			}
		});
		checkBox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				passengersPanel.setVisible(false);
				passengerSpecificPanel.setVisible(true);
				passengerSpecificPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
				passengerSpecificPanel.setBorder(new TitledBorder(new EtchedBorder(), " Send Message To Specific Passenger Area"));
				passengerSpecificPanel.add(passengerIdLabel);
				passengerSpecificPanel.add(passengerIDText);
				passengerSpecificPanel.add(messageToPassenger);
				passengerSpecificPanel.add(passengerMessageText);
				passengerSpecificPanel.add(sendMessageToSpecificPassengerButton);

			}
		});

		checkBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				driverSpecificPanel.setVisible(false);
				driversPanel.setVisible(true);
				driversPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
				driversPanel.setBorder(new TitledBorder(new EtchedBorder(), " Send message to all drivers area"));
				driversPanel.add(messageToDriver);
				driversPanel.add(driverMessageText);
				driversPanel.add(sendMessageToAllDriversButton);

			}
		});
		checkBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent t) {
				driversPanel.setVisible(false);
				driverSpecificPanel.setVisible(true);
				driverSpecificPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
				driverSpecificPanel.setBorder(new TitledBorder(new EtchedBorder(), " Send message to the specific driver area"));
				driverSpecificPanel.add(driverIdLabel);
				driverSpecificPanel.add(driverIdText);
				driverSpecificPanel.add(messageToDriver);
				driverSpecificPanel.add(driverMessageText);
				driverSpecificPanel.add(sendMessageToSpecificDriverButton);
				}
			
		});

	

		mainPanel.add(checkBoxPassengerPanel);
		mainPanel.add(checkBoxDriverPanel);
		mainPanel.add(passengersPanel);
		mainPanel.add(passengerSpecificPanel);
		mainPanel.add(driversPanel);
		mainPanel.add(driverSpecificPanel);
		mainPanel.add(backButton);

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(true);
		this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("Send Message To Driver/Passenger");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(sendMessageToSpecificDriverButton)) {
				int id = 0;
				String message = "";
				id = Integer.parseInt(driverIdText.getText());
				message = (driverMessageText.getText());
				sec.messageListToDriver(id, message);

			}

			if (e.getSource().equals(sendMessageToAllDriversButton)) {
				int id = 0;
				String message = "";
				message = (driverMessageText.getText());
		       sec.messageListToAllDrivers(message);

			}

			if (e.getSource().equals(sendMessageToPassengersButton)) {
				String message = "";
				message = (passengerMessageText.getText());
			}
			if (e.getSource().equals(sendMessageToSpecificPassengerButton)) {
				String message = "";
				message = (passengerMessageText.getText());
			}
		
			if(e.getSource().equals(backButton)) {
				new MainSecretariatFrame(sec);
				dispose();

			}
		}
	}

}
