
public class smartTicket {
	
	private String ticketID;
	private String Category; //regular or discounted
	private BusRoute Route;
	private String startingStop;
	private String destinationStop;
	
	public smartTicket(String ticketID, String Category, BusRoute Route, String startingStop, String destinationStop) {
		
		this.ticketID = ticketID;
		this.Category = Category;
		this.Route = Route;
		this.startingStop = new String(startingStop);
		this.destinationStop = new String(destinationStop);
	}
	
	public String getTicketID() {
		
		return ticketID;
	}
	
	public String getCategory() {
		
		return Category; 
	}
	
	public BusRoute getRoute() {
		
		return Route;
	}
	
	public double getCost() {
		

		double cost=0;
		boolean flag=false;
		
		for(String stop: Route.getLine().getStops()) {
			
			if(stop.equals(startingStop)) flag=true;
			if(flag) cost ++;
			if(stop.equals(destinationStop)) {
				flag=false;
				break;
			}
			
		if(Category.equals("discounted")) return (cost*0.2);
		else if(Category.equals("regular")) return (cost*0.5);
			
		}
		return cost;
	}
}

