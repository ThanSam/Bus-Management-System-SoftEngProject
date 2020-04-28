import java.awt.Color;

import javax.swing.BorderFactory;
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
	private JTextArea  printMessageDriverText;
	private Secretariat aSecretariat;

	
	
	public MessagesDriverGUI(Secretariat aSecretariat,Driver aDriver) {
		mainPanel = new JPanel();
		this.aSecretariat=aSecretariat;
		printMessageDriverText = new JTextArea(10,25);
	     
		int id = Integer.parseInt(aDriver.getId());
		String[][] messageDriverList = new String[5][7];
		int  y = 0;
		messageDriverList = aSecretariat.getMessageListDriver();
			for (y = 0; y < 5; y++) {
				if (messageDriverList[id][y] != null) {
					printMessageDriverText.append(messageDriverList[id][y]+"\n");
					
			}
		}
		
			printMessageDriverText.setEditable(false); // set textArea non-editable
			JScrollPane scroll = new JScrollPane(printMessageDriverText);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			mainPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			mainPanel.setBorder(new TitledBorder(new EtchedBorder(), "All Messages"));
			mainPanel.add(scroll);
		
		
		
	
		this.setContentPane(mainPanel);
		this.setTitle("");
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
