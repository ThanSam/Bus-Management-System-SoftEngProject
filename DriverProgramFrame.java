import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DriverProgramFrame extends JFrame {
	
	private JPanel mainPanel;
	private ImageIcon icon;
	private JPanel createPanel;
	private JPanel deletePanel;
	private JPanel printSpecificDriverProgramPanel;
	private JPanel printDriversProgramPanel;
	private JPanel backPanel;
	private JButton backButton;
	private JButton createButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JButton clear2Button;
	private JButton printSpecificDriverProgramButton;
	private JButton printAllDriversProgramButton;
	private JTextField idDriverCreateText;
	private JTextField dateMonthYearCreateText;
	private JTextField dateMonthYearDeleteText;
	private JTextField idDriverDeleteText;
	private JTextField printSpecificDriverProgramText;
	private JLabel idDriverCreateLabel;
	private JLabel dateMonthYearCreateLabel;
	private JLabel idDriverDeleteLabel;
	private JLabel dateMonthYearDeleteLabel;
	private JLabel printSpecificDriverProgramLabel;
	private Secretariat secretariat;
	private JTextArea printAllDriversProgramText;
	private JTextArea printSpecificDriverProgramTextArea;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;
	
	public DriverProgramFrame(Secretariat secretariat) {

		icon = new ImageIcon("p2.png");
		
		backButton = new JButton("Back");
		createButton = new JButton("Create");
		deleteButton = new JButton("Delete");
		clearButton = new JButton("Clear");
		clear2Button = new JButton("Clear");
		printSpecificDriverProgramButton = new JButton("Print Specific Driver Program");
		printAllDriversProgramButton = new JButton("Print All Driver Program");

		mainPanel = new JPanel();
		createPanel = new JPanel();
		deletePanel = new JPanel();
		printSpecificDriverProgramPanel = new JPanel();
		printDriversProgramPanel = new JPanel();
		backPanel = new JPanel();

		idDriverCreateText = new JTextField(5);
		dateMonthYearCreateText = new JTextField(15);

		idDriverDeleteText = new JTextField(10);
		dateMonthYearDeleteText = new JTextField(15);
		printSpecificDriverProgramText = new JTextField(5);
		printSpecificDriverProgramTextArea = new JTextArea(9, 15);

		printAllDriversProgramText = new JTextArea(9, 15);

		idDriverCreateLabel = new JLabel("Id Driver");
		dateMonthYearCreateLabel = new JLabel("Day/Date/Mounth/Year/Hour:Minute");

		idDriverDeleteLabel = new JLabel("Id Driver");
		dateMonthYearDeleteLabel = new JLabel("Date/Mounth/Year/Hour:Minute");

		printSpecificDriverProgramLabel = new JLabel("ID Driver");

		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		createButton.addActionListener(b1);
		printSpecificDriverProgramButton.addActionListener(b1);
		printAllDriversProgramButton.addActionListener(b1);
		deleteButton.addActionListener(b1);
		clearButton.addActionListener(b1);
		clear2Button.addActionListener(b1);

		createPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		createPanel.setBorder(new TitledBorder(new EtchedBorder(), "Create Driver Area"));
		createPanel.add(idDriverCreateLabel);
		createPanel.add(idDriverCreateText);
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		model.setSelected(true);
		createPanel.add(datePicker);
		createPanel.add(createButton);

		deletePanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
		deletePanel.setBorder(new TitledBorder(new EtchedBorder(), "Delete Driver Area"));
		deletePanel.add(idDriverDeleteLabel);
		deletePanel.add(idDriverDeleteText);
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		model1.setSelected(true);
		deletePanel.add(datePicker1);
		deletePanel.add(deleteButton);

		printSpecificDriverProgramTextArea.setEditable(false); // set textArea non-editable
		JScrollPane scroll1 = new JScrollPane(printSpecificDriverProgramTextArea);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		printSpecificDriverProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printSpecificDriverProgramPanel
				.setBorder(new TitledBorder(new EtchedBorder(), "Print Specific Driver Program Area"));
		printSpecificDriverProgramPanel.add(printSpecificDriverProgramLabel);
		printSpecificDriverProgramPanel.add(printSpecificDriverProgramText);
		printSpecificDriverProgramPanel.add(scroll1);
		printSpecificDriverProgramPanel.add(printSpecificDriverProgramButton);
		printSpecificDriverProgramPanel.add(clearButton);

		printAllDriversProgramText.setEditable(false); // set textArea non-editable
		JScrollPane scroll = new JScrollPane(printAllDriversProgramText);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		printDriversProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printDriversProgramPanel.add(printAllDriversProgramButton);
		printDriversProgramPanel.add(scroll);
		printDriversProgramPanel.add(clear2Button);
		
		backPanel.setLayout(null);
		backButton.setBounds(285,10,90,25);
		backPanel.add(backButton);

		mainPanel.add(createPanel);
		mainPanel.add(deletePanel);
		mainPanel.add(printSpecificDriverProgramPanel);
		mainPanel.add(printDriversProgramPanel);
		mainPanel.add(backPanel);

		BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxlayout);

		this.setContentPane(mainPanel);
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(400, 700);
		this.setTitle("Driver's Program");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setSecreatariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int id = 0;

			String dateMonthYear = "";
			int day = 0;
			if (e.getSource().equals(createButton)) {
				
				id = Integer.parseInt(idDriverCreateText.getText());
				dateMonthYear = String.valueOf(model.getValue());
				StringBuilder sb = new StringBuilder(dateMonthYear);
				sb.delete(11,20);
				dateMonthYear=String.valueOf(sb);
				secretariat.addProgramDriver(id, dateMonthYear);
				JOptionPane.showMessageDialog(mainPanel, "Added");
			}

			if (e.getSource().equals(deleteButton)) {
				dateMonthYear = "";
				id = Integer.parseInt(idDriverDeleteText.getText());
				dateMonthYear = String.valueOf(model1.getValue());
				StringBuilder sb = new StringBuilder(dateMonthYear);
				sb.delete(11,20);
				dateMonthYear=String.valueOf(sb);
				if(secretariat.deleteProgramDriver(id, dateMonthYear)==true) {
					JOptionPane.showMessageDialog(mainPanel, "The driver with ID: " + id + " has nothing in this date: "+dateMonthYear);
				}

			}
			if (e.getSource().equals(printSpecificDriverProgramButton)) {
				id = Integer.parseInt(printSpecificDriverProgramText.getText());

				String[][] idDriverList1 = new String[5][7];
				int y = 0;
				idDriverList1 = secretariat.getList();

				for (y = 0; y < 7; y++) {
					if (idDriverList1[id][y] != null) {
						printSpecificDriverProgramTextArea
								.append("ID:" + id + "  timetable: " + idDriverList1[id][y] + "\n");
					}
				}
			}
			if (e.getSource().equals(clearButton)) {

				printSpecificDriverProgramTextArea.setText("");

			}

			if (e.getSource().equals(printAllDriversProgramButton)) {

				String[][] idDriverList1 = new String[5][7];
				int i = 0, y = 0;
				idDriverList1 = secretariat.getList();
				for (i = 0; i < 10; i++) {
					for (y = 0; y < 7; y++) {
						if (idDriverList1[i][y] != null) {
							printAllDriversProgramText.append("ID:" + i + "  timetable: " + idDriverList1[i][y] + "\n");
							
						}
					}
				}
			}
			if (e.getSource().equals(clear2Button)) {

				printAllDriversProgramText.setText("");

			}

			if (e.getSource().equals(backButton)) {
				dispose();

			}
		}
	}

}
