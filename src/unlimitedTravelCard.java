
public abstract class unlimitedTravelCard {
	
	protected String cardID; 
	protected Passenger passenger;
	protected String Category; //regular or discounted
	
	public unlimitedTravelCard(String cardID, Passenger passenger, String Category) {
		
		this.cardID = cardID;
		this.passenger = passenger;
		this.Category = Category;
	}
	
	public abstract int getCost();
	public abstract String getInfo();
}
