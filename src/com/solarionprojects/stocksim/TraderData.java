package com.solarionprojects.stocksim;

import java.awt.Image;

public class TraderData {

	/*
	 * Note: the attributes below represent the full functionality of the Trader class, however not all attributes
	 * will be used in all difficulty levels of the simulation. The introductory/tutorial difficulty level (easiest)
	 * will most likely ignore all but a handful of these attributes.
	 *
	 * public int traderID;							// The sequential, unique number assigned to this trader.
	 * private String traderFirstName;				// The trader's first name.
	 * private String traderLastName;				// The trader's last name.
	 * private String traderBio;					// The trader's background biography.
	 * private int traderBehavior;					// The trader's trading behavior, e.g. bearish, bullish.
	 * private float traderWallet;					// The amount of money the trader has access to.
	 * private int traderFrequency;					// The trader's trading frequency, e.g. how many trades per "hour" (minute).
	 * private Image traderImage;					// The trader's picture.									NOT YET IMPLEMENTED
	 * private TraderFavoriteStock[] traderFavoriteStocks;		// The trader's favorite stock(s) to trade. 	NOT YET IMPLEMENTED
	 * private TraderFavoriteSector[] traderFavoriteSectors;	// The trader's market sector specialty(ies).	NOT YET IMPLEMENTED
	 * private Market[] traderFavoriteMarkets;		// The trader's market preference.							NOT YET IMPLEMENTED
	 * private Holding[] traderHoldings;			// The trader's current list of holdings (positions).		NOT YET IMPLEMENTED
	 * 
	 */
	
	/*
	 * Attributes used in Tutorial Mode
	 * 
	 * public int traderID;							// The sequential, unique number assigned to this trader.
	 * private String traderFirstName;				// The trader's first name.
	 * private String traderLastName;				// The trader's last name.
	 * private String traderBio;					// The trader's background biography.
	 * private float traderWallet;					// The amount of money the trader has access to.
	 * private int traderFrequency;					// The trader's trading frequency, e.g. how many trades per "hour" (minute).
	 * private Image traderImage;					// The trader's picture.									NOT YET IMPLEMENTED
	 * private Holding[] traderHoldings;			// The trader's current list of holdings (positions).		NOT YET IMPLEMENTED
	 * 
	 */
	
	/*
	 * Total of 14 Tutorial Mode Traders
	 */
	public static final String[] TUTORIAL_TRADER_FIRST_NAME = {
			"Adam", "Adrienne", "Brian", "Cynthia", "Denise", 
			"Eric", "Liam", "Lyndsey", "Marie", "Matthew", 
			"Nathan", "Neil", "Nicole", "Samantha" 
			};

	public static final String [] TUTORIAL_TRADER_LAST_NAME = {
			"Anspach", "Basse", "Columbia", "Edelsteen", "Farrell",    
			"Gruding", "Hengegrove", "Lee", "Mason", "Putnam", 
			"Revel", "Stoddard", "Vesubara", "Wasser"    
			};
	
	public static final String [] TUTORIAL_TRADER_BIO = {
			"Bio 01", 
			"Bio 02", 
			"Bio 03", 
			"Bio 04", 
			"Bio 05",    
			"Bio 06", 
			"Bio 07", 
			"Bio 08", 
			"Bio 09", 
			"Bio 10", 
			"Bio 11", 
			"Bio 12", 
			"Bio 13", 
			"Bio 14"    
			};
	
}
