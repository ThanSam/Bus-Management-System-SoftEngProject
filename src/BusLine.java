import java.util.ArrayList;

public class BusLine {
	

	private String lineID;
	private String startingPoint;
	private ArrayList<String> Stops;
	private ArrayList<Double> TimeBetweenStops;
	private ArrayList<Double> DepartureTimes;
	
	public BusLine(String lineID, String startingPoint, ArrayList<String> Stops, ArrayList<Double> TimeBetweenStops, ArrayList<Double> DepartureTimes) {
		
		this.lineID = lineID;
		this.startingPoint = startingPoint;
		this.Stops = Stops;
		this.TimeBetweenStops = TimeBetweenStops;
		this.DepartureTimes = DepartureTimes;

	}
	
	
	public String getLineID() {
		
		return lineID;
	}
	
	public String getStartingPoint() {
		
		return startingPoint;
	}
	
	public ArrayList<String> getStops() {
		
		return Stops;
	}
	
	public ArrayList<Double> getTimeBetweenStops() {
		
		return TimeBetweenStops;
	}
	
	public ArrayList<Double> getTimes() {
		
		return DepartureTimes; 
	}
	
}