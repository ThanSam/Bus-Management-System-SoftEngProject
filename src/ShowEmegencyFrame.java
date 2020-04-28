import java.awt.CheckboxGroup;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ShowEmegencyFrame extends JFrame{
	
	private ImageIcon icon;
	private JLabel img;
	
	private JTextArea printArea;
	private JTextArea printArea1;
	private ArrayList<Driver> emergencyList = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers = new ArrayList<Driver>();
	private JLabel EmergenciesLabel;
	private JLabel freeDriversLabel;
    private JPanel driversWhoPushButtonPanel;
    private JPanel driversFreePanel;
    private JButton sendDriverButton;
    private JButton BackButton;
    private JPanel mainPanel;
    private Secretariat secretariat;
    
	public ShowEmegencyFrame(Secretariat secretariat) {
		
		icon = new ImageIcon("p2.png");
		img = new JLabel(new ImageIcon("p8.png"));	
		this.secretariat=secretariat;
		
		EmergenciesLabel = new JLabel("Emergencies");
		freeDriversLabel = new JLabel("Free Drivers");
		driversWhoPushButtonPanel = new JPanel();
		driversFreePanel = new JPanel();
		sendDriverButton = new JButton("Send Driver!");
		BackButton = new JButton("Back");
		sendDriverButton.setForeground(Color.red);
		mainPanel = new JPanel();

		
		Driver d1 = new Driver("John", "Lampis", "22", "6981144627" , "JohnL", "mypass", secretariat);
		Driver d2 = new Driver("Kostas", "Kampos", "40", "6941144625" , "KostasKam", "mypass2", secretariat);
		Driver d3 = new Driver("George", "Dimitriou", "34", "6981145625" , "GeorgeDim", "mypass3", secretariat);
		Driver d4 = new Driver("Nick", "Delis", "25", "6973444625" , "NickDel", "mypass6", secretariat);
		Driver d5 = new Driver("Jim", "Papadopoulos", "27", "6981156789" , "JimPap", "mypass5", secretariat);
		Driver d6 = new Driver("Antonios", "Konstantinidis", "27", "6981156789" , "AntonisKon", "mypass5", secretariat);
		
		freeDrivers.add(d1);
		freeDrivers.add(d3);
		freeDrivers.add(d4);
		freeDrivers.add(d5);
	
		
		//ArrayList<JCheckBox> CheckBoxesD = new ArrayList<JCheckBox>(); 
		ArrayList<JCheckBox> CheckBoxesFD = new ArrayList<JCheckBox>();
		
	
		JCheckBox D = new JCheckBox("Route: 2K 11:40 Stop:Aristotelous Square"+"  Driver: " + d2.getId());
		JCheckBox D2 = new JCheckBox("Route: 14 11:55 Stop:Kamara"+"  Driver: " + d6.getId());
		
		driversWhoPushButtonPanel.setLayout(new BoxLayout(driversWhoPushButtonPanel, BoxLayout.Y_AXIS));
		
		driversWhoPushButtonPanel.add(D);
		driversWhoPushButtonPanel.add(D2);
		
		
		
		
		for(Driver fd:freeDrivers) {
			
			JCheckBox freeD = new JCheckBox(fd.getFirstname()+" "+ fd.getLastname());
			CheckBoxesFD.add(freeD);
		}
		
		driversFreePanel.setLayout(new BoxLayout(driversFreePanel, BoxLayout.Y_AXIS));
		
		for(JCheckBox freeD: CheckBoxesFD) {
			
			driversFreePanel.add(freeD);
		}
		

		
		JScrollPane scroll = new JScrollPane(driversWhoPushButtonPanel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setSize(30, 100);
		
		JScrollPane scroll2 = new JScrollPane(driversFreePanel);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setSize(30, 100);
		
		mainPanel.setLayout(null);
		img.setBounds(180,0,220,200);
		EmergenciesLabel.setBounds(150, 225, 100, 25);
		freeDriversLabel.setBounds(460, 225, 100, 25);
		scroll.setBounds(0, 250, 400, 140);
		scroll2.setBounds(405, 250, 165, 100);
		sendDriverButton.setBounds(220, 420, 150, 25);
		BackButton.setBounds(475, 430, 80, 25);
		
		mainPanel.add(img);
		mainPanel.add(EmergenciesLabel);
		mainPanel.add(freeDriversLabel);
		mainPanel.add(scroll);
		mainPanel.add(scroll2);
		mainPanel.add(sendDriverButton);
		mainPanel.add(BackButton);
		
	

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(590, 500);
		this.setTitle("Emergencies");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		}
		

}
