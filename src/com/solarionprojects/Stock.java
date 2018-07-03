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
	private float stockDividendPaid;			// The dollar value of any annual dividend paid for a single share of stock for the current fiscal year.
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
	 * 	- Make sure symbol parameter is of valid length.
	 *  - Make sure symbol parameter is not blank.
	 *  - Make sure symbol attribute is not already set.
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
	 *  - Make sure sector parameter is not blank.
	 *  - Make sure sector attribute is not already set.
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
	 *  - Make sure exchange parameter is not blank.
	 *  - Make sure exchange attribute is not already set.
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
	 *  - Make sure full name parameter is not blank.
	 *  - Make sure full name attribute is not already set.
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

	//-----------------------------
	// ATTRIBUTE: stockDescription
	//-----------------------------
	
	/**
	 * This method returns the current stockDescription attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stock description attribute
	 * @see				SetStockDescription
	 */
	public String GetStockDescription ( ) {
		return this.stockDescription;
	}
	
	/**
	 * This method allows for the one-time setting of the stockDescription attribute value. Subsequent requests
	 * to change the stockDescription will be rejected. Checks to be performed are:
	 *  - Make sure description parameter is not blank.
	 *  - Make sure description attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stock description to set
	 * @return			A boolean value indicating success or failure at setting a new stock description
	 * @see				GetStockDescription
	 */
	public boolean SetStockDescription (String sd) {
		if (sd.equals(EMPTY_STRING)) {
			return false;
		}
		if (this.stockDescription.equals(EMPTY_STRING)) {
			this.stockDescription = sd;
			return true;
		}
		return false;
	}

	//------------------------------
	// ATTRIBUTE: stockCurrentPrice
	//------------------------------
	
	/**
	 * This method returns the stockCurrentPrice attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the current stock price attribute
	 * @see				SetStockCurrentPrice
	 */
	public float GetStockCurrentPrice ( ) {
		return this.stockCurrentPrice;
	}
	
	/**
	 * This method sets the stockCurrentPrice attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The current stock price to set
	 * @return			A boolean value indicating success or failure at setting the current stock price
	 * @see				GetStockCurrentPrice
	 */
	public boolean SetStockCurrentPrice (float scp) {
		if (scp < 0.0f) {
			return false;
		}
		this.stockCurrentPrice = scp;
		return true;
	}

	//---------------------------------
	// ATTRIBUTE: stockCurrentPriceAsk
	//---------------------------------
	
	/**
	 * This method returns the stockCurrentPriceAsk attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the current stock price ask attribute
	 * @see				SetStockCurrentPriceAsk
	 */
	public float GetStockCurrentPriceAsk ( ) {
		return this.stockCurrentPriceAsk;
	}
	
	/**
	 * This method sets the stockCurrentPriceAsk attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The current stock price ask to set
	 * @return			A boolean value indicating success or failure at setting the current stock price ask
	 * @see				GetStockCurrentPriceAsk
	 */
	public boolean SetStockCurrentPriceAsk (float scpa) {
		if (scpa < 0.0f) {
			return false;
		}
		this.stockCurrentPriceAsk = scpa;
		return true;
	}

	//---------------------------------
	// ATTRIBUTE: stockCurrentPriceBid
	//---------------------------------
	
	/**
	 * This method returns the stockCurrentPriceBid attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the current stock price bid attribute
	 * @see				SetStockCurrentPriceBid
	 */
	public float GetStockCurrentPriceBid ( ) {
		return this.stockCurrentPriceBid;
	}
	
	/**
	 * This method sets the stockCurrentPriceBid attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The current stock price bid to set
	 * @return			A boolean value indicating success or failure at setting the current stock price bid
	 * @see				GetStockCurrentPriceBid
	 */
	public boolean SetStockCurrentPriceBid (float scpb) {
		if (scpb < 0.0f) {
			return false;
		}
		this.stockCurrentPriceBid = scpb;
		return true;
	}

	//------------------------------
	// ATTRIBUTE: stockSessionClose
	//------------------------------
	
	/**
	 * This method returns the stockSessionClose attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock session close attribute
	 * @see				SetStockSessionClose
	 */
	public float GetStockSessionClose ( ) {
		return this.stockSessionClose;
	}
	
	/**
	 * This method sets the stockSessionClose attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock session close value to set
	 * @return			A boolean value indicating success or failure at setting the stock session close attribute
	 * @see				GetStockSessionClose
	 */
	public boolean SetStockSessionClose (float ssc) {
		if (ssc < 0.0f) {
			return false;
		}
		this.stockSessionClose = ssc;
		return true;
	}

	//--------------------------------------
	// ATTRIBUTE: stockSessionClosePrevious
	//--------------------------------------
	
	/**
	 * This method returns the stockSessionClosePrevious attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock session close previous attribute
	 * @see				SetStockSessionClosePrevious
	 */
	public float GetStockSessionClosePrevious ( ) {
		return this.stockSessionClosePrevious;
	}
	
	/**
	 * This method sets the stockSessionClosePrevious attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock session close previous value to set
	 * @return			A boolean value indicating success or failure at setting the stock session close previous attribute
	 * @see				GetStockSessionClosePrevious
	 */
	public boolean SetStockSessionClosePrevious (float sscp) {
		if (sscp < 0.0f) {
			return false;
		}
		this.stockSessionClosePrevious = sscp;
		return true;
	}

	//-----------------------------
	// ATTRIBUTE: stockSessionHigh
	//-----------------------------
	
	/**
	 * This method returns the stockSessionHigh attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock session high attribute
	 * @see				SetStockSessionHigh
	 */
	public float GetStockSessionHigh ( ) {
		return this.stockSessionHigh;
	}
	
	/**
	 * This method sets the stockSessionHigh attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock session high value to set
	 * @return			A boolean value indicating success or failure at setting the stock session high attribute
	 * @see				GetStockSessionHigh
	 */
	public boolean SetStockSessionHigh (float ssh) {
		if (ssh < 0.0f) {
			return false;
		}
		this.stockSessionHigh = ssh;
		return true;
	}

	//----------------------------
	// ATTRIBUTE: stockSessionLow
	//----------------------------
	
	/**
	 * This method returns the stockSessionLow attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock session low attribute
	 * @see				SetStockSessionLow
	 */
	public float GetStockSessionLow ( ) {
		return this.stockSessionLow;
	}
	
	/**
	 * This method sets the stockSessionLow attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock session low value to set
	 * @return			A boolean value indicating success or failure at setting the stock session low attribute
	 * @see				GetStockSessionLow
	 */
	public boolean SetStockSessionLow (float ssl) {
		if (ssl < 0.0f) {
			return false;
		}
		this.stockSessionLow = ssl;
		return true;
	}

	//-----------------------------
	// ATTRIBUTE: stockSessionOpen
	//-----------------------------
	
	/**
	 * This method returns the stockSessionOpen attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock session open attribute
	 * @see				SetStockSessionOpen
	 */
	public float GetStockSessionOpen ( ) {
		return this.stockSessionOpen;
	}
	
	/**
	 * This method sets the stockSessionOpen attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock session open value to set
	 * @return			A boolean value indicating success or failure at setting the stock session open attribute
	 * @see				GetStockSessionOpen
	 */
	public boolean SetStockSessionOpen (float sso) {
		if (sso < 0.0f) {
			return false;
		}
		this.stockSessionOpen = sso;
		return true;
	}

	//--------------------------
	// ATTRIBUTE: stockYearHigh
	//--------------------------
	
	/**
	 * This method returns the stockYearHigh attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock year high attribute
	 * @see				SetStockYearHigh
	 */
	public float GetStockYearHigh ( ) {
		return this.stockYearHigh;
	}
	
	/**
	 * This method sets the stockYearHigh attribute value. Since the parameter must be a float or the code
	 * won't compile, and since the attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock year high value to set
	 * @return			A boolean value indicating success or failure at setting the stock year high attribute
	 * @see				GetStockYearHigh
	 */
	public boolean SetStockYearHigh (float syh) {
		if (syh < 0.0f) {
			return false;
		}
		this.stockYearHigh = syh;
		return true;
	}

	//-------------------------
	// ATTRIBUTE: stockYearLow
	//-------------------------
	
	/**
	 * This method returns the stockYearLow attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stock year low attribute
	 * @see				SetStockYearLow
	 */
	public float GetStockYearLow ( ) {
		return this.stockYearLow;
	}
	
	/**
	 * This method sets the stockYearLow attribute value. Since the parameter must be a float or the code
	 * won't compile. Since the attribute value can be anything from 0.0f to ?.?f, a check is needed to
	 * make sure the parameter is not a negative value. Additionally, the year low value cannot be higher
	 * than the year high value, otherwise by definition, it would be the year high value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock year low value to set
	 * @return			A boolean value indicating success or failure at setting the stock year low attribute
	 * @see				GetStockYearLow
	 */
	public boolean SetStockYearLow (float syl) {
		//
		// First check to make sure that the year low value is not negative.
		//
		if (syl < 0.0f) {
			return false;
		}
		//
		// Next, make sure that the year low value is not higher than the year high value.
		//
		if (syl > this.stockYearHigh) {
			return false;
		}
		this.stockYearLow = syl;
		return true;
	}

	//-----------------------------
	// ATTRIBUTE: stockSharesTotal
	//-----------------------------
	
	/**
	 * This method returns the stockSharesTotal attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the stock shares total attribute
	 * @see				SetStockSharesTotal
	 */
	public int GetStockSharesTotal ( ) {
		return this.stockSharesTotal;
	}
	
	/**
	 * This method sets the stockSharesTotal attribute value. Since the parameter must be an int or the code
	 * won't compile, and since the attribute value can be anything from 1 to ?, the only check needed
	 * is to make sure the parameter is not less than one (1).
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The stock shares total value to set
	 * @return			A boolean value indicating success or failure at setting the stock shares total attribute
	 * @see				GetStockSharesTotal
	 */
	public boolean SetStockSharesTotal (int sst) {
		if (sst < 1) {
			return false;
		}
		this.stockSharesTotal = sst;
		return true;
	}

	//-----------------------------------
	// ATTRIBUTE: stockSharesOutstanding
	//-----------------------------------
	
	/**
	 * This method returns the stockSharesOutstanding attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the stock shares outstanding attribute
	 * @see				SetStockSharesOutstanding
	 */
	public int GetStockSharesOutstanding ( ) {
		return this.stockSharesOutstanding;
	}
	
	/**
	 * This method sets the stockSharesOutstanding attribute value. Since the parameter must be an int or the code
	 * won't compile, and since the attribute value can be anything from 0 to ?, the only check needed
	 * is to make sure the parameter is not an invalid value.
	 * <p>
	 * Another important aspect to shares outstanding is that this value cannot be larger than the total number of shares
	 * available in the first place. Since shares outstanding = shares available for purchase, the most shares any company
	 * can ever have should equal the shares total number. You cannot have a total of 10 shares AND have 11 shares
	 * outstanding (more shares available to purchase than the company actual has in total shares. You could, however, 
	 * have 10 shares outstanding (meaning no shares are owned yet), 1 share outstanding (meaning one share is still 
	 * available for purchase), or 0 shares outstanding (meaning all shares are currently owned by shareholders. You can 
	 * also never have a negative outstanding share count.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The stock shares outstanding value to set
	 * @return			A boolean value indicating success or failure at setting the stock shares outstanding attribute
	 * @see				GetStockSharesOutstanding
	 */
	public boolean SetStockSharesOutstanding (int sso) {
		//
		// First, make sure the shares outstanding parameter is even valid, meaning it cannot be less than zero.
		//
		if (sso < 0) {
			return false;
		}
		//
		// Next, make sure that the shares outstanding parameter is less than or equal to the total shares value for this stock.
		//
		if (sso > this.stockSharesTotal) {
			return false;
		}
		this.stockSharesOutstanding = sso;
		return true;
	}



}
