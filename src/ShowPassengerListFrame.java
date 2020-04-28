
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
	private JLabel IdUsernameLabel;

	
	
	public ShowPassengerListFrame(Secretariat s1) {

		icon = new ImageIcon("p2.png");
		title = new JLabel("All Passengers's ID");
		IdUsernameLabel = new JLabel("ID");
		printArea = new JTextArea(7, 7);
		
		
		for(Passenger p: s1.getPassengerList()) 
			printArea.append(p.getId()+"\n");
		
		
		
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		
		printArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainPanel.setLayout(null);
		
		title.setBounds(35, 0, 220, 25);
		IdUsernameLabel.setBounds(40, 30, 170, 25);
		scroll.setBounds(40, 50, 100, 170);
		backButton.setBounds(150, 230, 80,25);
		
		mainPanel.add(title);
		mainPanel.add(IdUsernameLabel);
		mainPanel.add(scroll);
		mainPanel.add(backButton);
	
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(250, 300);
		this.setTitle("Passengers");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(backButton)) {
			dispose();
			
			}
		
	}
	}
}