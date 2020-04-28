import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
        Secretariat s1 = new Secretariat();
        
        //Dummy data
        Driver d1 = new Driver("John", "Lampis", "22", "6981144627" , "1", "mypass", s1);
		Driver d2 = new Driver("Kostas", "Kampos", "40", "6941144625" , "2", "mypass2", s1);
		Driver d3 = new Driver("George", "Dimitriou", "34", "6981145625" , "3", "mypass3", s1);
		Driver d4 = new Driver("Nick", "Delis", "25", "6973444625" , "4", "mypass6", s1);
		Passenger p1 = new Passenger("Jim","Dimitriou",22,"6981144627","JimD","mypass",s1);
		
		s1.addPassenger(p1);
		s1.addDriver(d1);
		s1.addDriver(d2);
		s1.addDriver(d3);
		s1.addDriver(d4);
		
		MainFrame mainFrame = new MainFrame(s1);
		//new DriverGUI(d4,s1);
		//new PassengerGUI(p1,mainFrame);
		//new MainSecretariatFrame(s1,mainFrame);
		
	}
	
}

