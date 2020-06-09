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

public class MessagesDriverGUI extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JTextArea printMessageDriverText;
	private JButton BackButton;
	private Secretariat sec;
	private Driver aDriver;

	public MessagesDriverGUI(Secretariat sec, Driver aDriver) {
        //Set
		this.sec = sec;
		this.aDriver = aDriver;

		//Create Button, Panel,Icon.
		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		printMessageDriverText = new JTextArea(10, 25);
		BackButton = new JButton("Back");

		int id = Integer.parseInt(aDriver.getId());
		String[][] messageToDriver = new String[5][100];
		messageToDriver = sec.getMessageListDriver();
		
		for (int y = 0; y < messageToDriver.length; y++) {
			if (messageToDriver[id][y] != null) {
				printMessageDriverText.append("New Message:" + messageToDriver[id][y] + "\n\n\n");

			}
		}

		// ButtonListener for BackButton.
		ButtonListener listener = new ButtonListener();
		BackButton.addActionListener(listener);

		// Scroll for printMessageDriverText.
		printMessageDriverText.setEditable(false);
		JScrollPane scroll = new JScrollPane(printMessageDriverText);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		mainPanel.setBorder(new TitledBorder(new EtchedBorder(), "Messages"));

		// Set in MainPanel the BackButton.
		mainPanel.add(scroll);
		mainPanel.add(BackButton);

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setTitle("My Messages");
		this.setSize(350, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// BackButton Function.
			if (e.getSource().equals(BackButton)) {
				dispose();
				new DriverGUI(aDriver, sec);

			}

		}
	}
}
