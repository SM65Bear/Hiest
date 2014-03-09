package com.censkh.hiest.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.censkh.hiest.Hiest;

public abstract class EventListener implements Listener {
	
	public static void createListeners() {
		new EntityEventListener();
		new PlayerEventListener();
	}
	
	public EventListener() {
		Bukkit.getPluginManager().registerEvents(this, Hiest.getPlugin(Hiest.class));
	}
	
}
