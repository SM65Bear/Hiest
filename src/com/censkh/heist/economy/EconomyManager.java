package com.censkh.heist.economy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

public class EconomyManager {
	
	private static EconomyManager instance;
	private final HashMap<String,List<EconomyAccount>> accounts = new HashMap<String,List<EconomyAccount>>();
	
	public EconomyManager() {
		instance = this;
	}
	
	public static EconomyManager getInstance() {
		return instance;
	}
	
	public PlayerAccount getPlayerAccount(Player player) {
		if (hasAccount(PlayerAccount.class,player.getName())) {
			return (PlayerAccount) getAccount(PlayerAccount.class,player.getName());
		} else {
			return new PlayerAccount(player.getName());
		}
	}
	
	public EconomyAccount getAccount(Class<? extends EconomyAccount> accountType,String name) {
		List<EconomyAccount> accounts = getAccounts(name);
		for (EconomyAccount account : accounts) {
			if (accountType.isInstance(account)) {
				return account;
			}
		}
		return null;
	}
	
	public void addAccount(String name, EconomyAccount account) {
		if (hasAccount(account.getClass(), name)) {
			System.out.println("Two accounts of same type tried to be added.");
			return;
		}
		getAccounts(name);
		List<EconomyAccount> accounts = getAccounts(name);
		accounts.add(account);
		getAccounts().put(name,accounts);
	}

	public boolean hasAccount(Class<? extends EconomyAccount> accountType,String name) {
		if (accountType.getName().equals(EconomyAccount.class.getName())) {
			return false;
		}
		List<EconomyAccount> accounts = getAccounts(name);
		for (EconomyAccount account : accounts) {
			if (accountType.isInstance(account)) {
				return true;
			}
		}
		return false;
	}
	
	public List<EconomyAccount> getAccounts(String name) {
		if (!getAccounts().containsKey(name)) {
			getAccounts().put(name, new ArrayList<EconomyAccount>());
		}
		return getAccounts().get(name);
	}

	public HashMap<String,List<EconomyAccount>> getAccounts() {
		return accounts;
	}
	
}
