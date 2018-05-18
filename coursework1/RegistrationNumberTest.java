import static org.junit.Assert.*;

import org.junit.Test;

public class RegistrationNumberTest {

	@Test
	public void testGetInstance() {
		assertNotNull(RegistrationNumber.getInstance());
	}

	@Test
	public void testRegistrationNumberStr() {
		RegistrationNumber r = RegistrationNumber.getInstance();
		System.out.println(r.RegistrationNumberStr());
		assertEquals(5, r.RegistrationNumberStr().length());
	}

}
