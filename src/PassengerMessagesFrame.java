import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PassengerMessagesFrame extends JFrame{

	private JPanel mainPanel;
	private ImageIcon icon;
	private JTextArea  printMessagePassengerText;
	private JButton BackButton;
    private Secretariat sec;
    private Passenger passenger;
 
	
	public PassengerMessagesFrame(Secretariat sec,Passenger passenger) {
		this.sec=sec;
		this.passenger=passenger;
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		BackButton = new JButton("Back");
		
		
		ButtonListener listener = new ButtonListener();
		BackButton.addActionListener(listener);
		
		printMessagePassengerText = new JTextArea(10,25);
	     
		int id = Integer.parseInt(passenger.getId());
		String[][] messageToPassenger = new String[5][7];
		int  y = 0;
		sec.messageListToDriver(id,"Emergency Route!\nBus Route 2K at 12:00!");
		messageToPassenger = sec.getÌessageListToPassenger();
			for (y = 0; y < 5; y++) {
				if (messageToPassenger[id][y] != null) {

					printMessagePassengerText.append();
					
			}
		}
			
		
		

			printMessagePassengerText.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printMessagePassengerText);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		mainPanel.setBorder(new TitledBorder(new EtchedBorder(), "Messages"));
			
		mainPanel.add(scroll);
		mainPanel.add(BackButton);
		
		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setTitle("My Messages");
		this.setSize(350, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		}
	
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource().equals(BackButton)) {
					 dispose();
				    
					
				}
	  
			}
		}
}
