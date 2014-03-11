package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.drug.Drug;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;

public class GuiDrugTypeMenu extends GuiAdminSubmenu {

	public GuiDrugTypeMenu() {
		super("Drugs");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (UniqueItem item : ItemManager.getInstance().getItems(ItemType.DRUG)) {
			final Drug drug = (Drug) item;

			icons.add(new GuiIcon(drug.getName(), new ItemStack(drug.getStack()), i) {

				@Override
				public void run(Player player) {
					player.getInventory().addItem(drug.getStack());
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
