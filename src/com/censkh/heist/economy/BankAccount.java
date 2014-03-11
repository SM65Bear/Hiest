package com.censkh.heist.economy;

public class BankAccount extends RootAccount {

	public BankAccount(String name) {
		super(name);
	}

	@Override
	public String getNamePrefix() {
		return "bank_";
	}

}
