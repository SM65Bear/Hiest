package com.censkh.heist.gui;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import com.censkh.heist.item.ItemManager;

public class GuiBlackMarketDrugs extends GuiStore {

	public GuiBlackMarketDrugs() {
		super("The High Mother Fucker");
	}

	@Override
	public HashMap<ItemStack, Integer> initStore() {
		HashMap<ItemStack, Integer> store = new HashMap<ItemStack, Integer>();
		store.put(ItemManager.getInstance().DRUG_COCANE.getStack(), 69000);
		store.put(ItemManager.getInstance().DRUG_HEROINE.getStack(), 1337);
		store.put(ItemManager.getInstance().DRUG_CRACK.getStack(), 2);
		store.put(ItemManager.getInstance().DRUG_CANABIS.getStack(), 2000);
		return store;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
