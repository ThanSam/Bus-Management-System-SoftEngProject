import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
	private JTextArea printSpecificDriverProgramTextArea;
	private Secretariat sec = new Secretariat();
	private int id;
	
	public ScheduleGUI(Secretariat aSecretariat ,Driver aDriver) {
		this.id=id;
		sec = aSecretariat;
		panel = new JPanel();
		printSpecificDriverProgramPanel= new JPanel();
	
		int id = Integer.parseInt(aDriver.getId());
		printSpecificDriverProgramTextArea = new JTextArea(10, 30);
		
		ArrayList<String> scheduleList  = new ArrayList<String>();
		scheduleList = sec.getSpecificDriverProgramm(id);
		for (int i= 0; i<scheduleList.size(); i++) {
			if (scheduleList.get(i)!= null) {
				printSpecificDriverProgramTextArea.append("\n"+scheduleList.get(i));
			}
		}
	
		
		printSpecificDriverProgramTextArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll1 = new JScrollPane(printSpecificDriverProgramTextArea);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		printSpecificDriverProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printSpecificDriverProgramPanel.setBorder(new TitledBorder(new EtchedBorder(), "Print Specific Driver Program Area"));
		printSpecificDriverProgramPanel.add(scroll1);
		
		panel.add(printSpecificDriverProgramPanel);

		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(700, 300);
		this.setTitle("ебдоладиаио пяоцяалла");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	}

