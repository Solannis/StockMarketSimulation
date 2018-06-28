/**
 * 
 */
package com.solarionprojects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Mitchell
 *
 */
class StockTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void TestSetStockSymbol () {
		//
		// Tests to perform:
		//	1 - Ensure something not-a-string cannot be sent. Prevented by compiler, not a test.
		//	2 - Ensure parameter value is valid length before setting.
		//	3 - Ensure parameter value is not blank before setting.
		//	4 - Ensure symbol can be set.
		//	5 - Ensure symbol, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		// 2 - Ensure parameter value is valid length before setting.
		//
		assertEquals(false, s.SetStockSymbol(""));				// Too short for min_length = 1
		assertEquals(false, s.SetStockSymbol("HelloWorld"));	// Too long for max_length = 5
		//
		// 3 - Ensure parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockSymbol(""));
		//
		//	4 - Ensure symbol can be set.
		//
		assertEquals(true, s.SetStockSymbol("AAPL"));
		//
		//	5 - Ensure symbol, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockSymbol("AMZN"));
	}
	
	@Test
	void TestGetStockSymbol () {
		//
		// Tests to perform:
		//	1 - Ensure the proper symbol is returned as a string value.
		//
		
		Stock s = new Stock();
		
		boolean pf = s.SetStockSymbol("AAPL");
		assertEquals("AAPL", s.GetStockSymbol());
	}
	
	@Test
	void testStockSectorIsSettable() {
		Stock s = new Stock();
		
		assertEquals(true, s.SetStockSector("Tech"));
		assertEquals(false, s.SetStockSector("Healthcare"));
	}

}
