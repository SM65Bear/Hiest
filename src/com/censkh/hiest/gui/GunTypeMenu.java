package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.hiest.gun.GunType;

public class GunTypeMenu extends GuiMenu {

	public GunTypeMenu() {
		super(""+ ChatColor.WHITE + "The Hiest " + ChatColor.AQUA + "$" + ChatColor.YELLOW + " [Guns]");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		for (GunType t: GunType.values()){
			final GunType type = t;
			
			icons.add(new GuiIcon(type.getName(), new ItemStack(type.getType())) {
				
				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().getMenu(type.getName()).open(player);
					
				}
			});
			
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9*6;
	}

}
