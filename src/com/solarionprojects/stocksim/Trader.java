package com.solarionprojects.stocksim;

import java.awt.Image;

public class Trader extends Thread {

	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================
	

	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================

	public int traderID;							// The sequential, unique number assigned to this trader.	
	private String traderFirstName;					// The trader's first name.	
	private String traderLastName;					// The trader's last name.	
	private String traderBio;						// The trader's background biography.	
	private String traderBehavior;					// The trader's trading behavior, e.g. bearish, bullish.	
	private float traderWallet;						// The amount of money the trader has access to.	
	private int	traderFrequency;					// The trader's trading frequencly, e.g. how many trades per "hour" (minute).	
	private Image traderPicture;					// The trader's picture.	
	//private TraderFavoriteStock[] traderFavoriteStocks;		// The trader's favorits stock(s) to trade.	
	//private TraderFavoriteSector[] traderFavoriteSectors;	// The trader's market sector specialty(ies).	
	//private Market[] traderFavoriteMarkets;		// The trader's market preference.	
	//private Holding[] traderHoldings;				// The trader's current list of holdings (positions).	

	
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
	public Trader () {
		InitializeValues();
	}

	
	//================
	// OBJECT METHODS
	//================
	
	/**
	 * This method sets all trader attribute values to their initial (blank/zero) state. This method takes
	 * no parameters and provides no return value.  
	 * <p>
	 * This method is private and should only be called by an object constructor.
	 * <p>
	 */
	private void InitializeValues ( ) {
		traderID = SimConstants.INT_ZERO;
		traderFirstName = SimConstants.EMPTY_STRING;
		traderLastName = SimConstants.EMPTY_STRING;
		traderBio = SimConstants.EMPTY_STRING;
		traderBehavior = SimConstants.EMPTY_STRING;
		traderWallet = SimConstants.FLOAT_ZERO;
		traderFrequency = SimConstants.INT_ZERO;
		traderPicture = null;
		//traderStockFavorites = null;
		//traderSectorFavorites = null;
		//traderMarketFavorites = null;
		//traderHoldings = null;
	}

	//============================
	// OBJECT GETTERS AND SETTERS
	//============================
	
	//---------------------
	// ATTRIBUTE: traderID
	//---------------------
	
	/**
	 * This method returns the traderID attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the traderID attribute
	 * @see				SetTraderID
	 */
	public int GetTraderID ( ) {
		return this.traderID;
	}
	
	/**
	 * This method allows for the one-time setting of the traderID attribute value. 
	 * Subsequent requests to change the stockSymbol will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *  - Make sure traderID attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new traderID to set
	 * @return			A boolean value indicating success or failure at setting a new traderID
	 * @see				GetTraderID
	 */
	public boolean SetTraderID (int tid) {
		if (tid <= SimConstants.INT_ZERO) {
			return false;
		}
		if (this.traderID == SimConstants.INT_ZERO) {
			this.traderID = tid;
			return true;
		}
		return false;
	}
	


	
}
