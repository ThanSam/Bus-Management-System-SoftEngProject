import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



public class ScheduleGUI extends JFrame{
	
	private JPanel panel,printSpecificDriverProgramPanel;
	private ImageIcon icon;
	private JTextArea printSpecificDriverProgramTextArea;
	private JButton BackButton;
	
	private Secretariat sec = new Secretariat();
	private int id;
	
	public ScheduleGUI(Secretariat aSecretariat ,Driver aDriver) {
		this.id=id;
		sec = aSecretariat;
		
		panel = new JPanel();
		icon = new ImageIcon("p2.png");
		printSpecificDriverProgramPanel= new JPanel();
		BackButton = new JButton("Back");
		
		
		int id = Integer.parseInt(aDriver.getId());
		printSpecificDriverProgramTextArea = new JTextArea(15, 35);
		
		ArrayList<String> scheduleList  = new ArrayList<String>();
		scheduleList = sec.getSpecificDriverProgramm(id);
		for (int i= 0; i<scheduleList.size(); i++) {
			if (scheduleList.get(i)!= null) {
				printSpecificDriverProgramTextArea.append(scheduleList.get(i) + "\nBus Line: 2K\nTime: 14.00, 15.00, 16.00\n\n");
			}
		}
	
		
		printSpecificDriverProgramTextArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll1 = new JScrollPane(printSpecificDriverProgramTextArea);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		printSpecificDriverProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printSpecificDriverProgramPanel.setBorder(new TitledBorder(new EtchedBorder(), "My Schedule"));
		printSpecificDriverProgramPanel.add(scroll1);
		
		panel.add(printSpecificDriverProgramPanel);
		panel.add(BackButton);

		this.setContentPane(panel);
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setSize(450, 360);
		this.setTitle("Weekly Schedule");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	}

