/**
 * 
 */
package com.solarionprojects.stocksim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mfreeman
 *
 */
class TraderTest {
	
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
	// TEST SET: traderID
	//-------------------
	
	@Test
	void TestSetTraderID () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (positive, non-zero).
		//	2 - Ensure traderID attribute can be set.
		//	3 - Ensure traderID attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (positive, non-zero).
		//
		assertEquals(false, t.SetTraderID(SimConstants.INT_NEGATIVE));			// Parameter value cannot be negative
		assertEquals(false, t.SetTraderID(SimConstants.INT_ZERO));				// Parameter value cannot be zero
		//
		//	2 - Ensure traderID attribute can be set.
		//
		assertEquals(true, t.SetTraderID(SimConstants.INT_POSITIVE));			// Should allow stockID to be set.
		//
		//	3 - Ensure traderID attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderID(SimConstants.INT_POSITIVE));			// Should NOT allow stockID to be set.
	}
	
	@Test
	void TestGetTraderID () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderID is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderID(SimConstants.INT_POSITIVE);

		//
		//	1 - Ensure the correct symbol is returned.
		//
		assertEquals(SimConstants.INT_POSITIVE, t.GetTraderID());
	}
	

}
