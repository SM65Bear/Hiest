package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.censkh.hiest.gun.Gun;
import com.censkh.hiest.gun.GunManager;

public class GuiGunMenu extends GuiMenu {

	public GuiGunMenu() {
		super("Guns");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		for (Gun g : GunManager.getInstance().getGuns()) {
			final Gun gun = g;
			icons.add(new GuiIcon(gun.getName(),gun.getStack()) {
				
				@Override
				public void run(Player player) {
					player.getInventory().addItem(gun.getStack());
				}
			});
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9*4;
	}

}
