package com.censkh.heist.economy;

import com.censkh.heist.SQLManager;

public abstract class RootAccount implements EconomyAccount {
	
	private final String name;
	
	public RootAccount(String name) {
		this.name = name;
		EconomyManager.getInstance().addAccount(name, this);
	}
	
	public int getBalance() {
		return SQLManager.getInstance().getAccountBalance(this);
	}
	
	public void setBalance(int balance) {
		if (SQLManager.getInstance().isAccountCreated(this)) {
			SQLManager.getInstance().updateAccount(this,balance);
		} else {
			SQLManager.getInstance().insertAccount(this,balance);
		}
	}
	
	public String getName() {
		return getNamePrefix() + name;
	}
	
	public boolean hasEnough(int i) {
		return getBalance()>=i;
	}
	
	public void removeMoney(int i) {
		setBalance(getBalance()-i);
	}
	
	public void addMoney(int i) {
		setBalance(getBalance()+i);
	}
	
}
