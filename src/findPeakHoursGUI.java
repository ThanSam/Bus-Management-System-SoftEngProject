import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class findPeakHoursGUI extends JFrame {
	
	private JPanel panel;
	private ImageIcon icon;
	private JLabel img;
	private JLabel busyRoutesLabel; 
	private JTable Table;
	private JButton backButton;
	private JButton addRouteButton;
	private JFrame frame;
	
	private Secretariat sec;
	
	public findPeakHoursGUI(Secretariat s) {
		frame = new JFrame();
		sec = s;
		
		panel = new JPanel();
		icon = new ImageIcon("p2.png");
		img = new JLabel(new ImageIcon("p10.png"));
		busyRoutesLabel = new JLabel("Busy Routes");
		busyRoutesLabel.setForeground(Color.red);
		backButton = new JButton("Back");
		addRouteButton = new JButton("Add Bus Route");
		
		String[] columnNames = {"Bus Line", "Time","Date"};
		ArrayList<BusRoute> busyRoutes = s.getBusyRoutes();
		String[][] data = new String[busyRoutes.size()][3]; 
		
		int i = 0;
		for(BusRoute route: busyRoutes) {
			data[i][0] = route.getLine().getLineID();
			data[i][1] = Double.toString(route.getDepartureTime());
			data[i][2] = route.getDate();
			i++;
		}
		
		Table = new JTable(data,columnNames);
		
		JScrollPane sp = new JScrollPane(Table); 
        
		ButtonListener buttonL = new ButtonListener();
		addRouteButton.addActionListener(buttonL);
		backButton.addActionListener(buttonL);
		
		panel.setLayout(null);
		img.setBounds(57, 5, 160, 160);
		busyRoutesLabel.setBounds(100, 170, 90, 20);
		sp.setBounds(20,195,240,190);
		addRouteButton.setBounds(20,410,118,30);
		backButton.setBounds(185,410,70,30);
		
		panel.add(img);
		panel.add(busyRoutesLabel);
		panel.add(sp);
		panel.add(addRouteButton);
		panel.add(backButton);
		
		
		frame.setContentPane(panel);
		frame.setIconImage(icon.getImage());
		frame.setTitle("Find Peak Hours");
		frame.setSize(300, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == addRouteButton) {
				new addBusRouteFrame(sec);
			
			}
			else if(e.getSource() == backButton) {
				new MainSecretariatFrame(sec);
				frame.dispose();
			}
		}
	}
}

