import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FastestBus extends JFrame {

	
	private JFrame frame;
	private ImageIcon icon;
	private JPanel panel,panelStarting,panelEnding;
	private JTextField startingField,stoppingField,currentTimeField;
	private JButton findButton,returnButton;
	private JLabel startingLabel,stoppingLabel,drawingLabel;
	
	public FastestBus() {
		
		frame=new JFrame();
		icon= new ImageIcon("p2.png");
		panel=new JPanel();
		
		//JTextField initialization
		startingField= new JTextField("Starting point");
		stoppingField= new JTextField("Stopping point");
		
		//JPanel initialization
		startingLabel=new JLabel("Starting point");
		stoppingLabel=new JLabel("Stopping point");
		drawingLabel= new JLabel("x- - - - - - - - - - - ->");
		
		findButton=new JButton("Find bus");
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				String start=startingField.getText();
				String stop=stoppingField.getText();
				double currentTime=Double.parseDouble(currentTimeField.getText());
				
				
				ArrayList<BusLine> selectedBusLine= new ArrayList<BusLine>();
				ArrayList<String> stops;
				
				int i,stopsFromStart=0;
				boolean f=true;
				
				for(BusLine busLine : busLines){
					i=0;
					stops=busLine.getStops();
					while(i<stops.size() && f) {
						if((stops.get(i)).equals(start)) {
							f=false;
						}
						i++;
						stopsFromStart=i;
					}
					
					while(i<stops.size() && !f) {
						if((stops.get(i)).equals(stop)) {
							selectedBusLine.add(busLine);
							f=true;
						}
						i++;
					}
				}
				
				if(selectedBusLine.size()==0) {
					System.out.println("No buses can get you there.");
				}
				else {
					//Showing buses coming in 20 minutes or earlier
					int min=1000,minutesFromStart;
					String incomingBuses="";
					ArrayList<Double> timeBetweenStop;
					
					for(BusLine busLine:selectedBusLine) {
						
						timeBetweenStop=busLine.getTimeBetweenStops();
						minutesFromStart=0;
						
						for(i=0; i<stopsFromStart; i++) {
							minutesFromStart+=timeBetweenStop.get(i);
						}	
						
						for(Double departureTime : busLine.getTimes()) {
							double g=(departureTime+minutesFromStart)-currentTime;
							if(g>=0 && g<=20) {
								incomingBuses+="Bus Line "+ busLine.getLineID()+"        " +g+"'\n";
							}
						}
					}
					if(!incomingBuses.equals("")) JOptionPane.showMessageDialog(null,incomingBuses);
					else {
						JOptionPane.showMessageDialog(null,"No buses coming in less than 20'.");
					}
				}
			}
		});
		
		returnButton=new JButton("Back");
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		
		
		panel.setLayout(null);
		panel.add(startingLabel);
		panel.add(startingField);
		panel.add(stoppingLabel);
		panel.add(stoppingField);
		panel.add(drawingLabel);
		panel.add(findButton);
		panel.add(returnButton);


		startingLabel.setBounds(30,50,100,20);
		stoppingLabel.setBounds(250,50,100,20);
		startingField.setBounds(20,70,100,20);
		stoppingField.setBounds(240,70,100,20);
		drawingLabel.setBounds(130,67,100,20);
		findButton.setBounds(130,120,100,50);
		returnButton.setBounds(295,185,80,20);
		
		//Frame
		frame.add(panel);
		frame.setIconImage(icon.getImage());
		frame.setTitle("Fastest bus");
		frame.setSize(400,250);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

/*
 * 
 * 
 * 
 * *************************************************************************
 *
 *  CHECK IF TIME IS NEEDED
 *
 *	CHECK CURRENT TIME 
 *
 *
 ***************************************************************************
 *
 *
 *
 */
