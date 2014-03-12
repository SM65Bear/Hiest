package com.censkh.heist.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class MaskItem extends GenericItem {

	public MaskItem(int id, String name, Color color) {
		super(id, name, creatStack(id, name, color));
	}

	private static ItemStack creatStack(int id, String name, Color color) {
		ItemStack stack = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + name);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "Once Equipped in stores a robbery will take place!");
		lore.add(ChatColor.DARK_GRAY + getIdent(id));
		meta.setLore(lore);
		LeatherArmorMeta armourMeta = (LeatherArmorMeta) meta;
		armourMeta.setColor(color);
		stack.setItemMeta(armourMeta);
		return stack;
	}

	@Override
	public ItemType getType() {
		return ItemType.ARMOUR;
	}

	@Override
	public void onItemUseEvent(ItemUseEvent event) {
		
	}

}
