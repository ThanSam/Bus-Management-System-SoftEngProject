import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TicketPurchase extends JFrame{
	
	
	private double cost; 
	
	//GUI variables
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel;
	private JButton returnButton,buyButton;
	private JList stopsList,cardsList;
	private JLabel stopsLabel,costLabel;
	private JTextField costField;
	
	public TicketPurchase(Passenger passenger) {
		
		cost=0.0;
		frame= new JFrame();
		icon= new ImageIcon("p2.png");
		panel= new JPanel();
		
		//Panel's elements
		stopsLabel= new JLabel("How many stops does your trip include?");
		costField= new JTextField("0.0");
		costLabel= new JLabel("The total cost is: ");
		
		//JList creation
		DefaultListModel defaultList= new DefaultListModel();
		for(int i=1; i<=10; i++) {
			defaultList.addElement("  "+i+"  ");
		}
		
		stopsList=new JList(defaultList);
		stopsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		stopsList.setVisibleRowCount(1);
		
		//JList creation
		DefaultListModel defaultList1= new DefaultListModel();
		defaultList1.addElement("Weekly Card                   ");			
		defaultList1.addElement("                   Monthly Card");
		cardsList=new JList(defaultList1);
		cardsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		cardsList.setVisibleRowCount(1);
		
		
		
		//Return button
		returnButton=new JButton("Back");
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		
		//MouseListener stopsList
		MouseListener mouseListener= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        stopsList=(JList) mouseEvent.getSource();
		        int stops=0;  
		        stops = stopsList.locationToIndex(mouseEvent.getPoint());
		        if (stops >= 0) {
		            Object o = stopsList.getModel().getElementAt(stops);
		            cost=Double.valueOf(o.toString())*0.2;
					if(passenger.getAge()<=24 && passenger.getAge()>=18) {
						cost=cost/2;
					}
		            costField.setText(String.format("%.2f", cost));
		          }
		      }
		};
		stopsList.addMouseListener(mouseListener);
		
		
		//MouseListener cardsList
		MouseListener mouseListener1= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				cardsList=(JList) mouseEvent.getSource();
		        int card=0;  
		        card = cardsList.locationToIndex(mouseEvent.getPoint());
		        if (card>=0) {
		        	Object o = cardsList.getModel().getElementAt(card);
		        	System.out.println(o.toString());
		            if((o.toString()).equals("Weekly Card                   ")) cost=14;
		            else cost=64;
		            costField.setText(String.format("%.2f", cost));
		        }
		    }
		};
		cardsList.addMouseListener(mouseListener1);
		
		//PurchaseButton
		buyButton=new JButton("Purchase");
		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cost<=0) JOptionPane.showMessageDialog(null,"FAILED. Please choose the number of stops.");
				else { 
					//if(cost==14) new oneWeekCard(...);
					//else if(cost==64) new oneMonthCard(...);
					//else new smartTicket(...);
					new BankSystem(cost);}	
			}
			
		});
		
		
		//Adding to panel
		panel.add(buyButton);
		panel.add(returnButton);
		panel.add(stopsList);
		panel.add(stopsLabel);
		panel.add(costLabel);
		panel.add(costField);
		panel.add(cardsList);
		
		//Setting bounds
		panel.setLayout(null);
		returnButton.setBounds(250,300,100,20);
		buyButton.setBounds(50,300,100,20);
		stopsList.setBounds(50,120,280,30);
		stopsLabel.setBounds(75,80,280,20);
		costLabel.setBounds(50,200,150,20);
		costField.setBounds(150,200,40,20);
		cardsList.setBounds(50,160,280,30);
		
		//Setting Frame
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setSize(400,400);
		frame.setTitle("Ticket/Card Purchase");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
