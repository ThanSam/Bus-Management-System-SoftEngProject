import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;





public class ScheduleGUI extends JFrame{
	
	private JPanel panel,printSpecificDriverProgramPanel;
	private ImageIcon icon;
	private JTextArea printSpecificDriverProgramTextArea;
	private JButton backButton;
	private Driver aDriver;
	private Secretariat sec;
	private int id=0;
	String[][] idDriverList1 = new String[5][7];
	String[][] driverLineList = new String[5][7];
	
	public ScheduleGUI(Secretariat aSecretariat ,Driver aDriver) {
		this.sec = aSecretariat;
		this.aDriver=aDriver;
		
		panel = new JPanel();
		icon = new ImageIcon("p2.png");
		printSpecificDriverProgramPanel= new JPanel();
		backButton = new JButton("Back");
		
		
	     id = Integer.parseInt(aDriver.getId());
		printSpecificDriverProgramTextArea = new JTextArea(15, 35);
		idDriverList1 = sec.getList();
		driverLineList = sec.getDriverLineList();
		int y=0;
			for (y = 0; y < 7; y++) {
				if (idDriverList1[id][y] != null) {
					printSpecificDriverProgramTextArea.append("ID:" + id + "  timetable: " + idDriverList1[id][y]
							+ " LineId: " + driverLineList[id][y] + "\n");
				}
		}
	
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		
		printSpecificDriverProgramTextArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll1 = new JScrollPane(printSpecificDriverProgramTextArea);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		printSpecificDriverProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printSpecificDriverProgramPanel.setBorder(new TitledBorder(new EtchedBorder(), "My Schedule"));
		printSpecificDriverProgramPanel.add(scroll1);
		
		panel.add(printSpecificDriverProgramPanel);
		panel.add(backButton);

		this.setContentPane(panel);
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setSize(450, 360);
		this.setTitle("Weekly Schedule");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource().equals(backButton)) {
				 dispose();
			      new DriverGUI(aDriver,sec);
			     

			}
	}
	}
}
