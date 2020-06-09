import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



public class ShowEmegencyFrame extends JFrame {

	private ImageIcon icon;
	private ImageIcon refreshIcon;
	private Image refreshImg;
	private Image refreshImg2;
	private JLabel img;
	private ArrayList<Driver> emergencyList = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers = new ArrayList<Driver>();
	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	private JLabel emergenciesLabel;
	private JLabel freeDriversLabel;
	private JPanel driversWhoPushButtonPanel;
	private JPanel driversFreePanel;
	private JButton sendDriverButton;
	private JButton backButton;
	private JButton refreshButton;
	private JPanel mainPanel;
	private Secretariat sec;
	private CheckboxGroup freeDriversBox = new CheckboxGroup();
	private CheckboxGroup emergencyDriversBox = new CheckboxGroup();
	private String[][] driverline = new String[10][7];
	private Checkbox checkBox1;
	private Checkbox checkBox2;
    private JScrollPane scroll2;
    private JScrollPane scroll;
    
    
	public ShowEmegencyFrame(Secretariat sec) {
        this.sec=sec;
        
        
        //Create panels, Labels, JTextField, Buttons.
		icon = new ImageIcon("p2.png");
		refreshIcon = new ImageIcon("p9.png");
		refreshImg = refreshIcon.getImage();
		refreshImg2 = refreshImg.getScaledInstance( 35, 35,  java.awt.Image.SCALE_SMOOTH );
		refreshIcon = new ImageIcon(refreshImg2);
		refreshButton= new JButton();
		refreshButton.setIcon(refreshIcon);
		img = new JLabel(new ImageIcon("p8.png"));
		emergenciesLabel = new JLabel("Emergencies");
		freeDriversLabel = new JLabel("Free Drivers");
		driversWhoPushButtonPanel = new JPanel();
		driversFreePanel = new JPanel();
		sendDriverButton = new JButton("Send Driver!");
		backButton = new JButton("Back");
		sendDriverButton.setForeground(Color.red);
		mainPanel = new JPanel();

		driversWhoPushButtonPanel.setLayout(new BoxLayout(driversWhoPushButtonPanel, BoxLayout.Y_AXIS));

		emergencyList = sec.getEmergencyList();
		for (Driver eD : emergencyList) {
			checkBox2 = new Checkbox(eD.getId() + " " + eD.getFirstname() + " " + eD.getLastname() + " "
					+ eD.getPhoneNumber() + " " + eD.getLineid(), emergencyDriversBox, false);
			driversWhoPushButtonPanel.add(checkBox2);
			
		}

		freeDrivers = sec.getFreeDriversList();
		for (Driver fD : freeDrivers) {
			checkBox1 = new Checkbox(
					fD.getId() + " " + fD.getFirstname() + " " + fD.getLastname() + " " + fD.getPhoneNumber(),
					freeDriversBox, false);
			driversFreePanel.add(checkBox1);

		}

		driversFreePanel.setLayout(new BoxLayout(driversFreePanel, BoxLayout.Y_AXIS));

		JScrollPane scroll = new JScrollPane(driversWhoPushButtonPanel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setSize(30, 100);

		 scroll2 = new JScrollPane(driversFreePanel);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setSize(30, 100);

		
		//ButtonListener for all Buttons.
		ButtonListener b1 = new ButtonListener();
		sendDriverButton.addActionListener(b1);
		refreshButton.addActionListener(b1);
		backButton.addActionListener(b1);
		
		
		//Set Size...
		mainPanel.setLayout(null);
		img.setBounds(180, 0, 375, 200);
		emergenciesLabel.setBounds(150, 225, 100, 25);
		freeDriversLabel.setBounds(460, 225, 100, 25);
		scroll.setBounds(15, 250, 400, 140);
		scroll2.setBounds(425, 250, 300, 140);
		sendDriverButton.setBounds(220, 440, 150, 25);
		refreshButton.setBounds(402, 400, 35, 35);
		backButton.setBounds(475, 450, 80, 25);

		
		
		//Add in mainPanel other components.
		mainPanel.add(img);
		mainPanel.add(emergenciesLabel);
		mainPanel.add(freeDriversLabel);
		mainPanel.add(scroll);
		mainPanel.add(scroll2);
		mainPanel.add(sendDriverButton);
		mainPanel.add(refreshButton);
		mainPanel.add(backButton);

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(750, 550);
		this.setTitle("Emergencies");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String driverLineID = null;
			
			//sendDriverButton Function.
			if (e.getSource().equals(sendDriverButton)) {
			if(emergencyList.isEmpty()||freeDrivers.isEmpty()) {
				JOptionPane.showMessageDialog(mainPanel, "You can not matche the drivers");

			}
			else {
				 String[] buttons = { "Yes","No"};

				    int rc = JOptionPane.showOptionDialog(null, "Are you sure","",
				        JOptionPane.WARNING_MESSAGE, 1, null, buttons, buttons[1]);

				    if(rc == 0) {
				    	String[] freeparts = freeDriversBox.getSelectedCheckbox().getLabel().split(" ");
				    	String[] emergencyparts = emergencyDriversBox.getSelectedCheckbox().getLabel().split(" ");
				    	
				    	driverList=sec.getDriverList();
				    	for(Driver driver:driverList) {
				    		if(driver.getId().equals(emergencyparts[0])) {
				    			int id = Integer.parseInt(driver.getId());
				       sec.deleteProgramDriver(id, sec.getEmergencyTime());
				    		driverLineID=driver.getLineid();
				    			emergencyList.remove(driver);}
				    		if(driver.getId().equals(freeparts[0])) {
				    			int id = Integer.parseInt(driver.getId());
				    			sec.addProgramDriverBusLine(id,  sec.getEmergencyTime(), driverLineID);
				    			freeDrivers.remove(driver);
				    		}
				    		  
				    	}
				    }
			}
			}
			//refreshButton Function.
			else if (e.getSource().equals(refreshButton)) {
				dispose();
				new ShowEmegencyFrame(sec);
				
			}
			//backButton Function.
		if (e.getSource().equals(backButton)) {
			new MainSecretariatFrame(sec);
			dispose();
		}
		}
	}
}