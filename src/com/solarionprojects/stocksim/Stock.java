package com.solarionprojects.stocksim;

public class Stock {

	//=========================
	// OBJECT GLOBAL CONSTANTS
	//=========================
	

	//==========================
	// OBJECT GLOBAL ATTRIBUTES
	//==========================
	
	//
	// Note: the attributes below represent the full functionality of the stock object, however not all attributes
	// will be used in all difficulty levels of the simulation. The introductory/tutorial difficulty level (easiest)
	// will most likely ignore all but a handful of these attributes.
	//
	public int stockID;							// Assigned index number of this stock. Defined in the stock data, selected and populated by the stock market.
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
	private float companyProfit;				// The Company Profit is a given value for purposes of calculating the Earnings Per Share.
	
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
		stockID = SimConstants.INT_ZERO;
		stockSymbol = SimConstants.EMPTY_STRING;
		stockSector = SimConstants.EMPTY_STRING;
		stockExchange = SimConstants.EMPTY_STRING;
		stockFullName = SimConstants.EMPTY_STRING;
		stockDescription = SimConstants.EMPTY_STRING;
		stockCurrentPrice = SimConstants.FLOAT_ZERO;
		stockCurrentPriceAsk = SimConstants.FLOAT_ZERO;
		stockCurrentPriceBid = SimConstants.FLOAT_ZERO;
		stockSessionClose = SimConstants.FLOAT_ZERO;
		stockSessionClosePrevious = SimConstants.FLOAT_ZERO;
		stockSessionHigh = SimConstants.FLOAT_ZERO;
		stockSessionLow = SimConstants.FLOAT_ZERO;
		stockSessionOpen = SimConstants.FLOAT_ZERO;
		stockYearHigh = SimConstants.FLOAT_ZERO;
		stockYearLow = SimConstants.FLOAT_ZERO;
		stockSharesTotal = SimConstants.INT_ZERO;
		stockSharesOutstanding = SimConstants.INT_ZERO;
		stockDividendPaid = SimConstants.FLOAT_ZERO;
		stockEarningsPerShare = SimConstants.FLOAT_ZERO;
		stockMarketCap = SimConstants.FLOAT_ZERO;
		stockProfitEarningsRatio = SimConstants.FLOAT_ZERO;
		stockDividendYield = SimConstants.FLOAT_ZERO;
	}
	
	/**
	 * This method forces the earnings per share to be calculated and update
	 * any associated attributes for the current stock object. 
	 * <p>
	 * As stated above, a stock's earnings per share is calculated by dividing the 
	 * companyProfit by stockSharesOutstanding. The resulting actions of this method 
	 * will be to update the stockEarningsPerShare attribute.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A boolean value indicating success or failure at calculating the earnings per share
	 * @see				CalculateMarketCap, CalculateProfitEarningsRatio, CalculateDividendYield
	 */
	public boolean CalculateEarningsPerShare () {
		boolean rv = false;
		float seps = SimConstants.FLOAT_ZERO; 
		
		//
		// Derive earnings per share
		//
		seps = this.GetCompanyProfit() / this.GetStockSharesOutstanding();
		//
		// Check if earnings per share is a valid value (meaning non-infinite)
		//
		if ((seps == SimConstants.FLOAT_INFINITY_POSITIVE) || (seps == SimConstants.FLOAT_INFINITY_NEGATIVE)) {
			//
			// Earnings per share value is infinite, which means it is an invalid value. Since the
			// value is invalid, there is no further need to set the earnings per share attribute.
			// Return immediately (rv = false).
			//
			/*
			 * Diagnostic code only -- not needed for production.
			 * 
			if (seps == INFINITY_FLOAT_POSITIVE) {
				System.out.println("Posistive Infinity");
			} else {
				System.out.println("Negative Infinity");
			}
			*
			*/
			return rv;
		}
		//System.out.println("Earnings per share = " + seps);
		rv = this.SetStockEarningsPerShare(seps);
		//
		// Need to deal with boolean result of this function.
		//
		return rv;
	}
	
	/**
	 * This method forces the market cap to be calculated and update
	 * any associated attributes for the current stock object. 
	 * <p>
	 * As stated above, a stock's market cap is calculated by multiplying the 
	 * SharesTotal by the present share price. The resulting actions of this method 
	 * will be to update the stockMarketCap attribute.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A boolean value indicating success or failure at calculating the market cap
	 * @see				CalculateEarningsPerShare, CalculateProfitEarningsRatio, CalculateDividendYield
	 */
	public boolean CalculateMarketCap () {
		boolean rv = false;
		float smc = SimConstants.FLOAT_ZERO;
		
		smc = this.GetStockSharesTotal() * this.GetStockCurrentPrice();
		rv = this.SetStockMarketCap(smc);
		//
		// Need to deal with boolean result of this function.
		//
		return rv;
	}
	
	/**
	 * This method forces the profit earnings ratio to be calculated and update
	 * any associated attributes for the current stock object. 
	 * <p>
	 * As stated above, a stock's profit earnings ratio is calculated by dividing 
	 * the stockCurrentPrice by the stockEarningsPerShare. The resulting actions 
	 * of this method will be to update the stockProfitEarningsRatio attribute.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A boolean value indicating success or failure at calculating the profit earnings ratio
	 * @see				CalculateEarningsPerShare, CalculateMarketCap, CalculateDividendYield
	 */
	public boolean CalculateProfitEarningsRatio () {
		boolean rv = false;
		float sper = SimConstants.FLOAT_ZERO;
		
		sper = this.GetStockCurrentPrice() / this.GetStockEarningsPerShare();
		rv = this.SetStockProfitEarningsRatio(sper);
		//
		// Need to deal with boolean result of this function.
		//
		return rv;
	}
	
	/**
	 * This method forces the dividend yield to be calculated and update
	 * any associated attributes for the current stock object. 
	 * <p>
	 * As stated above, a stock's dividend yield is calculated by dividing the dollar 
	 * value of dividends paid in a given year per share of stock held by 
	 * stockCurrentPrice for one share of stock. The resulting actions 
	 * of this method will be to update the dividend yield attribute.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A boolean value indicating success or failure at calculating the dividend yield
	 * @see				CalculateEarningsPerShare, CalculateMarketCap, CalculateProfitEarningsRatio
	 */
	public boolean CalculateDividendYield () {
		boolean rv = false;
		float sdy = SimConstants.FLOAT_ZERO;
		
		sdy = this.GetStockDividendPaid() / this.GetStockCurrentPrice();
		rv = this.SetStockDividendYield(sdy);
		//
		// Need to deal with boolean result of this function.
		//
		return rv;
	}
	
	/**
	 * This method is an override of the default toString method. This will provide the
	 * correct output of the stock object attribute values when called. This method should
	 * function correctly for both explicit .toString() calls as well as implicit string
	 * manipulations (..." + stockObject + "...).
	 * <p>
	 * The method will accept an int parameter to determine which version of toString will
	 * be called. TUTORIAL_MODE_BASIC and TUTORIAL_MODE_ADVANCED will call a brief version
	 * of toString, only outputting a small number of stock attributes. Any other value will
	 * result in the complete output of all stock attributes. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing attributes of the stock object
	 */
	public String toString (int mm) {
		String outputStr = SimConstants.EMPTY_STRING;
		
		if (mm < 3) {
			//
			// The market mode is tutorial basic or tutorial advanced. Gather only the
			// limited stock attributes associated with that market mode.
			//
			outputStr = outputStr + "               stockID: " + stockID + SimConstants.NEW_LINE;
			outputStr = outputStr + "           stockSymbol: " + this.GetStockSymbol() + SimConstants.NEW_LINE;
			outputStr = outputStr + "         stockFullName: " + this.GetStockFullName() + SimConstants.NEW_LINE;
			outputStr = outputStr + "      stockDescription: " + this.GetStockDescription() + SimConstants.NEW_LINE;
			outputStr = outputStr + "     stockCurrentPrice: " + this.GetStockCurrentPrice() + SimConstants.NEW_LINE;
			outputStr = outputStr + "      stockSharesTotal: " + this.GetStockSharesTotal() + SimConstants.NEW_LINE;
			outputStr = outputStr + "stockSharesOutstanding: " + this.GetStockSharesOutstanding();
		} else {
			//
			// The market mode is not a tutorial mode. Gather all the stock attributes.
			//
			outputStr = outputStr + "                  stockID: " + stockID + SimConstants.NEW_LINE;
			outputStr = outputStr + "              stockSymbol: " + this.GetStockSymbol() + SimConstants.NEW_LINE;
			outputStr = outputStr + "              stockSector: " + this.GetStockSector() + SimConstants.NEW_LINE;
			outputStr = outputStr + "            stockExchange: " + this.GetStockExchange() + SimConstants.NEW_LINE;
			outputStr = outputStr + "            stockFullName: " + this.GetStockFullName() + SimConstants.NEW_LINE;
			outputStr = outputStr + "         stockDescription: " + this.GetStockDescription() + SimConstants.NEW_LINE;
			outputStr = outputStr + "        stockCurrentPrice: " + this.GetStockCurrentPrice() + SimConstants.NEW_LINE;
			outputStr = outputStr + "     stockCurrentPriceAsk: " + this.GetStockCurrentPriceAsk() + SimConstants.NEW_LINE;
			outputStr = outputStr + "     stockCurrentPriceBid: " + this.GetStockCurrentPriceBid() + SimConstants.NEW_LINE;
			outputStr = outputStr + "        stockSessionClose: " + this.GetStockSessionClose() + SimConstants.NEW_LINE;
			outputStr = outputStr + "stockSessionClosePrevious: " + this.GetStockSessionClosePrevious() + SimConstants.NEW_LINE;
			outputStr = outputStr + "         stockSessionHigh: " + this.GetStockSessionHigh() + SimConstants.NEW_LINE;
			outputStr = outputStr + "          stockSessionLow: " + this.GetStockSessionLow() + SimConstants.NEW_LINE;
			outputStr = outputStr + "         stockSessionOpen: " + this.GetStockSessionOpen() + SimConstants.NEW_LINE;
			outputStr = outputStr + "            stockYearHigh: " + this.GetStockYearHigh() + SimConstants.NEW_LINE;
			outputStr = outputStr + "             stockYearLow: " + this.GetStockYearLow() + SimConstants.NEW_LINE;
			outputStr = outputStr + "         stockSharesTotal: " + this.GetStockSharesTotal() + SimConstants.NEW_LINE;
			outputStr = outputStr + "   stockSharesOutstanding: " + this.GetStockDescription() + SimConstants.NEW_LINE;
			outputStr = outputStr + "        stockDividendPaid: " + this.GetStockDividendPaid() + SimConstants.NEW_LINE;
			outputStr = outputStr + "    stockEarningsPerShare: " + this.GetStockEarningsPerShare() + SimConstants.NEW_LINE;
			outputStr = outputStr + "           stockMarketCap: " + this.GetStockMarketCap() + SimConstants.NEW_LINE;
			outputStr = outputStr + " stockProfitEarningsRatio: " + this.GetStockProfitEarningsRatio() + SimConstants.NEW_LINE;
			outputStr = outputStr + "       stockDividendYield: " + this.GetStockDividendYield() + SimConstants.NEW_LINE;
			outputStr = outputStr + "            companyProfit: " + this.GetCompanyProfit();
		}
		return outputStr;
	}
	
	//============================
	// OBJECT GETTERS AND SETTERS
	//============================
	
	//--------------------
	// ATTRIBUTE: stockID
	//--------------------
	
	/**
	 * This method returns the stockID attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the stockID attribute
	 * @see				SetStockID
	 */
	public int GetStockID ( ) {
		return this.stockID;
	}
	
	/**
	 * This method allows for the one-time setting of the stockID 
	 * attribute value. Subsequent requests to change the stockID 
	 * will be rejected. Checks to be performed are:
	 * 	- Make sure the parameter is valid (positive, non-zero).
	 *  - Make sure stockID attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int 	The new stockID to set
	 * @return			A boolean value indicating success or failure at setting a new stockID
	 * @see				GetStockID
	 */
	public boolean SetStockID (int sid) {
		if (sid <= SimConstants.INT_ZERO) {
			return false;
		}
		if (this.stockID == SimConstants.INT_ZERO) {
			this.stockID = sid;
			return true;
		}
		return false;
	}
	
	//------------------------
	// ATTRIBUTE: stockSymbol
	//------------------------
	
	/**
	 * This method returns the stockSymbol attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the stockSymbol attribute
	 * @see				SetStockSymbol
	 */
	public String GetStockSymbol ( ) {
		return this.stockSymbol;
	}
	
	/**
	 * This method allows for the one-time setting of the stockSymbol
	 * attribute value. Subsequent requests to change the stockSymbol 
	 * will be rejected. Checks to be performed are:
	 *  - Make sure parameter value is not blank.
	 * 	- Make sure parameter value is of valid length.
	 *  - Make sure stockSymbol attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stockSymbol to set
	 * @return			A boolean value indicating success or failure at setting a new stockSymbol
	 * @see				GetStockSymbol
	 */
	public boolean SetStockSymbol (String ss) {
		if (ss.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if ((ss.length() < SimConstants.STOCK_SYMBOL_MIN_LENGTH) || (ss.length() > SimConstants.STOCK_SYMBOL_MAX_LENGTH)) {
			return false;
		}
		if (this.stockSymbol.equals(SimConstants.EMPTY_STRING)) {
			this.stockSymbol = ss;
			return true;
		}
		return false;
	}
	
	//------------------------
	// ATTRIBUTE: stockSector
	//------------------------
	
	/**
	 * This method returns the stockSector attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the stockSector attribute
	 * @see				SetStockSector
	 */
	public String GetStockSector ( ) {
		return this.stockSector;
	}
	
	/**
	 * This method allows for the one-time setting of the stockSector 
	 * attribute value. Subsequent requests to change the stockSector 
	 * will be rejected. Checks to be performed are:
	 *  - Make sure parameter value is not blank.
	 *  - Make sure stockSector attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stockSector to set
	 * @return			A boolean value indicating success or failure at setting a new stockSector
	 * @see				GetStockSector
	 */
	public boolean SetStockSector (String ss) {
		if (ss.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.stockSector.equals(SimConstants.EMPTY_STRING)) {
			this.stockSector = ss;
			return true;
		}
		return false;
	}
	
	
	//--------------------------
	// ATTRIBUTE: stockExchange
	//--------------------------
	
	/**
	 * This method returns the stockExchange attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the current stockExchange attribute
	 * @see				SetStockExchange
	 */
	public String GetStockExchange ( ) {
		return this.stockExchange;
	}
	
	/**
	 * This method allows for the one-time setting of the stockExchange
	 * attribute value. Subsequent requests to change the stockExchange 
	 * will be rejected. Checks to be performed are:
	 *  - Make sure parameter value is not blank.
	 *  - Make sure stockExchange attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stockExchange to set
	 * @return			A boolean value indicating success or failure at setting a new stockExchange
	 * @see				GetStockExchange
	 */
	public boolean SetStockExchange (String se) {
		if (se.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.stockExchange.equals(SimConstants.EMPTY_STRING)) {
			this.stockExchange = se;
			return true;
		}
		return false;
	}
	
	//--------------------------
	// ATTRIBUTE: stockFullName
	//--------------------------
	
	/**
	 * This method returns the stockFullName attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the stockFullName attribute
	 * @see				SetStockFullName
	 */
	public String GetStockFullName ( ) {
		return this.stockFullName;
	}
	
	/**
	 * This method allows for the one-time setting of the stockFullName 
	 * attribute value. Subsequent requests to change the stockFullName 
	 * will be rejected. Checks to be performed are:
	 *  - Make sure parameter value is not blank.
	 *  - Make sure stockFullName attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stockFullName to set
	 * @return			A boolean value indicating success or failure at setting a new stockFullName
	 * @see				GetStockFullName
	 */
	public boolean SetStockFullName (String sfn) {
		if (sfn.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.stockFullName.equals(SimConstants.EMPTY_STRING)) {
			this.stockFullName = sfn;
			return true;
		}
		return false;
	}

	//-----------------------------
	// ATTRIBUTE: stockDescription
	//-----------------------------
	
	/**
	 * This method returns the stockDescription attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the stockDescription attribute
	 * @see				SetStockDescription
	 */
	public String GetStockDescription ( ) {
		return this.stockDescription;
	}
	
	/**
	 * This method allows for the one-time setting of the stockDescription
	 * attribute value. Subsequent requests to change the stockDescription 
	 * will be rejected. Checks to be performed are:
	 *  - Make sure parameter value is not blank.
	 *  - Make sure stockDescription attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new stockDescription to set
	 * @return			A boolean value indicating success or failure at setting a new stockDescription
	 * @see				GetStockDescription
	 */
	public boolean SetStockDescription (String sd) {
		if (sd.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.stockDescription.equals(SimConstants.EMPTY_STRING)) {
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
	 * @return			A float value representing the stockPCurrentrice attribute
	 * @see				SetStockCurrentPrice
	 */
	public float GetStockCurrentPrice ( ) {
		return this.stockCurrentPrice;
	}
	
	/**
	 * This method sets the stockCurrentPrice attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The new stockCurrentPrice to set
	 * @return			A boolean value indicating success or failure at setting the stockCurrentPrice
	 * @see				GetStockCurrentPrice
	 */
	public boolean SetStockCurrentPrice (float scp) {
		if (scp < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockCurrentPriceAsk attribute
	 * @see				SetStockCurrentPriceAsk
	 */
	public float GetStockCurrentPriceAsk ( ) {
		return this.stockCurrentPriceAsk;
	}
	
	/**
	 * This method sets the stockCurrentPriceAsk attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The new stockCurrentPriceAsk to set
	 * @return			A boolean value indicating success or failure at setting the stockCurrentPriceAsk
	 * @see				GetStockCurrentPriceAsk
	 */
	public boolean SetStockCurrentPriceAsk (float scpa) {
		if (scpa < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockCurrentPriceBid attribute
	 * @see				SetStockCurrentPriceBid
	 */
	public float GetStockCurrentPriceBid ( ) {
		return this.stockCurrentPriceBid;
	}
	
	/**
	 * This method sets the stockCurrentPriceBid attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockCurrentPriceBid to set
	 * @return			A boolean value indicating success or failure at setting the stockCurrentPriceBid
	 * @see				GetStockCurrentPriceBid
	 */
	public boolean SetStockCurrentPriceBid (float scpb) {
		if (scpb < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockSessionClose attribute
	 * @see				SetStockSessionClose
	 */
	public float GetStockSessionClose ( ) {
		return this.stockSessionClose;
	}
	
	/**
	 * This method sets the stockSessionClose attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockSessionClose value to set
	 * @return			A boolean value indicating success or failure at setting the stockSessionClose attribute
	 * @see				GetStockSessionClose
	 */
	public boolean SetStockSessionClose (float ssc) {
		if (ssc < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockSessionClosePrevious attribute
	 * @see				SetStockSessionClosePrevious
	 */
	public float GetStockSessionClosePrevious ( ) {
		return this.stockSessionClosePrevious;
	}
	
	/**
	 * This method sets the stockSessionClosePrevious attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockSessionClosePrevious value to set
	 * @return			A boolean value indicating success or failure at setting the stockSessionClosePrevious attribute
	 * @see				GetStockSessionClosePrevious
	 */
	public boolean SetStockSessionClosePrevious (float sscp) {
		if (sscp < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockSessionHigh attribute
	 * @see				SetStockSessionHigh
	 */
	public float GetStockSessionHigh ( ) {
		return this.stockSessionHigh;
	}
	
	/**
	 * This method sets the stockSessionHigh attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockSessionHigh value to set
	 * @return			A boolean value indicating success or failure at setting the stockSessionHigh attribute
	 * @see				GetStockSessionHigh
	 */
	public boolean SetStockSessionHigh (float ssh) {
		if (ssh < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockSessionLow attribute
	 * @see				SetStockSessionLow
	 */
	public float GetStockSessionLow ( ) {
		return this.stockSessionLow;
	}
	
	/**
	 * This method sets the stockSessionLow attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockSessionLow value to set
	 * @return			A boolean value indicating success or failure at setting the stockSessionLow attribute
	 * @see				GetStockSessionLow
	 */
	public boolean SetStockSessionLow (float ssl) {
		if (ssl < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockSessionOpen attribute
	 * @see				SetStockSessionOpen
	 */
	public float GetStockSessionOpen ( ) {
		return this.stockSessionOpen;
	}
	
	/**
	 * This method sets the stockSessionOpen attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockSessionOpen value to set
	 * @return			A boolean value indicating success or failure at setting the stockSessionOpen attribute
	 * @see				GetStockSessionOpen
	 */
	public boolean SetStockSessionOpen (float sso) {
		if (sso < SimConstants.FLOAT_ZERO) {
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
	 * This method sets the stockYearHigh attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stock year high value to set
	 * @return			A boolean value indicating success or failure at setting the stockYearHigh attribute
	 * @see				GetStockYearHigh
	 */
	public boolean SetStockYearHigh (float syh) {
		if (syh < SimConstants.FLOAT_ZERO) {
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
	 * @return			A float value representing the stockYearLow attribute
	 * @see				SetStockYearLow
	 */
	public float GetStockYearLow ( ) {
		return this.stockYearLow;
	}
	
	/**
	 * This method sets the stockYearLow attribute value. Since the 
	 * parameter must be a float or the code won't compile. Since the 
	 * attribute value can be anything from 0.0f to ?.?f, a check is 
	 * needed to make sure the parameter is not a negative value. 
	 * Additionally, the year low value cannot be higher
	 * than the year high value, otherwise by definition, it would be 
	 * the year high value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockYearLow value to set
	 * @return			A boolean value indicating success or failure at setting the stockYearLow attribute
	 * @see				GetStockYearLow
	 */
	public boolean SetStockYearLow (float syl) {
		//
		// First check to make sure that the year low value is not negative.
		//
		if (syl < SimConstants.FLOAT_ZERO) {
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
	 * @return			An int value representing the stockSharesTotal attribute
	 * @see				SetStockSharesTotal
	 */
	public int GetStockSharesTotal ( ) {
		return this.stockSharesTotal;
	}
	
	/**
	 * This method sets the stockSharesTotal attribute value. Since the 
	 * parameter must be an int or the code won't compile, and since the 
	 * attribute value can be anything from 1 to ?, the only check needed
	 * is to make sure the parameter is not less than one (1).
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The stockSharesTotal value to set
	 * @return			A boolean value indicating success or failure at setting the stockSharesTotal attribute
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
	 * @return			An int value representing the stockSharesOutstanding attribute
	 * @see				SetStockSharesOutstanding
	 */
	public int GetStockSharesOutstanding ( ) {
		return this.stockSharesOutstanding;
	}
	
	/**
	 * This method sets the stockSharesOutstanding attribute value. Since the 
	 * parameter must be an int or the code won't compile, and since the 
	 * attribute value can be anything from 0 to ?, the only check needed
	 * is to make sure the parameter is not an invalid value.
	 * <p>
	 * Additional important aspects to shares outstanding:
	 * 1) this value cannot be larger than the total number of shares available 
	 * in the first place. Since shares outstanding = shares available for 
	 * purchase, the most shares any company can ever have should equal the 
	 * shares total number. 
	 * <p>
	 * 2) You cannot have a total of 10 shares AND have 11 shares outstanding 
	 * (e.g. more shares available to purchase than the company actual has in 
	 * total shares). You could, however, have 10 shares outstanding (meaning 
	 * no shares are owned yet), 1 share outstanding (meaning one share is 
	 * still available for purchase), or 0 shares outstanding (meaning all 
	 * shares are currently owned by shareholders. 
	 * <p>
	 * 3) You can never have a negative outstanding share count.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The stockSharesOutstanding value to set
	 * @return			A boolean value indicating success or failure at setting the stockSharesOutstanding attribute
	 * @see				GetStockSharesOutstanding
	 */
	public boolean SetStockSharesOutstanding (int sso) {
		//
		// First, make sure the parameter value is even valid, meaning it cannot be less than zero.
		//
		if (sso < SimConstants.INT_ZERO) {
			return false;
		}
		//
		// Make sure that the parameter value is less than or equal to the total shares value for this stock.
		//
		if (sso > this.stockSharesTotal) {
			return false;
		}
		this.stockSharesOutstanding = sso;
		return true;
	}

	//------------------------------
	// ATTRIBUTE: stockDividendPaid
	//------------------------------
	
	/**
	 * This method returns the stockDividendPaid attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stockDividendPaid attribute
	 * @see				SetStockDividendPaid
	 */
	public float GetStockDividendPaid ( ) {
		return this.stockDividendPaid;
	}
	
	/**
	 * This method sets the stockDividendPaid attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not negative.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockDividendPaid value to set
	 * @return			A boolean value indicating success or failure at setting the stockDividendPaid attribute
	 * @see				GetStockDividendPaid
	 */
	public boolean SetStockDividendPaid (float sdp) {
		if (sdp < SimConstants.FLOAT_ZERO) {
			return false;
		}
		this.stockDividendPaid = sdp;
		return true;
	}

	//----------------------------------
	// ATTRIBUTE: stockEarningsPerShare
	//----------------------------------
	
	/**
	 * This method returns the stockEarningsPerShare attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stockEarningsPerShare attribute
	 * @see				SetStockEarningsPerShare
	 */
	public float GetStockEarningsPerShare ( ) {
		return this.stockEarningsPerShare;
	}
	
	/**
	 * This method sets the stockEarningsPerShare attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not negative.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockEarningsPerShare value to set
	 * @return			A boolean value indicating success or failure at setting the stockEarningsPerShare attribute
	 * @see				GetStockEarningsPerShare
	 */
	public boolean SetStockEarningsPerShare (float seps) {
		if (seps < SimConstants.FLOAT_ZERO) {
			return false;
		}
		this.stockEarningsPerShare = seps;
		return true;
	}

	//---------------------------
	// ATTRIBUTE: stockMarketCap
	//---------------------------
	
	/**
	 * This method returns the stockMarketCap attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stockMarketCap attribute
	 * @see				SetStockMarketCap
	 */
	public float GetStockMarketCap ( ) {
		return this.stockMarketCap;
	}
	
	/**
	 * This method sets the stockMarketCap attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 1.0f to ?.?f, check to see if the
	 * parameter is greater than 1.0f.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockMarketCap value to set
	 * @return			A boolean value indicating success or failure at setting the stockMarketCap attribute
	 * @see				GetStockMarketCap
	 */
	public boolean SetStockMarketCap (float smc) {
		if (smc < SimConstants.FLOAT_DOLLAR) {
			return false;
		}
		this.stockMarketCap = smc;
		return true;
	}

	//-------------------------------------
	// ATTRIBUTE: stockProfitEarningsRatio
	//-------------------------------------
	
	/**
	 * This method returns the stockProfitEarningsRatio attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stockProfitEarningsRatio attribute
	 * @see				SetStockProfitEarningsRatio
	 */
	public float GetStockProfitEarningsRatio ( ) {
		return this.stockProfitEarningsRatio;
	}
	
	/**
	 * This method sets the stockProfitEarningsRatio attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.01f to ?.?f, check to see if the
	 * parameter is greater than 0.01f.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockProfitEarningsRatio value to set
	 * @return			A boolean value indicating success or failure at setting the stockProfitEarningsRatio attribute
	 * @see				GetStockProfitEarningsRatio
	 */
	public boolean SetStockProfitEarningsRatio (float sper) {
		if (sper < SimConstants.FLOAT_PENNY) {
			return false;
		}
		this.stockProfitEarningsRatio = sper;
		return true;
	}

	//-------------------------------
	// ATTRIBUTE: stockDividendYield
	//-------------------------------
	
	/**
	 * This method returns the stockDividendYield attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the stockDividendYield attribute
	 * @see				SetStockDividendYield
	 */
	public float GetStockDividendYield ( ) {
		return this.stockDividendYield;
	}
	
	/**
	 * This method sets the stockDividendYield attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, check to see if the
	 * parameter is greater than 0.01f.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The stockDividendYield value to set
	 * @return			A boolean value indicating success or failure at setting the stockDividendYield attribute
	 * @see				GetStockDividendYield
	 */
	public boolean SetStockDividendYield (float sdy) {
		if (sdy < SimConstants.FLOAT_ZERO) {
			return false;
		}
		this.stockDividendYield = sdy;
		return true;
	}

	//--------------------------
	// ATTRIBUTE: companyProfit
	//--------------------------
	
	/**
	 * This method returns the companyProfit attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the companyProfit attribute
	 * @see				SetCompanyProfit
	 */
	public float GetCompanyProfit ( ) {
		return this.companyProfit;
	}
	
	/**
	 * This method sets the companyProfit attribute value. Since the 
	 * parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.01f to ?.?f, check to see if the
	 * parameter is greater than 0.01f.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The companyProfit value to set
	 * @return			A boolean value indicating success or failure at setting the companyProfit attribute
	 * @see				GetCompanyProfit
	 */
	public boolean SetCompanyProfit (float cp) {
		if (cp < SimConstants.FLOAT_PENNY) {
			return false;
		}
		this.companyProfit = cp;
		return true;
	}

}