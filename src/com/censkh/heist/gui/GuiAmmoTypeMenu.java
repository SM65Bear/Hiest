package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.ammo.Ammo;
import com.censkh.heist.ammo.AmmoManager;

public class GuiAmmoTypeMenu extends GuiMenu {

	public GuiAmmoTypeMenu() {
		super("Ammo");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (Ammo a: AmmoManager.getInstance().getAmmo()){
			final Ammo ammo = a;
			
			icons.add(new GuiIcon(a.getName(), new ItemStack(a.getStack()),i) {
				
				@Override
				public void run(Player player) {
					player.getInventory().addItem(ammo.getStack());
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
