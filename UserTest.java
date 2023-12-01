package Final;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest extends Customer {

	@Test
	// test to make sure the database stores the correct amount of savings
	void getSavingsTest() {
		assertEquals(100, getSavings("natebro"));
		assertEquals(250, getSavings("aidwi"));
		assertEquals(300, getSavings("aidwi"));
		assertEquals(175, getSavings("therock"));
		
	}
	@Test
	// test to make sure the database stores the correct amount of checking
	void getCheckingTest() {
		assertEquals(100, getChecking("natebro"));
		assertEquals(250, getChecking("aidwi"));
		assertEquals(300, getChecking("aidwi"));
		assertEquals(175, getChecking("therock"));
		
	}

}
