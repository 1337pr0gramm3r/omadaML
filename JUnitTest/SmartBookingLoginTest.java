import static org.junit.Assert.*;

import org.junit.Test;

public class SmartBookingLoginTest {

	@Test
	public void testLoginData() {
		SmartBookingLogin lintest = new SmartBookingLogin();
		assertEquals("Result", "1", lintest.loginData("adasd", "123"));
	}

}
