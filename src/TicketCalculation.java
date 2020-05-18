import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicketCalculation extends JFrame {

	private double weeklyCardCost, monthlyCardCost,ticketCostPerBusStop,cost;
	
	//GUI Variables
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel;
	private JLabel timesPerWeekLabel,busStopsLabel;
	private JList timesPerWeekList,busStopsList;
	private JButton calculationButton,returnButton;	
	
	public TicketCalculation(int age) {
		
		cost=0.0;
		
		//weeklyCardCost=secretariat.getWeeklyPrice();
		//monthlyCardCost=secretariat.getMonthlyPrice();
		//ticketCostPerBusStop=secretariat.getTicketCostPerBusStop();
		
		//Checking for discount
		if(age>=18 && age<=24) ticketCostPerBusStop/=2;
		
		//Variables initialization
		frame= new JFrame();
		icon= new ImageIcon("p2.png");
		panel= new JPanel();
				
		//Labels creation
		timesPerWeekLabel= new JLabel("How many times a week do you take the bus?");
		busStopsLabel= new JLabel("How many bus-stops each ride includes?");
		
		//JList times/week
		DefaultListModel defaultList= new DefaultListModel();
		for(int i=1; i<8; i++) {
			defaultList.addElement(i+"   ");
		}
		timesPerWeekList= new JList(defaultList);
		timesPerWeekList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		timesPerWeekList.setVisibleRowCount(1);
		
		//JList bus-stops/ride
		DefaultListModel defaultList2 = new DefaultListModel();
		for(int i=1; i<11; i++) {
			defaultList2.addElement(i+" ");
		}
		busStopsList = new JList(defaultList2);
		busStopsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		busStopsList.setVisibleRowCount(1);
		
		
		//Button Listener Creation
		ButtonListener listener = new ButtonListener();
		
		//Buttons Creation
		calculationButton=new JButton("Calculate");
		returnButton= new JButton("Back");

		//Adding listener to buttons
		calculationButton.addActionListener(listener);
		returnButton.addActionListener(listener);
		
		//Adding to main panel
		panel.add(timesPerWeekLabel);
		panel.add(timesPerWeekList);
		panel.add(busStopsLabel);
		panel.add(busStopsList);
		panel.add(calculationButton);
		panel.add(returnButton);
		
		//Sub-panels setting bounds
		panel.setLayout(null);
		timesPerWeekLabel.setBounds(70,40,320,20);
		busStopsLabel.setBounds(70,150,320,20);
		timesPerWeekList.setBounds(140,70,120,30);
		busStopsList.setBounds(110,180,180,30);
		calculationButton.setBounds(140,250,100,40);
		returnButton.setBounds(270,335,100,20);		
		
		//Frame
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setTitle("Ticket Calculator");
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//Calculation Button
			if (e.getSource() == calculationButton) {
					if(busStopsList.getSelectedValue()!=null && timesPerWeekList.getSelectedValue()!=null) cost= Double.valueOf(busStopsList.getSelectedValue().toString())*Double.valueOf(timesPerWeekList.getSelectedValue().toString()) *ticketCostPerBusStop;
					else cost=-1;
				
					if(cost!=-1) {
						if(cost>weeklyCardCost) JOptionPane.showMessageDialog(null,"Weekly Card would profit you : "+ (cost-weeklyCardCost)+"$\nMonthly Card would profit you : "+(cost*4-monthlyCardCost)+"$");
						else JOptionPane.showMessageDialog(null,"You should buy one route tickets.\nTickets cost: "+cost+"$/week.\nWeekly card cost: "+weeklyCardCost+"$\nMonthly card cost : "+monthlyCardCost+"$");				
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"FAILED. Please answer both questions.");
					}
			}
		
			//View Bus Program
			else{
				frame.dispose();

			}
			
		}

	}
}
