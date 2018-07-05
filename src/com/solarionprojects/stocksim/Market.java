package com.solarionprojects.stocksim;

import java.util.Currency;
import java.util.Date;
import java.sql.Time;

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

	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================
	
	//
	// Note: the attributes below represent the full functionality of the stock object, however not all attributes
	// will be used in all difficulty levels of the simulation. The introductory/tutorial difficulty level (easiest)
	// will most likely ignore all but a handful of these attributes.
	//
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
	 *      1) Initialize Stock Values: Sets all object global values to their initial (blank/zero) values.
	 * <p>
	 * Since this is a constructor, this method is public.
	 * Since this is a constructor, there is no return value.
	 * Since this is the default constructor, there are no arguments passed in. 
	 * <p> 
	 */
	public Market () {
		//InitializeValues();
	}

	//================
	// OBJECT METHODS
	//================

}
