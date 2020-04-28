import java.util.ArrayList;

public class Secretariat {

	private Passenger aPassenger;
	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	private ArrayList<Driver> emergencyList = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers = new ArrayList<Driver>();
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	String[][] driverProgramm = new String[10][7];
	String[][] messageToDriver = new String[5][100];

	public Secretariat() {

	}

	public void addDriver(Driver aDriver) {
		driverList.add(aDriver);

	}

	public void deleteDriver(Driver aDriver) {

		for (Driver driver : driverList) {
			if (aDriver.equals(driver)) {
				driverList.remove(aDriver);
			}
		}

	}

	public ArrayList<Driver> getDriverList() {
		return driverList;
	}

	public void addEmergncy(Driver aDriver) {
		for (Driver driver : driverList) {
			emergencyList.add(driver);
		}
	}

	public ArrayList<Driver> getEmergencyList() {
		return emergencyList;
	}

	public boolean searchIdDriver(Driver aDriver) {
		for (Driver driver : driverList) {
			if (aDriver.getId().equals(driver.getId()))
				return true;
		}
		return false;
	}

	public void checkIfDriverHasProgramm(Driver aDriver) {
		int y = 0;
		int id = Integer.parseInt(aDriver.getId());
		for (y = 0; y < 7; y++) {
			if (driverProgramm[id][y] == null) {
				freeDrivers.add(aDriver);
			}
		}

	}

	public void addProgramDriver(int id, String dateMonthYear) {
		int y;
		for (y = 1; y <= 7; y++) {
			if (driverProgramm[id][y] != dateMonthYear) {
				if (driverProgramm[id][y] == null) {
					driverProgramm[id][y] = dateMonthYear;
					break;
				}
			}
		}

	}
	
	
	public boolean deleteProgramDriver(int id, String dateMonthYear) {
		int day = 0;

		if (driverProgramm[id][day] == null) {
			return true;
		} else {
			driverProgramm[id][day] = null;
		}
		return false;
	}

	
	
	
	public ArrayList<String> getSpecificDriverProgramm(int aDriverId) {
		int id = aDriverId;
		int y = 0;
		ArrayList<String> list = new ArrayList<String>();

		for (y = 0; y < 7; y++) {
			if (driverProgramm[id][y] != null) {
				list.add(driverProgramm[id][y]);
			}
		}
		return list;
	}

	

	public ArrayList<Driver> getFreeDriverList() {
		return freeDrivers;
	}
	
	
	public String[][] getList() {
		return driverProgramm;
	}
	
	
	 public void messageListToAllDrivers(String message) { 
        int i = 0; 
        
	  for (Driver driver : driverList) { 
	  int id = Integer.parseInt(driver.getId());
	  if (messageToDriver[id][i] == null) {
	      messageToDriver[id][i] = message; } 
	   else { i = i + 1; messageToDriver[id][i] = message; } 
	  }
	  } 


	public String[][] getMessageListDriver() {
		return messageToDriver;
	}
	
	
	public void messageListToDriver(int id, String message) {
		int i = 0;
		if (messageToDriver[id][i] == null) {
			messageToDriver[id][i] = message;
		} else {
			i = i + 1;
			messageToDriver[id][i] = message;
		}
	}
	
	
	
	
	

	public void addPassenger(Passenger pas) {
		passengerList.add(pas);
	}

	public void deletePassenger(Passenger pas) {
		passengerList.remove(pas);

	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;

	}

	
	


	

}
