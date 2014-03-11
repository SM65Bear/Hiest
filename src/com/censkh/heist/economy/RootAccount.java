package com.censkh.heist.economy;

public abstract class RootAccount implements EconomyAccount {
	
	private final String name;
	
	public RootAccount(String name) {
		this.name = name;
		EconomyManager.getInstance().addAccount(name, this);
	}
	
	public int getBalance() {
		return 0;
	}
	
	public void setBalance(int balance) {
		
	}
	
	public String getName() {
		return getNamePrefix() + name;
	}
	
}
