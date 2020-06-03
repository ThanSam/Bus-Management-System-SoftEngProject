
public class oneWeekCard extends unlimitedTravelCard{
	
	private String purchaseTime;
	
	public oneWeekCard(String cardID, Passenger passenger,String Category, String purchaseTime) {
		
		super(cardID,passenger,Category);
		this.purchaseTime= purchaseTime;
	}
	
	public 	String getCardID() {
		
		return cardID;
	}
	
	public Passenger getPassenger() {
		
		return passenger;
	}
	
	public String getCardsCategory() {
		
		return Category;
	}
	
	public String getWeek() {
		
		String[] parts = purchaseTime.split("/");
		String year = parts[0]; 
		String month = parts[1];
		String day = parts[2];
		
		return (day + " Day of " + month + "/" + year);
	}
	
	public int getCost() {
		
		if(Category.equals("Discounted")) return 6;
		else return 12;
	}
	
	public String getPurchaseTime() {
		return purchaseTime;
	}
	
	public String getDay() {
		
		String[] parts = purchaseTime.split("/");
		String day = parts[2];
		return day;
	}
	
	public String getInfo() {
		
		String[] parts = purchaseTime.split("/");
		String year = parts[0]; 
		String month = parts[1];
		String day = parts[2];
		
		return("Passenger: " + passenger.getInfo() + "\n" +
				"Card: " + cardID + Category + "\n" +
			   "One-Week Card for: " + day + " Day of " + month+ "/" + year);
	}
	
}
