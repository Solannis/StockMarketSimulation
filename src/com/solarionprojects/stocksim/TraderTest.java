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

	//--------------------
	// TEST SET: traderID
	//--------------------
	
	@Test
	void TestSetTraderID () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (non-negative, non-zero).
		//	2 - Ensure traderID attribute can be set.
		//	3 - Ensure traderID attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (positive, non-zero).
		//
		assertEquals(false, t.SetTraderID(SimConstants.INT_NEGATIVE));				// Parameter value cannot be negative
		assertEquals(false, t.SetTraderID(SimConstants.INT_ZERO));					// Parameter value cannot be zero
		//
		//	2 - Ensure traderID attribute can be set.
		//
		assertEquals(true, t.SetTraderID(SimConstants.INT_POSITIVE));				// Should allow traderID to be set.
		//
		//	3 - Ensure traderID attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderID(SimConstants.INT_POSITIVE));				// Should NOT allow traderID to be set.
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
	
	//---------------------------
	// TEST SET: traderFirstName
	//---------------------------
	
	@Test
	void TestSetTraderFirstName () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (not empty).
		//	2 - Ensure traderFirstName attribute can be set.
		//	3 - Ensure traderFirstName attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (not empty).
		//
		assertEquals(false, t.SetTraderFirstName(SimConstants.EMPTY_STRING));		// Parameter value cannot be an empty string
		//
		//	2 - Ensure traderFirstName attribute can be set.
		//
		assertEquals(true, t.SetTraderFirstName(SimConstants.TEST_TRADER_FIRST_NAME));		// Should allow traderFirstName to be set.
		//
		//	3 - Ensure traderFirstName attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderFirstName("Elon"));							// Should NOT allow traderFirstName to be set.
	}
	
	@Test
	void TestGetTraderFirstName () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderFirstName is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderFirstName(SimConstants.TEST_TRADER_FIRST_NAME);

		//
		//	1 - Ensure the correct traderFirstName is returned.
		//
		assertEquals(SimConstants.TEST_TRADER_FIRST_NAME, t.GetTraderFirstName());
	}
	
	//--------------------------
	// TEST SET: traderLastName
	//--------------------------
	
	@Test
	void TestSetTraderLastName () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (not empty).
		//	2 - Ensure traderLastName attribute can be set.
		//	3 - Ensure traderLastName attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (not empty).
		//
		assertEquals(false, t.SetTraderLastName(SimConstants.EMPTY_STRING));		// Parameter value cannot be an empty string
		//
		//	2 - Ensure traderLastName attribute can be set.
		//
		assertEquals(true, t.SetTraderLastName(SimConstants.TEST_TRADER_LAST_NAME));	// Should allow traderLastName to be set.
		//
		//	3 - Ensure traderLastName attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderLastName("Musk"));							// Should NOT allow traderLastName to be set.
	}
	
	@Test
	void TestGetTraderLastName () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderLastName is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderLastName(SimConstants.TEST_TRADER_LAST_NAME);

		//
		//	1 - Ensure the correct traderLastName is returned.
		//
		assertEquals(SimConstants.TEST_TRADER_LAST_NAME, t.GetTraderLastName());
	}
	
	//---------------------
	// TEST SET: traderBio
	//---------------------
	
	@Test
	void TestSetTraderBio () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (not empty).
		//	2 - Ensure traderBio attribute can be set.
		//	3 - Ensure traderBio attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (not empty).
		//
		assertEquals(false, t.SetTraderBio(SimConstants.EMPTY_STRING));				// Parameter value cannot be an empty string
		//
		//	2 - Ensure traderBio attribute can be set.
		//
		assertEquals(true, t.SetTraderBio(SimConstants.TEST_TRADER_BIO));			// Should allow traderBio to be set.
		//
		//	3 - Ensure traderBio attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderBio("This is an alternate trader bio."));	// Should NOT allow traderBio to be set.
	}
	
	@Test
	void TestGetTraderBio () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderBio is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderBio(SimConstants.TEST_TRADER_BIO);

		//
		//	1 - Ensure the correct traderBio is returned.
		//
		assertEquals(SimConstants.TEST_TRADER_BIO, t.GetTraderBio());
	}
	
	//--------------------------
	// TEST SET: traderBehavior
	//--------------------------
	
	@Test
	void TestSetTraderBehavior () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (non-negative, non-zero, not out of range).
		//	2 - Ensure traderBehavior attribute can be set.
		//	3 - Ensure traderBehavior attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (non-negative, non-zero, not out of range).
		//
		assertEquals(false, t.SetTraderBehavior(SimConstants.INT_NEGATIVE));		// Parameter value cannot be a negative number
		assertEquals(false, t.SetTraderBehavior(SimConstants.INT_ZERO));			// Parameter value cannot be zero
		assertEquals(false, t.SetTraderBehavior(SimConstants.TRADER_BEHAVIOR_BULL - 1));	// Parameter value cannot be lower than BULL
		assertEquals(false, t.SetTraderBehavior(SimConstants.TRADER_BEHAVIOR_MIXED + 1));	// Parameter value cannot be higher than MIXED
		//
		//	2 - Ensure traderBehavior attribute can be set.
		//
		assertEquals(true, t.SetTraderBehavior(SimConstants.TRADER_BEHAVIOR_BULL));		// Should allow traderBehavior to be set.
		//
		//	3 - Ensure traderBehavior attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderBehavior(SimConstants.TRADER_BEHAVIOR_BEAR));	// Should NOT allow traderBehavior to be set.
	}
	
	@Test
	void TestGetTraderBehavior () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderBehavior is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderBehavior(SimConstants.TRADER_BEHAVIOR_BULL);

		//
		//	1 - Ensure the correct traderBehavior is returned.
		//
		assertEquals(SimConstants.TRADER_BEHAVIOR_BULL, t.GetTraderBehavior());
	}
	
	//------------------------
	// TEST SET: traderWallet
	//------------------------
	
	@Test
	void TestSetTraderWallet () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (non-negative).
		//	2 - Ensure traderWallet attribute can be set.
		//	3 - Ensure traderBehavior attribute, once set, CAN be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (non-negative).
		//
		assertEquals(false, t.SetTraderWallet(SimConstants.FLOAT_NEGATIVE));	// Parameter value cannot be a negative number
		//
		//	2 - Ensure traderWallet attribute can be set.
		//
		assertEquals(true, t.SetTraderWallet(SimConstants.FLOAT_POSITIVE));		// Should allow traderBehavior to be set.
		//
		//	3 - Ensure traderBio attribute, once set, CAN be reset.
		//
		assertEquals(true, t.SetTraderWallet(SimConstants.FLOAT_ZERO));			// Should NOT allow traderBehavior to be set.
	}
	
	@Test
	void TestGetTraderWallet () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderWallet is returned.
		//
		
		Trader t = new Trader();
		t.SetTraderWallet(SimConstants.FLOAT_POSITIVE);

		//
		//	1 - Ensure the correct traderWallet is returned.
		//
		assertEquals(SimConstants.FLOAT_POSITIVE, t.GetTraderWallet());
	}
	
	//---------------------------
	// TEST SET: traderFrequency
	//---------------------------
	
	@Test
	void TestSetTraderFrequency () {
		//
		// Tests to perform:
		//	1 - Ensure parameter value is valid (non-negative, non-zero, not out of range).
		//	2 - Ensure traderFrequency attribute can be set.
		//	3 - Ensure traderFrequency attribute, once set, cannot be reset.
		//
		
		Trader t = new Trader();
		
		//
		//	1 - Ensure parameter value is valid (non-negative, non-zero).
		//
		assertEquals(false, t.SetTraderFrequency(SimConstants.INT_NEGATIVE));		// Parameter value cannot be a negative number
		assertEquals(false, t.SetTraderFrequency(SimConstants.INT_ZERO));			// Parameter value cannot be zero
		assertEquals(false, t.SetTraderFrequency(SimConstants.TRADER_FREQUENCY_LOWEST - 1));	// Parameter value cannot be lower than LOWEST
		assertEquals(false, t.SetTraderFrequency(SimConstants.TRADER_FREQUENCY_HIGHEST + 1));	// Parameter value cannot be higher than HIGHEST
		
		//
		//	2 - Ensure traderFrequency attribute can be set.
		//
		assertEquals(true, t.SetTraderFrequency(SimConstants.TRADER_FREQUENCY_HIGH));		// Should allow traderFrequency to be set.
		//
		//	3 - Ensure traderBehavior attribute, once set, cannot be reset.
		//
		assertEquals(false, t.SetTraderFrequency(SimConstants.TRADER_FREQUENCY_LOW));		// Should NOT allow traderBehavior to be set.
	}
	
	@Test
	void TestGetTraderFrequency () {
		//
		// Tests to perform:
		//	1 - Ensure the correct traderFrequencyis returned.
		//
		
		Trader t = new Trader();
		t.SetTraderFrequency(SimConstants.TRADER_FREQUENCY_HIGHEST);

		//
		//	1 - Ensure the correct traderBehavior is returned.
		//
		assertEquals(SimConstants.TRADER_FREQUENCY_HIGHEST, t.GetTraderFrequency());
	}
	
	//-----------------------
	// TEST SET: traderImage
	//-----------------------
	/*
	 * This set of tests is not currently implemented since this feature is not currently implemented.
	 */

	//--------------------------------
	// TEST SET: traderStockFavorites
	//--------------------------------
	/*
	 * This set of tests is not currently implemented since this feature is not currently implemented.
	 */

	//---------------------------------
	// TEST SET: traderSectorFavorites
	//---------------------------------
	/*
	 * This set of tests is not currently implemented since this feature is not currently implemented.
	 */

	//---------------------------------
	// TEST SET: traderMarketFavorites
	//---------------------------------
	/*
	 * This set of tests is not currently implemented since this feature is not currently implemented.
	 */

	//--------------------------
	// TEST SET: traderHoldings
	//--------------------------
	/*
	 * This set of tests is not currently implemented since this feature is not currently implemented.
	 */
	
}
