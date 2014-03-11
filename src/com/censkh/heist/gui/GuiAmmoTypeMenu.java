package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.ammo.Ammo;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;

public class GuiAmmoTypeMenu extends GuiAdminSubmenu {

	public GuiAmmoTypeMenu() {
		super("Ammo");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (UniqueItem item : ItemManager.getInstance().getItems(ItemType.AMMO)) {
			final Ammo ammo = (Ammo) item;

			icons.add(new GuiIcon(ammo.getName(), new ItemStack(ammo.getStack()), i) {

				@Override
				public void run(Player player) {
					player.getInventory().addItem(ammo.getStack());
				}
			});
			i++;
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
