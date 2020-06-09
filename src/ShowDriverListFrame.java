import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ShowDriverListFrame extends JFrame {
	
	private ImageIcon icon;
	private JPanel mainPanel = new JPanel();
	private ArrayList<String> id_Username_UsercodeList = new ArrayList<String>();
	private JButton backButton;
	private JTextArea printArea;
	private JLabel title;
	private Secretariat sec;

	public ShowDriverListFrame(Secretariat sec) {
      this.sec=sec;
      
    //Create panels, Labels, JTextField, Buttons.
		icon = new ImageIcon("p2.png");
		title = new JLabel("All Drivers's Information");
		printArea= new JTextArea(7, 7);
		backButton = new JButton("Back");
		
		
		for(Driver d:sec.getDriverList()) {
			
			String id = d.getId();
			String firstName = d.getFirstname();
			String lastName = d.getLastname();
			String age = d.getAge();
			String phone = d.getPhoneNumber();
			String password = d.getPassword();
			printArea.append("ID: "+id+"\n");
			printArea.append("FirstName: " + firstName);
			printArea.append("\nLastName: " + lastName);
			printArea.append("\nPhoneNumber: " + phone);
			printArea.append("\nAge: " + age);
			printArea.append("\nPassword: " + password);
			printArea.append("\n\n\n");
		}
	
		//ButtonListener for all Buttons.
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		
		printArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(printArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Set Size...
		mainPanel.setLayout(null);
		title.setBounds(35, 0, 180, 25);
		scroll.setBounds(20, 50, 300, 270);
		backButton.setBounds(120, 320, 80,25);
		
		//Add in mainPanel other components.
		mainPanel.add(title);
		mainPanel.add(scroll);
	    mainPanel.add(backButton);
	    
	    this.setIconImage(icon.getImage());
		this.setContentPane(mainPanel);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 400);
		this.setTitle("Drivers");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//backButton Function.
			if(e.getSource().equals(backButton)) {
				new MainSecretariatFrame(sec);
				dispose();
			}
		
		}
	}
}


