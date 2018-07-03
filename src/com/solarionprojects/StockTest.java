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
	
	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================

	private static final String EMPTY_STRING = "";
	private static final String TEST_STOCK_SYMBOL = "AAPL";
	private static final String TEST_STOCK_SECTOR = "Technology";
	private static final String TEST_STOCK_EXCHANGE = "NASDAQ";
	private static final String TEST_STOCK_FULL_NAME = "Apple, Inc.";
	private static final String TEST_STOCK_DESCRIPTION = "Apple, Inc. common stock";
	private static final float FLOAT_NEGATIVE = -9.99f;
	private static final float FLOAT_ZERO = 0.0f;
	private static final float FLOAT_POSITIVE = 99.99f;
	private static final int INT_NEGATIVE = -9;
	private static final int INT_ZERO = 0;
	private static final int INT_POSITIVE = 99;
	
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
	void TestSetStockSector () {
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
	void TestSetStockExchange () {
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
	void TestSetStockFullName () {
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
	
	//----------------------------
	// TEST SET: stockDescription
	//----------------------------
	
	@Test
	void TestSetStockDescription () {
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
	
	//-----------------------------
	// TEST SET: stockCurrentPrice
	//-----------------------------
	
	@Test
	void TestSetStockCurrentPrice () {
		//
		// Tests to perform:
		//	1 - Ensure current price attribute cannot be a set as a negative value.
		//	2 - Ensure current price attribute can be set as zero (0.0f).
		//	3 - Ensure current price attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPrice(FLOAT_NEGATIVE));
		//
		//	2 - Ensure current price attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockCurrentPrice(FLOAT_ZERO));
		//
		//	3 - Ensure current price attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPrice(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPrice () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price 0.0f is returned.
		//	2 - Ensure the correct current price 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price 0.0f is returned.
		//
		assertEquals(true, s.SetStockCurrentPrice(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockCurrentPrice());
		//
		//	2 - Ensure the correct current price 99.99f is returned.
		//
		assertEquals(true, s.SetStockCurrentPrice(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockCurrentPrice());
	}
	
	//--------------------------------
	// TEST SET: stockCurrentPriceAsk
	//--------------------------------
	
	@Test
	void TestSetStockCurrentPriceAsk () {
		//
		// Tests to perform:
		//	1 - Ensure current price ask attribute cannot be a set as a negative value.
		//	2 - Ensure current price ask attribute can be set as zero (0.0f).
		//	3 - Ensure current price ask attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price ask attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPriceAsk(FLOAT_NEGATIVE));
		//
		//	2 - Ensure current price ask attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(FLOAT_ZERO));
		//
		//	3 - Ensure current price ask attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPriceAsk () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price ask 0.0f is returned.
		//	2 - Ensure the correct current price ask 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price ask 0.0f is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockCurrentPriceAsk());
		//
		//	2 - Ensure the correct current price ask 99.99f is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockCurrentPriceAsk());
	}
	
	//--------------------------------
	// TEST SET: stockCurrentPriceBid
	//--------------------------------
	
	@Test
	void TestSetStockCurrentPriceBid () {
		//
		// Tests to perform:
		//	1 - Ensure current price bid attribute cannot be a set as a negative value.
		//	2 - Ensure current price bid attribute can be set as zero (0.0f).
		//	3 - Ensure current price bid attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price bid attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPriceBid(FLOAT_NEGATIVE));
		//
		//	2 - Ensure current price bid attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockCurrentPriceBid(FLOAT_ZERO));
		//
		//	3 - Ensure current price bid attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPriceBid () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price bid 0.0f is returned.
		//	2 - Ensure the correct current price bid 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price bid 0.0f is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockCurrentPriceBid());
		//
		//	2 - Ensure the correct current price bid 99.99f is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockCurrentPriceBid());
	}
	
	//-----------------------------
	// TEST SET: stockSessionClose
	//-----------------------------
	
	@Test
	void TestSetStockSessionClose () {
		//
		// Tests to perform:
		//	1 - Ensure session close attribute cannot be a set as a negative value.
		//	2 - Ensure session close attribute can be set as zero (0.0f).
		//	3 - Ensure session close attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session close attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionClose(FLOAT_NEGATIVE));
		//
		//	2 - Ensure session close attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockSessionClose(FLOAT_ZERO));
		//
		//	3 - Ensure session close attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionClose(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockSessionClose () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session close 0.0f is returned.
		//	2 - Ensure the correct session close 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session close 0.0f is returned.
		//
		assertEquals(true, s.SetStockSessionClose(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockSessionClose());
		//
		//	2 - Ensure the correct session close 99.99f is returned.
		//
		assertEquals(true, s.SetStockSessionClose(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockSessionClose());
	}
	
	//-------------------------------------
	// TEST SET: stockSessionClosePrevious
	//-------------------------------------
	
	@Test
	void TestSetStockSessionClosePrevious () {
		//
		// Tests to perform:
		//	1 - Ensure session close previous attribute cannot be a set as a negative value.
		//	2 - Ensure session close previous attribute can be set as zero (0.0f).
		//	3 - Ensure session close previous attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session close previous attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionClosePrevious(FLOAT_NEGATIVE));
		//
		//	2 - Ensure session close previous attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockSessionClosePrevious(FLOAT_ZERO));
		//
		//	3 - Ensure session close previous attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockSessionClosePrevious () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session close previous 0.0f is returned.
		//	2 - Ensure the correct session close previous 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session close previous 0.0f is returned.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockSessionClosePrevious());
		//
		//	2 - Ensure the correct session close previous 99.99f is returned.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockSessionClosePrevious());
	}
	
	//-----------------------------
	// TEST SET: stockSessionHigh
	//-----------------------------
	
	@Test
	void TestSetStockSessionHigh () {
		//
		// Tests to perform:
		//	1 - Ensure session high attribute cannot be a set as a negative value.
		//	2 - Ensure session high attribute can be set as zero (0.0f).
		//	3 - Ensure session high attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session high attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionHigh(FLOAT_NEGATIVE));
		//
		//	2 - Ensure session high attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockSessionHigh(FLOAT_ZERO));
		//
		//	3 - Ensure session high attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionHigh(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockSessionHigh () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session high 0.0f is returned.
		//	2 - Ensure the correct session high 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session high 0.0f is returned.
		//
		assertEquals(true, s.SetStockSessionHigh(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockSessionHigh());
		//
		//	2 - Ensure the correct session high 99.99f is returned.
		//
		assertEquals(true, s.SetStockSessionHigh(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockSessionHigh());
	}
	
	//-----------------------------
	// TEST SET: stockSessionLow
	//-----------------------------
	
	@Test
	void TestSetStockSessionLow () {
		//
		// Tests to perform:
		//	1 - Ensure session low attribute cannot be a set as a negative value.
		//	2 - Ensure session low attribute can be set as zero (0.0f).
		//	3 - Ensure session low attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session low attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionLow(FLOAT_NEGATIVE));
		//
		//	2 - Ensure session low attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockSessionLow(FLOAT_ZERO));
		//
		//	3 - Ensure session low attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionLow(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockSessionLow () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session low 0.0f is returned.
		//	2 - Ensure the correct session low 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session low 0.0f is returned.
		//
		assertEquals(true, s.SetStockSessionLow(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockSessionLow());
		//
		//	2 - Ensure the correct session low 99.99f is returned.
		//
		assertEquals(true, s.SetStockSessionLow(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockSessionLow());
	}
	
	//-----------------------------
	// TEST SET: stockSessionOpen
	//-----------------------------
	
	@Test
	void TestSetStockSessionOpen () {
		//
		// Tests to perform:
		//	1 - Ensure session open attribute cannot be a set as a negative value.
		//	2 - Ensure session open attribute can be set as zero (0.0f).
		//	3 - Ensure session open attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session open attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionOpen(FLOAT_NEGATIVE));
		//
		//	2 - Ensure session open attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockSessionOpen(FLOAT_ZERO));
		//
		//	3 - Ensure session open attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionOpen(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockSessionOpen () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session open 0.0f is returned.
		//	2 - Ensure the correct session open 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session open 0.0f is returned.
		//
		assertEquals(true, s.SetStockSessionOpen(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockSessionOpen());
		//
		//	2 - Ensure the correct session open 99.99f is returned.
		//
		assertEquals(true, s.SetStockSessionOpen(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockSessionOpen());
	}
	
	//-------------------------
	// TEST SET: stockYearHigh
	//-------------------------
	
	@Test
	void TestSetStockYearHigh () {
		//
		// Tests to perform:
		//	1 - Ensure year high attribute cannot be a set as a negative value.
		//	2 - Ensure year high attribute can be set as zero (0.0f).
		//	3 - Ensure year high attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure year high attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockYearHigh(FLOAT_NEGATIVE));
		//
		//	2 - Ensure year high attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_ZERO));
		//
		//	3 - Ensure year high attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockYearHigh () {
		//
		// Tests to perform:
		//	1 - Ensure the correct year high 0.0f is returned.
		//	2 - Ensure the correct year high 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct year high 0.0f is returned.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockYearHigh());
		//
		//	2 - Ensure the correct year high 99.99f is returned.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockYearHigh());
	}
	
	//------------------------
	// TEST SET: stockYearLow
	//------------------------
	
	@Test
	void TestSetStockYearLow () {
		//
		// Tests to perform:
		//	1 - Ensure year low attribute cannot be a set as a negative value.
		//	2 - Ensure year low attribute can be set as zero (0.0f).
		//	3 - Ensure year low attribute can be set as a positive value.
		//	4 - Ensure year low attribute cannot be set above year high attribute.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure year low attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockYearLow(FLOAT_NEGATIVE));
		//
		//	2 - Ensure year low attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockYearLow(FLOAT_ZERO));
		//
		//	3 - Ensure year low attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_POSITIVE));
		assertEquals(true, s.SetStockYearLow(FLOAT_POSITIVE));
		//
		//	4 - Ensure year low attribute cannot be set above year high attribute.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_POSITIVE + FLOAT_NEGATIVE));
		assertEquals(false, s.SetStockYearLow(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockYearLow () {
		//
		// Tests to perform:
		//	1 - Ensure the correct year low 0.0f is returned.
		//	2 - Ensure the correct year low 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct year low 0.0f is returned.
		//
		assertEquals(true, s.SetStockYearLow(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockYearLow());
		//
		//	2 - Ensure the correct year low 99.99f is returned.
		//
		assertEquals(true, s.SetStockYearHigh(FLOAT_POSITIVE));
		assertEquals(true, s.SetStockYearLow(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockYearLow());
	}
	
	//----------------------------
	// TEST SET: stockSharesTotal
	//----------------------------
	
	@Test
	void TestSetStockSharesTotal () {
		//
		// Tests to perform:
		//	1 - Ensure shares total attribute cannot be a set as a negative value.
		//	2 - Ensure shares total attribute cannot be set as zero (0).
		//	3 - Ensure shares total attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure shares total attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSharesTotal(INT_NEGATIVE));
		//
		//	2 - Ensure shares total attribute cannot be set as zero (0).
		//
		assertEquals(false, s.SetStockSharesTotal(INT_ZERO));
		//
		//	3 - Ensure shares total attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE));
	}

	@Test
	void TestGetStockSharesTotal () {
		//
		// Tests to perform:
		//	1 - Ensure the correct shares total 99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct shares total 99 is returned.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE));
		assertEquals(INT_POSITIVE, s.GetStockSharesTotal());
	}
	
	//----------------------------------
	// TEST SET: stockSharesOutstanding
	//----------------------------------
	
	@Test
	void TestSetStockSharesOutstanding () {
		//
		// Tests to perform:
		//	1 - Ensure shares outstanding attribute cannot be a set as a negative value.
		//	2 - Ensure shares outstanding attribute can be set as zero (0).
		//	3 - Ensure shares outstanding attribute can be set as a positive value.
		//	4 - Ensure shares outstanding attribute cannot be set above shares total attribute.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure shares outstanding attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSharesOutstanding(INT_NEGATIVE));
		//
		//	2 - Ensure shares outstanding attribute can be set as zero (0).
		//
		assertEquals(true, s.SetStockSharesOutstanding(INT_ZERO));
		//
		//	3 - Ensure shares outstanding attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(INT_POSITIVE));
		//
		//	4 - Ensure shares outstanding attribute cannot be set above shares total attribute.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE + INT_NEGATIVE));
		assertEquals(false, s.SetStockSharesOutstanding(INT_POSITIVE));
	}

	@Test
	void TestGetStockSharesOutStanding() {
		//
		// Tests to perform:
		//	1 - Ensure the correct shares total 0 is returned.
		//	2 - Ensure the correct shares total 99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct shares total 0 is returned.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(INT_ZERO));
		assertEquals(INT_ZERO, s.GetStockSharesOutstanding());
		//
		//	2 - Ensure the correct shares total 99 is returned.
		//
		assertEquals(true, s.SetStockSharesTotal(INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(INT_POSITIVE));
		assertEquals(INT_POSITIVE, s.GetStockSharesOutstanding());
	}
	
	//-----------------------------
	// TEST SET: stockDividendPaid
	//-----------------------------
	
	@Test
	void TestSetStockDividendPaid () {
		//
		// Tests to perform:
		//	1 - Ensure dividend paid attribute cannot be a set as a negative value.
		//	2 - Ensure dividend paid attribute can be set as zero (0.0f).
		//	3 - Ensure dividend paid attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure dividend paid attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockDividendPaid(FLOAT_NEGATIVE));
		//
		//	2 - Ensure dividend paid attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockDividendPaid(FLOAT_ZERO));
		//
		//	3 - Ensure dividend paid attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockDividendPaid(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockDividendPaid () {
		//
		// Tests to perform:
		//	1 - Ensure the correct dividend paid 0.0f is returned.
		//	2 - Ensure the correct dividend paid 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct dividend paid 0.0f is returned.
		//
		assertEquals(true, s.SetStockDividendPaid(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockDividendPaid());
		//
		//	2 - Ensure the correct dividend paid 99.99f is returned.
		//
		assertEquals(true, s.SetStockDividendPaid(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockDividendPaid());
	}
	
	//---------------------------------
	// TEST SET: stockEarningsPerShare
	//---------------------------------
	
	@Test
	void TestSetStockEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure earnings per share attribute cannot be a set as a negative value.
		//	2 - Ensure earnings per share attribute can be set as zero (0.0f).
		//	3 - Ensure earnings per share attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure earnings per share attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockEarningsPerShare(FLOAT_NEGATIVE));
		//
		//	2 - Ensure earnings per share attribute can be set as zero (0.0f).
		//
		assertEquals(true, s.SetStockEarningsPerShare(FLOAT_ZERO));
		//
		//	3 - Ensure earnings per share attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockEarningsPerShare(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure the correct earnings per share 0.0f is returned.
		//	2 - Ensure the correct earnings per share 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct earnings per share 0.0f is returned.
		//
		assertEquals(true, s.SetStockEarningsPerShare(FLOAT_ZERO));
		assertEquals(FLOAT_ZERO, s.GetStockEarningsPerShare());
		//
		//	2 - Ensure the correct earnings per share 99.99f is returned.
		//
		assertEquals(true, s.SetStockEarningsPerShare(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockEarningsPerShare());
	}
	
	//--------------------------
	// TEST SET: stockMarketCap
	//--------------------------
	
	@Test
	void TestSetStockMarketCap () {
		//
		// Tests to perform:
		//	1 - Ensure market cap attribute cannot be a set as a negative value.
		//	2 - Ensure market cap attribute cannot be set as zero (0.0f).
		//	3 - Ensure market cap attribute cannot be set below 1.0f.
		//	4 - Ensure market cap attribute can be set at 1.0f.
		//	5 - Ensure market cap attribute can be set as a positive value.
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure market cap attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockMarketCap(FLOAT_NEGATIVE));
		//
		//	2 - Ensure market cap attribute cannot be set as zero (0.0f).
		//
		assertEquals(false, s.SetStockMarketCap(FLOAT_ZERO));
		//
		//	3 - Ensure market cap attribute cannot be set below 1.0f.
		//
		assertEquals(false, s.SetStockMarketCap(0.999f));
		//
		//	4 - Ensure market cap attribute can be set at 1.0f.
		//
		assertEquals(true, s.SetStockMarketCap(1.0f));
		//
		//	5 - Ensure market cap attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockMarketCap(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockMarketCap () {
		//
		// Tests to perform:
		//	1 - Ensure the correct market cap 1.0f is returned.
		//	2 - Ensure the correct market cap 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct market cap 1.0f is returned.
		//
		assertEquals(true, s.SetStockMarketCap(1.0f));
		assertEquals(1.0f, s.GetStockMarketCap());
		//
		//	2 - Ensure the correct market cap 99.99f is returned.
		//
		assertEquals(true, s.SetStockMarketCap(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockMarketCap());
	}
	
	//------------------------------------
	// TEST SET: stockProfitEarningsRatio
	//------------------------------------
	
	@Test
	void TestSetStockProfitEarningsRatio () {
		//
		// Tests to perform:
		//	1 - Ensure profit earnings ratio attribute cannot be a set as a negative value.
		//	2 - Ensure profit earnings ratio attribute cannot be set as zero (0.0f).
		//	3 - Ensure profit earnings ratio attribute cannot be set below 0.01f.
		//	4 - Ensure profit earnings ratio attribute can be set at 0.01f.
		//	5 - Ensure profit earnings ratio attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure profit earnings ratio attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(FLOAT_NEGATIVE));
		//
		//	2 - Ensure profit earnings ratio attribute cannot be set as zero (0.0f).
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(FLOAT_ZERO));
		//
		//	3 - Ensure profit earnings ratio attribute cannot be set below 0.01f.
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(0.009f));
		//
		//	4 - Ensure profit earnings ratio attribute can be set at 0.01f.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(0.01f));
		//
		//	5 - Ensure profit earnings ratio attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockProfitEarningsRatio () {
		//
		// Tests to perform:
		//	1 - Ensure the correct profit earnings ratio 0.01f is returned.
		//	2 - Ensure the correct profit earnings ratio 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct market cap 0.01f is returned.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(0.01f));
		assertEquals(0.01f, s.GetStockProfitEarningsRatio());
		//
		//	2 - Ensure the correct market cap 99.99f is returned.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockProfitEarningsRatio());
	}
	
	//------------------------------
	// TEST SET: stockDividendYield
	//------------------------------
	
	@Test
	void TestSetStockDividendYield () {
		//
		// Tests to perform:
		//	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//	2 - Ensure dividend yield attribute cannot be set as zero (0.0f).
		//	3 - Ensure dividend yield attribute cannot be set below 0.01f.
		//	4 - Ensure dividend yield attribute can be set at 0.01f.
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockDividendYield(FLOAT_NEGATIVE));
		//
		//	2 - Ensure dividend yield attribute cannot be set as zero (0.0f).
		//
		assertEquals(false, s.SetStockDividendYield(FLOAT_ZERO));
		//
		//	3 - Ensure dividend yield attribute cannot be set below 0.01f.
		//
		assertEquals(false, s.SetStockDividendYield(0.009f));
		//
		//	4 - Ensure dividend yield attribute can be set at 0.01f.
		//
		assertEquals(true, s.SetStockDividendYield(0.01f));
		//
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockDividendYield(FLOAT_POSITIVE));
	}

	@Test
	void TestGetStockDividendYield () {
		//
		// Tests to perform:
		//	1 - Ensure the correct dividend yield 0.01f is returned.
		//	2 - Ensure the correct dividend yield 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct dividend yield 0.01f is returned.
		//
		assertEquals(true, s.SetStockDividendYield(0.01f));
		assertEquals(0.01f, s.GetStockDividendYield());
		//
		//	2 - Ensure the correct dividend yield 99.99f is returned.
		//
		assertEquals(true, s.SetStockDividendYield(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetStockDividendYield());
	}
	
	//------------------------------
	// TEST SET: companyProfit
	//------------------------------
	
	@Test
	void TestSetCompanyProfit () {
		//
		// Tests to perform:
		//	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//	2 - Ensure dividend yield attribute cannot be set as zero (0.0f).
		//	3 - Ensure dividend yield attribute cannot be set below 0.01f.
		//	4 - Ensure dividend yield attribute can be set at 0.01f.
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure company profit attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetCompanyProfit(FLOAT_NEGATIVE));
		//
		//	2 - Ensure company profit attribute cannot be set as zero (0.0f).
		//
		assertEquals(false, s.SetCompanyProfit(FLOAT_ZERO));
		//
		//	3 - Ensure dividend yield attribute cannot be set below 0.01f.
		//
		assertEquals(false, s.SetCompanyProfit(0.009f));
		//
		//	4 - Ensure dividend yield attribute can be set at 0.01f.
		//
		assertEquals(true, s.SetCompanyProfit(0.01f));
		//
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		assertEquals(true, s.SetCompanyProfit(FLOAT_POSITIVE));
	}

	@Test
	void TestGetCompanyProfit () {
		//
		// Tests to perform:
		//	1 - Ensure the correct company profit 0.01f is returned.
		//	2 - Ensure the correct company profit 99.99f is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct company profit 0.01f is returned.
		//
		assertEquals(true, s.SetCompanyProfit(0.01f));
		assertEquals(0.01f, s.GetCompanyProfit());
		//
		//	2 - Ensure the correct company profit 99.99f is returned.
		//
		assertEquals(true, s.SetCompanyProfit(FLOAT_POSITIVE));
		assertEquals(FLOAT_POSITIVE, s.GetCompanyProfit());
	}
	
	@Test
	void TestCalculateEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure below-minimums for SetStockEarningsPerShare fails
		//	2 - Ensure minimums for SetStockEarningsPerShare passes
		//	3 - Ensure maximums for SetStockEarningsPerShare passes
		//
		// Since there are no theoretical maximums, we do not need to test over-maximum.
		// Also, there is no need to specifically test negatives since that is checked
		// in lower-level tests in this same object.
		//
		
		Stock s = new Stock();
		
		assertEquals(true, s.SetCompanyProfit(0.01f));
		assertEquals(true, s.SetStockSharesOutstanding(1));
	}
	
	/*
	 * 	seps = this.GetCompanyProfit() / this.GetStockSharesOutstanding();
		rv = this.SetStockEarningsPerShare(seps);
	 */
	
}
