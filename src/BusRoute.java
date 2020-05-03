import java.util.ArrayList;

public class BusRoute {
	
	private BusLine Line;
	private double DepartureTime;
	private int currPassengers;
	private int totalPassengers;
	private Bus bus;
	
	public BusRoute(BusLine Line,double DepartureTime, Bus bus) {
		
		this.Line = Line;
		this.DepartureTime = DepartureTime;
		this.currPassengers = 0;
		this.totalPassengers = 0;
		this.bus=bus;
	}
	
	public void addPassenger() {
		
		if(currPassengers<bus.getCapacity()) {
			
			currPassengers ++;
			totalPassengers ++;
		}
			
	}
	
	public void setNumOfPassengers(int passengers) {
		
		if(passengers<bus.getCapacity())
			this.currPassengers = passengers;
			this.totalPassengers += passengers;
	}
	
	public static ArrayList<BusRoute> initiateBusRoutes() {
		
		//Initiate buses.
		ArrayList<Bus> buses = new ArrayList<Bus>();
		buses.add(new Bus("B1",35));
		buses.add(new Bus("B2",35));
		buses.add(new Bus("B3",35));
		buses.add(new Bus("B4",35));
		buses.add(new Bus("B5",35));
		
		//Initiate bus routes.
		ArrayList<BusRoute> BusRoutes = new ArrayList<BusRoute>();
		
		int bus = 0;
	
		for(BusLine line: BusLine.initiateBusLines()) {
			for(double time: line.getTimes())
				BusRoutes.add(new BusRoute(line,time,buses.get(bus)));
			bus++;
		}
		
		return BusRoutes;
	}
	

	public BusLine getLine() {
		
		return Line;
	}
	
	public double getDepartureTime() {
		
		return DepartureTime;
	}
	
	public Bus getBus() {
		
		return bus;
	}
	
	public int getCurrNumOfPassengers() {
		
		return currPassengers;
	}
	
	public int getTotalPassenger() {
		
		return totalPassengers;
	}
	public void removePassenger() {
		currPassengers --;
	}
	
}
