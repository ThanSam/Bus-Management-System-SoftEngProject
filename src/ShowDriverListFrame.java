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
	private JPanel printPanel = new JPanel();
	private ArrayList<String> id_Username_UsercodeList = new ArrayList<String>();
	private JButton backButton = new JButton("Back");
	private JTextArea printArea;
	private JLabel title;
	private JLabel IdUsernameLabel;


	public ShowDriverListFrame(Secretariat secretariat) {

		icon = new ImageIcon("p2.png");
		title = new JLabel("All Drivers's ID");
		IdUsernameLabel = new JLabel("ID");
		printArea= new JTextArea(7, 7);
	
		
		
		for(Driver d:secretariat.getDriverList()) {
			
			String id = d.getId();
			
			printArea.append(id/*"                   "+userCode*/+"\n");
		}
	
		
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		
		printArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		printPanel.setLayout(null);
		title.setBounds(35, 0, 180, 25);
		IdUsernameLabel.setBounds(40, 30, 170, 25);
		scroll.setBounds(40, 50, 100, 170);
		backButton.setBounds(150, 230, 80,25);
		
		printPanel.add(title);
		printPanel.add(IdUsernameLabel);
		printPanel.add(scroll);
	    printPanel.add(backButton);
	    
	    this.setIconImage(icon.getImage());
		this.setContentPane(printPanel);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(250, 300);
		this.setTitle("Drivers");
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


