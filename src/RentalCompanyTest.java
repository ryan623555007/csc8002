import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class RentalCompanyTest{
	private RentalCompany company;
	private Calendar birthCalendar;
	private Calendar issueCalendar;
	private Driver driver = new Driver();
	private Driver driver2 = new Driver();
	@Before
	public void init( ){
		company = new RentalCompany();
		birthCalendar = new GregorianCalendar();
		issueCalendar = new GregorianCalendar();
		birthCalendar.set(1992, 11, 2);
		issueCalendar.set(2017, 0, 5);
		DrivingLicence drivingLicence = new DrivingLicence("Mike", "Blue",birthCalendar.getTime() ,  issueCalendar.getTime(), true);
		driver.setLicence(drivingLicence);
		
		birthCalendar.set(1992, 11, 2);
		issueCalendar.set(2012, 0, 5);
		driver2.setLicence(new DrivingLicence("Timo", "Blue",birthCalendar.getTime() , issueCalendar.getTime(), true));
	}
	@Test
	public void testRentCar() {
		boolean flag = company.issueCar(driver, CarFactory.SMALL_CAR);
		assertEquals(true,flag);
		assertEquals(false,company.issueCar(driver, CarFactory.LARGE_CAR));
		company.terminateRental(driver);
		assertEquals(null,driver.getCar());
		flag = company.issueCar(driver, CarFactory.LARGE_CAR);
		assertEquals(false,flag);
	}
	@Test
	public void testDriver() {
		company.issueCar(driver, CarFactory.SMALL_CAR);
		Car car = driver.getCar();
		int drive = car.drive(20);
		assertEquals(1, drive);
		assertEquals(car.getCurrentFuelTank(), car.drive(2000000));
	}
	@Test
	public void testRentLargeCar() {
		boolean flag = company.issueCar(driver2, CarFactory.LARGE_CAR);
		assertEquals(true,flag);
		Car car = driver2.getCar();
		int drive = car.drive(20);
		assertEquals(2, drive);
		assertEquals(car.getCurrentFuelTank(), car.drive(2000000));
	}
}
