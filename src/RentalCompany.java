import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class store list of cars and override toString method equals method.
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public class RentalCompany {
	private List<Car> smallCars;
	private List<Car> largeCars;
	private Map<Driver,Car> rentMaps;
	/**
	 * Constructor
	 * init small cars and large cars
	 */
	public RentalCompany() {
		smallCars = new ArrayList<>();
		for(int i = 0;i<30;i++) {
			smallCars.add(CarFactory.createCar(CarFactory.SMALL_CAR));
		}
		largeCars = new ArrayList<>();
		for(int i = 0;i<20;i++) {
			largeCars.add(CarFactory.createCar(CarFactory.LARGE_CAR));
		}
		rentMaps = new HashMap<>();
	}
	/**
	 * 
	 * @param typeOfCar the type of car
	 * @return amount of this cars
	 */
	public int availableCars(int typeOfCar) {
		int sum = 0;
		if(typeOfCar == CarFactory.LARGE_CAR) {
			for(Car i : largeCars) {
				if(!i.isRented()) {
					sum++;
				}
			}
		}else if(typeOfCar == CarFactory.SMALL_CAR) {
			for(Car i : smallCars) {
				if(!i.isRented()) {
					sum++;
				}
			}
		}
		return sum;
	}
	/**
	 * 
	 * @return the amount of cars that were rented
	 */
	public List<Car> getRentedCars() {
		List<Car> carList = new ArrayList<>();
		for(Car i : largeCars) {
			if(i.isRented()) {
				carList.add(i);
			}
		}
		for(Car i : smallCars) {
			if(i.isRented()) {
				carList.add(i);
			}
		}
		return carList;
	}
	/**
	 * 
	 * @param drivingLicence which is driver's drivinglicnece 
	 * @return get the rented car
	 */
	public Car getCar(String drivingLicence) {
		return rentMaps.get(drivingLicence);
	}
	/**
	 * rent a car
	 * @param driver which is the people who want to rent car
	 * @param typeOfCar is small car or large car
	 * @return Ture or False 
	 */
	public boolean issueCar(Driver driver,int typeOfCar){
		if(!driver.getLicence().isFullDrivingLicence()){
			return false;
		}
		if(driver.getCar() != null) {
			return false;
		}
		Calendar c = new GregorianCalendar();
		c.setTime(driver.getLicence().getBirth());
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		
		if(typeOfCar == CarFactory.LARGE_CAR) {
			c.add(Calendar.YEAR, 25);
			if(c.compareTo(now)>0) {
				return false;
			}
			c.setTime(driver.getLicence().getIssueDate());
			c.add(Calendar.YEAR, 5);
			if(c.compareTo(now)>0) {
				return false;
			}
		}else if(typeOfCar == CarFactory.SMALL_CAR) {
			c.add(Calendar.YEAR, 21);
			if(c.compareTo(now)>0) {
				return false;
			}
			c.setTime(driver.getLicence().getIssueDate());
			c.add(Calendar.YEAR, 1);
			if(c.compareTo(now)>0) {
				return false;
			}
		}
		Car car = getAvailableCar(typeOfCar);
		car.setRent(true);
		car.addFuelTank();
		driver.setCar(car);
		rentMaps.put(driver, car);
		return true;
	}
	
	private Car getAvailableCar(int typeOfCar) {
		if(typeOfCar == CarFactory.LARGE_CAR) {
			for(Car i : largeCars) {
				if(!i.isRented()) {
					return i;
				}
			}
		}else if(typeOfCar == CarFactory.SMALL_CAR) {
			for(Car i : smallCars) {
				if(!i.isRented()) {
					return i;
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @param driver to return his rent car status
	 */
	public void terminateRental(Driver driver){
		Car car = rentMaps.get(driver);
		car.setRent(false);
		car.addFuelTank();
		car.setFullFuel(true);
		rentMaps.remove(driver);
		driver.setCar(null);
	}
	@Override
	public String toString() {
		return "RentalCompany [smallCars=" + smallCars + ", largeCars=" + largeCars + ", rentMaps=" + rentMaps + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((largeCars == null) ? 0 : largeCars.hashCode());
		result = prime * result + ((rentMaps == null) ? 0 : rentMaps.hashCode());
		result = prime * result + ((smallCars == null) ? 0 : smallCars.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalCompany other = (RentalCompany) obj;
		if (largeCars == null) {
			if (other.largeCars != null)
				return false;
		} else if (!largeCars.equals(other.largeCars))
			return false;
		if (rentMaps == null) {
			if (other.rentMaps != null)
				return false;
		} else if (!rentMaps.equals(other.rentMaps))
			return false;
		if (smallCars == null) {
			if (other.smallCars != null)
				return false;
		} else if (!smallCars.equals(other.smallCars))
			return false;
		return true;
	}
	
}
