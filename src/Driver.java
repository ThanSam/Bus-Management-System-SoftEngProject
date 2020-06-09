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
	private String idBusLine;

	// Constructor for Driver
	public Driver(String firstname, String lastname, String age, String phoneNumber, String id, String password,
			Secretariat sec) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.password = password;
		this.sec = sec;
	}

	// Return First Name
	public String getFirstname() {
		return firstname;
	}

	// Set First Name
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	// Set last Name
	public String getLastname() {
		return lastname;
	}

	// Set Last Name
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	// Return Age
	public String getAge() {
		return age;
	}

	// Set Age
	public void setAge(String age) {
		this.age = age;
	}

	// Return PhoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

     //Set PhoneNumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    // Return Driver Id
	public String getId() {
		return id;
	}

    //Set Driver Id
	public void setId(String id) {
		this.id = id;
	}

    //Return Driver Password
	public String getPassword() {
		return password;
	}

	// Set Driver Password
	public void setPassword(String password) {
		this.password = password;
	}

	// Set Line Id
	public void setLineid(String idbusline) {
		this.idBusLine = idbusline;
	}

	// Return Line Id
	public String getLineid() {
		return idBusLine;
	}

	// Add Message to Driver
	public void addMessage(String aMessage) {
		driversMessages.add(aMessage);
	}

	// Return ArrayListMessagesDriver
	public ArrayList<String> getDriverMessages(Driver aDriver) {

		ArrayList<String> DriverMessages = new ArrayList<>();

		for (int i = 0; i < driversMessages.size(); i++) {
			int id = Character.getNumericValue(driversMessages.get(i).charAt(0));

			if (Integer.parseInt(aDriver.getId()) == id) {
				DriverMessages.add(driversMessages.get(i));
			}
		}

		for (int i = 0; i < DriverMessages.size(); i++) {
			DriverMessages.get(i);
		}

		return DriverMessages;
	}

}
