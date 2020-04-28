import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainSecretariatFrame extends JFrame {
	
	private JPanel mainPanel;
	private JPanel LogOutPanel;
	private ImageIcon icon;
	private JLabel img;
	private JButton createDeleteDriverButton;
	private JButton showDriverIdListButton;
	private JButton showPassengerListButton;
	private JButton driverProgramButton;
	private JButton sendMessageToDriverOrPassengerButton;
	private JButton showEmergencyButton;
	private JButton LogOutButton;
	private Secretariat secretariat;
	 private JFrame mainMenuFrame;

	public MainSecretariatFrame(Secretariat aSecretariat, JFrame mainMenuFrame) {
		this.mainMenuFrame=mainMenuFrame;
		this.secretariat=aSecretariat;
		
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		img = new JLabel(new ImageIcon("p6.png"));
		
		createDeleteDriverButton = new JButton("Create/Delete Driver");
		driverProgramButton = new JButton("Driver's Schedule");
		showDriverIdListButton = new JButton(" Show Drivers List ");
		sendMessageToDriverOrPassengerButton = new JButton("Send Message To Driver Or Passenger");
		showPassengerListButton = new JButton(" Show Passengers List ");
		showEmergencyButton = new JButton("Show Emergency");
		showEmergencyButton.setForeground(Color.RED);
		LogOutButton = new JButton("Logout");
		LogOutButton.setBackground(Color.LIGHT_GRAY);

		ButtonListener b1 = new ButtonListener();
		createDeleteDriverButton.addActionListener(b1);
		showDriverIdListButton.addActionListener(b1);
		driverProgramButton.addActionListener(b1);
		sendMessageToDriverOrPassengerButton.addActionListener(b1);
		showPassengerListButton.addActionListener(b1);
		showEmergencyButton.addActionListener(b1);
		LogOutButton.addActionListener(b1);
		
		mainPanel.setLayout(null);
		img.setBounds(35, 0, 260, 260);
		createDeleteDriverButton.setBounds(20, 280, 150, 25);
		showDriverIdListButton.setBounds(185, 280, 150, 25);
		showPassengerListButton.setBounds(90, 320, 170, 25);
		driverProgramButton.setBounds(20, 360, 150, 25);
		showEmergencyButton.setBounds(185, 360, 150, 25);
		sendMessageToDriverOrPassngerButton.setBounds(50, 400, 255, 25);
		LogOutButton.setBounds(255, 455, 100, 25);
		
		mainPanel.add(img);
		mainPanel.add(createDeleteDriverButton);
		mainPanel.add(showDriverIdListButton);
		mainPanel.add(showPassengerListButton);
		mainPanel.add(driverProgramButton);
		mainPanel.add(showEmergencyButton);
		mainPanel.add(sendMessageToDriverOrPassngerButton);
		mainPanel.add(LogOutButton);
	
		
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setSize(380, 525);
		this.setResizable(false);
		this.setTitle("Secretary Page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void setSecreatariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == createDeleteDriverButton) {
				CreateDeleteDriverFrame createDeleteDriver = new CreateDeleteDriverFrame();
				createDeleteDriver.setVisible(true);
				createDeleteDriver.setSecreatariat(secretariat);
			}
			if (e.getSource() == showDriverIdListButton) {
				ShowDriverListFrame showDriverListFrame = new ShowDriverListFrame(secretariat);
				showDriverListFrame.setVisible(true);

			}
			if (e.getSource() == driverProgramButton) {
				DriverProgramFrame driverProgramFrame = new DriverProgramFrame(secretariat);
				driverProgramFrame.setSecreatariat(secretariat);
			}

		
			if (e.getSource() == sendMessageToDriverOrPassengerButton) {
				SendMessageToDriverOrPassengerFrame sendMessageToDriverOrPassngerFrame = new SendMessageToDriverOrPassngerFrame(secretariat);

			}
			if (e.getSource() == showPassengerListButton) {
				ShowPassengerListFrame showPassengerListFrame = new ShowPassengerListFrame(secretariat);

			}
			if (e.getSource() == showEmergencyButton) {
				ShowEmegencyFrame showPassengerListFrame = new ShowEmegencyFrame(secretariat);
				    
			}
			if(e.getSource() == LogOutButton) {
				dispose();
				mainMenuFrame.setVisible(true);
			}
			
		}

	}
}
