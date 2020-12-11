import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.time.format.DateTimeFormatter;

public class Secretariat {

	private String time;

	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	private ArrayList<Driver> emergencyList = new ArrayList<Driver>();
	private ArrayList<Driver> freeDrivers = new ArrayList<Driver>();
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private ArrayList<BusLine> busLineList = new ArrayList<BusLine>();
	private ArrayList<BusRoute> busRouteList = new ArrayList<BusRoute>();
	private ArrayList<unlimitedTravelCard> cardsList = new ArrayList<unlimitedTravelCard>();
	private ArrayList<smartTicket> ticketsList = new ArrayList<smartTicket>();

	private double ticketPrice = 0.2;
	private double weeklyCardPrice = 12;
	private double monthlyCardPrice = 44;

	String[][] driverProgram = new String[10][7];
	String[][] driverline = new String[10][7];
	String[][] messageToDriver = new String[5][100];
	String[][] messageToPassenger = new String[10][100];
	String[][] freeDriver = new String[10][7];

	// All Function About Drivers(Create,Delete,Search,ReturnListswithIds).
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

//Add in EmergencyList if Driver Press EmergencyButton.
	public void addEmergncy(Driver aDriver, String time) {
		int id = Integer.parseInt(aDriver.getId());
		int y = 1;
		boolean flag = false;
		for (y = 1; y <= 7; y++) {
			if (driverProgram[id][y].equals(time)) {
				String idBusLine = driverline[id][y];
				aDriver.setLineid(idBusLine);
				flag = true;
				break;
			}
		}
		if (flag == true) {
			getEmergencyTime();
			emergencyList.add(aDriver);
		}

	}

	public String getEmergencyTime() {
		return time;
	}

