
public class oneWeekCard extends unlimitedTravelCard{
	
	private String week;
	private String month;
	private String year;
	
	public oneWeekCard(String cardID, Passenger passenger,String Category, String week , String month, String year) {
		
		super(cardID,passenger,Category);
		this.week = week;
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
	
	public String getWeek() {
		
		return (week + " Week of " + month + "/" + year);
	}
	
	public int getCost() {
		
		if(Category.equals("discounted")) return 5;
		else return 10;
	}
	
	public String getInfo() {
		
		return("Passenger: " + Passenger.getInfo() + "\n" +
				"Card: " + cardID + Category + "\n" +
			   "One-Week Card for: " + week + " Week of " + month+ "/" + year);
	}
	
}
