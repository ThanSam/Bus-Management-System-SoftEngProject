import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TicketPurchase extends JFrame{
	
	//additional variables
	private double cost; 
	private Passenger passenger;
	private String category="Normal";
	private double ticketPrice,weeklyCardPrice,monthlyCardPrice;
	private BusRoute route=null;
	private String lineID="";
	private double time=-1;
	
	
	//GUI variables
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel;
	private JButton returnButton,buyButton;
	private JList stopsList,cardsList,linesList,timeList;
	private JLabel stopsLabel,costLabel,cardsLabel,linesLabel,timeLabel;
	private JTextField costField;
	
	
	public TicketPurchase(Passenger passenger) {
		
		ticketPrice= passenger.getSecretariat().getPrice(1);
		weeklyCardPrice= passenger.getSecretariat().getPrice(2);
		monthlyCardPrice= passenger.getSecretariat().getPrice(3);
		
		//Variables creation
		cost=0.0;
		this.passenger=passenger;
		int age = passenger.getAge();
		
		if(age<=24 && age>=18) {
			category="Discount";
		}
		
		frame= new JFrame();
		icon= new ImageIcon("p2.png");
		panel= new JPanel();
		
		//Panel's elements
		stopsLabel= new JLabel("How many stops does your trip include?");
		costField= new JTextField("0.0");
		costLabel= new JLabel("The total cost is: ");
		cardsLabel= new JLabel("Or you can purchase an unlimited card:");
		linesLabel= new JLabel("Which Bus Line will you be using? (Optimal)");
		timeLabel= new JLabel("What's the route's departure time?");
		
		//Stops JList Creation
		DefaultListModel defaultList= new DefaultListModel();
		for(int i=1; i<=10; i++) {
			defaultList.addElement("  "+i+"  ");
		}
		stopsList=new JList(defaultList);
		stopsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		stopsList.setVisibleRowCount(1);
		
		
		//Cards JList Creation
		DefaultListModel defaultList1= new DefaultListModel();
		defaultList1.addElement("Weekly Card                   ");			
		defaultList1.addElement("                   Monthly Card");
		cardsList=new JList(defaultList1);
		cardsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		cardsList.setVisibleRowCount(1);
		
		//BusLines JList Creation
		DefaultListModel defaultList2= new DefaultListModel();
		for(BusLine l : passenger.getSecretariat().getBusLineList()) {
			defaultList2.addElement("  "+l.getLineID()+"  ");
		}
		linesList=new JList(defaultList2);
		linesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		linesList.setVisibleRowCount(1);
		
		//timeList JList Creation
		DefaultListModel defaultList3= new DefaultListModel();
		for(BusLine l : passenger.getSecretariat().getBusLineList()) {
			if(l.getLineID().equals(lineID)) {
				for(Double time: l.getTimes()) {
					defaultList3.addElement(time);
				}
			}
		}
		timeList=new JList(defaultList3);
		timeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		timeList.setVisibleRowCount(1); 
		
		//MouseListener stopsList
		MouseListener mouseListenerStops= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
		        stopsList=(JList) mouseEvent.getSource();
		        int stops=0;  
		        stops = stopsList.locationToIndex(mouseEvent.getPoint());
		        if (stops >= 0) {
		            Object o = stopsList.getModel().getElementAt(stops);
		            cost=Double.valueOf(o.toString())*0.2;
					if(category.equals("Discount")) {
						if(cost>0) cost=cost/2;
					}
		            costField.setText(String.format("%.2f", cost));
		          }
		      }
		};
		stopsList.addMouseListener(mouseListenerStops);
		
		
		//MouseListener cardsList
		MouseListener mouseListenerCards= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				cardsList=(JList) mouseEvent.getSource();
		        int card=0;  
		        card = cardsList.locationToIndex(mouseEvent.getPoint());
		        if (card>=0) {
		        	Object o = cardsList.getModel().getElementAt(card);
		            if((o.toString()).equals("Weekly Card                   ")) cost=weeklyCardPrice;
		            else cost=monthlyCardPrice;
		            costField.setText(String.format("%.2f", cost));
		        }
			}
		};
		cardsList.addMouseListener(mouseListenerCards);
		
		
		//MouseListener linesList
		MouseListener mouseListenerLines= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				linesList=(JList) mouseEvent.getSource();
				int r=0;  
				r = linesList.locationToIndex(mouseEvent.getPoint());
				if (r>=0) {
					Object o = linesList.getModel().getElementAt(r);
					lineID=(String)o;	
					lineID=lineID.replaceAll("\\s", "");
					
					defaultList3.removeAllElements();
					for(BusLine l : passenger.getSecretariat().getBusLineList()) {
						if(l.getLineID().equals(lineID)) {
							for(Double time: l.getTimes()) {
								defaultList3.addElement(String.valueOf(time)+" -- ");
							}
						}
					}
					timeList=new JList(defaultList3);
				}
			}
		};
		linesList.addMouseListener(mouseListenerLines);
		
		//MouseListener timeList
		MouseListener mouseListenerTime= new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				String text="";
				timeList=(JList) mouseEvent.getSource();
				int t=0;  
				t = timeList.locationToIndex(mouseEvent.getPoint());
				if (t>=0) {
					Object o = timeList.getModel().getElementAt(t);
				    text=(String)o;
				    text=text.replaceAll("--","");
					time=Double.parseDouble(text);
				}
			}
		};
		timeList.addMouseListener(mouseListenerTime);
		
		//Creating button listener
		ButtonListener listener=new ButtonListener();
		
		//Buttons creation
		buyButton=new JButton("Purchase");
		returnButton=new JButton("Back");
		
		//Adding listener to buttons
		buyButton.addActionListener(listener);
		returnButton.addActionListener(listener);
		
		
		//Adding elements to panel
		panel.add(buyButton);
		panel.add(returnButton);
		panel.add(stopsList);
		panel.add(stopsLabel);
		panel.add(costLabel);
		panel.add(costField);
		panel.add(cardsLabel);
		panel.add(cardsList);
		panel.add(linesList);
		panel.add(linesLabel);
		panel.add(timeList);
		panel.add(timeLabel);
		
		//Setting bounds
		panel.setLayout(null);
		returnButton.setBounds(250,320,100,20);
		buyButton.setBounds(50,320,100,20);
		stopsList.setBounds(50,50,280,30);
		stopsLabel.setBounds(75,20,280,20);
		costLabel.setBounds(50,290,150,20);
		costField.setBounds(150,290,40,20);
		cardsLabel.setBounds(75,220,280,30);
		cardsList.setBounds(50,250,280,30);
		linesLabel.setBounds(75,90,280,30);
		linesList.setBounds(110,120,150,30);
		timeLabel.setBounds(75,150,280,30);
		timeList.setBounds(50,180,280,30);
		
		//Setting Frame
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setSize(400,400);
		frame.setTitle("Ticket/Card Purchase");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//Purchase Button
			if (e.getSource() == buyButton) {
				if(cost<=0) JOptionPane.showMessageDialog(null,"FAILED. Please choose the number of stops.");
				else { 
					String purchaseTime = new SimpleDateFormat("yyyy/MM/dd--HH:mm:ss").format(Calendar.getInstance().getTime());
					if(cost==weeklyCardPrice) {
						new oneWeekCard(passenger.getSecretariat().getCardID(passenger),passenger,category,purchaseTime);
						new BankSystem(cost);
					}
					else if(cost==monthlyCardPrice) {
						new oneMonthCard(passenger.getSecretariat().getCardID(passenger),passenger,category,purchaseTime);
						new BankSystem(cost);
					}
					else { 
						
						for(BusRoute b: passenger.getSecretariat().getBusRouteList()) {
							if(b.getLine().getLineID().equals(lineID)&& b.getDepartureTime()==time) {
								route=b;
							}
						}
						if(route==null) {
							JOptionPane.showMessageDialog(null,"Please choose a valid line and departure time.");
						}
						else {
							new smartTicket(passenger.getSecretariat().getCardID(passenger),category,route,purchaseTime);
							route.addPassenger();
							new BankSystem(cost);
						}
					}
					
				}				
			}
			
			//Return Button
			else if (e.getSource() == returnButton) {
				frame.dispose();

			}
			

		}
	
	}
}