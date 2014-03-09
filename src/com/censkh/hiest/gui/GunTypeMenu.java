package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.hiest.gun.ItemType;

public class GunTypeMenu extends GuiMenu {

	public GunTypeMenu() {
		super(""+ ChatColor.WHITE + "The Hiest " + ChatColor.AQUA + "$" + ChatColor.YELLOW + " [Guns]");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (ItemType t: ItemType.values()){
			final ItemType type = t;
			
			icons.add(new GuiIcon(type.getName(), new ItemStack(type.getType()),i) {
				
				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().getMenu(type.getName()).open(player);
					
				}
			});
			i++;
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9*6;
	}

}
