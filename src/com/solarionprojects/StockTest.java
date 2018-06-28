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
	void testStockSymbolIsSettable() {
		Stock s = new Stock();
		
		// need to try a test that sends something not a string, see how that reacts.
		assertEquals(true, s.SetStockSymbol("AAPL"));
		assertEquals(false, s.SetStockSymbol("AMZN"));
		//fail("Not yet implemented");
	}
	
	@Test
	void testStockSectorIsSettable() {
		Stock s = new Stock();
		
		assertEquals(true, s.SetStockSector("Tech"));
		assertEquals(false, s.SetStockSector("Healthcare"));
	}

}
