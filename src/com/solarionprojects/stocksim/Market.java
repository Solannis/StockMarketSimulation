package com.solarionprojects.stocksim;

import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;
import java.sql.Time;
import com.solarionprojects.utility.RNG;

public class Market {

	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================
	
	private static final int STOCK_SYMBOL_MIN_LENGTH = 1;
	private static final int STOCK_SYMBOL_MAX_LENGTH = 5;
	private static final int INT_ZERO = 0;
	private static final float FLOAT_ZERO = 0.0f;
	private static final float FLOAT_PENNY = 0.01f;
	private static final float FLOAT_DOLLAR = 1.0f;
	private static final float FLOAT_INFINITY_POSITIVE = Float.POSITIVE_INFINITY;
	private static final float FLOAT_INFINITY_NEGATIVE = Float.NEGATIVE_INFINITY;
	private static final String EMPTY_STRING = "";

	private static final int MODE_TUTORIAL_BASIC = 0x01;
	private static final int MODE_TUTORIAL_ADVANCED = 0x02;
	private static final int MODE_EASY = 0x04;
	private static final int MODE_MODERATE = 0x05;
	private static final int MODE_ADVANCED = 0x06;
	
	private static final int STOCK_SELECT_QTY_TUTORIAL = 10;
	
	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================
	
	//
	// Note: the attributes below represent the full functionality of the stock object, however not all attributes
	// will be used in all difficulty levels of the simulation. The introductory/tutorial difficulty level (easiest)
	// will most likely ignore all but a handful of these attributes.
	//
	private int marketMode;					// The difficulty level of the stock market.
	private String marketName;				// Name of the market.
	private Time marketHoursPre;			// Start time of pre-market trading hours.
	private Time marketHoursNormal;			// Start time of normal market trading hours.
	private Time marketHoursPost;			// Start time of after-hours market trading hours.
	private Currency marketCurrency;		// The type of currency used in this market.
	private Stock[] marketStockList;		// List of stocks available in this market.
	//private Trader[] marketTraderList;		// List of traders using this market. (commented out until the trader object is available)
	
	
	//=====================
	// OBJECT CONSTRUCTORS
	//=====================
	
	/**
	 * Default object constructor.
	 * <p>
	 * This method performs the following steps:
	 *      1) Initialize Market
	 *      2) Select Stocks
	 *      3) Load Stock Data
	 * <p>
	 * Since this is a constructor, this method is public.
	 * Since this is a constructor, there is no return value.
	 * Since this is the default constructor, there are no arguments passed in. 
	 * <p> 
	 */
	public Market () {
		InitializeMarket(MODE_TUTORIAL_BASIC);
		SelectStocks();
		//PopulateStockData();
	}

	//================
	// OBJECT METHODS
	//================

	private boolean InitializeMarket (int mm) {
		if ((mm < Market.MODE_TUTORIAL_BASIC) || (mm > MODE_ADVANCED)) {
			return false;
		}
		this.marketMode = mm;
		//
		// Add initialization of other market attributes
		//
		return true;
	}
	
	private void SelectStocks () {
		switch (this.marketMode) {
		case MODE_TUTORIAL_BASIC:
				SelectStocksTutorialBasic();
		}
	}
	
	private void SelectStocksTutorialBasic () {
		//
		// 1) Create a blank stock object
		// 2) Generate a random stock indenx number from 0 to 17
		// 3) Check to see if that number has already been selected. If so, select another number.
		// 4) Populate stock object with data for that index number.
		// 5) Repeat steps 1 through 5 until ten of the 18 tutorial stocks has been selected. No duplicates. 
		//
		
		int rnd;
		Integer indexInt;
		boolean indexIsUnique;
		TreeMap<Integer, Integer> indexHashShadow = new TreeMap<Integer, Integer>();

		for (int i = 0; i < STOCK_SELECT_QTY_TUTORIAL; i++) {
			System.out.println("Iteration: " + i);
			indexIsUnique = false;
			while (!indexIsUnique) {
				rnd = RNG.NextInt(18);
				System.out.println("\tRandom number:" + rnd);
				indexInt = indexHashShadow.get(Integer.valueOf(rnd));
				if (indexInt != null) {
					System.out.println("\t\tNot unique.");
					indexIsUnique = false;
				} else {
					System.out.println("\t\tUnique, adding to hashtable.");
					indexHashShadow.put(rnd, rnd);
					indexIsUnique = true;
				}
			}
			
			//marketStockList = new Stock[STOCK_SELECT_QTY_TUTORIAL];
				
		}
		System.out.println("==========Final Result==========\n"+indexHashShadow);
		
	}
}
