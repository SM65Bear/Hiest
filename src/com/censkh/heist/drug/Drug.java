package com.censkh.heist.drug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;
import com.censkh.heist.util.BuffData;

public class Drug extends UniqueItem {
	
	private final ItemStack stack;
	private final DrugData data;
	public final Random random = new Random();

	public Drug(int id,String name, ItemStack stack, DrugData data) {
		super(id,name);
		this.data = data;
		this.stack = bake(stack);
		
	}

	private ItemStack bake(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + getName());
		List<String> lore = new ArrayList<String>(getData().toLore());
		lore.add(ChatColor.DARK_GRAY + getIdent());
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}

	@Override
	public ItemStack getStack(int i) {
		ItemStack stack = this.stack.clone();
		stack.setAmount(i);
		return stack;
	}
	
	public DrugData getData() {
		return data;
	}

	public void apply(Player player) {
		player.sendMessage(ChatColor.AQUA + "[Sniff] " + ChatColor.GRAY +"Oh yeah that's the stuff.");
		for (BuffData data : getData().getBuffs()) {
			player.addPotionEffect(data.toPotionEffect());
		}
	}
	
	@Override
	public ItemType getType() {
		return ItemType.DRUG;
	}

}
