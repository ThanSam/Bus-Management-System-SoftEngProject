import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankSystem extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JButton cancelButton,verificationButton;
	private JTextField numberField,nameField,threeDigitField;
	private JLabel numberLabel,nameLabel,threeDigitLabel;
	
	public BankSystem(double cost) {
		
		frame=new JFrame();
		panel=new JPanel();
		
		numberLabel=new JLabel("Enter Card's Number:");
		nameLabel=new JLabel("Enter Card's Owner Name:");
		threeDigitLabel=new JLabel("Enter the 3-Digit Code:");
		
		
		numberField= new JTextField("Enter card number.");
		nameField=new JTextField("Enter name.");
		threeDigitField= new JTextField("Enter code.");
		
		
		cancelButton=new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
	
		
		verificationButton=new JButton("Verify");
		verificationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		
		//Adding in panel
		panel.add(verificationButton);
		panel.add(cancelButton);
		panel.add(numberField);
		panel.add(nameField);
		panel.add(threeDigitField);
		panel.add(numberLabel);
		panel.add(nameLabel);
		panel.add(threeDigitLabel);
		
		//Setting bounds
		panel.setLayout(null);
		verificationButton.setBounds(30,320,100,20);
		cancelButton.setBounds(250,320,100,20);

		numberLabel.setBounds(110,20,150,20);
		nameLabel.setBounds(100,110,150,20);
		threeDigitLabel.setBounds(100,200,150,20);

		numberField.setBounds(70,40,200,20);
		nameField.setBounds(70,130,200,20);
		threeDigitField.setBounds(137,220,50,20);

		
		//Frame settings
		frame.add(panel);
		frame.setSize(400,400);
		frame.setTitle("Payment completion");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	

}
