import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

public class LicenceNumberTest {

	@Test
	public void testGetInstance() {
		assertNotNull(LicenceNumber.getInstance(new Date(), "Mike", "Lero"));
	}

	@Test
	public void testGetLicenceNumber() {
		LicenceNumber l = LicenceNumber.getInstance(new Date(), "Mike", "Lero");
		System.out.println(l.getLicenceNumber());
		assertEquals(true, l.getLicenceNumber().contains("ML-2018"));
	}

}
