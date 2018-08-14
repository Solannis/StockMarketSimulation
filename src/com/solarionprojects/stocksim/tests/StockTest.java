/**
 * 
 */
package com.solarionprojects.stocksim.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import com.solarionprojects.stocksim.SimConstants;
import com.solarionprojects.stocksim.Stock;

/**
 * @author Mitchell Freeman
 *
 */
class StockTest {
	
	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================

	
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

	//-------------------
	// TEST SET: stockID
	//-------------------
	
	@Test
	void TestSetStockID () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (positive, non-zero).
		//	2 - Ensure stockID attribute can be set.
		//	3 - Ensure stockID attribute, once set, cannot be reset.
		//
		
		Stock s = new Stock();
		
		//
		//	1 - Ensure parameter value is valid (positive, non-zero).
		//
		assertEquals(false, s.SetStockID(SimConstants.INT_NEGATIVE));			// Parameter value cannot be negative
		assertEquals(false, s.SetStockID(SimConstants.INT_ZERO));				// Parameter value cannot be zero
		//
		//	2 - Ensure stockID attribute can be set.
		//
		assertEquals(true, s.SetStockID(SimConstants.INT_POSITIVE));			// Should allow stockID to be set.
		//
		//	3 - Ensure stockID attribute, once set, cannot be reset.
		//
		assertEquals(false, s.SetStockID(SimConstants.INT_POSITIVE));			// Should NOT allow stockID to be set.
	}
	
	@Test
	void TestGetStockID () {
		//
		// Tests to perform:
		//	1 - Ensure the correct stockID is returned.
		//
		
		Stock s = new Stock();
		s.SetStockID(SimConstants.INT_POSITIVE);

		//
		//	1 - Ensure the correct symbol is returned.
		//
		assertEquals(SimConstants.INT_POSITIVE, s.GetStockID());
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
		assertEquals(false, s.SetStockSymbol(SimConstants.EMPTY_STRING));		// Too short for min_length = 1
		assertEquals(false, s.SetStockSymbol("HelloWorld"));		// Too long for max_length = 5
		//
		//	2 - Ensure symbol parameter value is not blank before setting.
		//
		assertEquals(false, s.SetStockSymbol(SimConstants.EMPTY_STRING));		// Cannot be an empty string
		//
		//	3 - Ensure symbol attribute can be set.
		//
		assertEquals(true, s.SetStockSymbol(SimConstants.TEST_STOCK_SYMBOL));	// Should allow symbol to be set.
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
		s.SetStockSymbol(SimConstants.TEST_STOCK_SYMBOL);

		//
		//	1 - Ensure the correct symbol is returned.
		//
		assertEquals(SimConstants.TEST_STOCK_SYMBOL, s.GetStockSymbol());
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
		assertEquals(false, s.SetStockSector(SimConstants.EMPTY_STRING));
		//
		//	2 - Ensure sector attribute can be set.
		//
		assertEquals(true, s.SetStockSector(SimConstants.TEST_STOCK_SECTOR));
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
		s.SetStockSector(SimConstants.TEST_STOCK_SECTOR);

		//
		//	1 - Ensure the correct sector is returned.
		//
		assertEquals(SimConstants.TEST_STOCK_SECTOR, s.GetStockSector());
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
		assertEquals(false, s.SetStockExchange(SimConstants.EMPTY_STRING));
		//
		//	2 - Ensure exchange attribute can be set.
		//
		assertEquals(true, s.SetStockExchange(SimConstants.TEST_STOCK_EXCHANGE));
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
		s.SetStockExchange(SimConstants.TEST_STOCK_EXCHANGE);

		//
		//	1 - Ensure the correct exchange is returned.
		//
		assertEquals(SimConstants.TEST_STOCK_EXCHANGE, s.GetStockExchange());
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
		assertEquals(false, s.SetStockFullName(SimConstants.EMPTY_STRING));
		//
		//	2 - Ensure full name attribute can be set.
		//
		assertEquals(true, s.SetStockFullName(SimConstants.TEST_STOCK_FULL_NAME));
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
		s.SetStockFullName(SimConstants.TEST_STOCK_FULL_NAME);

		//
		//	1 - Ensure the correct full name is returned.
		//
		assertEquals(SimConstants.TEST_STOCK_FULL_NAME, s.GetStockFullName());
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
		assertEquals(false, s.SetStockDescription(SimConstants.EMPTY_STRING));
		//
		//	2 - Ensure description attribute can be set.
		//
		assertEquals(true, s.SetStockDescription(SimConstants.TEST_STOCK_DESCRIPTION));
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
		s.SetStockDescription(SimConstants.TEST_STOCK_DESCRIPTION);

		//
		//	1 - Ensure the correct description is returned.
		//
		assertEquals(SimConstants.TEST_STOCK_DESCRIPTION, s.GetStockDescription());
	}
	
	//-----------------------------
	// TEST SET: stockCurrentPrice
	//-----------------------------
	
	@Test
	void TestSetStockCurrentPrice () {
		//
		// Tests to perform:
		//	1 - Ensure current price attribute cannot be a set as a negative value.
		//	2 - Ensure current price attribute can be set as zero (0.0).
		//	3 - Ensure current price attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPrice(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure current price attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_ZERO));
		//
		//	3 - Ensure current price attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPrice () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price 0.0 is returned.
		//	2 - Ensure the correct current price 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price 0.0 is returned.
		//
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockCurrentPrice());
		//
		//	2 - Ensure the correct current price 99.99 is returned.
		//
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockCurrentPrice());
	}
	
	//--------------------------------
	// TEST SET: stockCurrentPriceAsk
	//--------------------------------
	
	@Test
	void TestSetStockCurrentPriceAsk () {
		//
		// Tests to perform:
		//	1 - Ensure current price ask attribute cannot be a set as a negative value.
		//	2 - Ensure current price ask attribute can be set as zero (0.0).
		//	3 - Ensure current price ask attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price ask attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPriceAsk(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure current price ask attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(SimConstants.BD_ZERO));
		//
		//	3 - Ensure current price ask attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPriceAsk () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price ask 0.0 is returned.
		//	2 - Ensure the correct current price ask 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price ask 0.0 is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockCurrentPriceAsk());
		//
		//	2 - Ensure the correct current price ask 99.99 is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceAsk(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockCurrentPriceAsk());
	}
	
	//--------------------------------
	// TEST SET: stockCurrentPriceBid
	//--------------------------------
	
	@Test
	void TestSetStockCurrentPriceBid () {
		//
		// Tests to perform:
		//	1 - Ensure current price bid attribute cannot be a set as a negative value.
		//	2 - Ensure current price bid attribute can be set as zero (0.0).
		//	3 - Ensure current price bid attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure current price bid attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockCurrentPriceBid(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure current price bid attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockCurrentPriceBid(SimConstants.BD_ZERO));
		//
		//	3 - Ensure current price bid attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockCurrentPriceBid () {
		//
		// Tests to perform:
		//	1 - Ensure the correct current price bid 0.0 is returned.
		//	2 - Ensure the correct current price bid 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct current price bid 0.0 is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockCurrentPriceBid());
		//
		//	2 - Ensure the correct current price bid 99.99 is returned.
		//
		assertEquals(true, s.SetStockCurrentPriceBid(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockCurrentPriceBid());
	}
	
	//-----------------------------
	// TEST SET: stockSessionClose
	//-----------------------------
	
	@Test
	void TestSetStockSessionClose () {
		//
		// Tests to perform:
		//	1 - Ensure session close attribute cannot be a set as a negative value.
		//	2 - Ensure session close attribute can be set as zero (0.0).
		//	3 - Ensure session close attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session close attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionClose(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure session close attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockSessionClose(SimConstants.BD_ZERO));
		//
		//	3 - Ensure session close attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionClose(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockSessionClose () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session close 0.0 is returned.
		//	2 - Ensure the correct session close 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session close 0.0 is returned.
		//
		assertEquals(true, s.SetStockSessionClose(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockSessionClose());
		//
		//	2 - Ensure the correct session close 99.99 is returned.
		//
		assertEquals(true, s.SetStockSessionClose(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockSessionClose());
	}
	
	//-------------------------------------
	// TEST SET: stockSessionClosePrevious
	//-------------------------------------
	
	@Test
	void TestSetStockSessionClosePrevious () {
		//
		// Tests to perform:
		//	1 - Ensure session close previous attribute cannot be a set as a negative value.
		//	2 - Ensure session close previous attribute can be set as zero (0.0).
		//	3 - Ensure session close previous attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session close previous attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionClosePrevious(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure session close previous attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockSessionClosePrevious(SimConstants.BD_ZERO));
		//
		//	3 - Ensure session close previous attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockSessionClosePrevious () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session close previous 0.0 is returned.
		//	2 - Ensure the correct session close previous 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session close previous 0.0 is returned.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockSessionClosePrevious());
		//
		//	2 - Ensure the correct session close previous 99.99 is returned.
		//
		assertEquals(true, s.SetStockSessionClosePrevious(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockSessionClosePrevious());
	}
	
	//-----------------------------
	// TEST SET: stockSessionHigh
	//-----------------------------
	
	@Test
	void TestSetStockSessionHigh () {
		//
		// Tests to perform:
		//	1 - Ensure session high attribute cannot be a set as a negative value.
		//	2 - Ensure session high attribute can be set as zero (0.0).
		//	3 - Ensure session high attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session high attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionHigh(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure session high attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockSessionHigh(SimConstants.BD_ZERO));
		//
		//	3 - Ensure session high attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionHigh(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockSessionHigh () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session high 0.0 is returned.
		//	2 - Ensure the correct session high 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session high 0.0 is returned.
		//
		assertEquals(true, s.SetStockSessionHigh(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockSessionHigh());
		//
		//	2 - Ensure the correct session high 99.99 is returned.
		//
		assertEquals(true, s.SetStockSessionHigh(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockSessionHigh());
	}
	
	//-----------------------------
	// TEST SET: stockSessionLow
	//-----------------------------
	
	@Test
	void TestSetStockSessionLow () {
		//
		// Tests to perform:
		//	1 - Ensure session low attribute cannot be a set as a negative value.
		//	2 - Ensure session low attribute can be set as zero (0.0).
		//	3 - Ensure session low attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session low attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionLow(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure session low attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockSessionLow(SimConstants.BD_ZERO));
		//
		//	3 - Ensure session low attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionLow(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockSessionLow () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session low 0.0 is returned.
		//	2 - Ensure the correct session low 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session low 0.0 is returned.
		//
		assertEquals(true, s.SetStockSessionLow(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockSessionLow());
		//
		//	2 - Ensure the correct session low 99.99 is returned.
		//
		assertEquals(true, s.SetStockSessionLow(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockSessionLow());
	}
	
	//-----------------------------
	// TEST SET: stockSessionOpen
	//-----------------------------
	
	@Test
	void TestSetStockSessionOpen () {
		//
		// Tests to perform:
		//	1 - Ensure session open attribute cannot be a set as a negative value.
		//	2 - Ensure session open attribute can be set as zero (0.0).
		//	3 - Ensure session open attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure session open attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockSessionOpen(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure session open attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockSessionOpen(SimConstants.BD_ZERO));
		//
		//	3 - Ensure session open attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSessionOpen(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockSessionOpen () {
		//
		// Tests to perform:
		//	1 - Ensure the correct session open 0.0 is returned.
		//	2 - Ensure the correct session open 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct session open 0.0 is returned.
		//
		assertEquals(true, s.SetStockSessionOpen(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockSessionOpen());
		//
		//	2 - Ensure the correct session open 99.99 is returned.
		//
		assertEquals(true, s.SetStockSessionOpen(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockSessionOpen());
	}
	
	//-------------------------
	// TEST SET: stockYearHigh
	//-------------------------
	
	@Test
	void TestSetStockYearHigh () {
		//
		// Tests to perform:
		//	1 - Ensure year high attribute cannot be a set as a negative value.
		//	2 - Ensure year high attribute can be set as zero (0.0).
		//	3 - Ensure year high attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure year high attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockYearHigh(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure year high attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_ZERO));
		//
		//	3 - Ensure year high attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockYearHigh () {
		//
		// Tests to perform:
		//	1 - Ensure the correct year high 0.0 is returned.
		//	2 - Ensure the correct year high 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct year high 0.0 is returned.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockYearHigh());
		//
		//	2 - Ensure the correct year high 99.99 is returned.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockYearHigh());
	}
	
	//------------------------
	// TEST SET: stockYearLow
	//------------------------
	
	@Test
	void TestSetStockYearLow () {
		//
		// Tests to perform:
		//	1 - Ensure year low attribute cannot be a set as a negative value.
		//	2 - Ensure year low attribute can be set as zero (0.0).
		//	3 - Ensure year low attribute can be set as a positive value.
		//	4 - Ensure year low attribute cannot be set above year high attribute.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure year low attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockYearLow(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure year low attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockYearLow(SimConstants.BD_ZERO));
		//
		//	3 - Ensure year low attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_POSITIVE));
		assertEquals(true, s.SetStockYearLow(SimConstants.BD_POSITIVE));
		//
		//	4 - Ensure year low attribute cannot be set above year high attribute.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_POSITIVE.add(SimConstants.BD_NEGATIVE)));
		assertEquals(false, s.SetStockYearLow(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockYearLow () {
		//
		// Tests to perform:
		//	1 - Ensure the correct year low 0.0 is returned.
		//	2 - Ensure the correct year low 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct year low 0.0 is returned.
		//
		assertEquals(true, s.SetStockYearLow(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockYearLow());
		//
		//	2 - Ensure the correct year low 99.99 is returned.
		//
		assertEquals(true, s.SetStockYearHigh(SimConstants.BD_POSITIVE));
		assertEquals(true, s.SetStockYearLow(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockYearLow());
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
		assertEquals(false, s.SetStockSharesTotal(SimConstants.INT_NEGATIVE));
		//
		//	2 - Ensure shares total attribute cannot be set as zero (0).
		//
		assertEquals(false, s.SetStockSharesTotal(SimConstants.INT_ZERO));
		//
		//	3 - Ensure shares total attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE));
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
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE));
		assertEquals(SimConstants.INT_POSITIVE, s.GetStockSharesTotal());
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
		assertEquals(false, s.SetStockSharesOutstanding(SimConstants.INT_NEGATIVE));
		//
		//	2 - Ensure shares outstanding attribute can be set as zero (0).
		//
		assertEquals(true, s.SetStockSharesOutstanding(SimConstants.INT_ZERO));
		//
		//	3 - Ensure shares outstanding attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(SimConstants.INT_POSITIVE));
		//
		//	4 - Ensure shares outstanding attribute cannot be set above shares total attribute.
		//
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE + SimConstants.INT_NEGATIVE));
		assertEquals(false, s.SetStockSharesOutstanding(SimConstants.INT_POSITIVE));
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
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(SimConstants.INT_ZERO));
		assertEquals(SimConstants.INT_ZERO, s.GetStockSharesOutstanding());
		//
		//	2 - Ensure the correct shares total 99 is returned.
		//
		assertEquals(true, s.SetStockSharesTotal(SimConstants.INT_POSITIVE));
		assertEquals(true, s.SetStockSharesOutstanding(SimConstants.INT_POSITIVE));
		assertEquals(SimConstants.INT_POSITIVE, s.GetStockSharesOutstanding());
	}
	
	//-----------------------------
	// TEST SET: stockDividendPaid
	//-----------------------------
	
	@Test
	void TestSetStockDividendPaid () {
		//
		// Tests to perform:
		//	1 - Ensure dividend paid attribute cannot be a set as a negative value.
		//	2 - Ensure dividend paid attribute can be set as zero (0.0).
		//	3 - Ensure dividend paid attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure dividend paid attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockDividendPaid(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure dividend paid attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_ZERO));
		//
		//	3 - Ensure dividend paid attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockDividendPaid () {
		//
		// Tests to perform:
		//	1 - Ensure the correct dividend paid 0.0 is returned.
		//	2 - Ensure the correct dividend paid 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct dividend paid 0.0 is returned.
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockDividendPaid());
		//
		//	2 - Ensure the correct dividend paid 99.99 is returned.
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockDividendPaid());
	}
	
	//---------------------------------
	// TEST SET: stockEarningsPerShare
	//---------------------------------
	
	@Test
	void TestSetStockEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure earnings per share attribute cannot be a set as a negative value.
		//	2 - Ensure earnings per share attribute can be set as zero (0.0).
		//	3 - Ensure earnings per share attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure earnings per share attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockEarningsPerShare(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure earnings per share attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_ZERO));
		//
		//	3 - Ensure earnings per share attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure the correct earnings per share 0.0 is returned.
		//	2 - Ensure the correct earnings per share 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct earnings per share 0.0 is returned.
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_ZERO));
		assertEquals(SimConstants.BD_ZERO, s.GetStockEarningsPerShare());
		//
		//	2 - Ensure the correct earnings per share 99.99 is returned.
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockEarningsPerShare());
	}
	
	//--------------------------
	// TEST SET: stockMarketCap
	//--------------------------
	
	@Test
	void TestSetStockMarketCap () {
		//
		// Tests to perform:
		//	1 - Ensure market cap attribute cannot be a set as a negative value.
		//	2 - Ensure market cap attribute cannot be set as zero (0.0).
		//	3 - Ensure market cap attribute cannot be set below 1.0.
		//	4 - Ensure market cap attribute can be set at 1.0.
		//	5 - Ensure market cap attribute can be set as a positive value.
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure market cap attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockMarketCap(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure market cap attribute cannot be set as zero (0.0).
		//
		assertEquals(false, s.SetStockMarketCap(SimConstants.BD_ZERO));
		//
		//	3 - Ensure market cap attribute cannot be set below 1.0.
		//
		assertEquals(false, s.SetStockMarketCap(new BigDecimal("0.999")));
		//
		//	4 - Ensure market cap attribute can be set at 1.0.
		//
		assertEquals(true, s.SetStockMarketCap(SimConstants.BD_DOLLAR));
		//
		//	5 - Ensure market cap attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockMarketCap(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockMarketCap () {
		//
		// Tests to perform:
		//	1 - Ensure the correct market cap 1.0 is returned.
		//	2 - Ensure the correct market cap 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct market cap 1.0 is returned.
		//
		assertEquals(true, s.SetStockMarketCap(SimConstants.BD_DOLLAR));
		assertEquals(SimConstants.BD_DOLLAR, s.GetStockMarketCap());
		//
		//	2 - Ensure the correct market cap 99.99 is returned.
		//
		assertEquals(true, s.SetStockMarketCap(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockMarketCap());
	}
	
	//------------------------------------
	// TEST SET: stockProfitEarningsRatio
	//------------------------------------
	
	@Test
	void TestSetStockProfitEarningsRatio () {
		//
		// Tests to perform:
		//	1 - Ensure profit earnings ratio attribute cannot be a set as a negative value.
		//	2 - Ensure profit earnings ratio attribute cannot be set as zero (0.0).
		//	3 - Ensure profit earnings ratio attribute cannot be set below 0.01.
		//	4 - Ensure profit earnings ratio attribute can be set at 0.01.
		//	5 - Ensure profit earnings ratio attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure profit earnings ratio attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure profit earnings ratio attribute cannot be set as zero (0.0).
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(SimConstants.BD_ZERO));
		//
		//	3 - Ensure profit earnings ratio attribute cannot be set below 0.01.
		//
		assertEquals(false, s.SetStockProfitEarningsRatio(new BigDecimal("0.009")));
		//
		//	4 - Ensure profit earnings ratio attribute can be set at 0.01.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(SimConstants.BD_PENNY));
		//
		//	5 - Ensure profit earnings ratio attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockProfitEarningsRatio () {
		//
		// Tests to perform:
		//	1 - Ensure the correct profit earnings ratio 0.01f is returned.
		//	2 - Ensure the correct profit earnings ratio 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct market cap 0.01f is returned.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(SimConstants.BD_PENNY));
		assertEquals(SimConstants.BD_PENNY, s.GetStockProfitEarningsRatio());
		//
		//	2 - Ensure the correct market cap 99.99 is returned.
		//
		assertEquals(true, s.SetStockProfitEarningsRatio(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockProfitEarningsRatio());
	}
	
	//------------------------------
	// TEST SET: stockDividendYield
	//------------------------------
	
	@Test
	void TestSetStockDividendYield () {
		//
		// Tests to perform:
		//	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//	2 - Ensure dividend yield attribute can be set as zero (0.0).
		//	3 - Ensure dividend yield attribute can be set at 0.01f.
		//	4 - Ensure dividend yield attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetStockDividendYield(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure dividend yield attribute can be set as zero (0.0).
		//
		assertEquals(true, s.SetStockDividendYield(SimConstants.BD_ZERO));
		//
		//	3 - Ensure dividend yield attribute can be set at 0.01f.
		//
		assertEquals(true, s.SetStockDividendYield(SimConstants.BD_PENNY));
		//
		//	4 - Ensure dividend yield attribute can be set as a positive value.
		//
		assertEquals(true, s.SetStockDividendYield(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetStockDividendYield () {
		//
		// Tests to perform:
		//	1 - Ensure the correct dividend yield 0.01f is returned.
		//	2 - Ensure the correct dividend yield 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct dividend yield 0.01f is returned.
		//
		assertEquals(true, s.SetStockDividendYield(SimConstants.BD_PENNY));
		assertEquals(SimConstants.BD_PENNY, s.GetStockDividendYield());
		//
		//	2 - Ensure the correct dividend yield 99.99 is returned.
		//
		assertEquals(true, s.SetStockDividendYield(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetStockDividendYield());
	}
	
	//------------------------------
	// TEST SET: companyProfit
	//------------------------------
	
	@Test
	void TestSetCompanyProfit () {
		//
		// Tests to perform:
		//	1 - Ensure dividend yield attribute cannot be a set as a negative value.
		//	2 - Ensure dividend yield attribute cannot be set as zero (0.0).
		//	3 - Ensure dividend yield attribute cannot be set below 0.01.
		//	4 - Ensure dividend yield attribute can be set at 0.01.
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		
		Stock s = new Stock();
		
		//
		// 	1 - Ensure company profit attribute cannot be a set as a negative value.
		//
		assertEquals(false, s.SetCompanyProfit(SimConstants.BD_NEGATIVE));
		//
		//	2 - Ensure company profit attribute cannot be set as zero (0.0).
		//
		assertEquals(false, s.SetCompanyProfit(SimConstants.BD_ZERO));
		//
		//	3 - Ensure dividend yield attribute cannot be set below 0.01.
		//
		assertEquals(false, s.SetCompanyProfit(new BigDecimal("0.009")));
		//
		//	4 - Ensure dividend yield attribute can be set at 0.01.
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_PENNY));
		//
		//	5 - Ensure dividend yield attribute can be set as a positive value.
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_POSITIVE));
	}

	@Test
	void TestGetCompanyProfit () {
		//
		// Tests to perform:
		//	1 - Ensure the correct company profit 0.01f is returned.
		//	2 - Ensure the correct company profit 99.99 is returned.
		//
		
		Stock s = new Stock();

		//
		//	1 - Ensure the correct company profit 0.01f is returned.
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_PENNY));
		assertEquals(SimConstants.BD_PENNY, s.GetCompanyProfit());
		//
		//	2 - Ensure the correct company profit 99.99 is returned.
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_POSITIVE));
		assertEquals(SimConstants.BD_POSITIVE, s.GetCompanyProfit());
	}
	
	//-------------------------------------
	// TEST SET: CalculateEarningsPerShare
	//-------------------------------------
	
	@Test
	void TestCalculateEarningsPerShare () {
		//
		// Tests to perform:
		//	1 - Ensure below-minimums for CalculateEarningsPerShare fails
		//	2 - Ensure minimums for CalculateEarningsPerShare passes
		//	3 - Ensure non-minimums for CalculateEarningsPerShare passes
		//
		// Since there are no theoretical maximums, we do not need to test over-maximum.
		// Also, there is no need to specifically test negatives since that is checked
		// in lower-level tests in this same object.
		//
		// Due to error prevention checking in the Company Profit, SetStockSharesTotal, and 
		// SetStockSharesOutstanding, there is no way to test for below-minimums here. That
		// means test #1 is not needed and is therefore skipped.
		//
		
		Stock s = new Stock();
		
		//
		//  2 - Ensure minimums for CalculateEarningsPerShare passes
		//
		// Steps needed:
		//	1 - Set the company profit as low as possible
		//	2 - Set the total shares as low as possible
		//	3 - Set the outstanding shares as low as possible
		//	4 - Attempt to calculate the earnings per share
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_PENNY));
		assertEquals(true, s.SetStockSharesTotal(1));
		assertEquals(true, s.SetStockSharesOutstanding(1));
		assertEquals(true, s.CalculateEarningsPerShare());
		//
		//	3 - Ensure non-minimums for CalculateEarningsPerShare passes
		//
		assertEquals(true, s.SetCompanyProfit(SimConstants.BD_POSITIVE));
		assertEquals(true, s.SetStockSharesTotal(100000));
		assertEquals(true, s.SetStockSharesOutstanding(1000));
		assertEquals(true, s.CalculateEarningsPerShare());
	}
	
	//------------------------------
	// TEST SET: CalculateMarketCap
	//------------------------------
	
	@Test
	void TestCalculateMarketCap () {
		//
		// Tests to perform:
		//	1 - Ensure minimums for CalculateMarketCap passes
		//	2 - Ensure non-minimums for CalculateMarketCap passes
		//
		// Since there are no theoretical maximums, and since minimums are error checked
		// within the lower-level methods, we do not need to test under-minimum or over-maximum
		// values. Also, there is no need to specifically test negatives since that is checked
		// in lower-level tests as well.
		//
		
		Stock s = new Stock();
		
		//
		//  1 - Ensure minimums for CalculateMarketCap passes
		//
		// Steps needed:
		//	1 - Set the total shares as low as possible
		//	2 - Set the current share price as low as possible
		//	3 - Attempt to calculate the market cap
		//
		assertEquals(true, s.SetStockSharesTotal(1));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_DOLLAR));
		assertEquals(true, s.CalculateMarketCap());
		//
		//	2 - Ensure non-minimums for CalculateMarketCap passes
		//
		assertEquals(true, s.SetStockSharesTotal(100000));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_POSITIVE));
		assertEquals(true, s.CalculateMarketCap());
	}
	
	//----------------------------------------
	// TEST SET: CalculateProfitEarningsRatio
	//----------------------------------------
	
	@Test
	void TestCalculateProfitEarningsRatio () {
		//
		// Tests to perform:
		//	1 - Ensure minimums for CalculateProfitEarningsRatio passes
		//	2 - Ensure non-minimums for CalculateProfitEarningsRatio passes
		//
		// Since there are no theoretical maximums, and since minimums are error checked
		// within the lower-level methods, we do not need to test under-minimum or over-maximum
		// values. Also, there is no need to specifically test negatives since that is checked
		// in lower-level tests as well.
		//
		
		Stock s = new Stock();
		
		//
		//  1 - Ensure minimums for CalculateProfitEarningsRatio passes
		//
		// Steps needed:
		//	1 - Set the earnings per share as low as possible
		//	2 - Set the current share price as low as possible
		//	3 - Attempt to calculate the profit earnings ratio
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_PENNY));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_DOLLAR));
		assertEquals(true, s.CalculateProfitEarningsRatio());
		//
		//	2 - Ensure non-minimums for CalculateMarketCap passes
		//
		assertEquals(true, s.SetStockEarningsPerShare(SimConstants.BD_POSITIVE));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_POSITIVE));
		assertEquals(true, s.CalculateProfitEarningsRatio());
	}
	
	//----------------------------------
	// TEST SET: CalculateDividendYield
	//----------------------------------
	
	@Test
	void TestCalculateDividendYield () {
		//
		// Tests to perform:
		//	1 - Ensure minimums for CalculateDividendYield passes
		//	2 - Ensure non-minimums for CalculateDividendYield passes
		//
		// Since there are no theoretical maximums, and since minimums are error checked
		// within the lower-level methods, we do not need to test under-minimum or over-maximum
		// values. Also, there is no need to specifically test negatives since that is checked
		// in lower-level tests as well.
		//
		
		Stock s = new Stock();
		
		//
		//  1 - Ensure minimums for CalculateDividendYield passes
		//
		// Steps needed:
		//	1 - Set the earnings per share as low as possible
		//	2 - Set the current share price as low as possible
		//	3 - Attempt to calculate the profit earnings ratio
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_ZERO));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_DOLLAR));
		assertEquals(true, s.CalculateDividendYield());
		//
		//	2 - Ensure non-minimums for CalculateDividendYield passes
		//
		assertEquals(true, s.SetStockDividendPaid(SimConstants.BD_POSITIVE));
		assertEquals(true, s.SetStockCurrentPrice(SimConstants.BD_POSITIVE));
		assertEquals(true, s.CalculateDividendYield());
	}
	
}
