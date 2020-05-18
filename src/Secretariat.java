import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Secretariat {

	private String  time;
	private Passenger aPassenger;
	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	private ArrayList<Driver> emergencyList = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers1 = new ArrayList<Driver>();
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private ArrayList<BusLine> busLineList = new ArrayList<BusLine>();
	private ArrayList<BusRoute> busRouteList = new ArrayList<BusRoute>();
	String[][] driverProgramm = new String[10][7];
	String[][] driverline = new String[10][7];
	String[][] messageToDriver = new String[5][100];
    String[][] freeDriver = new String[10][7];
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

	public boolean searchIdDriver(Driver aDriver) {
		for (Driver driver : driverList) {
			if (aDriver.getId().equals(driver.getId()))
				return true;
		}
		return false;
	}

	
	public void addEmergncy(Driver aDriver, String time) {
		int id = Integer.parseInt(aDriver.getId());
		int y = 1;
		boolean flag = false;
		System.out.println(time);
		System.out.println(driverProgramm[id][1]);
		for (y = 1; y <= 7; y++) {
			if (driverProgramm[id][y].equals(time)) {
				String idBusLine = driverline[id][y];
				aDriver.setLineid(idBusLine);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			emergencyList.add(aDriver);
		}

	}

	public void deleteDriverFromEmergancyList(Driver aDriver) {
		for (Driver driver : emergencyList) {
			if (driver == aDriver) {
				emergencyList.remove(aDriver);
				break;
			}
		}

	}

	public ArrayList<Driver> getEmergencyList() {
		return emergencyList;
	}

	public void setTime(String time) {
		this.time=time;
	}
	
	public void addFreeDrivers(Driver aDriver) {
		int y = 0;
        int z=0;
		int id = Integer.parseInt(aDriver.getId());
		for (y = 1; y < 7; y++) {
			if (driverProgramm[id][y] == null) {
			       freeDriver[id][z]=driverProgramm[id][y];
                    z=z+1;
			}
		}
			if(z==6) {
				freeDrivers.add(aDriver);
			}
	
}
	public void check(){
		int y=0;
	   for(Driver driver:freeDrivers) {
		  for (y = 1; y < 7; y++) {
			if (freeDriver[Integer.parseInt(driver.getId())][y] != time) {
				     freeDrivers.add(driver);
				     y=7;
					}
				}
			}
	}

	public void deleteDriverFromFreeDriversList(Driver aDriver) {
		freeDrivers.remove(aDriver);

	}
	public ArrayList<Driver> getFreeDriversList( ) {
		return freeDrivers;

	}

	
	public void addProgramDriverBusLine(int id, String dateMonthYear, String idLine) {
		int y;
		for (y = 1; y <= 7; y++) {
			if (driverProgramm[id][y] != dateMonthYear) {
				if (driverProgramm[id][y] == null) {
					driverProgramm[id][y] = dateMonthYear;
					driverline[id][y] = idLine;
					break;
				}
			}
		}

	}

	public String[][] getList() {
		return driverProgramm;
	}

	public String[][] getDriverLineList() {
		return driverline;
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

		for (y = 1; y <= 7; y++) {
			if (driverProgramm[id][y] != null) {
				list.add(driverProgramm[id][y]);
			}
		}
		return list;
	}

	public void messageListToAllDrivers(String message) {
		int i = 0;

		for (Driver driver : driverList) {
			int id = Integer.parseInt(driver.getId());
			if (messageToDriver[id][i] == null) {
				messageToDriver[id][i] = message;
			} else {
				i = i + 1;
				messageToDriver[id][i] = message;
			}
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

	public void setPassenger(Passenger passenger) {
		for(Passenger p : passengerList) {
			if(p.getId().equals(passenger.getId())) {
				passenger=p;
			}
		}
	}
	
	public void addBusLine(BusLine busLine) {
		busLineList.add(busLine);
	}

	public void deleteBusLine(BusLine busLine) {
		busLineList.remove(busLine);

	}

	public ArrayList<BusLine> getBusLineList() {
		return busLineList;

	}
	
	public void addBusRoute(BusRoute busRoute) {
		busRouteList.add(busRoute);
		
	}
	
	public void deleteBusRoute(BusRoute busRoute) {
		busRouteList.remove(busRoute);
		
	}
	
	public ArrayList<BusRoute> getBusRouteList() {
		return busRouteList;
	}

}
