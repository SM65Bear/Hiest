package com.censkh.heist.gui;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GuiBlackMarketArmour extends GuiStore {

	public GuiBlackMarketArmour() {
		super("Black Market Armour");
	}

	@Override
	public HashMap<ItemStack, Integer> initStore() {
		HashMap<ItemStack, Integer> store = new HashMap<ItemStack, Integer>();
		store.put(new ItemStack(Material.CHAINMAIL_CHESTPLATE), 200);
		store.put(new ItemStack(Material.CHAINMAIL_LEGGINGS), 150);
		store.put(new ItemStack(Material.CHAINMAIL_BOOTS), 125);
		return store;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
