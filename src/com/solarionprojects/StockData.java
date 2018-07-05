package com.solarionprojects;

public class StockData {

	/*
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
	private float companyProfit;				// The Company Profit is a given value for purposes of calculating the Earnings Per Share.
	*/
	
	//
	// Attributes used in Tutorial Mode
	//
	// private String stockSymbol;				// Stock ticker symbol. Can be anywhere from one to five letters, typically three or four.
	// private String stockFullName;			// The full name of the stock, e.g. Symbol AMZN = Full Name Amazon.com, Inc.
	// private String stockDescription; 		// A short description of the stock.
	// private float stockCurrentPrice;			// The current price of the stock.
	// private int stockSharesTotal;			// The total number of shares available of this stock.
	// private int stockSharesOutstanding;		// The number of shares held/owned by investors/traders/not in the company's pool; e.g. stockSharesTotal - stockSharesOutstanding = shares available for purchase.
	//
	
	//
	// Holdings used in Tutorial Mode (COMMODITIES)
	//
	// Holdings available in tutorial mode:
	// COCOA		- COCO	- CJ	- Agricultural crop gathered from farming, primarily consumed as food
	// COFFEE		- COFE	- KT	- Agricultural crop gathered from farming, primarily consumed as food
	// COPPER		- COPR	- HG	- Mineral gathered from mining, primarily used as a resource for tools
	// CORN			- CORN	- ZC	- Agricultural crop gathered from farming, primarily consumed as food and used for fuels
	// COTTON		- COTN	- TT	- Agricultural crop gathered from farming, primarily used for textiles and clothing
	// CRUDE OIL	- COIL	- CL	- Liquid collected from pumping, primarily refined into fuels
	// GOLD			- GOLD	- GC	- Mineral gathered from mining, primarily used as currency and jewelry
	// LIVE CATTLE	- LIVC	- LE	- Animal crop gathered from cattle ranch, primarily consumed as food
	// LUMBER		- LMBR	- LBS	- Resource gathered from timber farming, used as a resource for tools and building
	// NATURAL GAS	- NATG	- NG	- Gas collected from pumping, primarily refined into fuel
	// OATS			- OATS	- ZO	- Agricultural crop gathered from farming, primarily consumed as food
	// ORANGE JUICE	- ORJU	- OJ	- Agricultural crop gathered from farming, primarily consumed as food
	// PLATINUM		- PLAT	- PL	- Mineral gathered from mining, primarily used as a resource for tools and jewelry
	// ROUGH RICE	- RICE	- ZR	- Agricultural crop gathered from farming, primarily consumed as food
	// SILVER		- SLVR	- SI	- Mineral gathered from mining, primarily used for currency and jewelry
	// SOYBEANS		- SOYB	- ZS	- Agricultural crop gathered from farming, primarily consumed as food
	// SUGAR		- SUGR	- YO	- Agricultural crop gathered from farming, primarily consumed as food
	// WHEAT		- WEAT	- ZW	- Agricultural crop gathered from farming, primarily consumed as food
	//
	
	
	public static final String[] TUTORIAL_BASIC_SYMBOLS = {
			"COCO", "COFE", "COPR", "CORN", "COTN", "COIL", 
			"GOLD", "LIVC", "LMBR", "NATG", "OATS", "ORJU", 
			"PLAT", "RICE", "SLVR", "SOYB", "SUGR", "WEAT"
			};
	public static final String[] TUTORIAL_FULL_NAMES = {
			"Cocoa", "Coffee", "Copper", "Corn", "Cotton","Crude Oil", 
			"Gold", "Live Cattle", "Lumber", "Natural Gas", "Oats", "Orange Juice", 
			"Platinum", "Rough Rice", "Silver", "Soybeans", "Sugar", "Wheat"
			};
	public static final String[] TUTORIAL_DESCRIPTIONS = {
			"Agricultural crop gathered from farming, primarily consumed as food", "Agricultural crop gathered from farming, primarily consumed as food", 
			"Mineral gathered from mining, primarily used as a resource for tools", "Agricultural crop gathered from farming, primarily consumed as food and used for fuels",
			"Agricultural crop gathered from farming, primarily used for textiles and clothing", "Liquid collected from pumping, primarily refined into fuels",
			"Mineral gathered from mining, primarily used as currency and jewelry", "Animal crop gathered from cattle ranch, primarily consumed as food", 
			"Resource gathered from timber farming, used as a resource for tools and building", "Gas collected from pumping, primarily refined into fuel",
			"Agricultural crop gathered from farming, primarily consumed as food", "Agricultural crop gathered from farming, primarily consumed as food",
			"Mineral gathered from mining, primarily used as a resource for tools and jewelry", "Agricultural crop gathered from farming, primarily consumed as food",
			"Mineral gathered from mining, primarily used for currency and jewelry", "Agricultural crop gathered from farming, primarily consumed as food",
			"Agricultural crop gathered from farming, primarily consumed as food", "Agricultural crop gathered from farming, primarily consumed as food"
			};
	public static final float[] TUTORIAL_CURRENT_PRICE = {
			1.0f, 1.25f, 2.50f, 1.0f, 1.0f, 4.5f,
			7.0f, 4.0f,	1.5f, 3.0f, 1.25f, 2.0f,
			10.0f, 1.25f, 5.0f, 1.25f, 1.5f, 1.25f
			};
	public static final int[] TUTORIAL_SHARES_TOTAL = {
			35000, 45000, 10000, 60000, 65000, 20000,
			3000, 35000, 75000, 25000, 80000, 45000,
			1000, 65000, 5000, 70000, 55000, 70000
			};
	public static final int[] TUTORIAL_SHARES_OUTSTANDING = {
			0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0,
			};
	
}
