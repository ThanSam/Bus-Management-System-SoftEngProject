

public class Passenger{
		
	//Passenger's data
	private String firstname;
	private String lastname;
	private int age;
	private String phoneNumber;
	private String id;
	private String password;	
	private Secretariat sec;
	

	//Creation of new Passenger
	public Passenger(String firstname,String lastname,int age ,String phoneNumber,String id,String password,Secretariat sec) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.phoneNumber=phoneNumber;
		this.id=id;
		this.password=password;
	    this.sec=sec;
	}

	
	//SetInfo
	public void setInfo(String firstname,String lastname,int age ,String phoneNumber,String password) {//
		if(!firstname.equals(null)) this.firstname=firstname;
		if(!lastname.equals(null)) this.lastname=lastname;
		if(age!=-1)	this.age=age;
		if(!phoneNumber.equals(null)) this.phoneNumber=phoneNumber;
		if(!password.equals(null)) this.password=password;
	}
	
	
	
	//Profile Deletion
	public void deletion() {
		this.firstname=null;
		this.lastname=null;
		this.age=-1;
		this.phoneNumber=null;
		this.id=null;
		this.password=null;
	}
	
	
	public boolean ticketReservation() {
		return true;
	}
	
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	

}

