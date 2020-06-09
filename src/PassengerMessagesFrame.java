
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextArea;

public class PassengerMessagesFrame extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JTextArea printMessagePassengerText;
	private JButton BackButton;
	private Secretariat sec;
	private Passenger passenger;

	public PassengerMessagesFrame(Secretariat sec, Passenger passenger) {

		this.sec = sec;
		this.passenger = passenger;

		mainPanel = new JPanel();
		icon = new ImageIcon("p2.png");
		BackButton = new JButton("Back");
		printMessagePassengerText = new JTextArea(10, 25);

		int id = Integer.parseInt(passenger.getId());
		String[][] messageToPassenger = new String[5][100];
		messageToPassenger = sec.getÌessageListToPassenger();

		// Appear Every Message to Passenger
		for (int y = 0; y < messageToPassenger.length; y++) {
			if (messageToPassenger[id][y] != null) {
				printMessagePassengerText.append("Message: " + messageToPassenger[id][y] + "\n\n\n");
			}
		}

		// ButtonListener
		ButtonListener listener = new ButtonListener();
		BackButton.addActionListener(listener);

		mainPanel.add(printMessagePassengerText);
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

			// Back Button
			if (e.getSource().equals(BackButton)) {
				new PassengerGUI(passenger, sec);
				dispose();
				


		}
	}

	}
}