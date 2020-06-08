import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class addBusRouteFrame {

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
	private Secretariat sec;
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
	private Choice c;
	private Choice time;
	private JFrame frame;


	
	public addBusRouteFrame(Secretariat sec) {
	  this.sec=sec;
		frame = new JFrame();
		c = new Choice();
		time = new Choice();
		icon = new ImageIcon("p2.png");
		busLineList = new ArrayList<BusLine>();
		busLineList = sec.getBusLineList();
		backButton = new JButton("Back");
		createButton = new JButton("Create");
		mainPanel = new JPanel();
		createPanel = new JPanel();
	    backPanel = new JPanel();
		idDriverCreateText = new JTextField("1",5);
		dateMonthYearCreateText = new JTextField(15);
	
	
		idDriverCreateLabel = new JLabel("Id Driver");
		dateMonthYearCreateLabel = new JLabel("Day/Date/Mounth/Year/Hour:Minute");
		idDriverDeleteLabel = new JLabel("Id Driver");
		BusLineTextArea = new JTextArea(9, 15);

		ButtonListener b1 = new ButtonListener();
		backButton.addActionListener(b1);
		createButton.addActionListener(b1);
	
		

		for (BusLine busLine : busLineList) {
			c.add(busLine.getLineID());
		}
		DateTimeFormatter h = DateTimeFormatter.ofPattern("H");
		LocalDateTime now3 = LocalDateTime.now();
		String hour = h.format(now3);
		if (hour.equals("8")||hour.equals("9")||hour.equals("10")||hour.equals("11")||hour.equals("12")||hour.equals("13")||hour.equals("14")||hour.equals("15")||hour.equals("16")) {
        time.add("8:00-16:00");
        time.add("16:00-00:00");
		}
		else {
	        time.add("16:00-00:00");
			 time.add("8:00-16:00");
		
		}
        
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

		



		backPanel.setLayout(null);
		backButton.setBounds(285, 10, 90, 25);
		backPanel.add(backButton);

		mainPanel.add(createPanel);
		mainPanel.add(backPanel);

		BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxlayout);

	    frame.setContentPane(mainPanel);
		frame.setIconImage(icon.getImage());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setTitle("Driver's Program");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setSecreatariat(Secretariat secretariat) {
		this.sec = secretariat;
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int id = 0;
            ArrayList<Driver> driverList = new    ArrayList<Driver>();
            driverList=sec.getDriverList();
            for(Driver driver:driverList) {
            if(idDriverCreateText.getText().equals(driver.getId())){
              	sec.deleteDriverFromFreeDriversList(driver);
            }
         }
			String[][] idDriverList1 = new String[5][7];
			String[][] driverLineList = new String[5][7];
			idDriverList1 = sec.getList();
			driverLineList = sec.getDriverLineList();
			String dateMonthYear = "";
			int day = 0;
			if (e.getSource().equals(createButton)) {
				String month=String.valueOf(model.getMonth());
				 month=String.valueOf(Integer.parseInt(month)+1);
				id = Integer.parseInt(idDriverCreateText.getText());
				dateMonthYear = String.valueOf(model.getDay()+"/"+month+"/"+model.getYear());
				
				dateMonthYear = dateMonthYear +" " + time.getSelectedItem();
	
				String idLine = c.getSelectedItem();
				sec.addProgramDriverBusLine(id, dateMonthYear, idLine);
		   
				JOptionPane.showMessageDialog(mainPanel, "Added");
			}

			if (e.getSource().equals(backButton)) {
			    frame.dispose();
			     

			}
		}
	}

}