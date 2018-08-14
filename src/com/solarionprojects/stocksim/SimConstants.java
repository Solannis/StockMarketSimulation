package com.solarionprojects.stocksim;

import java.math.BigDecimal;

public class SimConstants {

	//==============================
	// SIM CONTROL GLOBAL CONSTANTS
	//==============================

	public static final int MODE_TUTORIAL_BASIC = 0x01;
	public static final int MODE_TUTORIAL_ADVANCED = 0x02;
	public static final int MODE_EASY = 0x04;
	public static final int MODE_MODERATE = 0x05;
	public static final int MODE_ADVANCED = 0x06;

	public static final int STOCK_DATA_BASIC = 0x01;					// Tutorial Mode toString()
	public static final int STOCK_DATA_ADVANCED = 0x02;					// Regular Mode toString()
	
	public static final int TRADER_BEHAVIOR_BULL = 0x01;
	public static final int TRADER_BEHAVIOR_BEAR = 0x02;
	public static final int TRADER_BEHAVIOR_MIXED = 0x03;
	
	public static final int TRADER_FREQUENCY_LOWEST = 0x01;				// One trade per "hour" (1 every 60s)
	public static final int TRADER_FREQUENCY_LOW = 0x02;				// Two trades per "hour" (1 every 30s)
	public static final int TRADER_FREQUENCY_MEDIUM = 0x03;				// Four trades per hour (1 every 15s)
	public static final int TRADER_FREQUENCY_HIGH = 0x04;				// Six trades per hour (1 every 10s)
	public static final int TRADER_FREQUENCY_HIGHEST = 0x05;			// Twelve trades per hour 1 every 5s) 
	public static final int TRADER_FREQUENCY_MIN = TRADER_FREQUENCY_LOWEST;
	public static final int TRADER_FREQUENCY_MAX = TRADER_FREQUENCY_HIGHEST;

	public static final int TUTORIAL_STOCK_TOTAL_QTY = 18;
	public static final int TUTORIAL_STOCK_SELECT_QTY = 10;
	public static final int TUTORIAL_STOCK_DATA_= STOCK_DATA_BASIC;		// Why did I think I needed this?
	public static final int TUTORIAL_TRADER_QTY = 4;
	public static final BigDecimal TUTORIAL_TRADER_WALLET_MIN = new BigDecimal("10000.00");
	public static final BigDecimal TUTORIAL_TRADER_WALLET_ADDITIONAL = TUTORIAL_TRADER_WALLET_MIN;


	//==============================
	// FIXED VALUE GLOBAL CONSTANTS
	//==============================
	
	public static final String EMPTY_STRING = "";
	public static final String NEW_LINE = "\n";
	public static final String TAB = "\t";
	public static final String TEST_STOCK_SYMBOL = "AAPL";
	public static final String TEST_STOCK_SECTOR = "Technology";
	public static final String TEST_STOCK_EXCHANGE = "NASDAQ";
	public static final String TEST_STOCK_FULL_NAME = "Apple, Inc.";
	public static final String TEST_STOCK_DESCRIPTION = "Apple, Inc. common stock";
	public static final String TEST_TRADER_FIRST_NAME = "Matthew";
	public static final String TEST_TRADER_LAST_NAME = "Farrell";
	public static final String TEST_TRADER_BIO = "A bullish trader who prefers to focus on technology stocks";

	/*
	public static final float FLOAT_NEGATIVE = -9.990f;
	public static final float FLOAT_ZERO = 0.0f;
	public static final float FLOAT_PENNY = 0.010f;
	public static final float FLOAT_DOLLAR = 1.00f;
	public static final float FLOAT_POSITIVE = 99.990f;
	public static final float FLOAT_INFINITY_POSITIVE = Float.POSITIVE_INFINITY;
	public static final float FLOAT_INFINITY_NEGATIVE = Float.NEGATIVE_INFINITY;
	 */
	
	public static final BigDecimal BD_NEGATIVE = new BigDecimal("-9.99");
	public static final BigDecimal BD_ZERO = new BigDecimal("0.00");
	public static final BigDecimal BD_PENNY = new BigDecimal("0.01");
	public static final BigDecimal BD_DOLLAR = new BigDecimal("1.00");
	public static final BigDecimal BD_POSITIVE = new BigDecimal("99.99");

	
	public static final int INT_NEGATIVE = -9;
	public static final int INT_ZERO = 0;
	public static final int INT_POSITIVE = 99;

	public static final int STOCK_SYMBOL_MIN_LENGTH = 1;
	public static final int STOCK_SYMBOL_MAX_LENGTH = 5;

}
