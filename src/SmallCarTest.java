import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SmallCarTest {
	private Car car;
	
	@Before
	public void init() {
		car = CarFactory.createCar(CarFactory.SMALL_CAR);
	}
	
	
	@Test
	public void testDrive() {
		assertEquals(1, car.drive(20));
	}

	@Test
	public void testGetRegistrationNumber() {
		String number = car.getRegistrationNumber();
		System.out.println(number);
		assertEquals(5, number.length());
	}

	@Test
	public void testGetMaxFuelTank() {
		assertEquals(49, car.getMaxFuelTank());
	}

	@Test
	public void testIsFullFuel() {
		assertEquals(true, car.isFullFuel());
		car.drive(23);
		assertEquals(false, car.isFullFuel());
	}

	@Test
	public void testIsRented() {
		assertEquals(false, car.isRented());
	}

}
