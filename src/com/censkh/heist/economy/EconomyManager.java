package com.censkh.heist.economy;

public class EconomyManager {
	
	private static EconomyManager instance;
	
	public EconomyManager() {
		instance = this;
	}
	
	public static EconomyManager getInstance() {
		return instance;
	}
	
}
