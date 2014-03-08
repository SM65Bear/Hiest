package com.censkh.hiest;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class ThrowableManager {

	private static ThrowableManager instance;
	private final List<Throwable> throwables = new ArrayList<Throwable>();
	private final List<Item> items = new ArrayList<Item>();

	public ThrowableManager() {
		instance = this;
		create(FragGrenade.class);
	}

	public Throwable create(Class<? extends Throwable> clazz) {
		Throwable t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		getThrowables().add(t);
		return t;
	}

	public static ThrowableManager getInstance() {
		return instance;
	}

	public List<Throwable> getThrowables() {
		return throwables;
	}

	public List<Item> getItems() {
		return items;
	}

	public void add(Item item) {
		getItems().add(item);
	}

	public Throwable getThrowable(ItemStack stack) {
		for (Throwable t : getThrowables()) {
			if (t.isStack(stack)) {
				return t;
			}
		}
		return null;
	}

	public Throwable getThrowable(String name) {
		for (Throwable t : getThrowables()) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	public void update() {
		List<Item> removeList = new ArrayList<Item>();
		for (Item item : getItems()) {
			item.setPickupDelay(5);
			if (item.getTicksLived()>=getThrowable(item.getItemStack()).getLifetime()) {
				removeList.add(item);
			}
		}
		for (Item item : removeList) {
			item.remove();
			getThrowable(item.getItemStack()).onRemoved(item.getLocation());
			getItems().remove(item);
		}
	}

}
