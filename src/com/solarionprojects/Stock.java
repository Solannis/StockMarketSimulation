package com.solarionprojects;

public class Stock {

	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================
	
	private static final int STOCK_SYMBOL_MIN_LENGTH = 1;
	private static final int STOCK_SYMBOL_MAX_LENGTH = 5;
	private static final float ZERO_FLOAT = 0.0f;
	private static final String EMPTY_STRING = "";

	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================
	
	//
	// Note: the attributes below represent the full functionality of the stock object, however not all attributes
	// will be used in all difficulty levels of the simulation. The introductory/tutorial difficulty level (easiest)
	// will most likely ignore all but a handful of these attributes.
	//
	private String stockSymbol;					// Stock ticker symbol. Can be anywhere from one to five letters, typically three or four.
	private String stockSector; 				// The market sector the stock belongs to, e.g. Tech, Healthcare, Industrials, Utilities, Transportation.
	private String stockExchange;				// The specific market exchange the stock is traded upon/within, e.g. NYSE, DOW, NASDAQ.
	private String stockFullName;				// The full name of the stock, e.g. Symbol AMZN = Full Name Amazon.com, Inc.
	private String stockDescription; 			// A short description of the stock.
	private float stockCurrentPrice;			// The current price of the stock.
	private float stockCurrentPriceAsk;			// The price of the stock a seller is willing to sell shares for.
	private float stockCurrentPriceBid;			// The price of the stock a buyer is willing to buy shares for.
	private float stockSessionClose;			// The stock value at close of a given trading ession.
	private float stockSessionClosePrevious;	// The stock value at close of the prior trading session.
	private float stockSessionHigh;				// The highest stock value during the current trading session.
	private float stockSessionLow;				// The lowest stock value during the current trading session.
	private float stockSessionOpen;				// The stock value at the open of the current trading session.
	private float stockYearHigh;				// The highest stock value during the current 52-week period.
	private float stockYearLow;					// The lowest stock value durin the current 52-week period.
	private	int stockSharesTotal;				// The total number of shares available of this stock.
	private int stockSharesOutstanding;			// The number of shares held/owned by investors/traders/not in the company's pool; e.g. stockSharesTotal - stockSharesOutstanding = shares available for purchase.
	private float stockDividendPaid;			// The dollar value of any dividend paid for a single share of stock for the current fiscal year.
	private float stockEarningsPerShare;		// The EPS is calculated by dividing the companyProfit by stockSharesOutstanding.
	private float stockMarketCap;				// The Market Cap is calculated by multiplying the SharesTotal by the present share price.
	private float stockProfitEarningsRatio;		// The Profit Earnings Ratio is calculated by dividing the stockCurrentPrice by the stockEarningsPerShare.
	private float stockDividendYield;			// The Dividend Yield is calculated by dividing the dollar value of dividends paid in a given year per share of stock held by stockCurrentPrice for one share of stock.
	
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
	public Stock () {
		InitializeValues();
	}

	//================
	// OBJECT METHODS
	//================
	
	/**
	 * This method sets all stock attribute values to their initial (blank/zero) state. This method takes
	 * no parameters and provides no return value.  
	 * <p>
	 * This method is private and should only be called by an object constructor.
	 * <p>
	 */
	private void InitializeValues ( ) {
		stockSymbol = EMPTY_STRING;
		stockSector = EMPTY_STRING;
		stockExchange = EMPTY_STRING;
		stockFullName = EMPTY_STRING;
		stockDescription = EMPTY_STRING;
		stockCurrentPrice = ZERO_FLOAT;
		stockCurrentPriceAsk = ZERO_FLOAT;
		stockCurrentPriceBid = ZERO_FLOAT;
		stockSessionClose = ZERO_FLOAT;
		stockSessionClosePrevious = ZERO_FLOAT;
		stockSessionHigh = ZERO_FLOAT;
		stockSessionLow = ZERO_FLOAT;
		stockSessionOpen = ZERO_FLOAT;
		stockYearHigh = ZERO_FLOAT;
		stockYearLow = ZERO_FLOAT;
		stockSharesTotal = 0;
		stockSharesOutstanding = 0;
		stockDividendPaid = ZERO_FLOAT;
		stockEarningsPerShare = ZERO_FLOAT;
		stockMarketCap = ZERO_FLOAT;
		stockProfitEarningsRatio = ZERO_FLOAT;
		stockDividendYield = ZERO_FLOAT;
	}
	
