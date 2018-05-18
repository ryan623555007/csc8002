import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年3月11日
 *
 */
public class DriverTest {

	private Driver driver = new Driver();
	@Before
	public void init( ){
		Calendar birthCalendar = new GregorianCalendar();
		Calendar issueCalendar = new GregorianCalendar();
		birthCalendar.set(1994, 4, 28);
		issueCalendar.set(2012, 1, 5);
		DrivingLicence drivingLicence = new DrivingLicence("ryan", "corleone",birthCalendar.getTime() ,  issueCalendar.getTime(), true);
	 	driver.setLicence(drivingLicence);
	}
	@Test
	public void testGetLicence() {
		assertNotNull(driver.getLicence());
	}

	@Test
	public void testSetLicence() {
		driver.setLicence(null);
		assertEquals(null, driver.getLicence());
	}

	@Test
	public void testGetCar() {
		assertEquals(null, driver.getCar());
	}


}
