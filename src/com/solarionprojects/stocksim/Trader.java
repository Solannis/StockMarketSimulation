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
	private int traderBehavior;						// The trader's trading behavior, e.g. bearish, bullish.	
	private float traderWallet;						// The amount of money the trader has access to.	
	private int	traderFrequency;					// The trader's trading frequency, e.g. how many trades per "hour" (minute).	
	private Image traderImage;						// The trader's picture.	
	//private TraderFavoriteStock[] traderFavoriteStocks;		// The trader's favorite stock(s) to trade.	
	//private TraderFavoriteSector[] traderFavoriteSectors;		// The trader's market sector specialty(ies).	
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
		traderBehavior = SimConstants.INT_ZERO;
		traderWallet = SimConstants.FLOAT_ZERO;
		traderFrequency = SimConstants.INT_ZERO;
		traderImage = null;
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
	 * Subsequent requests to change the traderID will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *  - Make sure traderID attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The new traderID to set
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
	
	//----------------------------
	// ATTRIBUTE: traderFirstName
	//----------------------------
	
	/**
	 * This method returns the traderFirstName attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the traderFirstName attribute
	 * @see				SetTraderFirstName
	 */
	public String GetTraderFirstName ( ) {
		return this.traderFirstName;
	}
	
	/**
	 * This method allows for the one-time setting of the traderFirstName attribute value. 
	 * Subsequent requests to change the traderFirstName will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *  - Make sure traderFirstName attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new traderFirstName to set
	 * @return			A boolean value indicating success or failure at setting a new traderFirstName
	 * @see				GetTraderFirstName
	 */
	public boolean SetTraderFirstName (String tfn) {
		if (tfn.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.traderFirstName.equals(SimConstants.EMPTY_STRING)) {
			this.traderFirstName = tfn;
			return true;
		}
		return false;
	}
	
	//---------------------------
	// ATTRIBUTE: traderLastName
	//---------------------------
	
	/**
	 * This method returns the traderLastName attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the traderLastName attribute
	 * @see				SetTraderLastName
	 */
	public String GetTraderLastName ( ) {
		return this.traderLastName;
	}
	
	/**
	 * This method allows for the one-time setting of the traderLastName attribute value. 
	 * Subsequent requests to change the traderLastName will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *  - Make sure traderLastName attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new traderLastName to set
	 * @return			A boolean value indicating success or failure at setting a new traderLastName
	 * @see				GetTraderLastName
	 */
	public boolean SetTraderLastName (String tln) {
		if (tln.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.traderLastName.equals(SimConstants.EMPTY_STRING)) {
			this.traderLastName = tln;
			return true;
		}
		return false;
	}
	
	//----------------------
	// ATTRIBUTE: traderBio
	//----------------------
	
	/**
	 * This method returns the traderBio attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A String value representing the traderBio attribute
	 * @see				SetTraderBio
	 */
	public String GetTraderBio ( ) {
		return this.traderBio;
	}
	
	/**
	 * This method allows for the one-time setting of the traderBio attribute value. 
	 * Subsequent requests to change the traderBio will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *  - Make sure traderBio attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	String	The new traderBio to set
	 * @return			A boolean value indicating success or failure at setting a new traderID
	 * @see				GetTraderID
	 */
	public boolean SetTraderBio (String tb) {
		if (tb.equals(SimConstants.EMPTY_STRING)) {
			return false;
		}
		if (this.traderBio.equals(SimConstants.EMPTY_STRING)) {
			this.traderBio = tb;
			return true;
		}
		return false;
	}
	
	//---------------------------
	// ATTRIBUTE: traderBehavior
	//---------------------------
	
	/**
	 * This method returns the traderBehavior attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the traderBehavior attribute
	 * @see				SetTraderBehavior
	 */
	public int GetTraderBehavior ( ) {
		return this.traderBehavior;
	}
	
	/**
	 * This method allows for the one-time setting of the traderBehavior attribute value. 
	 * Subsequent requests to change the traderBehavior will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *	- Make sure parameter value is valid (within the range of valid behaviors).
	 *  - Make sure traderBehavior attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The new traderBehavior to set
	 * @return			A boolean value indicating success or failure at setting a new traderBehavior
	 * @see				GetTraderBehavior
	 */
	public boolean SetTraderBehavior (int tb) {
		if (tb <= SimConstants.INT_ZERO) {
			return false;
		}
		if ((tb < SimConstants.TRADER_BEHAVIOR_BEAR) || (tb > SimConstants.TRADER_BEHAVIOR_MIXED)) {
			return false;
		}
		if (this.traderBehavior == SimConstants.INT_ZERO) {
			this.traderBehavior = tb;
			return true;
		}
		return false;
	}
	
	//-------------------------
	// ATTRIBUTE: traderWallet
	//-------------------------
	
	/**
	 * This method returns the traderWallet attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			A float value representing the traderWallet attribute
	 * @see				SetTraderWallet, ChangeTraderWallet
	 */
	public float GetTraderWallet ( ) {
		return this.traderWallet;
	}
	
	/**
	 * This method allows for the setting of the traderWallet attribute value. 
	 * Since the parameter must be a float or the code won't compile, and since the 
	 * attribute value can be anything from 0.0f to ?.?f, the only check needed
	 * is to make sure the parameter is not a negative value.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The new traderWallet to set
	 * @return			A boolean value indicating success or failure at setting a new traderWallet
	 * @see				GetTraderWallet, ChangeTraderWallet
	 */
	public boolean SetTraderWallet (float tw) {
		if (tw < SimConstants.FLOAT_ZERO) {
			return false;
		}
		this.traderWallet = tw;
		return true;
	}
	
	/**
	 * This method allows for the changing of the traderWallet attribute value. 
	 * Since the parameter must be a float or the code won't compile, and since the 
	 * attribute value can be any float value (indicating profit or loss to the 
	 * trader's wallet), the only check needed is to make sure the balance of the
	 * traderWallet attribute does not go down below $0.00.
	 * <p>
	 * The only real difference between the Set and Change methods is that the Set
	 * method forces the parameter value as the new traderWallet value, whereas this
	 * Change method adds (or subtracts) the parameter value to/from the traderWallet
	 * attribute.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	float	The new change to the traderWallet attribute
	 * @return			A boolean value indicating success or failure at changing a traderWallet
	 * @see				GetTraderWallet, SetTraderWallet
	 */
	public boolean ChangeTraderWallet (float tw) {
		if ((this.traderWallet + tw) < 0.0f) {
			return false;
		}
		this.traderWallet = this.traderWallet + tw;
		return true;
	}
	
	//----------------------------
	// ATTRIBUTE: traderFrequency
	//----------------------------
	
	/**
	 * This method returns the traderFrequency attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An int value representing the traderFrequency attribute
	 * @see				SetTraderFrequency
	 */
	public int GetTraderFrequency ( ) {
		return this.traderFrequency;
	}
	
	/**
	 * This method allows for the one-time setting of the traderFrequency attribute value. 
	 * Subsequent requests to change the traderFrequency will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not zero and not negative.
	 *	- Make sure parameter value is valid (within the range of valid frequency).
	 *  - Make sure traderFrequency attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	int		The new traderFrequency to set
	 * @return			A boolean value indicating success or failure at setting a new traderFrequency
	 * @see				GetTraderFrequency
	 */
	public boolean SetTraderFrequency (int tf) {
		if (tf <= SimConstants.INT_ZERO) {
			return false;
		}
		if ((tf < SimConstants.TRADER_FREQUENCY_LOWEST) || (tf > SimConstants.TRADER_FREQUENCY_HIGHEST)) {
			return false;
		}
		if (this.traderFrequency == SimConstants.INT_ZERO) {
			this.traderFrequency = tf;
			return true;
		}
		return false;
	}
	
	//------------------------
	// ATTRIBUTE: traderImage
	//------------------------
	
	/**
	 * This method returns the traderImage attribute value. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @return			An Image object representing the traderImage attribute
	 * @see				SetTraderImage
	 */
	public Image GetTraderImage ( ) {
		return this.traderImage;
	}
	
	/**
	 * This method allows for the one-time setting of the traderImage attribute value. 
	 * Subsequent requests to change the traderImage will be rejected. Checks to 
	 * be performed are:
	 * 	- Make sure parameter value is not null.
	 *  - Make sure traderImage attribute is not already set.
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 * @param	Image	The new traderImage to set
	 * @return			A boolean value indicating success or failure at setting a new traderImage
	 * @see				GetTraderImage
	 */
	public boolean SetTraderImage (Image ti) {
		if (ti == null) {
			return false;
		}
		if (this.traderImage == null) {
			this.traderImage = ti;
			return true;
		}
		return false;
	}
	

}
