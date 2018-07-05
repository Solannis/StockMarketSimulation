package com.solarionprojects.utility;

import java.util.Random;

public class RNG {

	/*
	 * ==================================================
	 * Global Constant Declarations
	 * ==================================================
	 */

	
	/*
	 * ==================================================
	 * Global Variable Declarations
	 * ==================================================
	 */
	private static Random numberGenerator;

	
	/*
	 * ==================================================
	 * Constructors and Main Control
	 * ==================================================
	 */
	public RNG () {
		//
		// Default Constructor
		//
		
		//
		// Initialize the random number generator
		//
		RNG.numberGenerator = new Random(System.currentTimeMillis());
	}

	
	/*
	 * ==================================================
	 * Class Methods
	 * ==================================================
	 */
	/**
	 * This method initializes the random number generator. Since this is a 
	 * static object in a largely static class, a regular constructor will 
	 * not work to initialize the RNG. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 *
	 * @param  
	 * @return      
	 * @see         
	 */
	public static void Initialize () {
		RNG.numberGenerator = new Random(System.currentTimeMillis());
	}

	/**
	 * This method returns a random int. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 *
	 * @param  
	 * @return      a random integer.
	 * @see			nextInt(int)   
	 */
	public static int NextInt () {
		int newInt;
		
		if (RNG.numberGenerator == null) {
			RNG.Initialize();
		}
		newInt = numberGenerator.nextInt();
		return newInt;
	}

	/**
	 * This method returns a random int within a range from 0 (inclusive)
	 * to a maximum value (exclusive) provided as a parameter when calling 
	 * this method. 
	 * <p>
	 * This method is public and can be be called by any object.
	 * <p>
	 *
	 * @param  int	the maximum integer value (exclusive)
	 * @return      a random integer.
	 * @see         parseInt()
	 */
	public static int NextInt (int maxInt) {
		int newInt;
		
		if (RNG.numberGenerator == null) {
			RNG.Initialize();
		}
		newInt = numberGenerator.nextInt(maxInt);
		return newInt;
	}
}
