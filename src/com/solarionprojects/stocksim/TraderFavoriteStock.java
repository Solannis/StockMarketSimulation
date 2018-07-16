package com.solarionprojects.stocksim;

public class TraderFavoriteStock {

	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================
	

	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================

	public int favoriteStockID;						// The sequential, unique number assigned to this stock.
	private String favoriteStockSymbol;				// Symbol of the stock favorite.
	private float favoriteStockPriceBuyLow;			// Lowest price at which the trader is likely to buy the stock.
	private float favoriteStockPriceBuyHigh;		// Highest price at which the trader is likely to buy the stock.
	private float favoriteStockPriceSellLow;		// Lowest price at which the trader is likely to sell the stock.
	private float favoriteStockPriceSellHigh;		// Highest price at which the trader is likely to sell the stock.

	
	//=====================
	// OBJECT CONSTRUCTORS
	//=====================
	
	/**
	 * Default object constructor.
	 * <p>
	 * This method performs the following steps:
	 *      1) Initialize TraderFavoriteStock Values: Sets all object global values to their initial (blank/zero) values.
	 * <p>
	 * Since this is a constructor, this method is public.
	 * Since this is a constructor, there is no return value.
	 * Since this is the default constructor, there are no arguments passed in. 
	 * <p> 
	 */
	public TraderFavoriteStock () {
		InitializeValues();
	}

	
	//================
	// OBJECT METHODS
	//================
	
	/**
	 * This method sets all trader favorite stock attribute values to their initial (blank/zero) state. 
	 * This method takes no parameters and provides no return value.  
	 * <p>
	 * This method is private and should only be called by an object constructor.
	 * <p>
	 */
	private void InitializeValues ( ) {
		favoriteStockID = SimConstants.INT_ZERO;
		favoriteStockSymbol = SimConstants.EMPTY_STRING;
		favoriteStockPriceBuyLow = SimConstants.FLOAT_ZERO;
		favoriteStockPriceBuyHigh = SimConstants.FLOAT_ZERO;
		favoriteStockPriceSellLow = SimConstants.FLOAT_ZERO;
		favoriteStockPriceSellHigh = SimConstants.FLOAT_ZERO;
	}

	//============================
	// OBJECT GETTERS AND SETTERS
	//============================
	
	//--------------------------------
	// ATTRIBUTE: favoriteStockSymbol
	//--------------------------------
	
	/**
	 * This method returns the current favoriteStockID attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the favorite stock symbol attribute
	 * @see				SetFavoriteStockSymbol
	 */
	public String GetFavoriteStockSymbol ( ) {
		return this.favoriteStockSymbol;
	}
	
	/**
	 * This method allows for the one-time setting of the favoriteStockSymbol attribute value. 
	 * Subsequent requests to change the favoriteStockSymbol will be rejected. Checks to be 
	 * performed are:
	 * 	- Make sure symbol parameter is of valid length.
	 *  - Make sure symbol parameter is not blank.
	 *  - Make sure symbol attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new favorite stock symbol to set
	 * @return			A boolean value indicating success or failure at setting a new favorite stock symbol
	 * @see				GetFavoriteStockSymbol
	 */
	public boolean SetFavoriteStockSymbol (String fss) {
		if ((fss.length() < SimConstants.STOCK_SYMBOL_MIN_LENGTH) || (fss.length() > SimConstants.STOCK_SYMBOL_MAX_LENGTH)) {
			return false;
		}
		if (fss.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.favoriteStockSymbol.equals(SimConstants.EMPTY_STRING)) {
			this.favoriteStockSymbol = fss;
			return true;
		}
		return false;
	}
	


}
