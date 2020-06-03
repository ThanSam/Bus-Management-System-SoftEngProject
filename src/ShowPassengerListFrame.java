
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class ShowPassengerListFrame extends JFrame {
	
	private ImageIcon icon;
	private JTextArea printArea =new JTextArea();
	private JPanel mainPanel = new JPanel();
	private JButton backButton = new JButton("Back");
	private JLabel title;	
    private Secretariat sec;
	
	
	public ShowPassengerListFrame(Secretariat sec ) {
        this.sec = sec;
		icon = new ImageIcon("p2.png");
		title = new JLabel("All Passengers's ID");
		printArea = new JTextArea(7, 7);
		
		
		for(Passenger p: sec.getPassengerList()) {
			printArea.append("ID:"+p.getId()+"\n");
			printArea.append("First Name: "+p.getFirstName()+"\n");
			printArea.append("Last Name: "+p.getLastName()+"\n");
			printArea.append("PhoneNumber: "+p.getPhoneNumber()+"\n");
			printArea.append("Age: "+p.getAge()+"\n");
			printArea.append("Password: "+p.getPassword()+"\n");
		}
		
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		
		printArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainPanel.setLayout(null);
		
		title.setBounds(35, 0, 180, 25);
		scroll.setBounds(20, 50, 300, 270);
		backButton.setBounds(120, 320, 80,25);
		
		mainPanel.add(title);
		mainPanel.add(scroll);
		mainPanel.add(backButton);
	
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 400);
		this.setTitle("Passengers");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(backButton)) {
				new MainSecretariatFrame(sec);
				dispose();
			
			}
		
	}
	}
}