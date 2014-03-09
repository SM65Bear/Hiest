package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiAdminMenu extends GuiMenu {

	public GuiAdminMenu() {
		super(""+ ChatColor.WHITE + ChatColor.BOLD + "The Hiest " + ChatColor.AQUA + ChatColor.BOLD + "$" + ChatColor.YELLOW + " [Panel]");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		for (GuiPanelOptions t: GuiPanelOptions.values()){
			final GuiPanelOptions type = t;
			
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
