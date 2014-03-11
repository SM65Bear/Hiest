package com.censkh.heist.economy;

public class PlayerAccount extends RootAccount {

	public PlayerAccount(String name) {
		super(name);
	}

	@Override
	public String getName() {
		return "player_"+super.name;
	}

}
