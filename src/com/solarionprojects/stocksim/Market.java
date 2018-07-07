package com.solarionprojects.stocksim;

import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
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
	 *      2) Select Stocks and load stock data
	 *      3) 
	 * <p>
	 * Since this is a constructor, this method is public.
	 * Since this is a constructor, there is no return value.
	 * Since this is the default constructor, there are no arguments passed in. 
	 * <p> 
	 */
	public Market () {
		//
		// For initial development purposes, the line below forces the market to initialize in the
		// basic tutorial mode. In the future, there will be an overload of this constructor that
		// will allow for any market mode to be selected as an argument.
		//
		InitializeMarket(MODE_TUTORIAL_BASIC);
		SelectStocks();
		//PopulateStockData();
	}

	//================
	// OBJECT METHODS
	//================

	/**
	 * This method initializes the Market object attributes.
	 * <p>
	 * Attributes affected by this method are as follows:
	 * 	- marketMode
	 * 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A boolean value indicating success or failure at initializing the market object
	 * @see				SelectStocks				
	 */
	private boolean InitializeMarket (int mm) {
		//
		// Range check the market mode parameter value to make sure it's valid
		//
		if ((mm < Market.MODE_TUTORIAL_BASIC) || (mm > MODE_ADVANCED)) {
			return false;
		}
		this.marketMode = mm;
		//
		// Add initialization of other market attributes
		//
		return true;
	}
	
	/**
	 * This method determines which market mode the market object is set for and will execute the
	 * corresponding stock selection method.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @see 			SelectStocksTutorialBasic				
	 */
	private void SelectStocks () {
		switch (this.marketMode) {
		case MODE_TUTORIAL_BASIC:
				SelectStocksTutorialBasic();
		}
	}
	
	/**
	 * This method selects stocks for the basic tutorial mode. In the basic tutorial mode, only
	 * ten stocks are selected, and only a limited set of attributes for those stocks is loaded.
	 * This method has to ensure that each of the ten stocks selected are unique (no selecting
	 * the same stock two or more times).
	 * <p>
	 * This method relies upon a random number generator and the TreeMap class to select stocks,
	 * validate uniqueness, and sort the list of selected stocks.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @see		SelectStocks				
	 */
	private void SelectStocksTutorialBasic () {
		int rnd;							// Random number variable
		Integer indexInt;					// The current index integer
		boolean indexIsUnique;				// Boolean to represent uniqueness of a given random number
		TreeMap<Integer, Integer> indexHash = new TreeMap<Integer, Integer>();
											// TreeMap is a variation of a hash table that has a built-in 
											// sorting function to keep key/val pairs sorted by key 
		marketStockList = new Stock[STOCK_SELECT_QTY_TUTORIAL];
		
		//
		// Set up the for loop to represent the ten selected stocks for basic tutorial mode
		//
		for (int i = 0; i < STOCK_SELECT_QTY_TUTORIAL; i++) {
			//
			// Set the boolean uniqueness value to false (presumed not unique)
			//
			indexIsUnique = false;
			//
			// While the random value is not unique, keep pulling new random values
			//
			while (!indexIsUnique) {
				//
				// Request the next random number (the parameter is the MAX value for the random
				// number, exclusive (not included)).
				//
				rnd = RNG.NextInt(18);
				//
				// Query the TreeMap to see if the selected key already exists
				//
				indexInt = indexHash.get(Integer.valueOf(rnd));
				//
				// If the key already exists, the indexInt value will be the value of that key. This means the key already exists.
				// If the key does not exist, the indexInt will be null. This means we can add the key/val pair to the TreeMap.
				//
				if (indexInt != null) {
					//
					// Found the key, so not unique, so do not add to the TreeMap and perform 
					// another loop to request an additional random number
					//
					indexIsUnique = false;
				} else {
					//
					// No key was found, so this random value is unique, therefore add it to the TreeMap.
					//
					indexHash.put(rnd, rnd);
					//
					// Load the stock data for tutorial mode
					//
					Stock s = new Stock();
					s.stockIndexNumber = rnd;
					s.SetStockSymbol(StockData.TUTORIAL_BASIC_SYMBOLS[rnd]);
					s.SetStockFullName(StockData.TUTORIAL_FULL_NAMES[rnd]);
					s.SetStockDescription(StockData.TUTORIAL_DESCRIPTIONS[rnd]);
					s.SetStockCurrentPrice(StockData.TUTORIAL_CURRENT_PRICE[rnd]);
					s.SetStockSharesTotal(StockData.TUTORIAL_SHARES_TOTAL[rnd]);
					s.SetStockSharesOutstanding(StockData.TUTORIAL_SHARES_OUTSTANDING[rnd]);
					marketStockList[i] = s;
					//
					// Since the value was unique, set the boolean to true to allow us to exit the while 
					// loop (for random number selection) and let us skip to the next iteration of the
					// selection loop.
					//
					indexIsUnique = true;
				}
			}
			
		}
		System.out.println("Stock 0 is: " + marketStockList[0].toString(1));
	}
}
