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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class MessagesDriverGUI extends JFrame{
	
	private JPanel mainPanel;
	private ImageIcon icon;
	private JTextArea  printMessageDriverText;
	private JButton BackButton;
private Secretariat sec;
private Driver aDriver;
	
	public MessagesDriverGUI(Secretariat sec,Driver aDriver) {
		this.sec=sec;
		this.aDriver=aDriver;
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		BackButton = new JButton("Back");
		
		
		ButtonListener listener = new ButtonListener();
		BackButton.addActionListener(listener);
		
		printMessageDriverText = new JTextArea(10,25);
	     
		int id = Integer.parseInt(aDriver.getId());
		String[][] messageDriverList = new String[5][7];
		int  y = 0;
		sec.messageListToDriver(id,"Emergency Route!\nBus Route 2K at 12:00!");
		messageDriverList = sec.getMessageListDriver();
			for (y = 0; y < 5; y++) {
				if (messageDriverList[id][y] != null) {
					printMessageDriverText.append("New Message, Time:11:00\n" + messageDriverList[id][y]+"\n");
					
			}
		}
			
		
		
		printMessageDriverText.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printMessageDriverText);
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
				      new DriverGUI(aDriver,sec);
					
				}
	  
			}
		}
}