	public ArrayList<Driver> getEmergencyList() {
		return emergencyList;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void deleteDriverFromEmergancyList(Driver aDriver) {
		for (Driver driver : emergencyList) {
			if (driver == aDriver) {
				emergencyList.remove(aDriver);
				break;
			}
		}

	}

//When Create one Driver we put him in FreeDriverList.If Secretariat add in his program a new route we delete from freeDriversList.
	public void addFreeDrivers(Driver aDriver) {
		int y = 0;
		int z = 0;
		int id = Integer.parseInt(aDriver.getId());
		for (y = 1; y < 7; y++) {
			if (driverProgram[id][y] == null) {
				freeDriver[id][z] = driverProgram[id][y];
				z = z + 1;
			}
		}
		if (z == 6) {
			freeDrivers.add(aDriver);
		}

	}

	// Check if Driver has programm.if not add him in freeDriverList
	public void check() {
		int y = 0;
		for (Driver driver : freeDrivers) {
			for (y = 1; y < 7; y++) {
				if (freeDriver[Integer.parseInt(driver.getId())][y] != time) {
					freeDrivers.add(driver);
					y = 7;
				}
			}
		}
	}

	// delete driver from FReeDriversList
	public void deleteDriverFromFreeDriversList(Driver aDriver) {
		freeDrivers.remove(aDriver);

	}

	// Return FreeDriverList.
	public ArrayList<Driver> getFreeDriversList() {
		return freeDrivers;

	}

	// Add a new Program in Driver.
	public void addProgramDriverBusLine(int id, String dateMonthYear, String idLine) {
		int y;
		for (y = 1; y <= 7; y++) {
			if (driverProgram[id][y] != dateMonthYear) {
				if (driverProgram[id][y] == null) {
					driverProgram[id][y] = dateMonthYear;
					driverline[id][y] = idLine;
					break;
				}
			}
		}

	}

	// Return Drivers Program.
	public String[][] getList() {
		return driverProgram;
	}

	public String[][] getDriverLineList() {
		return driverline;
	}

	// Delete Driver's program.
	public boolean deleteProgramDriver(int id, String dateMonthYear) {
		int day = 0;
		for (day = 1; day <= 7; day++) {
			if (driverProgram[id][day] == null) {
				return true;
			} else {
				driverProgram[id][day] = null;
			}
		}
		return false;
	}

//Return Specific Driver Program.
	public ArrayList<String> getSpecificDriverProgramm(int aDriverId) {
		int y = 0;
		ArrayList<String> list = new ArrayList<String>();

		for (y = 1; y <= 7; y++) {
			if (driverProgram[aDriverId][y] != null) {
				list.add(driverProgram[aDriverId][y]);
			}
		}
		return list;
	}

	// Send Message to allDrivers
	public void messageListToAllDrivers(String message) {
		for (Driver driver : driverList) {
			int id = Integer.parseInt(driver.getId());
			for (int i = 0; i < messageToDriver.length; i++) {
				if (messageToDriver[id][i] == null) {
					messageToDriver[id][i] = message;
					break;
				}

			}
		}
	}

	// Return message DriverList.
	public String[][] getMessageListDriver() {
		return messageToDriver;
	}

	// Message to specific Driver
	public void messageListToDriver(int id, String message) {

		for (int i = 0; i < messageToDriver.length; i++) {
			if (messageToDriver[id][i] == null) {
				messageToDriver[id][i] = message;
				break;
			}

		}

	}

	// Message to specific Passenger
	public void messageListToPassenger(int id, String message) {
		for (int i = 0; i < messageToPassenger.length; i++) {
			if (messageToPassenger[id][i] == null) {
				messageToPassenger[id][i] = message;
				break;
			}

		}

	}

	// Message to all Drivers
	public void messageListToAllPassenger(String message) {
		for (Passenger passenger : passengerList) {
			int id = Integer.parseInt(passenger.getId());
			for (int i = 0; i < messageToPassenger.length; i++) {
				if (messageToPassenger[id][i] == null) {
					messageToPassenger[id][i] = message;
					break;
				}

			}
		}
	}

	// Return all passenger's messages.
	public String[][] getÌessageListToPassenger() {
		return messageToPassenger;
	}

	// Add Passenger from passengerList
	public void addPassenger(Passenger pas) {
		passengerList.add(pas);
	}

	// Delete Driver from passengerList
	public void deletePassenger(Passenger pas) {
		passengerList.remove(pas);

	}

	// Return PassegerList
	public ArrayList<Passenger> getPassengerList() {
		return passengerList;

	}

	public void setPassenger(Passenger passenger) {
		for (Passenger p : passengerList) {
			if (p.getId().equals(passenger.getId())) {
				passenger = p;
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

	public ArrayList<BusRoute> getBusyRoutes() {

		ArrayList<BusRoute> busyRoutes = new ArrayList<BusRoute>();

		for (BusRoute route : busRouteList) {
			if (route.getTotalPassenger() > 30) {
				busyRoutes.add(route);
			}
		}

		return busyRoutes;
	}

	public double getPrice(int i) {
		switch (i) {
		case 1:
			return this.ticketPrice;
		case 2:
			return this.weeklyCardPrice;
		case 3:
			return this.monthlyCardPrice;
		default:
			return 0;
		}

	}

	public String getCardID(Passenger passenger) {
		Random random = new Random();
		return passenger.getId() + Integer.toString(random.nextInt());
	}

	public void addTicketsList(smartTicket s1) {

		ticketsList.add(s1);

		String timeStamp = new SimpleDateFormat("yyyy/MM/dd--HH:mm:ss").format(Calendar.getInstance().getTime());

		String[] timeTable = timeStamp.split("/");
		String currentDay = timeTable[2];

		for (smartTicket s : ticketsList) {

			String[] parts = s.getPurchaseTime().split("/");
			String day = parts[2];

			if (Math.abs(Integer.valueOf(day) - Integer.valueOf(currentDay)) >= 1)
				ticketsList.remove(s);
		}
	}

	public void addCardsList(unlimitedTravelCard card) {

		String timeStamp = new SimpleDateFormat("yyyy/MM/dd--HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeTable = timeStamp.split("/");
		String currentMonth = timeTable[1];
		String currentDay = timeTable[2];

		cardsList.add(card);
		for (unlimitedTravelCard c : cardsList) {

			if (c.getCost() == monthlyCardPrice) {

				String[] parts = ((oneMonthCard) c).getPurchaseTime().split("/");
				String month = parts[1];

				if (Math.abs((Integer.valueOf(month) - Integer.valueOf(currentMonth))) >= 2)
					cardsList.remove(c);
			}

			else {

				String[] parts = ((oneWeekCard) c).getPurchaseTime().split("/");
				String day = parts[2];

				if (Math.abs((Integer.valueOf(day) - Integer.valueOf(currentDay))) > 7)
					cardsList.remove(c);
			}

		}

	}
}
