package com.censkh.heist.economy;

public abstract class RootAccount implements EconomyAccount {
	
	protected final String name;
	
	public RootAccount(String name) {
		this.name = name;
	}
	
}
