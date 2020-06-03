
public class oneMonthCard extends unlimitedTravelCard {
	
	private String purchaseTime;
	
	
	public oneMonthCard(String cardID, Passenger passenger,String Category, String purchaseTime) {
		
		super(cardID,passenger,Category);
		this.purchaseTime=purchaseTime;
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
	
	public String getMonth() {
		
		String[] parts = purchaseTime.split("/");
		String year = parts[0]; 
		String month = parts[1];
		String day = parts[2];
		return (day+"/"+month + "/" + year);
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}
	
	public int getCost() {
		
		if(Category.equals("discounted")) return 22;
		else return 44;
	}
	
	public String getInfo() {
		
		String[] parts = purchaseTime.split("/");
		String year = parts[0]; 
		String month = parts[1];
		String day = parts[2];
		
		return("Passenger: " + passenger.getInfo() + "\n" +
				"Card: " + cardID + Category + "\n" +
			   "One-Month Card for: "+ day + "/"+month + "/" + year);
	}
}