	//============================
	// OBJECT GETTERS AND SETTERS
	//============================
	
	//------------------------
	// ATTRIBUTE: stockSymbol
	//------------------------
	
	/**
	 * This method returns the current stockSymbol attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stock symbol attribute
	 * @see				SetStockSymbol
	 */
	public String GetStockSymbol ( ) {
		return this.stockSymbol;
	}
	
	/**
	 * This method allows for the one-time setting of the stockSymbol attribute value. Subsequent requests
	 * to change the stockSymbol will be rejected. Checks to be performed are:
	 * 	- Make sure symbol is valid length.
	 *  - Make sure symbol is not blank.
	 *  - Make sure symbol is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stock symbol to set
	 * @return			A boolean value indicating success or failure at setting a new stock symbol
	 * @see				GetStockSymbol
	 */
	public boolean SetStockSymbol (String ss) {
		if ((ss.length() < STOCK_SYMBOL_MIN_LENGTH) || (ss.length() > STOCK_SYMBOL_MAX_LENGTH)) {
			return false;
		}
		if (ss.equals(EMPTY_STRING)) {
			return false;
		}
		if (this.stockSymbol.equals(EMPTY_STRING)) {
			this.stockSymbol = ss;
			return true;
		}
		return false;
	}
	
	//------------------------
	// ATTRIBUTE: stockSector
	//------------------------
	
	/**
	 * This method returns the current stockSector attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stock sector attribute
	 * @see				SetStockSector
	 */
	public String GetStockSector ( ) {
		return this.stockSector;
	}
	
	/**
	 * This method allows for the one-time setting of the stockSector attribute value. Subsequent requests
	 * to change the stockSector will be rejected. Checks to be performed are:
	 *  - Make sure sector is not blank.
	 *  - Make sure sector is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stock sector to set
	 * @return			A boolean value indicating success or failure at setting a new stock sector
	 * @see				GetStockSector
	 */
	public boolean SetStockSector (String ss) {
		if (ss.equals(EMPTY_STRING)) {
			return false;
		}
		if (this.stockSector.equals(EMPTY_STRING)) {
			this.stockSector = ss;
			return true;
		}
		return false;
	}
	
	
	//--------------------------
	// ATTRIBUTE: stockExchange
	//--------------------------
	
	/**
	 * This method returns the current stockExchange attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stock exchange attribute
	 * @see				SetStockExchange
	 */
	public String GetStockExchange ( ) {
		return this.stockExchange;
	}
	
	/**
	 * This method allows for the one-time setting of the stockExchange attribute value. Subsequent requests
	 * to change the stockExchange will be rejected. Checks to be performed are:
	 *  - Make sure exchange is not blank.
	 *  - Make sure exchange is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stock Exchange to set
	 * @return			A boolean value indicating success or failure at setting a new stock exchange
	 * @see				GetStockExchange
	 */
	public boolean SetStockExchange (String se) {
		if (se.equals(EMPTY_STRING)) {
			return false;
		}
		if (this.stockExchange.equals(EMPTY_STRING)) {
			this.stockExchange = se;
			return true;
		}
		return false;
	}
	
	//--------------------------
	// ATTRIBUTE: stockFullName
	//--------------------------
	
	/**
	 * This method returns the current stockFullName attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stock full name attribute
	 * @see				SetStockFullName
	 */
	public String GetStockFullName ( ) {
		return this.stockFullName;
	}
	
	/**
	 * This method allows for the one-time setting of the stockFullName attribute value. Subsequent requests
	 * to change the stockFullName will be rejected. Checks to be performed are:
	 *  - Make sure full name is not blank.
	 *  - Make sure full name is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stock full name to set
	 * @return			A boolean value indicating success or failure at setting a new stock full name
	 * @see				GetStockFullName
	 */
	public boolean SetStockFullName (String sfn) {
		if (sfn.equals(EMPTY_STRING)) {
			return false;
		}
		if (this.stockFullName.equals(EMPTY_STRING)) {
			this.stockFullName = sfn;
			return true;
		}
		return false;
	}


}
