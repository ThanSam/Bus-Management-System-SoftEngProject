import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

	private JTextArea printAllDriversProgramText;
	private JTextArea printSpecificDriverProgramTextArea;
	private JTextArea BusLineTextArea;

	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private UtilDateModel model1;
	private JDatePanelImpl datePanel1;
	private JDatePickerImpl datePicker1;

	private ArrayList<BusLine> busLineList;
	private ImageIcon icon;
	private Choice c;
	private Choice time;
	private Secretariat sec;

	public DriverProgramFrame(Secretariat sec) {
		// Set secretariat
		this.sec = sec;

		// Create Icons,Buttons, JLabels, JTextFields, Panels.
		c = new Choice();
		time = new Choice();
		icon = new ImageIcon("p2.png");
		busLineList = new ArrayList<BusLine>();
		busLineList = sec.getBusLineList();
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
		idDriverCreateText = new JTextField("1", 5);
		dateMonthYearCreateText = new JTextField(15);
		idDriverDeleteText = new JTextField("1", 5);
		dateMonthYearDeleteText = new JTextField(15);
		printSpecificDriverProgramText = new JTextField("1", 5);
		printSpecificDriverProgramTextArea = new JTextArea(9, 15);
		printAllDriversProgramText = new JTextArea(9, 15);
		idDriverCreateLabel = new JLabel("Id Driver");
		dateMonthYearCreateLabel = new JLabel("Day/Date/Mounth/Year/Hour:Minute");
		idDriverDeleteLabel = new JLabel("Id Driver");
		dateMonthYearDeleteLabel = new JLabel("Date/Mounth/Year/Hour:Minute");
		printSpecificDriverProgramLabel = new JLabel("ID Driver");
		BusLineTextArea = new JTextArea(9, 15);

		// ButtonListeners for all Buttons
		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		createButton.addActionListener(b1);
		printSpecificDriverProgramButton.addActionListener(b1);
		printAllDriversProgramButton.addActionListener(b1);
		deleteButton.addActionListener(b1);
		clearButton.addActionListener(b1);
		clear2Button.addActionListener(b1);

		for (BusLine busLine : busLineList) {
			c.add(busLine.getLineID());
		}

		// check what time is so we change the choiceField
		DateTimeFormatter h = DateTimeFormatter.ofPattern("H");
		LocalDateTime now3 = LocalDateTime.now();
		String hour = h.format(now3);

		if (hour.equals("8") || hour.equals("9") || hour.equals("10") || hour.equals("11") || hour.equals("12")
				|| hour.equals("13") || hour.equals("14") || hour.equals("15") || hour.equals("16")) {
			time.add("8:00-16:00");
			time.add("16:00-00:00");
		} else {
			time.add("16:00-00:00");
			time.add("8:00-16:00");

		}

		// Add in CreatePanel all components
		createPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		createPanel.setBorder(new TitledBorder(new EtchedBorder(), "Create Driver Area"));
		createPanel.add(idDriverCreateLabel);
		createPanel.add(idDriverCreateText);
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		model.setSelected(true);
		createPanel.add(datePicker);
		createPanel.add(c);
		createPanel.add(time);
		createPanel.add(createButton);

		// Add in DeletePanel all components
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

		// Add in printSpecificDriverProgramPanel all components
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

		// Add in printDriversProgramPanel all components
		printDriversProgramPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		printDriversProgramPanel.add(printAllDriversProgramButton);
		printDriversProgramPanel.add(scroll);
		printDriversProgramPanel.add(clear2Button);

		// Set Size to Buttons,Panels.
		backPanel.setLayout(null);
		backButton.setBounds(285, 10, 90, 25);
		backPanel.add(backButton);

		// Add in MainPanel all other Panels.
		mainPanel.add(createPanel);
		mainPanel.add(deletePanel);
		mainPanel.add(printSpecificDriverProgramPanel);
		mainPanel.add(printDriversProgramPanel);
		mainPanel.add(backPanel);

		// Put main panel in specific Layout.
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

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Read all drivers from SecretariatList and put the data in otherList which we
			// can use in this frame
			int id = 0;

			ArrayList<Driver> driverList = new ArrayList<Driver>();
			driverList = sec.getDriverList();

			for (Driver driver : driverList) {
				if (idDriverCreateText.getText().equals(driver.getId())) {
					sec.deleteDriverFromFreeDriversList(driver);
				}
			}

			String[][] idDriverList1 = new String[5][7];
			String[][] driverLineList = new String[5][7];

			idDriverList1 = sec.getList();
			driverLineList = sec.getDriverLineList();
			String dateMonthYear = "";

			// CreateButton Function.
			if (e.getSource().equals(createButton)) {
				String month = String.valueOf(model.getMonth());
				month = String.valueOf(Integer.parseInt(month) + 1);
				id = Integer.parseInt(idDriverCreateText.getText());
				dateMonthYear = String.valueOf(model.getDay() + "/" + month + "/" + model.getYear());

				dateMonthYear = dateMonthYear + " " + time.getSelectedItem();

				String idLine = c.getSelectedItem();
				sec.addProgramDriverBusLine(id, dateMonthYear, idLine);
				JOptionPane.showMessageDialog(mainPanel, "Added");
			}

			// DeleteButton Function.
			if (e.getSource().equals(deleteButton)) {
				String date;
				id = Integer.parseInt(idDriverDeleteText.getText());
				dateMonthYear = String.valueOf(model1.getValue());
				StringBuilder sb = new StringBuilder(dateMonthYear);
				sb.delete(11, 20);
				dateMonthYear = String.valueOf(sb);
				date = dateMonthYear.substring(0, 3);
				if (sec.deleteProgramDriver(id, date) == true) {
					JOptionPane.showMessageDialog(mainPanel,
							"The driver with ID: " + id + " has nothing in this date: " + dateMonthYear);
				}

			}

			// printSpecificDriverProgramButton Function(Print specific Driver
			// ProgrammData).
			if (e.getSource().equals(printSpecificDriverProgramButton)) {
				id = Integer.parseInt(printSpecificDriverProgramText.getText());

				int y = 0;

				for (y = 0; y < 7; y++) {
					if (idDriverList1[id][y] != null) {
						printSpecificDriverProgramTextArea.append("ID:" + id + "  timetable: " + idDriverList1[id][y]
								+ " LineId: " + driverLineList[id][y] + "\n");
					}
				}
			}

			// clearButton Function.(We clear the data from
			// printSpecificDriverProgramTextArea )
			if (e.getSource().equals(clearButton)) {
				printSpecificDriverProgramTextArea.setText("");
			}

			// printAllDriversProgramButton function(Print all Drivers ProgrammData).
			if (e.getSource().equals(printAllDriversProgramButton)) {

				int i = 0, y = 0;
				idDriverList1 = sec.getList();
				for (i = 0; i < 10; i++) {
					for (y = 0; y < 7; y++) {
						if (idDriverList1[i][y] != null) {
							printAllDriversProgramText.append("ID:" + i + "  timetable: " + idDriverList1[i][y]
									+ " LineId: " + driverLineList[i][y] + "\n");

						}
					}
				}
			}

			// clear2Button Function.(We clear the data from printAllDriversProgramText)
			if (e.getSource().equals(clear2Button)) {

				printAllDriversProgramText.setText("");

			}

			if (e.getSource().equals(backButton)) {
				new MainSecretariatFrame(sec);
				dispose();

			}
		}
	}

}
