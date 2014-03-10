package com.censkh.heist.gui;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.GunManager;

public class GuiBlackMarketGuns extends GuiStore {

	public GuiBlackMarketGuns() {
		super("Black Market Guns");
	}

	@Override
	public HashMap<ItemStack, Integer> initStore() {
		HashMap<ItemStack, Integer> store = new HashMap<ItemStack, Integer>();
		store.put(GunManager.getInstance().getGun(310).getStack(), 300);
		return store;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
