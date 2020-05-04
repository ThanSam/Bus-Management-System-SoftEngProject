import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
        Secretariat s1 = new Secretariat();
        
        //Dummy data(Drivers & Passengers)
        Driver d1 = new Driver("John", "Lampis", "22", "6981144627" , "1", "1", s1);
		Driver d2 = new Driver("Kostas", "Kampos", "40", "6941144625" , "2", "2", s1);
		Driver d3 = new Driver("George", "Dimitriou", "34", "6981145625" , "3", "3", s1);
		Driver d4 = new Driver("Nick", "Delis", "25", "6973444625" , "4", "4", s1);
		Passenger p1 = new Passenger("Jim","Dimitriou",22,"6981144627","1","1",s1);
		s1.addFreeDrivers(d1);
		s1.addFreeDrivers(d2);
		s1.addFreeDrivers(d3);
		s1.addFreeDrivers(d4);
	
		s1.addPassenger(p1);
		s1.addDriver(d1);
		s1.addDriver(d2);
		s1.addDriver(d3);
		s1.addDriver(d4);

		
		MainFrame mainFrame = new MainFrame(s1);
		//new DriverGUI(d4,s1);
		//new PassengerGUI(p1,mainFrame);
		//new MainSecretariatFrame(s1,mainFrame);
		
		
		//Initiate bus line no.1X 
		ArrayList<String> Stops1X = new ArrayList<String>();
		Stops1X.add("T.S. K.T.E.L.");
		Stops1X.add("PLATIA ARISTOTELOUS");
		Stops1X.add("KAMARA");
		Stops1X.add("DIMARHIAKO MEGARO");
		Stops1X.add("MEGARO MOUSIKIS-25 MARTIOU");
		Stops1X.add("KRIKELA");
		Stops1X.add("MACEDONIA AIRPORT - DEPARTURES");
		Stops1X.add("MACEDONIA AIRPORT - ARRIVALS");
		
		ArrayList<Double> TimeBetweenStops1X = new ArrayList<Double>();
		TimeBetweenStops1X.add(15.0);
		TimeBetweenStops1X.add(5.0);
		TimeBetweenStops1X.add(5.0);
		TimeBetweenStops1X.add(10.0);
		TimeBetweenStops1X.add(7.0);
		TimeBetweenStops1X.add(13.0);
		TimeBetweenStops1X.add(3.0);
		
		ArrayList<Double> depTimes1X = new ArrayList<Double>();
		depTimes1X.add(00.00);
		depTimes1X.add(06.00);
		depTimes1X.add(08.00);
		depTimes1X.add(12.00);
		depTimes1X.add(15.00);
		depTimes1X.add(18.00);
		depTimes1X.add(22.00);
		
		BusLine X1 = new BusLine("1X","T.S. K.T.E.L.",Stops1X,TimeBetweenStops1X,depTimes1X); 

		
		//Initiate bus line no.10 
		ArrayList<String> Stops10 = new ArrayList<String>();
		Stops10.add("NEOS SIDIRODROMIKOS STATHMOS");
		Stops10.add("KOLOMVOU");
		Stops10.add("PLATIA ARISTOTELOUS");
		Stops10.add("KAMARA");
		Stops10.add("IPPOKRATIO");
		Stops10.add("OSIA XENI");
		Stops10.add("VOULGARI");
		Stops10.add("T.S. HARILAOU");
				
		ArrayList<Double> TimeBetweenStops10 = new ArrayList<Double>();
		TimeBetweenStops10.add(6.0);
		TimeBetweenStops10.add(7.0);
		TimeBetweenStops10.add(5.0);
		TimeBetweenStops10.add(10.0);
		TimeBetweenStops10.add(12.0);
		TimeBetweenStops10.add(3.0);
		TimeBetweenStops10.add(4.0);
				
		ArrayList<Double> depTimes10 = new ArrayList<Double>();
		depTimes10.add(00.00);
		depTimes10.add(07.15);
		depTimes10.add(08.00);
		depTimes10.add(11.00);
		depTimes10.add(15.00);
		depTimes10.add(19.00);
		depTimes10.add(22.00);
				
		BusLine l10 = new BusLine("10","NEOS SIDIRODROMIKOS STATHMOS",Stops10,TimeBetweenStops10,depTimes10);
		
		//Initiate bus line no.14  
		ArrayList<String> Stops14 = new ArrayList<String>();
		Stops14.add("NEOS SIDIRODROMIKOS STATHMOS");
		Stops14.add("KOLOMVOU");
		Stops14.add("PLATIA ARISTOTELOUS");
		Stops14.add("KAMARA");
		Stops14.add("LIMODON");
		Stops14.add("AGIA VARVARA");
		Stops14.add("DIMOKRATIAS");
		Stops14.add("T.S. ANO TOUMPAS");
						
		ArrayList<Double> TimeBetweenStops14 = new ArrayList<Double>();
		TimeBetweenStops14.add(6.0);
		TimeBetweenStops14.add(7.0);
		TimeBetweenStops14.add(5.0);
		TimeBetweenStops14.add(7.0);
		TimeBetweenStops14.add(8.0);
		TimeBetweenStops14.add(6.0);
		TimeBetweenStops14.add(10.0);
						
		ArrayList<Double> depTimes14 = new ArrayList<Double>();
		depTimes14.add(00.00);
		depTimes14.add(07.30);
		depTimes14.add(08.45);
		depTimes14.add(11.00);
		depTimes14.add(15.30);
		depTimes14.add(20.00);
		depTimes14.add(21.30);
						
		BusLine l14 = new BusLine("14","NEOS SIDIRODROMIKOS STATHMOS",Stops14,TimeBetweenStops14,depTimes14);
		
		//Initiate bus line no.17 
		ArrayList<String> Stops17 = new ArrayList<String>();
		Stops17.add("NEOS SIDIRODROMIKOS STATHMOS");
		Stops17.add("KOLOMVOU");
		Stops17.add("PLATIA ARISTOTELOUS");
		Stops17.add("KAMARA");
		Stops17.add("KAFTANZOGLIO");
		Stops17.add("NISAKI");
		Stops17.add("AGIOS SPIRIDONAS");
		Stops17.add("T.S. TRIANDRIAS");
								
		ArrayList<Double> TimeBetweenStops17 = new ArrayList<Double>();
		TimeBetweenStops17.add(6.0);
		TimeBetweenStops17.add(7.0);
		TimeBetweenStops17.add(5.0);
		TimeBetweenStops17.add(6.0);
		TimeBetweenStops17.add(10.0);
		TimeBetweenStops17.add(8.0);
		TimeBetweenStops17.add(7.0);
								
		ArrayList<Double> depTimes17 = new ArrayList<Double>();
		depTimes17.add(00.00);
		depTimes17.add(08.00);
		depTimes17.add(09.45);
		depTimes17.add(11.15);
		depTimes17.add(16.00);
		depTimes17.add(20.00);
		depTimes17.add(23.30);
								
		BusLine l17 = new BusLine("17","NEOS SIDIRODROMIKOS STATHMOS",Stops17,TimeBetweenStops17,depTimes17);
		
		//Initiate bus line no.11 
		ArrayList<String> Stops11= new ArrayList<String>();
		Stops11.add("NEOS SIDIRODROMIKOS STATHMOS");
		Stops11.add("KOLOMVOU");
		Stops11.add("PLATIA ARISTOTELOUS");
		Stops11.add("KAMARA");
		Stops11.add("BOTSARI");
		Stops11.add("AGIA KIRIAKI");
		Stops11.add("GERANIOU");
		Stops11.add("T.S. PILEAS");
										
		ArrayList<Double> TimeBetweenStops11 = new ArrayList<Double>();
		TimeBetweenStops11.add(6.0);
		TimeBetweenStops11.add(7.0);
		TimeBetweenStops11.add(5.0);
		TimeBetweenStops11.add(14.0);
		TimeBetweenStops11.add(13.0);
		TimeBetweenStops11.add(9.0);
		TimeBetweenStops11.add(6.0);
										
		ArrayList<Double> depTimes11 = new ArrayList<Double>();
		depTimes11.add(00.00);
		depTimes11.add(06.30);
		depTimes11.add(10.40);
		depTimes11.add(11.25);
		depTimes11.add(17.00);
		depTimes11.add(20.20);
		depTimes11.add(23.10);
										
		BusLine l11 = new BusLine("11","NEOS SIDIRODROMIKOS STATHMOS",Stops11,TimeBetweenStops11,depTimes11);
		
		
		s1.addBusLine(X1);
		s1.addBusLine(l10);
		s1.addBusLine(l14);
		s1.addBusLine(l17);
		s1.addBusLine(l11);
		
	}
	
}

