
public class oneMonthCard extends unlimitedTravelCard {
	
	private String month;
	private String year;
	
	
	public oneMonthCard(String cardID, Passenger passenger,String Category, String month, String year) {
		
		super(cardID,passenger,Category);
		this.month = month;
		this.year = year;
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
		
		return (month + "/" + year);
	}

	public int getCost() {
		
		if(Category.equals("discounted")) return 15;
		else return 30;
	}
	
	public String getInfo() {
		
		return("Passenger: " + Passenger.getInfo() + "\n" +
				"Card: " + cardID + Category + "\n" +
			   "One-Month Card for: " + month + "/" + year);
	}
}
