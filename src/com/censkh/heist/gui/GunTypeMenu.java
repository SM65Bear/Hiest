package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.ItemType;

public class GunTypeMenu extends GuiMenu {

	public GunTypeMenu() {
		super("Guns");
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
			icons.add(new GuiIcon("Back",new ItemStack(Material.ARROW),getSize()-1) {
				
				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().ADMIN.open(player);
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
