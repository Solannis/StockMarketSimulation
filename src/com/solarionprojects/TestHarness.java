package com.solarionprojects;

public class TestHarness {

	//
	// Default constructor
	//
	public TestHarness () {
		Stock st = new Stock();
		boolean b = false;
		
		b = st.SetStockSymbol("AAPL");
		System.out.println("Boolean: " + b + "\tSymbol: " + st.GetStockSymbol());
		b = st.SetStockSymbol("AMZN");
		System.out.println("Boolean: " + b + "\tSymbol: " + st.GetStockSymbol());		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestHarness th = new TestHarness();
	}

}
