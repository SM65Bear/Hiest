package com.censkh.heist.drug;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_7_R1.ItemStack;

public class DrugStack {
	
	private final Drug drug;
	private int amount = 1;

	public DrugStack(ItemStack oldstack) {
		//for james i don't even know anymore.....life
	}

	public Drug read(ItemStack stack) {
		// For le james. ok fine ill try and probably fuck up here goes.....

		Drug drug = null;
		
		List<String> lore = meta.getLore();
		String drugIdent = ChatColor.stripColor(lore.get(lore.size() - 1));
		int drugId = Integer.parseInt(drugIdent.replaceAll("Item #", ""));
		drug = DrugManager.getInstance().getDrug(drugID);
		
		
		//yep fucked up. illl leave it there
		
		
		return drug;
	}

	public int setAmount(int i) {
		return amount;
		
	}
	

}
