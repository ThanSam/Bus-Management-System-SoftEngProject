import java.util.ArrayList;

public class Driver {
	private Secretariat sec = new Secretariat();
	private ArrayList<String> driversMessages = new ArrayList<>();

	private String firstname;
	private String lastname;
	private String age;
	private String phoneNumber;
	private String id;
	private String password;	
	
	public Driver(String firstname, String lastname, String age, String phoneNumber,String id, String password, Secretariat sec)	
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.phoneNumber=phoneNumber;
		this.id=id;
		this.password=password;
	    this.sec=sec;
	}

	
	
	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	
	
	public void addMessage(String aMessage) {
		driversMessages.add(aMessage);
	}
	
	public ArrayList<String> getDriverMessages(Driver aDriver) {
		ArrayList<String> DriverMessages = new ArrayList<>();
		for(int i=0; i<driversMessages.size(); i++) {
			int id = Character.getNumericValue(driversMessages.get(i).charAt(0));
			
			
			if(Integer.parseInt(aDriver.getId())==id) {
				DriverMessages.add(driversMessages.get(i));
			}
		}
		for(int i=0; i<DriverMessages.size(); i++) {
			DriverMessages.get(i);
		}
		return DriverMessages;
	}
	
}
