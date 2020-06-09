import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

	private JPanel mainPanel;
	private ImageIcon icon;
	private JLabel image;
	private JLabel message;
	private JButton PassengerButton;
	private JButton DriverButton;
	private JButton SecretaryButton;
	private Secretariat sec;
	private Driver driver;

	public MainFrame(Secretariat sec) {

		this.sec = sec;
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		icon = new ImageIcon("p2.png");
		image = new JLabel(new ImageIcon("p1.png"));
		message = new JLabel("Login as:");
		message.setFont(new Font("Login as:", Font.BOLD, 20));
		PassengerButton = new JButton("Passenger");
		PassengerButton.setFont(new Font("Passenger", Font.PLAIN, 18));
		DriverButton = new JButton("Driver");
		DriverButton.setFont(new Font("Driver", Font.PLAIN, 18));
		SecretaryButton = new JButton("Secretary");
		SecretaryButton.setFont(new Font("Secretary", Font.PLAIN, 18));

		image.setBounds(50, 0, 300, 300);
		message.setBounds(170, 250, 150, 150);
		PassengerButton.setBounds(100, 350, 200, 80);
		DriverButton.setBounds(100, 450, 200, 80);
		SecretaryButton.setBounds(100, 550, 200, 80);

		mainPanel.add(image);
		mainPanel.add(message);
		mainPanel.add(PassengerButton);
		mainPanel.add(DriverButton);
		mainPanel.add(SecretaryButton);

		ButtonListener listener1 = new ButtonListener();
		PassengerButton.addActionListener(listener1);

		DriverButton.addActionListener(listener1);

		SecretaryButton.addActionListener(listener1);

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setTitle("Bus Management System");
		this.setSize(430, 700);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == PassengerButton) {

				PassengerLoginFrame passengerLoginFrame = new PassengerLoginFrame(sec);
				dispose();

			} else if (e.getSource() == DriverButton) {
				DriverLoginFrame driverFrame = new DriverLoginFrame(sec, driver);
				dispose();
			} else if (e.getSource() == SecretaryButton) {

				SecretaryLoginFrame SecretaryLoginFrame = new SecretaryLoginFrame(sec);
				dispose();

			}

		}
	}
}
