package com.censkh.heist.throwable;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Item;

import com.censkh.heist.item.ItemManager;

public class ThrowableManager {

	private static ThrowableManager instance;
	private final List<Item> items = new ArrayList<Item>();

	public ThrowableManager() {
		instance = this;
	}

	public static ThrowableManager getInstance() {
		return instance;
	}

	public List<Item> getItems() {
		return items;
	}

	public void add(Item item) {
		getItems().add(item);
	}

	public void update() {
		List<Item> removeList = new ArrayList<Item>();
		for (Item item : getItems()) {
			item.setPickupDelay(5);
			if (item.getTicksLived() >= ((Throwable)ItemManager.getInstance().getItem(item.getItemStack())).getLifetime()) {
				removeList.add(item);
			}
		}
		for (Item item : removeList) {
			item.remove();
			((Throwable)ItemManager.getInstance().getItem(item.getItemStack())).onRemoved(item.getLocation());
			getItems().remove(item);
		}
	}

}
