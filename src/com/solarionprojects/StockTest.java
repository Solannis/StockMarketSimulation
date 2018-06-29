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
 * @author Mitchell Freeman
 *
 */
class StockTest {
	
	private static final String EMPTY_STRING = "";
	private static final String TEST_STOCK_SYMBOL = "AAPL";
	private static final String TEST_STOCK_SECTOR = "Technology";
	private static final String TEST_STOCK_EXCHANGE = "NASDAQ";
	private static final String TEST_STOCK_FULL_NAME = "Apple, Inc.";
	private static final String TEST_STOCK_DESCRIPTION = "Apple, Inc. common stock";
	
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

	//-----------------------
	// TEST SET: stockSymbol
	//-----------------------
	
	@Test
	void TestSetStockSymbol () {
		//
		// Tests to perform:
		//	1 - Ensure symbol parameter value is valid length before setting.
		//	2 - Ensure symbol parameter value is not blank before setting.
		//	3 - Ensure symbol attribute can be set.
		//	4 - Ensure symbol attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		//	1 - Ensure symbol parameter value is valid length before setting.
		//
		assertEquals(false, s.SetStockSymbol(EMPTY_STRING));		// Too short for min_length = 1
		assertEquals(false, s.SetStockSymbol("HelloWorld"));		// Too long for max_length = 5
		//
		//	2 - Ensure symbol parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockSymbol(EMPTY_STRING));		// Cannot be an empty string
		//
		//	3 - Ensure symbol attribute can be set.
		//
		assertEquals(true, s.SetStockSymbol(TEST_STOCK_SYMBOL));	// Should allow symbol to be set.
		//
		//	4 - Ensure symbol attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockSymbol("AMZN"));				// Should NOT allow symbol to be set.
	}
	
	@Test
	void TestGetStockSymbol () {
		//
		// Tests to perform:
		//	1 - Ensure the correct symbol is returned.
		//
		
		Stock s = new Stock();
		s.SetStockSymbol(TEST_STOCK_SYMBOL);

		//
		//	1 - Ensure the correct symbol is returned.
		//
		assertEquals(TEST_STOCK_SYMBOL, s.GetStockSymbol());
	}
	
	//-----------------------
	// TEST SET: stockSector
	//-----------------------
	
	@Test
	void TestSetStockSector() {
		//
		// Tests to perform:
		//	1 - Ensure sector parameter value is not blank before setting.
		//	2 - Ensure sector attribute can be set.
		//	3 - Ensure sector attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure sector parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockSector(EMPTY_STRING));
		//
		//	2 - Ensure sector attribute can be set.
		//
		assertEquals(true, s.SetStockSector(TEST_STOCK_SECTOR));
		//
		//	3 - Ensure sector attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockSector("Healthcare"));
	}

	@Test
	void TestGetStockSector () {
		//
		// Tests to perform:
		//	1 - Ensure the correct sector is returned.
		//
		
		Stock s = new Stock();
		s.SetStockSector(TEST_STOCK_SECTOR);

		//
		//	1 - Ensure the correct sector is returned.
		//
		assertEquals(TEST_STOCK_SECTOR, s.GetStockSector());
	}
	
	//-------------------------
	// TEST SET: stockExchange
	//-------------------------
	
	@Test
	void TestSetStockExchange() {
		//
		// Tests to perform:
		//	1 - Ensure exchange parameter value is not blank before setting.
		//	2 - Ensure exchange attribute can be set.
		//	3 - Ensure exchange attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure exchange parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockExchange(EMPTY_STRING));
		//
		//	2 - Ensure exchange attribute can be set.
		//
		assertEquals(true, s.SetStockExchange(TEST_STOCK_EXCHANGE));
		//
		//	3 - Ensure exchange attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockExchange("DOW JONES"));
	}

	@Test
	void TestGetStockExchange () {
		//
		// Tests to perform:
		//	1 - Ensure the correct exchange is returned.
		//
		
		Stock s = new Stock();
		s.SetStockExchange(TEST_STOCK_EXCHANGE);

		//
		//	1 - Ensure the correct exchange is returned.
		//
		assertEquals(TEST_STOCK_EXCHANGE, s.GetStockExchange());
	}
	
	//-------------------------
	// TEST SET: stockFullName
	//-------------------------
	
	@Test
	void TestSetStockFullName() {
		//
		// Tests to perform:
		//	1 - Ensure full name parameter value is not blank before setting.
		//	2 - Ensure full name attribute can be set.
		//	3 - Ensure full name attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure full name parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockFullName(EMPTY_STRING));
		//
		//	2 - Ensure full name attribute can be set.
		//
		assertEquals(true, s.SetStockFullName(TEST_STOCK_FULL_NAME));
		//
		//	3 - Ensure full name attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockFullName("Amazon.com, Inc."));
	}

	@Test
	void TestGetStockFullName () {
		//
		// Tests to perform:
		//	1 - Ensure the correct full name is returned.
		//
		
		Stock s = new Stock();
		s.SetStockFullName(TEST_STOCK_FULL_NAME);

		//
		//	1 - Ensure the correct full name is returned.
		//
		assertEquals(TEST_STOCK_FULL_NAME, s.GetStockFullName());
	}
	
	//-------------------------
	// TEST SET: stockDescription
	//-------------------------
	
	@Test
	void TestSetStockDescription() {
		//
		// Tests to perform:
		//	1 - Ensure description parameter value is not blank before setting.
		//	2 - Ensure description attribute can be set.
		//	3 - Ensure description attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure description parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockDescription(EMPTY_STRING));
		//
		//	2 - Ensure description attribute can be set.
		//
		assertEquals(true, s.SetStockDescription(TEST_STOCK_DESCRIPTION));
		//
		//	3 - Ensure description attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockDescription("Amazon.com, Inc. common stock"));
	}

	@Test
	void TestGetStockDescription () {
		//
		// Tests to perform:
		//	1 - Ensure the correct description is returned.
		//
		
		Stock s = new Stock();
		s.SetStockDescription(TEST_STOCK_DESCRIPTION);

		//
		//	1 - Ensure the correct description is returned.
		//
		assertEquals(TEST_STOCK_DESCRIPTION, s.GetStockDescription());
	}
	

}
