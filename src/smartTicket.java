
public class smartTicket {
	
	private String ticketID;
	private String Category; //regular or discounted
	private BusRoute Route;
	private String purchaseTime;
	
	public smartTicket(String ticketID, String Category, BusRoute Route,String purchaseTime) {
		
		this.ticketID = ticketID;
		this.Category = Category;
		this.Route = Route;
		this.purchaseTime= new String(purchaseTime);
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
	
	public String getPurchaseTime() {
		return purchaseTime;
	}
}

